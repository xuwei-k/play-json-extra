import sbtrelease.ReleaseStateTransformations._

@transient
val generateSources = taskKey[Unit]("generate main source files")
val generatedSourceDir = "generated"
@transient
val checkGenerate = taskKey[Unit]("check generate")

Global / onChangedBuildSource := ReloadOnSourceChanges

val tagName = Def.setting {
  s"v${if (releaseUseGlobalVersion.value) (ThisBuild / version).value else version.value}"
}
val tagOrHash = Def.setting {
  if (isSnapshot.value) {
    sys.process.Process("git rev-parse HEAD").lineStream_!.head
  } else {
    tagName.value
  }
}

val unusedWarnings = Def.setting(
  scalaBinaryVersion.value match {
    case "2.12" =>
      Seq(
        "-Ywarn-unused",
      )
    case _ =>
      Seq(
        "-Wunused:imports",
      )
  }
)

def Scala3 = "3.3.7"

val scalaVersions = Seq(
  "2.12.21",
  "2.13.18",
  Scala3,
)

val commonSettings = Seq(
  publishTo := (if (isSnapshot.value) None else localStaging.value),
  scalacOptions ++= Seq(
    "-deprecation",
    "-unchecked",
    "-language:existentials",
    "-language:implicitConversions",
  ) ++ unusedWarnings.value,
  scalacOptions ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, 12)) =>
        Seq(
          "-Xfuture",
          "-language:higherKinds",
          "-Xlint",
        )
      case _ =>
        Nil
    }
  },
  releaseCrossBuild := true,
  releaseTagName := tagName.value,
  releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runClean,
    runTest,
    setReleaseVersion,
    commitReleaseVersion,
    UpdateReadme.updateReadmeProcess,
    tagRelease,
    releaseStepCommandAndRemaining("publishSigned"),
    releaseStepCommandAndRemaining("sonaRelease"),
    setNextVersion,
    commitNextVersion,
    UpdateReadme.updateReadmeProcess,
    pushChanges
  ),
  organization := "com.github.xuwei-k",
  licenses := Seq("MIT License" -> url("https://opensource.org/licenses/mit-license")),
  homepage := Some(url("https://github.com/xuwei-k/play-json-extra")),
  commands += Command.command("updateReadme")(UpdateReadme.updateReadme),
  pomPostProcess := { node =>
    import scala.xml._
    import scala.xml.transform._
    def stripIf(f: Node => Boolean) = new RewriteRule {
      override def transform(n: Node) =
        if (f(n)) NodeSeq.Empty else n
    }
    val stripTestScope = stripIf { n => n.label == "dependency" && (n \ "scope").text == "test" }
    new RuleTransformer(stripTestScope).transform(node)(0)
  },
  (Compile / doc / scalacOptions) ++= {
    val tag = tagOrHash.value
    Seq(
      "-sourcepath",
      (LocalRootProject / baseDirectory).value.getAbsolutePath,
      "-doc-source-url",
      s"https://github.com/xuwei-k/play-json-extra/tree/${tag}€{FILE_PATH}.scala"
    )
  },
  description := "play2 json extra module",
  pomExtra := (
    <developers>
      <developer>
        <id>xuwei-k</id>
        <name>Kenji Yoshida</name>
        <url>https://github.com/xuwei-k</url>
      </developer>
    </developers>
    <scm>
      <url>git@github.com:xuwei-k/play-json-extra.git</url>
      <connection>scm:git:git@github.com:xuwei-k/play-json-extra.git</connection>
      <tag>{tagOrHash.value}</tag>
    </scm>
  )
) ++ Seq(Compile, Test).flatMap(c =>
  c / console / scalacOptions := { (c / console / scalacOptions).value.filterNot(unusedWarnings.value.toSet) }
)

val noPublish = Seq(
  PgpKeys.publishLocalSigned := {},
  PgpKeys.publishSigned := {},
  publishLocal := {},
  publish := {},
  Compile / publishArtifact := false
)

// https://groups.google.com/d/topic/simple-build-tool/_bBUQk4dIAE/discussion
lazy val generator = Project(
  "generator",
  file("generator")
).settings(
  commonSettings,
  noPublish,
  scalaVersion := Scala3,
  generateSources := {
    val dir = ((LocalRootProject / baseDirectory).value / "src/main/scala" / generatedSourceDir).toString
    val cp = (Compile / fullClasspath).value
    (Compile / runner).value.run("play.jsonext.Generate", Attributed.data(cp), Seq(dir), streams.value.log)
  }
)

lazy val playJsonExtra = projectMatrix
  .withId(UpdateReadme.moduleName)
  .in(file("."))
  .defaultAxes()
  .settings(
    commonSettings,
    name := UpdateReadme.moduleName,
    buildInfoKeys := Seq[BuildInfoKey](
      organization,
      name,
      version,
      scalaVersion,
      sbtVersion,
      licenses,
    ),
    buildInfoPackage := "play.jsonext",
    buildInfoObject := "PlayJsonExtraBuildInfo",
    (console / initialCommands) += {
      Seq(
        "play.api.libs.json._",
        "play.jsonext._"
      ).map("import " + _ + ";").mkString
    },
    checkGenerate := {
      val _ = (generator / generateSources).value
      val diff = sys.process.Process("git diff").lineStream_!
      assert(diff.size == 0, diff)
    },
    libraryDependencies += "org.scalacheck" %%% "scalacheck" % "1.19.0" % "test",
    libraryDependencies += "com.github.xuwei-k" %%% "applybuilder" % "0.3.2" % "test",
    libraryDependencies += "com.github.xuwei-k" %%% "unapply" % "0.1.0" % "test",
    watchSources ++= ((generator / sourceDirectory).value ** "*.scala").get()
  )
  .enablePlugins(BuildInfoPlugin)
  .jvmPlatform(
    scalaVersions,
    Def.settings(
      libraryDependencies += "org.playframework" %%% "play-json" % "3.0.6",
    )
  )
  .nativePlatform(
    scalaVersions,
    Def.settings(
      evictionErrorLevel := Level.Warn,
      libraryDependencies += "org.playframework" %%% "play-json" % "3.1.0-M10",
    )
  )
  .jsPlatform(
    scalaVersions,
    Def.settings(
      libraryDependencies += "org.playframework" %%% "play-json" % "3.0.6",
      scalacOptions += {
        val a = (LocalRootProject / baseDirectory).value.toURI.toString
        val g = "https://raw.githubusercontent.com/xuwei-k/play-json-extra/" + tagOrHash.value
        val key = scalaBinaryVersion.value match {
          case "3" =>
            "-scalajs-mapSourceURI"
          case _ =>
            "-P:scalajs:mapSourceURI"
        }
        s"${key}:$a->$g/"
      },
    )
  )

commonSettings
noPublish
Compile / scalaSource := baseDirectory.value / "dummy"
Test / scalaSource := baseDirectory.value / "dummy"
autoScalaLibrary := false
