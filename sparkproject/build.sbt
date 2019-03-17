// give the user a nice default project!

lazy val root = (project in file(".")).

  settings(
    inThisBuild(List(
      organization := "com.babs",
      scalaVersion := "2.11.12"
    )),
    name := "sparkProject",
    version := "0.0.1",

//    sparkVersion := "2.3.0",

    libraryDependencies ++= Seq(
//      "org.apache.spark" %% "spark-streaming" % "2.3.0",
      "org.apache.spark" %% "spark-sql" % "2.3.0",
      "org.apache.spark" %% "spark-core" % "2.3.0",

      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
  )
