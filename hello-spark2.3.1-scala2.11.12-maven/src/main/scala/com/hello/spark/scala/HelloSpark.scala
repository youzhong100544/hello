package com.hello.spark.scala

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object HelloSpark {

  def main(args: Array[String]): Unit = {
    val demo = new HelloSpark

    demo.demo_spark_1

    demo.demo_spark_2
  }
}
class HelloSpark {

  def demo_spark_1(): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("MapPartitions").setMaster("local")
    val sc: SparkContext = new SparkContext(conf)

    val rdd = sc.textFile("C:\\Users\\calm\\Desktop\\hello\\hello.txt")

    rdd.collect().foreach(println)

    sc.stop()
  }


  /**
    * SparkSession是Spark 2.0引如的新概念。
    * SparkSession为用户提供了统一的切入点，来让用户学习spark的各项功能。
    *
    * 在spark的早期版本中，SparkContext是spark的主要切入点，由于RDD是主要的API，我们通过sparkcontext来创建和操作RDD。
    * 对于每个其他的API，我们需要使用不同的context。
    * 例如，对于Streming，我们需要使用StreamingContext；对
    * 于sql，使用sqlContext；
    * 对于hive，使用hiveContext。
    *
    * 但是随着DataSet和DataFrame的API逐渐成为标准的API，就需要为他们建立接入点。
    *
    * 所以在spark2.0中，引入SparkSession作为DataSet和DataFrame API的切入点，SparkSession封装了SparkConf、SparkContext和SQLContext。
    *
    * 为了向后兼容，SQLContext和HiveContext也被保存下来。
    *
    *
    */
  def demo_spark_2(): Unit = {
    val sparkSession: SparkSession = SparkSession.builder
      .master("local")
      .appName("HelloSpark")
      .getOrCreate()

    val sc: SparkContext = sparkSession.sparkContext

    val rdd = sc.textFile("C:\\Users\\calm\\Desktop\\hello\\hello.txt")

    rdd.collect().foreach(println)

    sc.stop()
  }


}