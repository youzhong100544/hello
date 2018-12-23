package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.{SparkConf, SparkContext}


/**
  * 这个表示的是给每一个元素一个新的id值，这个id值不一定和真实的元素的索引值一致。返回的同样是一个元祖
  * 这个唯一ID生成算法如下：
  *
  * 每个分区中第一个元素的唯一ID值为：该分区索引号，
  *
  * 每个分区中第N个元素的唯一ID值为：(前一个元素的唯一ID值) + (该RDD总的分区数)
  */
object ZipWithUniqueId {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ZipWithUniqueId").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(100 to 110,3)
    val value = rdd.zipWithUniqueId()
    value.foreachPartition(x => {
      x.foreach(line => {
        println(line)
      })
    })


    /*
    18/12/23 23:44:54 INFO Executor: Running task 0.0 in stage 0.0 (TID 0)
    (100,0)
    (101,3)
    (102,6)
    18/12/23 23:44:54 INFO Executor: Finished task 0.0 in stage 0.0 (TID 0). 751 bytes result sent to driver
    (103,1)
    (104,4)
    (105,7)
    (106,10)
    18/12/23 23:44:54 INFO Executor: Finished task 1.0 in stage 0.0 (TID 1). 622 bytes result sent to driver
    (107,2)
    (108,5)
    (109,8)
    (110,11)
    18/12/23 23:44:54 INFO Executor: Finished task 2.0 in stage 0.0 (TID 2). 622 bytes result sent to driver
     */

    sc.stop()
  }

}
