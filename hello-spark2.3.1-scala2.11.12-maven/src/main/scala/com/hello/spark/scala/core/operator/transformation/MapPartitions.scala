package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

object MapPartitions {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf().setAppName("MapPartitions").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(1 to 10,3)

    val result = rdd.mapPartitions((x: Iterator[Int]) => {
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
