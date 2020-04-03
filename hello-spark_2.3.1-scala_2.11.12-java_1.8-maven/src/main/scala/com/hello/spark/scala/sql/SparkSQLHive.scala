package com.hello.spark.scala.sql

import org.apache.spark.sql.SparkSession

object SparkSQLHive {
  def main(args: Array[String]): Unit = {
    // 获取环境变量
    val env_Java_HOME = System.getenv("Java_HOME")
    println("Java_HOME： " + env_Java_HOME)

    println("Java_HOME： " + System.getProperty("java.home"))

    println("user.dir： " + System.getProperty("user.dir"))

    System.setProperty("HADOOP_HOME","C:/develop/hadoop-3.1.0")
    System.setProperty("SPARK_HOME","C:/develop/spark-2.3.0-bin-hadoop2.7")


    // val sparkSession: SparkSession = SparkSession.builder().appName("SparkSQLHive").master("local[*]").enableHiveSupport().getOrCreate()

    // sparkSession.sql("show databases").collect().foreach(println)


  }


}
