package com.hello.spark.scala

import java.io.File

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import com.hello.spark.scala.util.CommomUtil

object SparkScalaWordCountLocal {

  def main(args: Array[String]): Unit = {

    val inputPath = "C:\\Users\\calm\\Desktop\\hello\\"
    val outputPath = "C:\\Users\\calm\\Desktop\\hello\\output\\spark\\scala"

    val conf = new SparkConf()
    //conf.setMaster("local").setAppName("SparkScalaWordCount")
    conf.setMaster("local[*]").setAppName("SparkScalaWordCount")

    val sc = new SparkContext(conf)

    val lineRDD : RDD[String] = sc.textFile(inputPath + "hello.txt")

    val wordRDD : RDD[String] = lineRDD.flatMap((line : String) => {
      line.split(" ")
    })

    // val pairRDD : RDD[Tuple2[String, Integer]] = wordRDD.map(word => {new Tuple2(word, 1)})
    val pairRDD : RDD[(String, Integer)] = wordRDD.map(word => {new Tuple2(word, 1)})

    // val resultRDD : RDD[Tuple2[String, Integer]] = pairRDD.reduceByKey(_+_)
    val resultRDD : RDD[(String, Integer)] = pairRDD.reduceByKey(_+_)

    resultRDD.collect().foreach(println)

    // 排序
    // 方式一
    val result = resultRDD.sortBy(tuple => {tuple._2}, false)

    result.collect().foreach(println)


    val output: File = new File(outputPath)
    // 删除输出目录
    if (output.exists())
      CommomUtil.deleteDir(output)

    result.saveAsTextFile(outputPath)



    sc.stop()
  }


}
