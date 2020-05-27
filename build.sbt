import sbtrelease.ReleaseStateTransformations._
import sbtcrossproject.{CrossProject, CrossType}

val playJsonVersion = settingKey[String]("")
val generateSources = taskKey[Unit]("generate main source files")
val generatedSourceDir = "generated"
val checkGenerate = taskKey[Unit]("check generate")
val playJsonExtraJVMRef = LocalProject(UpdateReadme.moduleName + "JVM")

Global / onChangedBuildSource := ReloadOnSourceChanges

val tagName = Def.setting{
  s"v${if (releaseUseGlobalVersion.value) (version in ThisBuild).value else version.value}"
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

val Scala212 = "2.12.11"

val commonSettings = Seq(
  publishTo := sonatypePublishToBundle.value,
  scalaVersion := Scala212,
  fullResolvers ~= {_.filterNot(_.name == "jcenter")},
  crossScalaVersions := Scala212 :: "2.13.2" :: Nil,
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
    releaseStepTask(checkGenerate in playJsonExtraJVMRef),
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
        extracted.runAggregated(PgpKeys.publishSigned in Global in extracted.get(thisProjectRef), state)
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
  scalacOptions in (Compile, doc) ++= {
    val tag = tagOrHash.value
    Seq(
      "-sourcepath", (baseDirectory in playJsonExtraJVMRef).value.getAbsolutePath,
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
  scalacOptions in (c, console) ~= {_.filterNot(unusedWarnings.toSet)}
)

val noPublish = Seq(
  PgpKeys.publishLocalSigned := {},
  PgpKeys.publishSigned := {},
  publishLocal := {},
  publish := {},
  publishArtifact in Compile := false
)

// https://groups.google.com/d/topic/simple-build-tool/_bBUQk4dIAE/discussion
lazy val generator = Project(
  "generator", file("generator")
).settings(
  commonSettings,
  noPublish,
  generateSources := {
    val dir = ((baseDirectory in LocalRootProject).value / "src/main/scala" / generatedSourceDir).toString
    val cp = (fullClasspath in Compile).value
    (runner in Compile).value.run("play.jsonext.Generate", Attributed.data(cp), Seq(dir), streams.value.log)
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
  initialCommands in console += {
    Seq(
      "play.api.libs.json._", "play.jsonext._"
    ).map("import " + _ + ";").mkString
  },
  checkGenerate := {
    val _ = (generateSources in generator).value
    val diff = sys.process.Process("git diff").lineStream_!
    assert(diff.size == 0, diff)
  },
  playJsonVersion := "2.9.0",
  libraryDependencies += "com.typesafe.play" %%% "play-json" % playJsonVersion.value % "provided",
  libraryDependencies += "org.scalacheck" %%% "scalacheck" % "1.14.3" % "test",
  libraryDependencies += "com.github.xuwei-k" %%% "applybuilder" % "0.3.0" % "test",
  watchSources ++= ((sourceDirectory in generator).value ** "*.scala").get
).enablePlugins(BuildInfoPlugin).jsSettings(
  scalacOptions += {
    val a = (baseDirectory in LocalRootProject).value.toURI.toString
    val g = "https://raw.githubusercontent.com/xuwei-k/play-json-extra/" + tagOrHash.value
    s"-P:scalajs:mapSourceURI:$a->$g/"
  }
)

lazy val playJsonExtraJVM = playJsonExtra.jvm
lazy val playJsonExtraJS = playJsonExtra.js

val root = Project("root", file(".")).settings(
  commonSettings,
  noPublish,
  scalaSource in Compile := file("dummy"),
  scalaSource in Test := file("dummy")
).aggregate(
  playJsonExtraJVM, playJsonExtraJS, generator
)
