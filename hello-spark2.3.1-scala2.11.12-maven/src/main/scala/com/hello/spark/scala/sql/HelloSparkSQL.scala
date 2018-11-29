package com.hello.spark.scala.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object HelloSparkSQL {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("WordCount").setMaster("local")
    val hive = SparkSession.builder().enableHiveSupport().config(conf).getOrCreate()
    hive.sql("")

  }
}
