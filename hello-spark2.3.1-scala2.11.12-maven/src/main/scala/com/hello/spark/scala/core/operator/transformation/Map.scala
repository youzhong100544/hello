package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Map {
  def main(args: Array[String]) : Unit = {

    val conf = new SparkConf().setAppName("Map").setMaster("local")
    val sc = new SparkContext(conf)


    val rdd : RDD[Int] = sc.parallelize(1 to 9, 3)

    // val rdd1 : RDD[Int] = rdd.map(num => {num * 2})
    val rdd1 : RDD[Int] = rdd.map(num * 2)

    rdd1.collect().foreach(println)

  }





}
