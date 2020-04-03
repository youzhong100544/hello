package com.hello.spark.scala.core.operator.action

import org.apache.spark.{SparkConf, SparkContext}

object Collect {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CollectOperator").setMaster("local")
    val sc = new SparkContext(conf)

    val numberArray = Array(1,2,3,4,5)
    val numbers = sc.parallelize(numberArray)

    val ints : Array[Int] = numbers.collect()

    println(ints.size)

    println(ints.length)

  }
}
