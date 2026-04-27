import sbt.Keys._
import sbt._
import sbtrelease.ReleasePlugin.autoImport.ReleaseStep

object UpdateReadme {

  val moduleName = "play-json-extra"

  val updateReadme: State => State = { state =>
    val extracted = Project.extract(state)
    val v = extracted.get(version)
    val org = extracted.get(organization)
    val readme = "README.md"
    val readmeFile = file(readme)
    val newReadme = IO
      .readLines(readmeFile)
      .map { line =>
        val matchReleaseOrSnapshot = (line.contains("SNAPSHOT") == v.contains("SNAPSHOT")) && line.contains(moduleName)
        if (line.startsWith("libraryDependencies") && matchReleaseOrSnapshot && line.contains(" %% ")) {
          s"""libraryDependencies += "${org}" %% "${moduleName}" % "$v""""
        } else if (line.startsWith("libraryDependencies") && matchReleaseOrSnapshot && line.contains(" %%% ")) {
          s"""libraryDependencies += "${org}" %%% "${moduleName}" % "$v""""
        } else line
      }
      .mkString("", "\n", "\n")
    IO.write(readmeFile, newReadme)
    val git = new sbtrelease.Git(extracted.get(baseDirectory))
    git.add(readme) ! state.log
    git.commit(message = "update " + readme, sign = false, signOff = false) ! state.log
    sys.process.Process("git diff HEAD^") ! state.log
    state
  }

  val updateReadmeProcess: ReleaseStep = updateReadme

}
