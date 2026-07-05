import Dependencies.*
import scala.sys.process.stringToProcess

/*
 * Language settings
 */
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
 * Change the name with yours.
 */
val projectName = "scala3-sbt-template"
/*
 * Root project.
 */
lazy val root = project
  .in(file("."))
  .settings(
    name := projectName,
    libraryDependencies += scalaTest % Test
  )
