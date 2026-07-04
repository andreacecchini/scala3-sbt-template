import Dependencies.*
import scala.sys.process.stringToProcess

ThisBuild / scalaVersion := "3.8.1"

/*
 * Ensuring hooks path is always set every time sbt starts.
 */
Global / onLoad := { s =>
  "git config core.hooksPath .githooks".!
  s
}

lazy val root = project.in(file("."))
  .settings(
    name := "scala3-sbt-template",
    libraryDependencies += scalaTest % Test
  )
