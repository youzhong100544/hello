package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
  * zipPartitions函数将多个RDD按照partition组合成为新的RDD，该函数需要组合的RDD具有相同的分区数，但对于每个分区内的元素数量没有要求。
  * preservesPartitioning表示的是否保留父RDD的partitioner分区信息。
  *
  * def zipPartitions[B: ClassTag, V: ClassTag](rdd2: RDD[B])(f: (Iterator[T], Iterator[B]) => Iterator[V]): RDD[V]
  * def zipPartitions[B: ClassTag, V: ClassTag](rdd2: RDD[B], preservesPartitioning: Boolean)(f: (Iterator[T], Iterator[B]) => Iterator[V]): RDD[V]
  * def zipPartitions[B: ClassTag, C: ClassTag, V: ClassTag](rdd2: RDD[B], rdd3: RDD[C])(f: (Iterator[T], Iterator[B], Iterator[C]) => Iterator[V]): RDD[V]
  *
  *
  */
object ZipPartitions {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ZipPartitionsOperator").setMaster("local")

    val sc = new SparkContext(conf)

    var rdd1 = sc.makeRDD(1 to 5,2)

    var rdd2 = sc.makeRDD(Seq("A","B","C","D","E"),2)

    //rdd1两个分区中元素分布：
    val result1: RDD[String] = rdd1.mapPartitionsWithIndex((index: Int, iterator: Iterator[Int]) => {
      val list: scala.collection.mutable.ListBuffer[String] = new ListBuffer[String]()

      while (iterator.hasNext){
        list +=  "[partitionID: " + index + ", value: " + iterator.next() + "]"
      }
      list.iterator
    })

    result1.foreach(println)

    //rdd2两个分区中元素分布
    val result2: RDD[String] = rdd2.mapPartitionsWithIndex((index: Int, iterator: Iterator[String]) => {
      val list: scala.collection.mutable.ListBuffer[String] = new ListBuffer[String]()

      while (iterator.hasNext){
        list +=  "[partitionID: " + index + ", value: " + iterator.next() + "]"
      }
      list.iterator
    })

    result2.foreach(println)


    println("zipPartitions:-----------------------------------------------------" )
    //rdd1和rdd2做zipPartition
    //可以看到，两个rdd，相同的分区里面会进行按照顺序进行合并。
    val zipPartitions : ((Iterator[Int], Iterator[String]) => Iterator[String]) => RDD[String] = rdd1.zipPartitions(rdd2)

    val result :RDD[String] = rdd1.zipPartitions(rdd2)((rdd1Iterator, rdd2Iterator) =>{
      var result : List[String] = List[String]()
      while(rdd1Iterator.hasNext && rdd2Iterator.hasNext) {

        val i : Integer = rdd1Iterator.next()
        val j : String = rdd2Iterator.next()

        result::=(i + "_" + j)
      }
      result.iterator
    })

    result.foreachPartition(x => {
      x.foreach(line => {
        println(line)
      })
    })

    println("zipPartitions:-----------------------------------------------------" )


    sc.stop()

  }
}
