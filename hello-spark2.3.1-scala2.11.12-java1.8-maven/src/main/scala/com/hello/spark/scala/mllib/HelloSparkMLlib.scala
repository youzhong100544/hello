package com.hello.spark.scala.mllib

import org.apache.spark.{SparkConf, SparkContext}

object HelloSparkMLlib {
  def main(args: Array[String]): Unit = {
    // 初始化
    val conf = new SparkConf().setMaster("local").setAppName("HelloSparkMLlib-scala")
    val sc = new SparkContext(conf)

    val sparkMLlib = new HelloSparkMLlib

    sparkMLlib.correlationAnalysis(sc);
  }

}
class HelloSparkMLlib {
  /**
    * 相关性分析
    *
    * @param sparkContext
    */
  def correlationAnalysis(sparkContext: SparkContext): Unit = {
    val sc = sparkContext



  }
}