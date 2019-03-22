package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.{SparkConf, SparkContext, TaskContext}

import scala.collection.mutable.ListBuffer

object MapPartitions {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf().setAppName("MapPartitions").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(1 to 10,3)

    println("分区数：" + rdd.getNumPartitions)

    val result = rdd.mapPartitions((x: Iterator[Int]) => {

      println("当前partitionId：" + TaskContext.get.partitionId)

      println("当前分区的数据量：" + TaskContext.get.partitionId)

      val list = new ListBuffer[String]()

      while (x.hasNext){
        list += x.next() + "==="
      }
      list.iterator
    })

    println(result.count())

    println(result.collect().length)

    result.foreach(println)


    result.collect().foreach(println)



  }
}
