import sbt._, Keys._
import sbtrelease.ReleasePlugin.autoImport.ReleaseStep

object UpdateReadme {

  val moduleName = "play-json-extra"

  val updateReadme = { state: State =>
    val extracted = Project.extract(state)
    val scalaV = extracted get scalaBinaryVersion
    val v = extracted get version
    val org =  extracted get organization
    val snapshotOrRelease = if(extracted get isSnapshot) "snapshots" else "releases"
    val readme = "README.md"
    val readmeFile = file(readme)
    val SonatypeURL = "https://oss.sonatype.org/service/local/repositories"
    val newReadme = Predef.augmentString(IO.read(readmeFile)).lines.map{ line =>
      val matchReleaseOrSnapshot = (line.contains("SNAPSHOT") == v.contains("SNAPSHOT")) && line.contains(moduleName)
      if(line.startsWith("libraryDependencies") && matchReleaseOrSnapshot && line.contains(" %% ")){
        s"""libraryDependencies += "${org}" %% "${moduleName}" % "$v""""
      }else if(line.startsWith("libraryDependencies") && matchReleaseOrSnapshot && line.contains(" %%% ")){
        s"""libraryDependencies += "${org}" %%% "${moduleName}" % "$v""""
      }else if(line.contains(SonatypeURL) && matchReleaseOrSnapshot){
        s"- [API Documentation](${SonatypeURL}/${snapshotOrRelease}/archive/${org.replace('.','/')}/${moduleName}_${scalaV}/${v}/${moduleName}_${scalaV}-${v}-javadoc.jar/!/index.html)"
      }else line
    }.mkString("", "\n", "\n")
    IO.write(readmeFile, newReadme)
    val git = new sbtrelease.Git(extracted get baseDirectory)
    git.add(readme) ! state.log
    git.commit(message = "update " + readme, sign = false) ! state.log
    sys.process.Process("git diff HEAD^") ! state.log
    state
  }

  val updateReadmeProcess: ReleaseStep = updateReadme

}
