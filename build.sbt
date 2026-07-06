import Dependencies.*
import sbtassembly.AssemblyPlugin.autoImport.*
import scala.sys.process.stringToProcess


ThisBuild / scalaVersion := "3.8.1"
ThisBuild / scalacOptions ++= Seq("-Werror", "-Wall", "-Wunused:all")
ThisBuild / semanticdbEnabled := true

lazy val root = (project in file("."))
  .settings(
    name := "scala3-sbt-template",
    libraryDependencies += scalaTest,
    assembly / mainClass := Some("Main"),
    assembly / assemblyJarName := s"${name.value}-${version.value}-fat.jar",
  )

Global / onLoad := { s =>
  "git config core.hooksPath .githooks".!
  s
}

addCommandAlias("check", "; clean; scalafmtCheckAll; scalafixAll --check; testFull")
addCommandAlias("build", "; check; doc; assembly")
