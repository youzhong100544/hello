package com.hello.spark.scala

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local").setAppName("WordCount")


    val context = new SparkContext(conf)

    val lineRDD = context.textFile("C:\\Users\\dafochaodong\\Desktop\\wc.txt")


    val wordRDD = lineRDD.flatMap((line : String) => {
      line.split(" ")
    })

    val pairRDD = wordRDD.map(word => {
      new Tuple2(word, 1)
    })


    val resultRDD = pairRDD.reduceByKey(_+_)

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


    context.stop()
  }


}
