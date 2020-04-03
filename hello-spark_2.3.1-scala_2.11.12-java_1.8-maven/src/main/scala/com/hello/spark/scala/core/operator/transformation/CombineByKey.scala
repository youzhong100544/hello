package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

object CombineByKey {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("CombineByKeyOperator")
    val sc = new SparkContext(conf)

    val rdd1 = sc.makeRDD(Array(
      ("A",1),
      ("A",3),
      ("A",4),
      ("A",5),
      ("A",2),
      ("B",1),
      ("B",2),
      ("C",1),
      ("A",2)
    ),3)
    rdd1.mapPartitionsWithIndex((index, iterator) => {
      println(index)
      val list = new ListBuffer[Tuple2[String,Int]]()
      while (iterator.hasNext) {
        val log = iterator.next()
        println(log)
        list += log
      }
      list.iterator
    }).count()

    /**
      * CombineByKey是一个比较底层的算子，用法如下：
      *
      * combineByKey(createCombiner,mergeValue,mergeCombiners,partitioner,mapSideCombine)
      *
      * createCombiner:在第一次遇到Key时创建组合器函数，将RDD数据集中的V类型值转换C类型值（V => C）；
      *
      *
      *
      * mergeValue：合并值函数，再次遇到相同的Key时，将createCombiner的C类型值与这次传入的V类型值合并成一个C类型值（C,V）=>C
      *
      *
      *
      * mergeCombiners:合并组合器函数，将C类型值两两合并成一个C类型值
      *
      * partitioner：使用已有的或自定义的分区函数，默认是HashPartitioner 
      *
      * mapSideCombine：是否在map端进行Combine操作,默认为true
      *
      */
    rdd1.combineByKey(
      (v:Int)=>v+"_",
      (c:String,v:Int) => {c + "@" + v} ,
      (c1:String,c2:String) => c1+"$"+c2,
      4).collect().foreach(println)
  }
}
