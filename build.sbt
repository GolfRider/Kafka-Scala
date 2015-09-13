ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka_2.11" % "0.8.2.1"
      exclude("javax.jms", "jms")
      exclude("com.sun.jdmk", "jmxtools")
      exclude("com.sun.jmx", "jmxri"),
      "com.typesafe" % "config" % "1.3.0",
      "org.apache.kafka" % "kafka-clients" % "0.8.2.1"
)


