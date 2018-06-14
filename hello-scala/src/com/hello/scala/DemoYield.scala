package com.hello.scala

import scala.collection.immutable

object DemoYield {

  def main(args: Array[String]): Unit = {

    val i: immutable.IndexedSeq[Int] = for (i <- 1 to 5) yield i

    println("i " + i)
    println("type-i " + i.asInstanceOf[AnyRef].getClass.getName)
    //scala.collection.immutable.Vector

    val v: immutable.IndexedSeq[Int] = for (i <- 1 to 5) yield i * 2

    println("v " + v)
    println("v.size 的值: " + v.size )
    println("v.length 的值: " + v.length )

    // 遍历1
    v.foreach(println)
    // 遍历2
    for (elem <- v) {
      print(elem + ",")
    }

  }
}
