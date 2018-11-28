package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.{SparkConf, SparkContext}

object Filter {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("FilterOperator").setMaster("local")
    val sc = new SparkContext(conf)

    val numbers = Array(1,2,3,4,5)
    val numberRDD = sc.parallelize(numbers)

    val filteredRDD = numberRDD.filter(_ % 2 == 0)
    filteredRDD.foreach(println)
  }
}
