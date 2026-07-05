import Dependencies.*
import scala.sys.process.stringToProcess

/*
 * Global settings
 */
scalaVersion := "3.8.1"
semanticdbEnabled := true
scalacOptions ++= Seq("-Werror", "-Wall", "-Wunused:all")

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
