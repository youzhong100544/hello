package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.{SparkConf, SparkContext}

object Zip {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ZipOperator").setMaster("local")

    val sc = new SparkContext(conf)

    val a = sc.parallelize(1 to 10, 3)
    // val b = sc.parallelize(11 to 20, 2)
    // Exception in thread "main" java.lang.IllegalArgumentException: Can't zip RDDs with unequal numbers of partitions: List(3, 2)
    // at org.apache.spark.rdd.ZippedPartitionsBaseRDD.getPartitions(ZippedPartitionsRDD.scala:57)

    val b = sc.parallelize(11 to 20, 3)

    val result = a.zip(b)
    println("foreach:-----------------------------------------------------" )
    println("resultRDD.partitions.size=" + result.partitions.size)
    result.foreach(x => {
      println(x)
    })
    println("foreach:-----------------------------------------------------" )

    println("foreachPartition:-----------------------------------------------------" )
    println("resultRDD.partitions.size=" + result.partitions.size)
    result.foreachPartition(x => {
      x.foreach(line => {
        //save(line)  落地数据

        println(line)
      })
    })
    println("foreachPartition:-----------------------------------------------------" )

    /*
    foreachPartition:-----------------------------------------------------
    resultRDD.partitions.size=3
    (1,11)
    (2,12)
    (3,13)
    // 18/12/23 22:53:58 INFO Executor: Finished task 2.0 in stage 1.0 (TID 5). 622 bytes result sent to driver
    (4,14)
    (5,15)
    (6,16)
    (7,17)
    (8,18)
    (9,19)
    (10,20)
    // 18/12/23 22:53:58 INFO TaskSetManager: Finished task 2.0 in stage 1.0 (TID 5) in 10 ms on localhost (executor driver) (2/3)
    foreachPartition:-----------------------------------------------------

    之前3个分区
    之后变成2个分区

     */

    sc.stop()

  }
}
