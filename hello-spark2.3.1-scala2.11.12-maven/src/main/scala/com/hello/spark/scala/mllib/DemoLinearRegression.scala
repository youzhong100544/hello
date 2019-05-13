package com.hello.spark.scala.mllib

import org.apache.spark.{SparkConf, SparkContext}

object DemoLinearRegression {
  def main(args: Array[String]): Unit = {
    // 初始化
    val conf = new SparkConf().setMaster("local").setAppName("DemoLinearRegression")
    val sc = new SparkContext(conf)

    val sparkMLlib = new HelloSparkMLlib

    sparkMLlib.correlationAnalysis(sc);
  }
}
