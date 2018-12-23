package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.Iterator
import scala.collection.immutable.List
import scala.collection.mutable.ListBuffer

object MapPartitionsWithIndex {
  def main(args: Array[String]) : Unit = {
    val conf = new SparkConf().setAppName("MapPartitionsWithIndex").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(1 to 10,3)

    val result: RDD[String] = rdd.mapPartitionsWithIndex((index: Int, iterator: Iterator[Int]) => {
      val list: scala.collection.mutable.ListBuffer[String] = new ListBuffer[String]()

      while (iterator.hasNext){
        list +=  "[partitionID: " + index + ", value: " + iterator.next() + "]"
      }
      list.iterator
    })

    println(result.count())

    result.foreach(println)

    result.collect().foreach(println)



  }

}
