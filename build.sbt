// uncomment for sbt-locales
// import locales._
ThisBuild / scalaVersion := "2.13.10"

enablePlugins(ScalaJSPlugin)

lazy val root = project.in(file(".")).
  aggregate(javajsdateformat.js, javajsdateformat.jvm).
  settings(
    publish := {},
    publishLocal := {},
  )

lazy val javajsdateformat = crossProject(JSPlatform, JVMPlatform).in(file(".")).
  // uncomment for sbt-locales
  // enablePlugins(LocalesPlugin).
  settings(
    name := "javajsdateformat",
    version := "0.1-SNAPSHOT",

    libraryDependencies += "com.lihaoyi" %%% "utest" % "0.7.4" % "test",
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.5.0",
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time-tzdb" % "2.5.0",
    testFrameworks += new TestFramework("utest.runner.Framework")
  ).
  jvmSettings(
    // Add JVM-specific settings here
    
  ).
  jsSettings(
    // Add JS-specific settings here
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-locales" % "1.5.1",
    libraryDependencies += "io.github.cquiroz" %%% "locales-full-db" % "1.5.1",
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
    // uncomment for sbt-locales
    // localesFilter := LocalesFilter.Selection("en", "en-US", "es", "es-US")
  )
