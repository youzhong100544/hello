package com.hello.scala

import scala.collection.mutable

object DemoMap {

  def main(args: Array[String]): Unit = {



  }

  def immutable_Map(): Unit ={
    /*
    （1）不可变Map
          特点：
            api不太丰富
            如果是var修饰，引用可变，支持读写
            如果是val修饰，引用不可变，只能写入一次值，其后只读
     */

    // 如果是不可变得的map，直接Map(key->value),如map，
    // 但是如果是可变的map,则必须要类型明确标明scala.collection.mutable.Map，否则编译器不会报错，但是执行的话会报错误。
    var a: Map[String, Int] = Map("k1"->1,"k2"->2)//初始化构造函数
    println("遍历：")
    a.foreach{case (e,i) => println(e,i)} //遍历打印

    println("添加元素：")
    a += ("k3"->3)//添加元素
    a += ("k4"->4)//添加元素
    println("遍历：")
    a.foreach{case (e,i) => println(e,i)} //遍历打印

    println("添加元素：已经存在添加元素会覆盖")
    a += ("k1"->100)//已经存在添加元素会覆盖
    println("遍历：")
    a.foreach{case (e,i) => println(e,i)} //遍历打印

    println("删除元素：")
    a -= ("k2","k1")//删除元素
    println("遍历：")
    a.foreach{case (e,i) => println(e,i)} //遍历打印

    //immutable不可变，它不具有以下操作
    //a("k1") = 177
    /*
    Error:(21, 5) value update is not a member of Map[String,Int]
    Note: implicit value KeyOrdering is not applicable here because it comes after the application point and it lacks an explicit result type
    a("k1") = 177//不支持
     */
    // a.foreach{case (e,i) => println(e,i)} //遍历打印

    println()
    println("--------------------------------------------------------------------------")
    println()

    println( "a 中的键为 : " + a.keys )
    println( "a 中的值为 : " + a.values )
    println("是否包含某元素：" + a.contains("k6"))//是否包含某元素
    println("大小：" + a.size)//大小
    println("判断是否为空：" + a.isEmpty)//判断是否为空

    println("根据key读取元素，不存在就替换成默认值：")
    println("get-k1：")
    println(a.get("k1").getOrElse("default")) //根据key读取元素，不存在就替换成默认值
    println("遍历：")
    a.foreach{case (e,i) => println(e,i)} //遍历打印

    println("get-k3：")
    println(a.get("k3").getOrElse("default")) //根据key读取元素，不存在就替换成默认值
    println("遍历：")
    a.foreach{case (e,i) => println(e,i)} //遍历打印

    println()
    println("--------------------------------------------------------------------------")
    println()

    // 遍历
    println("遍历：")
    println("遍历方法1：")
    a.foreach{case (e,i) => println(e,i)}
    println("遍历方法2：")
    for((k,v) <- a) println(k,v)
    println("遍历方法3：")
    a.keys.foreach{ i =>
      print( "Key = " + i )
      println(" Value = " + a(i) )
    }

    println("只打印key：")
    a.keys.foreach(println)//只打印key
    println("只打印value")
    a.values.foreach(println)//只打印value

    println("数据清空使用再次new：")
    a=Map()//数据清空使用再次new
    println("大小：" + a.size)//大小
    println("判断是否为空：" + a.isEmpty)//判断是否为空

    println()
    println("--------------------------------------------------------------------------")
    println()

    println("排序：")
    println("添加元素：")
    a += ("k3"->3)//添加元素
    a += ("k2"->2)//添加元素
    a += ("k1"->1)//添加元素
    a += ("k4"->4)//添加元素
    println("遍历：")
    a.foreach{case (e,i) => println(e,i)} //遍历打印

    println()
    println()

    println("排序a1：")
    var a1: Seq[(String, Int)] =  a.toSeq.sortBy(_._1)//升序排序 key
    println("遍历a1：")

    var a11: List[(String, Int)] =  a.toList.sortBy(_._1)//升序排序 key
    println("遍历a11：")
    a11.foreach(line => println(line._1 +"\t"+ line._2))

    var a111: Seq[(String, Int)] =  a.toList.sortBy(_._1)//升序排序 key
    println("遍历a111：")
    a111.foreach(line => println(line._1 +"\t"+ line._2))

    println("排序a2：")
    var a2: Seq[(String, Int)] =  a.toSeq.sortBy(_._2)//升序排序 value
    println("遍历：")
    a2.foreach{case (e,i) => println(e,i)} //遍历打印

    /*
    println("排序：")
    var a1: Seq[(String, Int)] =  a.toSeq.sortWith(_._1>_._1) //降序排序 key
    println("遍历：")
    a.foreach{case (e,i) => println(e,i)} //遍历打印

    println("排序：")
    var a1: Seq[(String, Int)] =  a.toSeq.sortWith(_._2>_._2) //降序排序 value
    println("遍历：")
    a.foreach{case (e,i) => println(e,i)} //遍历打印


    println("自定义按英文字母或数字排序：")
    //下面自定义按英文字母或数字排序
    implicit  val KeyOrdering = new Ordering[String] {
      override def compare(x: String, y: String): Int = {
        x.compareTo(y)
      }
    }
    println(a.toSeq.sorted)
     */
  }

