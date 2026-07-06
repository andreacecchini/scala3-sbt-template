import sbt.*

object Dependencies:
  object Versions:
    val scalaTest = "3.2.20"

  /** ScalaTest.
    */
  val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % Versions.scalaTest % Test
