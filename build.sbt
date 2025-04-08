ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "shopping-cart",
    idePackagePrefix := Some("com.akkum")
  )
  .settings(libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest"  % "3.2.18"  % Test,
    "org.scalatestplus" %% "scalacheck-1-17" % "3.2.18.0" % Test
  ))
