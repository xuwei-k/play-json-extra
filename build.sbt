import sbtrelease.ReleaseStateTransformations._
import sbtcrossproject.{CrossProject, CrossType}

val playJsonVersion = settingKey[String]("")
val generateSources = taskKey[Unit]("generate main source files")
val generatedSourceDir = "generated"
val checkGenerate = taskKey[Unit]("check generate")
val playJsonExtraJVMRef = LocalProject(UpdateReadme.moduleName + "JVM")

Global / onChangedBuildSource := ReloadOnSourceChanges

val tagName = Def.setting{
  s"v${if (releaseUseGlobalVersion.value) (ThisBuild / version).value else version.value}"
}
val tagOrHash = Def.setting{
  if(isSnapshot.value) {
    sys.process.Process("git rev-parse HEAD").lineStream_!.head
  } else {
    tagName.value
  }
}

val unusedWarnings = (
  "-Ywarn-unused" ::
  Nil
)

val Scala212 = "2.12.15"

val commonSettings = Seq(
  publishTo := sonatypePublishToBundle.value,
  scalaVersion := Scala212,
  fullResolvers ~= {_.filterNot(_.name == "jcenter")},
  crossScalaVersions := Scala212 :: "2.13.6" :: Nil,
  scalacOptions ++= (
    "-deprecation" ::
    "-unchecked" ::
    "-Xlint" ::
    "-language:existentials" ::
    "-language:higherKinds" ::
    "-language:implicitConversions" ::
    Nil
  ) ++ unusedWarnings,
  scalacOptions ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, 11 | 12)) =>
        Seq("-Xfuture")
      case _ =>
        Nil
    }
  },
  releaseCrossBuild := true,
  releaseTagName := tagName.value,
  releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    releaseStepTask(playJsonExtraJVMRef / checkGenerate),
    inquireVersions,
    runClean,
    runTest,
    setReleaseVersion,
    commitReleaseVersion,
    UpdateReadme.updateReadmeProcess,
    tagRelease,
    ReleaseStep(
      action = { state =>
        val extracted = Project extract state
        extracted.runAggregated(extracted.get(thisProjectRef) / (Global / PgpKeys.publishSigned), state)
      },
      enableCrossBuild = true
    ),
    releaseStepCommand("sonatypeBundleRelease"),
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
  credentials ++= PartialFunction.condOpt(sys.env.get("SONATYPE_USER") -> sys.env.get("SONATYPE_PASS")){
    case (Some(user), Some(pass)) =>
      Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass)
  }.toList,
  (Compile / doc / scalacOptions) ++= {
    val tag = tagOrHash.value
    Seq(
      "-sourcepath", (playJsonExtraJVMRef / baseDirectory).value.getAbsolutePath,
      "-doc-source-url", s"https://github.com/xuwei-k/play-json-extra/tree/${tag}€{FILE_PATH}.scala"
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
  c / console / scalacOptions ~= {_.filterNot(unusedWarnings.toSet)}
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
  "generator", file("generator")
).settings(
  commonSettings,
  noPublish,
  generateSources := {
    val dir = ((LocalRootProject / baseDirectory).value / "src/main/scala" / generatedSourceDir).toString
    val cp = (Compile / fullClasspath).value
    (Compile / runner).value.run("play.jsonext.Generate", Attributed.data(cp), Seq(dir), streams.value.log)
  }
)

lazy val playJsonExtra = CrossProject(UpdateReadme.moduleName, file("."))(JVMPlatform, JSPlatform).crossType(
  CrossType.Pure
).settings(
  commonSettings,
  name := UpdateReadme.moduleName,
  buildInfoKeys := Seq[BuildInfoKey](
    organization,
    name,
    version,
    scalaVersion,
    sbtVersion,
    licenses,
    playJsonVersion
  ),
  buildInfoPackage := "play.jsonext",
  buildInfoObject := "PlayJsonExtraBuildInfo",
  (console / initialCommands) += {
    Seq(
      "play.api.libs.json._", "play.jsonext._"
    ).map("import " + _ + ";").mkString
  },
  checkGenerate := {
    val _ = (generator / generateSources).value
    val diff = sys.process.Process("git diff").lineStream_!
    assert(diff.size == 0, diff)
  },
  playJsonVersion := "2.9.2",
  libraryDependencies += "com.typesafe.play" %%% "play-json" % playJsonVersion.value % "provided" cross CrossVersion.for3Use2_13,
  libraryDependencies += "org.scalacheck" %%% "scalacheck" % "1.15.4" % "test",
  libraryDependencies += "com.github.xuwei-k" %%% "applybuilder" % "0.3.1" % "test",
  watchSources ++= ((generator / sourceDirectory).value ** "*.scala").get
).enablePlugins(BuildInfoPlugin).jsSettings(
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
  }
)

lazy val playJsonExtraJVM = playJsonExtra.jvm
lazy val playJsonExtraJS = playJsonExtra.js

val root = Project("root", file(".")).settings(
  commonSettings,
  noPublish,
  Compile / scalaSource := baseDirectory.value / "dummy",
  Test / scalaSource := baseDirectory.value / "dummy",
).aggregate(
  playJsonExtraJVM, playJsonExtraJS, generator
)
