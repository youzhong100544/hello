package com.hello.spark.scala.core.operator.transformation

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer


/**
  * Aggregate the elements of each partition, and then the results for all the partitions, using
  * given combine functions and a neutral "zero value". This function can return a different result
  * type, U, than the type of this RDD, T. Thus, we need one operation for merging a T into an U
  * and one operation for merging two U's, as in scala.TraversableOnce. Both of these functions are
  * allowed to modify and return their first argument instead of creating a new U to avoid memory
  * allocation.
  *
  * @param zeroValue the initial value for the accumulated result of each partition for the
  *                  `seqOp` operator, and also the initial value for the combine results from
  *                  different partitions for the `combOp` operator - this will typically be the
  *                  neutral element (e.g. `Nil` for list concatenation or `0` for summation)
  * @param seqOp an operator used to accumulate results within a partition
  * @param combOp an associative operator used to combine results from different partitions
  */
// def aggregate[U: ClassTag](zeroValue: U)(seqOp: (U, T) => U, combOp: (U, U) => U): U = withScope
/**
  * 翻译：
  *   aggregate先对每个分区的元素做聚集，然后对所有分区的结果做聚集，聚集过程中，使用的是给定的聚集函数以及初始值”zero value”。
  *
  *   这个函数能返回一个与原始RDD不同的类型U，因此，需要一个合并RDD类型T到结果类型U的函数，还需要一个合并类型U的函数。
  *   这两个函数都可以修改和返回他们的第一个参数，而不是重新新建一个U类型的参数以避免重新分配内存。
  *
  *   参数zeroValue:
  *           seqOp运算符的每个分区的累积结果的初始值以及combOp运算符的不同分区的组合结果的初始值 - 这通常将是初始元素（例如“Nil”表的列表 连接或“0”表示求和）
  *   参数seqOp:
  *           每个分区累积结果的聚集函数。
  *   参数combOp:
  *           一个关联运算符用于组合不同分区的结果
  *
  */
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