  def mutable_Map(): Unit ={
    /*
     （2）可变Map例子
          特点：
            api丰富与Java中Map基本类似
            如果是var修饰，引用可变，支持读写
            如果是val修饰，引用不可变，支持读写
     */

    // 不可变Map+var关键词修饰例子
    // 如果是不可变得的map，直接Map(key->value),如map，
    // 但是如果是可变的map,则必须要类型明确标明scala.collection.mutable.Map，否则编译器不会报错，但是执行的话会报错误。
    var a: scala.collection.mutable.Map[String,Int] = scala.collection.mutable.Map("k1"->1,"k2"->2)//初始化构造函数
    a += ("k3"->3)//添加元素
    a += ("k4"->4)//添加元素
    a += ("k1"->100)//已经存在添加元素会覆盖
    a += ("k1"->100,"k9"->9)//添加多个元素
    a -= ("k2","k1")//删除元素
    a ++= List("CA" -> 23, "CO" -> 25)//追加集合
    a --= List("AL", "AZ")//删除集合

    a.retain((k,v)=> k=="k1")//只保留等于k1元素，其他的删除
    a.put("put1",200)//put
    a.remove("k2")//remove
    a.clear()//清空
    a("k3")=100//支持

    println(a.contains("k6"))//是否包含某元素
    println(a.size)//打印大小
    println(a.get("k1").getOrElse("default")) //根据key读取元素，不存在就替换成默认值
    a.foreach{case (e,i) => println(e,i)} //遍历打印1
    for( (k,v)<-a ) println(k,v) //遍历打印2
    println(a.isEmpty)//判断是否为空
    a.keys.foreach(println)//只打印key
    a.values.foreach(println)//只打印value
    a=scala.collection.mutable.Map()//引用能变
    println(a.size)
    a.toSeq.sortBy(_._1)//排序 key
    a.toSeq.sortBy(_._2)//排序 value
    a.toSeq.sortWith(_._1>_._1) //降序排序 key
    a.toSeq.sortWith(_._2>_._2) //降序排序 value

    //下面自定义按英文字母或数字排序
    implicit  val KeyOrdering=new Ordering[String] {
      override def compare(x: String, y: String): Int = {
        x.compareTo(y)
      }
    }
    println(a.toSeq.sorted)
  }


  def convert_Map(): Unit ={

    //Java 与 Scala 集合互转
    //导入包
    import  collection.JavaConverters._
    import  collection.JavaConversions._
    import java.util.ArrayList;
    // scala 转 java
    val ja  =List(1,5,3).asJava
    println(List(1,5,3))
    println(ja)
    // java 转 scala
    val s =new java.util.ArrayList(3).asScala;


  }


}
