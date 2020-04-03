package com.hello.test.spark.scala.macOS

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object TestSpark {

	val inputPath = "file:///Users/hiahia/develop/hello/"
	val fileInputPath = inputPath + "hello.txt"

	def main(args: Array[String]): Unit = {

		val conf = new SparkConf()
		//conf.setMaster("local").setAppName("SparkScalaWordCount")
		conf.setMaster("local[*]").setAppName("SparkScalaWordCount")

		val sc = new SparkContext(conf)

		val lineRDD : RDD[String] = sc.textFile(fileInputPath)

		lineRDD.collect().foreach(println)
	}


}
