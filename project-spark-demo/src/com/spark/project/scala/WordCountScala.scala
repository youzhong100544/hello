package com.spark.project.scala

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD


object WordCountScala {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("WordCount")

    val sc = new SparkContext(conf)

    val path = "C:\\Users\\dell\\Desktop\\hello.txt"

    val lineRDD : RDD[String] = sc.textFile(path)

    val wordRDD : RDD[String] = lineRDD.flatMap((line : String) => {
      line.split(" ")
    })

    val pairRDD : RDD[Tuple2[String, Integer]] = wordRDD.map(word => {
      new Tuple2(word, 1)
    })


    val resultRDD : RDD[Tuple2[String, Integer]] = pairRDD.reduceByKey(_+_)

    // 一 输出到文件
    //resultRDD.saveAsTextFile("C:\\Users\\dafochaodong\\Desktop\\WordCountResult.txt")

    // 二 输出控制台
    resultRDD.collect().foreach(println)

    // 排序
    // 方式一
    val resultSort = resultRDD.sortBy(tuple => {tuple._2}, false)

    resultSort.collect().foreach(println)

    // 排序
    // 方式二
    val result = resultRDD.map(tuple => {new Tuple2(tuple._2, tuple._1)})
    val value = result.sortByKey(false)
    value.collect().foreach(println)


    val value1 = value.map(tuple => {new Tuple2(tuple._2, tuple._1)})
    value1.collect().foreach(println)


    sc.stop()
  }
}
