package com.hello.spark.scala

package com.hello.spark.scala

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object WordCountHDFS {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("WordCount")

    val sc = new SparkContext(conf)

    val lineRdd = sc.textFile(args(0))


    val wordRDD = lineRdd.flatMap ( x => {
      x.split(" ")
    })

    //(_,1) 二元组
    val pairRDD = wordRDD.map ((_,1))

    val resultRDD = pairRDD.reduceByKey((v1:Int,v2:Int) => {
      v1 + v2
    })

    resultRDD.saveAsTextFile(args(1))


    sc.stop()

  }
}
