ThisBuild / scalaVersion := "2.13.2"
ThisBuild / organization := "geronimus"
ThisBuild / name := "bog-standard-error"
ThisBuild / version := "0.1.0-SNAPSHOT"

val scalatest = "org.scalatest" %% "scalatest" % "3.1.2"

lazy val stderror = ( project in file( "." ) )
  .settings(
    libraryDependencies += scalatest
  )

