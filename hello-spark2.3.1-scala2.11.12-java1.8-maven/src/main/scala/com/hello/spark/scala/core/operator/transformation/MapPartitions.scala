package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext, TaskContext}

import scala.collection.immutable.List
import scala.collection.mutable.ListBuffer

object MapPartitions {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf().setAppName("MapPartitions").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(1 to 10,3)

    println("分区数：" + rdd.getNumPartitions)

    val result : RDD[String] = rdd.mapPartitions((x: Iterator[Int]) => {

      println("当前partitionId：" + TaskContext.get.partitionId)

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

    println("++++++++++++++++++++++++++++++++++++++++++++")

    val result1 : RDD[(Int, List[Int])]= rdd.mapPartitions((iterator: Iterator[Int]) => {

      println("当前partitionId：" + TaskContext.get.partitionId)

      var map = scala.collection.mutable.Map[Int,List[Int]]()
      map += (TaskContext.get.partitionId -> iterator.toList)

      map.iterator.foreach(println)

      map.iterator
    })

    result1.collect()

    //result1.collect().foreach(println)
  }
}
