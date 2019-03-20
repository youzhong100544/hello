package com.hello.spark.scala.core.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Foreach {
  def main(args: Array[String]) : Unit = {
    val conf = new SparkConf().setAppName("Foreach").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd : RDD[String] = sc.parallelize(List("cat", "dog", "tiger", "lion", "gnu", "crocodile", "ant", "whale", "dolphin", "spider"))

    rdd.foreach(println)

  }
}
