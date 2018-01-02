package com.hello.spark.scala.sparkstreaming

import org.apache.spark.{SparkConf, SparkContext}

object SparkStreamingDemo {
  
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setMaster("local").setAppName("SparkStreamingDemo-Scala")


    val sparkContext = new SparkContext(sparkConf)
    
    // 关闭资源
    sparkContext.stop()
  }
  
}