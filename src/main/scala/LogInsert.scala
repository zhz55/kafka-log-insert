import java.text.SimpleDateFormat

import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.kafka010.{KafkaUtils, LocationStrategies, OffsetRange}

import scala.collection.JavaConverters._
import rules._
import ctitc.seagoing.SEAGOING.VehiclePosition
import org.apache.kudu.spark.kudu.KuduContext

/**
  * Created by zhz55 on 2018/1/24.
  */
object LogInsert {
  case class TableStructureVehiclePosition(vehicleno : String, platecolor : Int,
                                           positiontime : Long, accesscode : Int,
                                           city : Int, curaccesscode : Int,
                                           trans : Int, updatetime : Long,
                                           encrypt : Int, lon : Int, lat : Int,
                                           vec1 : Int, vec2 : Int, vec3 : Int,
                                           direction : Int, altitude : Int,
                                           state : Long, alarm : Long,
                                           reserved : String, errorcode : String,
                                           roadcode : Int)

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("LogInsertKudu").setMaster("yarn")
    val sparkContext = new SparkContext(conf)
    var startingOffset = 0l
    var endingOffset = 0l


    if(!args(0).isEmpty() && !args(1).isEmpty()) {
      startingOffset = args(0).toLong
      endingOffset = args(1).toLong
    }

    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "kf01:9092,kf02:9092,kf03:9092,kf04:9092,kf05:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[org.apache.kafka.common.serialization.ByteArrayDeserializer],
      "group.id" -> "log_insert_kudu",
      "auto.offset.reset" -> ("latest"),
      "enable.auto.commit" -> (false: java.lang.Boolean)
    ).asJava

    val offsetRanges = Array(
      // topic, partition, starting offset, ending offset
      OffsetRange("HYPT_POSITION", 0, startingOffset, endingOffset),
      OffsetRange("LWLK_POSITION", 0, startingOffset, endingOffset)

    )

    for (partition <- 1 to 30) {
      OffsetRange("HYPT_POSITION", partition, startingOffset, endingOffset) +: offsetRanges
      OffsetRange("LWLK_POSITION", partition, startingOffset, endingOffset) +: offsetRanges
    }


    val positionRules = new PositionRules
    val kuduContext = new KuduContext("nn01", sparkContext)
    val tableArray = positionRules.tableArray()

    val rdd = KafkaUtils.createRDD[String, Array[Byte]](
      sparkContext,
      kafkaParams,
      offsetRanges,
      LocationStrategies.PreferConsistent
    )
    val sparkSession = Sp
    import
    try{
      val noRepeatedRdd = rdd.filter(record => !{
        if(!record.value().isEmpty) {
          if(VehiclePosition.parseFrom(record.value()).accessCode
            == positionRules.repeatFilter(record.partition())) false else true
        } else true}).map(record => {
          val positionRecord = VehiclePosition.parseFrom(record.value())
          TableStructureVehiclePosition(
            positionRecord.vehicleNo.trim(), positionRecord.getPlateColor,
            // Date->UnixTime
            {
              if ("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}$".r.pattern.matcher(positionRecord.gnss.positionTime).matches())
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(positionRecord.gnss.positionTime).getTime / 1000
              else 0
            }, positionRecord.accessCode,
            positionRecord.city, positionRecord.getCurAccessCode,
            positionRecord.getTrans, positionRecord.updateTime,
            positionRecord.gnss.getEncrypt, positionRecord.gnss.lon, positionRecord.gnss.lat,
            positionRecord.gnss.getVec1, positionRecord.gnss.getVec2, positionRecord.gnss.getVec3,
            positionRecord.gnss.getDirection, positionRecord.gnss.getAltitude,
            positionRecord.gnss.getState, positionRecord.gnss.getAlarm,
            positionRecord.getReserved, positionRules.positionJudge(positionRecord).toString, 0)
        })

      kuduContext.insertIgnoreRows(
        noRepeatedRdd.filter(record => {
          !positionRules.crossTableFlag(record.positiontime * 1000)
        }).toDF(), tableArray(0)
      )

    }
  }

}
