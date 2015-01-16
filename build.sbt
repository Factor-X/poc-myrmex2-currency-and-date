name := "currencyAverage"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "joda-time" % "joda-time" % "2.3",
  "org.postgresql" % "postgresql" % "9.3-1101-jdbc41"
)

play.Project.playJavaSettings
