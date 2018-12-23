package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.{SparkConf, SparkContext}

object ZipWithIndex {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ZipWithIndex").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(Array("A", "B", "C", "D", "1", "2"),3)
    val r = rdd.zipWithIndex

    r.foreachPartition(x => {
      x.foreach(line => {
        println(line)
      })
    })

    /*
    18/12/23 23:39:35 INFO Executor: Running task 0.0 in stage 1.0 (TID 2)
    (A,0)
    (B,1)
    18/12/23 23:40:42 INFO Executor: Finished task 0.0 in stage 1.0 (TID 2). 665 bytes result sent to driver
    (C,2)
    (D,3)
    18/12/23 23:40:42 INFO Executor: Finished task 1.0 in stage 1.0 (TID 3). 622 bytes result sent to driver
    (1,4)
    (2,5)
     */

    sc.stop()
  }
}
