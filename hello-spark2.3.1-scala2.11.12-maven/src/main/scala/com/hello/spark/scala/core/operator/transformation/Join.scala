package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Join {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("JoinOperator").setMaster("local")

    val sc = new SparkContext(conf)


    val nameList = Array(Tuple2(1,"Angelababy"),Tuple2(2,"hanhong"),Tuple2(3,"dilireba"),(4,"gaoyuanyuan"))
    val scoreList = Array(Tuple2(1,101),Tuple2(2,66),Tuple2(3,100),Tuple2(3,103),Tuple2(5,108))
    /**
      * makeRDD:可以将一个本地集合变成一个RDD
      * parallilize:可以将一个本地集合变成一个RDD
      */
    val nameRDD :RDD[(Int,String)] = sc.makeRDD(nameList,3)
    println("nameRDD.partitions.size=" + nameRDD.partitions.size)
    val scoreRDD :RDD[(Int,Int)] = sc.parallelize(scoreList,2)
    println("scoreRDD.partitions.size=" + scoreRDD.partitions.size)

    // join是内连接
    /**
      * join内连接
      * (Int:key的类型,(Int：scoreRDD中value的类型,String：nameRDD中value的类型)
      * 返回的这个RDD的泛型与join的这两个RDD的顺序有关
      * resultRDD 会有几条记录？
      */
    println("join:-----------------------------------------------------" )
    val resultRDD :RDD[(Int,(String,Int))] = nameRDD.join(scoreRDD)
    println("resultRDD.partitions.size=" + resultRDD.partitions.size)

    println("join-foreach:-----------------------------------------------------" )
    resultRDD.foreach(result=>{
      println(result)

      val id = result._1
      val name = result._2._1
      val score = result._2._2

      println("id:" +id +"\tname:" +name + "\tscore:" + score)

    })
    println("join-foreach:-----------------------------------------------------" )

    println("join-foreachPartition:-----------------------------------------------------" )
    resultRDD.foreachPartition(partiton=> {
      // println(partiton.size)
      // partiton.size 不能执行这个方法，否则下面的foreach方法里面会没有数据，
      // 因为iterator只能被执行一次
      partiton.foreach(line => {
        //save(line)  落地数据

        println(line)
      })

    })
    println("join-foreachPartition:-----------------------------------------------------" )

    println("join:-----------------------------------------------------" )


    /**
      * leftOuterJoin 是以左边RDD中的 数据内容作为标准
      * fullOuterJoin()
      */

    println("leftOuterJoin:-----------------------------------------------------" )
    val leftOuterJoinResultRDD = nameRDD.leftOuterJoin(scoreRDD)


    /**
      * foreach vs foreachPartition的区别：
      *
      */
    leftOuterJoinResultRDD.foreachPartition(x => {
      while(x.hasNext){
        //next方法在while循环中  只能调用一次，调用多次汇报游标越界的错误
        val log = x.next
        val id = log._1
        val name = log._2._1
        val score = log._2._2
        println("id:" +id +"\tname:" +name + "\tscore:" + score)
      }
    })
    println("leftOuterJoin:-----------------------------------------------------" )

    sc.stop()
  }
}
