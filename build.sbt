import locales._

ThisBuild / scalaVersion := "2.13.10"

// For all Sonatype accounts created on or after February 2021
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"

ThisBuild / publishTo := sonatypePublishTo.value

enablePlugins(ScalaJSPlugin)


lazy val root = project.in(file(".")).
  aggregate(javajsdateformat.js, javajsdateformat.jvm).
  settings(
    publish := {},
    publishLocal := {},
  )

lazy val javajsdateformat = crossProject(JSPlatform, JVMPlatform).in(file(".")).
  enablePlugins(LocalesPlugin).
  settings(
    name := "javajsdateformat",
    version := "0.2",

    // groupId, SCM, license information
    organization := "io.github.mishakanai",
    homepage := Some(url("https://github.com/mishakanai/java-js-dateformat")),
    scmInfo := Some(ScmInfo(url("https://github.com/mishakanai/java-js-dateformat"), "git@github.com:mishakanai/java-js-dateformat.git")),
    developers := List(Developer("Misha", "Kanai", "misha.a.kanai@gmail.com", url("https://github.io/mishakanai"))),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    publishMavenStyle := true,
    sonatypeCredentialHost := "s01.oss.sonatype.org",
    publishTo := sonatypePublishTo.value,
    // disable publish with scala version, otherwise artifact name will include scala version 
    // e.g javajsdateformat_2.13
    crossPaths := false,


    libraryDependencies += "com.lihaoyi" %%% "utest" % "0.7.4" % "test",
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.5.0",
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time-tzdb" % "2.5.0",
    testFrameworks += new TestFramework("utest.runner.Framework"),
  ).
  jvmSettings(
    // Add JVM-specific settings here
  ).
  jsSettings(

    libraryDependencies += "io.github.cquiroz" %%% "scala-java-locales" % "1.5.1",
    // For just english locale DB
    // libraryDependencies += "io.github.cquiroz" %%% "locales-minimal-en-db" % "1.5.1",

    // full locale DB (causes a quite large bundle with locales we don't need)
    // libraryDependencies += "io.github.cquiroz" %%% "locales-full-db" % "1.5.1",

    // for sbt-locales, building custom locale database to reduce bundle size.
    cldrVersion := CLDRVersion.Version("38.1"),
    localesFilter := LocalesFilter.Selection("en", "en-US", "es", "es-419", "es-US"),
    
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
  )
