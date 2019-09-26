package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * cogroup相当于，一个key join上所有value，都给放到一个Iterable里面去！
  * 当（K，V）格式和（K，W）格式的Dstream使用时，返回一个新的DStream（K，Seq [V]，Seq [W]）格式的元组。
  *
  *
  * 数据：
  *  a 100
  *	b 200
  *	c 300
  *	a 400
  *	b 500
  *	c 600
  *
  */
object Cogroup {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("JoinOperator").setMaster("local")

    val sc = new SparkContext(conf)


    val nameList : List[(Int, String)] = List((1, "校长"), (2, "小强"), (3, "小红"), (4, "小明"))
    val nameRdd : RDD[(Int, String)] = sc.parallelize(nameList, 3)

    val scoreList : List[(Int, Int)] = List((1, 100), (2, 59), (3, 12) , (3, 14) , (4, 14) , (5, 14))
    val scoreRdd : RDD[(Int, Int)] = sc.parallelize(scoreList, 2)

    val gradeList : List[(Int, String)] = List((1, "三年级"),(2, "幼儿园"),(3, "五年级"), (6, "六年级"))
    val gradeRdd : RDD[(Int, String)] = sc.parallelize(gradeList, 2)

    val resultRdd : RDD[(Int, (Iterable[String], Iterable[Int], Iterable[String]))] = nameRdd.cogroup(scoreRdd,gradeRdd)

    resultRdd.collect().foreach(println)

    /*
    (6,(CompactBuffer(),CompactBuffer(),CompactBuffer(六年级)))
    (3,(CompactBuffer(小红),CompactBuffer(12, 14),CompactBuffer(五年级)))
    (4,(CompactBuffer(小明),CompactBuffer(14),CompactBuffer()))
    (1,(CompactBuffer(校长),CompactBuffer(100),CompactBuffer(三年级)))
    (5,(CompactBuffer(),CompactBuffer(14),CompactBuffer()))
    (2,(CompactBuffer(小强),CompactBuffer(59),CompactBuffer(幼儿园)))
    */

    resultRdd.collect().foreach((result : (Int, (Iterable[String], Iterable[Int], Iterable[String]))) => {

      val id : Int = result._1
      val name : Iterable[String] = result._2._1
      val score : Iterable[Int] = result._2._2
      val grade : Iterable[String] = result._2._3

      println("id:" +id +"\tname:" +name + "\tscore:" + score + "\tgrade:" + grade)
    })
    /*
    id:6	name:CompactBuffer()	score:CompactBuffer()	grade:CompactBuffer(六年级)
    id:3	name:CompactBuffer(小红)	score:CompactBuffer(12, 14)	grade:CompactBuffer(五年级)
    id:4	name:CompactBuffer(小明)	score:CompactBuffer(14)	grade:CompactBuffer()
    id:1	name:CompactBuffer(校长)	score:CompactBuffer(100)	grade:CompactBuffer(三年级)
    id:5	name:CompactBuffer()	score:CompactBuffer(14)	grade:CompactBuffer()
    id:2	name:CompactBuffer(小强)	score:CompactBuffer(59)	grade:CompactBuffer(幼儿园)
    */


    nameRdd.cogroup(scoreRdd).collect().foreach(println)
    /*
    (3,(CompactBuffer(小红),CompactBuffer(12, 14)))
    (4,(CompactBuffer(小明),CompactBuffer(14)))
    (1,(CompactBuffer(校长),CompactBuffer(100)))
    (5,(CompactBuffer(),CompactBuffer(14)))
    (2,(CompactBuffer(小强),CompactBuffer(59)))
    */

  }
}
