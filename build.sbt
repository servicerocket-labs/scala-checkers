javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
scalacOptions ++= Seq("-feature", "-target:jvm-1.8")
scalaVersion := "2.13.3"
val ScalacheckVersion = "1.14.1"

crossScalaVersions := Seq("2.11.12", "2.12.12", "2.13.3")
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
publishMavenStyle := true
publishTo := version { (v: String) =>
  val Nexus = "https://t-nx2.performancerocket.com/"
  if (v.trim.endsWith("SNAPSHOT")) Some("ServiceRocket's Snapshots" at Nexus + "content/repositories/snapshots")
  else Some("ServiceRocket's Releases" at Nexus + "content/repositories/releases")
}.value

name := "scala-checkers"
version := "0.1.2-SNAPSHOT"
description := "ScalaCheck Generators Extension"
organization := "com.servicerocket"
organizationName := "ServiceRocket"
organizationHomepage := Option(url("http://www.servicerocket.com"))
libraryDependencies += "org.scalacheck" %% "scalacheck" % ScalacheckVersion % "provided"