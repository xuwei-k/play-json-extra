import sbt._, Keys._
import sbtrelease._
import xerial.sbt.Sonatype._
import ReleaseStateTransformations._
import com.typesafe.sbt.pgp.PgpKeys

object Generate extends Build {

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
    crossScalaVersions := scalaVersion.value :: Nil,
    scalacOptions := Seq("-deprecation", "-unchecked", "-Xlint", "-language:_")
  )

  val updateReadme = { state: State =>
    val extracted = Project.extract(state)
    val scalaV = extracted get scalaBinaryVersion
    val v = extracted get version
    val org =  extracted get organization
    val moduleName = extracted get name
    val snapshotOrRelease = if(extracted get isSnapshot) "snapshots" else "releases"
    val readme = "README.md"
    val readmeFile = file(readme)
    val SonatypeURL = "https://oss.sonatype.org/service/local/repositories"
    val newReadme = Predef.augmentString(IO.read(readmeFile)).lines.map{ line =>
      val matchReleaseOrSnapshot = line.contains("SNAPSHOT") == v.contains("SNAPSHOT")
      if(line.startsWith("libraryDependencies") && matchReleaseOrSnapshot){
        s"""libraryDependencies += "${org}" %% "${moduleName}" % "$v""""
      }else if(line.contains(SonatypeURL) && matchReleaseOrSnapshot){
        s"- [API Documentation](${SonatypeURL}/${snapshotOrRelease}/archive/${org.replace('.','/')}/${moduleName}_${scalaV}/${v}/${moduleName}_${scalaV}-${v}-javadoc.jar/!/index.html)"
      }else line
    }.mkString("", "\n", "\n")
    IO.write(readmeFile, newReadme)
    val git = new Git(extracted get baseDirectory)
    git.add(readme) ! state.log
    git.commit("update " + readme) ! state.log
    "git diff HEAD^" ! state.log
    state
  }

  val updateReadmeProcess: ReleaseStep = updateReadme


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
    commonSettins ++ ReleasePlugin.releaseSettings ++ sonatypeSettings : _*
  ).settings(
    name := "play-json-extra",
    organization := "com.github.xuwei-k",
    licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")),
    homepage := Some(url("https://github.com/xuwei-k/play-json-extra")),
    commands += Command.command("updateReadme")(updateReadme),
    ReleasePlugin.ReleaseKeys.releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      updateReadmeProcess,
      tagRelease,
      ReleaseStep(
        action = state => Project.extract(state).runTask(PgpKeys.publishSigned, state)._1,
        enableCrossBuild = true
      ),
      setNextVersion,
      commitNextVersion,
      updateReadmeProcess,
      ReleaseStep(state => Project.extract(state).runTask(SonatypeKeys.sonatypeReleaseAll, state)._1),
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
    libraryDependencies += "com.typesafe.play" %% "play-json" % "2.2.2" % "provided",
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.11.3" % "test",
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
