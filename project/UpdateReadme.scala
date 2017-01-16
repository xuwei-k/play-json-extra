import sbt._, Keys._
import sbtrelease.ReleasePlugin.autoImport.ReleaseStep

object UpdateReadme {

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
    val git = new sbtrelease.Git(extracted get baseDirectory)
    git.add(readme) ! state.log
    git.commit(message = "update " + readme, sign = false) ! state.log
    "git diff HEAD^" ! state.log
    state
  }

  val updateReadmeProcess: ReleaseStep = updateReadme

}
