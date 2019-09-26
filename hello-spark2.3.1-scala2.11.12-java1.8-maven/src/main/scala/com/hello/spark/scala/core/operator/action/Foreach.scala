package com.hello.spark.scala.core.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext, TaskContext}

object Foreach {
  def main(args: Array[String]) : Unit = {
    val conf = new SparkConf().setAppName("Foreach").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd : RDD[String] = sc.parallelize(List("cat", "dog", "tiger", "lion", "gnu", "crocodile", "ant", "whale", "dolphin", "spider"))

    println("分区数：" + rdd.getNumPartitions)

    // rdd.foreach(println)

    rdd.foreach((word :String) => {
      println("当前partitionId：" + TaskContext.get.partitionId)
      println(word)
    })
  }
}
