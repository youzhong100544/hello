package com.hello.spark.scala.streaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Durations, StreamingContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf : SparkConf = new SparkConf().setMaster("local[2]").setAppName("WordCount")


    val ssc : StreamingContext = new StreamingContext(sparkConf,Durations.seconds(5))

    ssc.checkpoint("d:/StreamingReceiverData")

    val linesDStream : ReceiverInputDStream[String] = ssc.socketTextStream("node", 9999, StorageLevel.MEMORY_AND_DISK_SER)

    val wordsDStream : DStream[String] = linesDStream.flatMap { _.split(" ") }

    // val pairDStream : DStream[Tuple2[String, Integer]] = wordsDStream.map { (_,1) }
    val pairDStream : DStream[(String, Integer)] = wordsDStream.map { (_,1) }

    val resultDStream : DStream[(String, Integer)] = pairDStream.reduceByKey(_+_)

    resultDStream.print()

    ssc.start()
    ssc.awaitTermination()
    ssc.stop()

  }
}
