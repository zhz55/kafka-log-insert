
name := "kafka-log-insert"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.1.1" % "provided",
  "org.apache.spark" % "spark-streaming-kafka-0-10_2.11" % "2.1.1" % "provided",
  "org.apache.spark" % "spark-sql_2.11" % "2.1.1" % "provided",
  "org.apache.kudu" % "kudu-spark2_2.11" % "1.4.0"
)

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)