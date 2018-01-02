package com.hello.spark.scala.sparkstreaming

import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Durations
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.dstream.DStream

object SparkStreamingDemo {
  
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setMaster("local[2]").setAppName("SparkStreamingDemo-Scala")
    
    val sparkContext = new SparkContext()
    
    val streamingContextBySparkContext = new StreamingContext(sparkContext,Durations.seconds(5))
    
    val streamingContext = new StreamingContext(sparkConf,Durations.seconds(5))
    
    val linesDStream : ReceiverInputDStream[String] = streamingContext.socketTextStream("node1", 9999)
    
    val wordsDStream : DStream[String] = linesDStream.flatMap((line : String) => {
      line.split(" ")
    })
    
    val pairDStream : DStream[ Tuple2[String, Integer]] = wordsDStream.map(word => {
      new Tuple2[String, Integer](word, 1)
    })
    
    val resultDStream : DStream[ Tuple2[String, Integer]] = pairDStream.reduceByKey( _ + _)
    
    resultDStream.print()
    
    streamingContext.start()
    
    streamingContext.awaitTermination()
    
    streamingContext.stop()
  }
  
}