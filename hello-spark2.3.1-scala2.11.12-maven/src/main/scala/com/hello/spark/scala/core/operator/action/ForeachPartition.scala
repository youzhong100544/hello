package com.hello.spark.scala.core.operator.action

import org.apache.spark.{SparkConf, SparkContext, TaskContext}
import org.apache.spark.rdd.RDD

object ForeachPartition {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Foreach").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd : RDD[String] = sc.parallelize(List("cat", "dog", "tiger", "lion", "gnu", "crocodile", "ant", "whale", "dolphin", "spider"), 3)

    println("分区数：" + rdd.getNumPartitions)

    rdd.foreachPartition((word :Iterator[String])=>{
      println("当前partitionId：" + TaskContext.get.partitionId)
      word.foreach(println)
    })
  }
}
