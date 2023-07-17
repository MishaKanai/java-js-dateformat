addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.13.2")
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.3.2")
// uncomment for sbt-locales
addSbtPlugin("io.github.cquiroz" % "sbt-locales" % "4.2.0")

// sbt-sonatype plugin used to publish artifact to maven central via sonatype nexus
// sbt-pgp plugin used to sign the artifcat with pgp keys
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.9.21")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.1")