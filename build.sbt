name := "scala-examples"

organization := "org.example.scala"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "org.scalactic" %% "scalactic" % "3.0.4",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test"
)

//test in assembly := {}
//mainClass in assembly := Some("org.example.scala.MainObject")

enablePlugins(JmhPlugin)
