package com.hello.spark.scala.core

import org.apache.spark.{SparkConf, SparkContext}

object HelloSpark {
  def main(args: Array[String]) {
    /**
      * SparkConf对象,是spark的一个配置对象
      * 在sparkconf对象中
      *   1、可以设置spark的运行模式：
      *   2、设置程序application运行所需要的资源
      *   3、给程序起一个名字
      */
    val conf = new SparkConf()
    conf.setAppName("HelloSpark")
    conf.setMaster("local")

    /**
      * spark配置对象创建完毕后，需要再创建一个spark 上下文
      * sc是通往集群的唯一通道
      */
    val sc = new SparkContext(conf)

    val rdd = sc.textFile("C:\\Users\\calm\\Desktop\\hello\\hello.txt")

    println(rdd.count())

    sc.stop()
  }
}
