package com.hello.spark.scala.core.operator.action

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
  * aggregate函数
  *
  * def aggregate[U: ClassTag](zeroValue: U)(seqOp: (U, T) => U, combOp: (U, U) => U): U = withScope
  *
  *     将每个分区里面的元素进行聚合，然后用combine函数将每个分区的结果和初始值(zeroValue)进行combine操作。
  *     这个函数最终返回的类型不需要和RDD中元素类型一致。
  *
  *     seqOp操作会聚合各分区中的元素，然后combOp操作把所有分区的聚合结果再次聚合，两个操作的初始值都是zeroValue.   seqOp的操作是遍历分区中的所有元素(T)，第一个T跟zeroValue做操作，结果再作为与第二个T做操作的zeroValue，直到遍历完整个分区。combOp操作是把各分区聚合的结果，再聚合。
  *     aggregate函数返回一个跟RDD不同类型的值。因此，需要一个操作seqOp来把分区中的元素T合并成一个U，另外一个操作combOp把所有U聚合。
  *
  */
object Aggregate {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("Aggregate").setMaster("local"))

    val data = sc.parallelize(1 to 10, 3)

    val result = data.mapPartitionsWithIndex((index: Int, iterator: Iterator[Int]) => {
      val list: scala.collection.mutable.ListBuffer[String] = new ListBuffer[String]()

      while (iterator.hasNext){
        list +=  "[partitionID: " + index + ", value: " + iterator.next() + "]"
      }
      list.iterator
    })

    result.foreach(println)


    def seqOP(a: Int, b: Int): Int = {
      println("seqOp: " + a + "\t" + b)
      math.min(a, b)
    }

    def combOp(a: Int, b: Int): Int = {
      println("combOp: " + a + "\t" + b)
      a + b
    }

    val i: Int = data.aggregate(0)(seqOP, combOp)

    println(i)

    val j: Tuple2[Int, Int] = data.aggregate((0, 0))((acc,number) => (acc._1 + number, acc._2 + 1), (par1,par2) => (par1._1 + par2._1, par1._2 + par2._2))
    println(j)

    val k: Tuple3[Int, Int, Int] = data.aggregate((0, 0, 0))((acc, number) => (acc._1 * number, acc._2 + number, acc._3 + 1), (x, y) => (x._1 * y._1, x._2 + y._2, x._3 + y._3))
    println(k)


  }
}
