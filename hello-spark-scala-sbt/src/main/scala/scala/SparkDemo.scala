package com.hello.spark.scala

import org.apache.spark.{SparkConf, SparkContext}

object SparkDemo {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()

    conf.setMaster("local").setAppName("SparkDemo-Scala")

    val context = new SparkContext(conf)

    // 创建数组
    val strArr : Array[String]= Array("hello world", "hello java", "hello hadoop", "world is good")

    val intArr : Array[Int]= Array(11, 22, 33, 44, 55)


    // 创建集合
    // List一但创建，其值不能被改变
    val left = List(1,2,3)// 方式一
    val right = List.apply(4,5,6)// 方式二
    // List连接操作
    /**
      * 集合间的链接交互
      */


    //以下操作等价
    println(left ++ right)   // List(1,2,3,4,5,6)
    println(left ++: right)  // List(1,2,3,4,5,6)
    println(right.++:(left))    // List(1,2,3,4,5,6)
    println(right.:::(left))  // List(1,2,3,4,5,6)

    //以下操作等价
    println(0 +: left)    //List(0,1,2,3)
    println(left.+:(0))   //List(0,1,2,3)
    //以下操作等价
    println(left :+ 4 )   //List(1,2,3,4)
    println(left.:+(4) )  //List(1,2,3,4)

    //以下操作等价
    println(0 :: left )     //List(0,1,2,3)
    println(left.::(0) )    //List(0,1,2,3)


    val intList : List[Int] = left ::: right

    // 打印
    println(intList(0))
    // 遍历
    intList.foreach((i : Int ) => {
      print(i)
    })
    println
    // 简写
    intList.foreach(print(_))
    println
    intList.foreach(print)
    println

    // 将集合转换成RDD
    val value = context.makeRDD(intList,1)// 方式一

    val value1 = context.parallelize(intList)// 方式二

    // 关闭资源
    context.stop()

  }

}
