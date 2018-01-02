package com.hello.spark.scala.sparkstreaming

import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Durations
import org.apache.spark.SparkConf

object SparkStreamingDemo {
  
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setMaster("local[2]").setAppName("SparkStreamingDemo-Scala")
    
    val streamingContext = new StreamingContext(sparkConf,Durations.seconds(5))

    // 关闭资源
    streamingContext.stop()
  }
  
}