import Dependencies.*
import sbtassembly.AssemblyPlugin.autoImport.*
import scala.sys.process.stringToProcess

/*
 * Project settings
 */
val projectName = "scala3-sbt-template"
scalaVersion := "3.8.1"
scalacOptions ++= Seq("-Werror", "-Wall", "-Wunused:all")
/*
 * Scalafix settings
 */
semanticdbEnabled := true
/*
 * Scoverage settings
 */
// TODO: configure scoverage
/*
 * Ensuring hooks path is always set every time sbt starts.
 */
Global / onLoad := { s =>
  "git config core.hooksPath .githooks".!
  s
}
/*
 * Root project.
 */
lazy val root = project
  .in(file("."))
  .settings(
    name := projectName,
    libraryDependencies += scalaTest % Test,
    assembly / mainClass := Some("Main"),
    assembly / assemblyJarName := s"${name.value}-${version.value}-fat.jar",
  )
/*
 * Command aliases.
 */
addCommandAlias("check", "; scalafmtCheckAll; scalafixAll --check; test")
