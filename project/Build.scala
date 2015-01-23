import sbt._, Keys._
import sbtrelease._
import xerial.sbt.Sonatype._
import ReleaseStateTransformations._
import com.typesafe.sbt.pgp.PgpKeys
import sbtbuildinfo.Plugin._

object Generate extends Build {

  final val PlayVersion = "2.3.0"
  private val generateSources = taskKey[Unit]("generate main source files")
  private val generatedSourceDir = "generated"
  private val cleanSrc = taskKey[Unit]("clean generated sources")
  private val rootProjectId = "play-json-extra"
  private val checkGenerate = taskKey[Unit]("check generate")

  def gitHash: String = scala.util.Try(
    sys.process.Process("git rev-parse HEAD").lines_!.head
  ).getOrElse("master")

  val commonSettins = Seq(
    scalaVersion := "2.10.4",
    crossScalaVersions := scalaVersion.value :: "2.11.5" :: Nil,
    scalacOptions ++= (
      "-deprecation" ::
      "-unchecked" ::
      "-Xlint" ::
      "-language:existentials" ::
      "-language:higherKinds" ::
      "-language:implicitConversions" ::
      Nil
    ),
    scalacOptions ++= (
      if(scalaVersion.value startsWith "2.11")
        Seq("-Ywarn-unused", "-Ywarn-unused-import")
      else
        Nil
    )
  )

  // https://groups.google.com/d/topic/simple-build-tool/_bBUQk4dIAE/discussion
  lazy val generator = Project(
    "generator", file("generator")
  ).settings(
    commonSettins: _*
  ).settings(
    publishArtifact := false,
    publish := {},
    publishLocal := {},
    generateSources := {
      val dir = ((scalaSource in Compile in LocalProject(rootProjectId)).value / generatedSourceDir).toString
      val cp = (fullClasspath in Compile).value
      (runner in Compile).value.run("play.jsonext.Generate", Attributed.data(cp), Seq(dir), streams.value.log)
    }
  )

  lazy val playJsonExtra = Project(
    rootProjectId, file(".")
  ).settings(
    commonSettins ++ ReleasePlugin.releaseSettings ++ sonatypeSettings ++ buildInfoSettings : _*
  ).settings(
    name := "play-json-extra",
    organization := "com.github.xuwei-k",
    licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")),
    homepage := Some(url("https://github.com/xuwei-k/play-json-extra")),
    commands += Command.command("updateReadme")(UpdateReadme.updateReadme),
    buildInfoKeys := Seq[BuildInfoKey](
      organization,
      name,
      version,
      scalaVersion,
      sbtVersion,
      scalacOptions,
      licenses,
      "playVersion" -> PlayVersion
    ),
    sourceGenerators in Compile <+= buildInfo,
    buildInfoPackage := "play.jsonext",
    buildInfoObject := "PlayJsonExtraBuildInfo",
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
    ReleasePlugin.ReleaseKeys.releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      UpdateReadme.updateReadmeProcess,
      tagRelease,
      ReleaseStep(
        action = state => Project.extract(state).runTask(PgpKeys.publishSigned, state)._1,
        enableCrossBuild = true
      ),
      setNextVersion,
      commitNextVersion,
      UpdateReadme.updateReadmeProcess,
      pushChanges
    ),
    credentials ++= PartialFunction.condOpt(sys.env.get("SONATYPE_USER") -> sys.env.get("SONATYPE_PASS")){
      case (Some(user), Some(pass)) =>
        Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass)
    }.toList,
    scalacOptions in (Compile, doc) ++= {
      val tag = if(isSnapshot.value) gitHash else { "v" + version.value }
      Seq(
        "-sourcepath", (baseDirectory in LocalProject(rootProjectId)).value.getAbsolutePath,
        "-doc-source-url", s"https://github.com/xuwei-k/play-json-extra/tree/${tag}€{FILE_PATH}.scala"
      )
    },
    checkGenerate := {
      val _ = (generateSources in generator).value
      val diff = sys.process.Process("git diff").lines_!
      assert(diff.size == 0, diff)
    },
    initialCommands in console += {
      Seq(
        "play.api.libs.json._", "play.jsonext._"
      ).map("import " + _ + ";").mkString
    },
    aggregate := false,
    resolvers += "typesafe" at "http://typesafe.artifactoryonline.com/typesafe/releases/",
    libraryDependencies += "com.typesafe.play" %% "play-json" % PlayVersion % "provided",
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.1" % "test",
    libraryDependencies += "com.github.xuwei-k" %% "applybuilder71" % "0.1.5" % "test",
    packageSrc in Compile <<= (packageSrc in Compile).dependsOn(compile in Compile),
    watchSources ++= ((sourceDirectory in generator).value ** "*.scala").get,
    cleanSrc := IO.delete((scalaSource in Compile).value / generatedSourceDir),
    clean <<= clean dependsOn cleanSrc,
    compile in Compile <<= (compile in Compile) dependsOn (generateSources in generator),
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
        <tag>{if(isSnapshot.value) gitHash else { "v" + version.value }}</tag>
      </scm>
    )
  )
}
