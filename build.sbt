import Dependencies.*

ThisBuild / scalaVersion := "3.8.1"

lazy val root = project.in(file("."))
  .settings(
    name := "scala3-sbt-template",
    libraryDependencies += scalaTest % Test
  )
