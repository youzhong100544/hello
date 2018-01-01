package com.hello.spark.scala.sparksql.dataframe

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
 * 读取json格式的文件创建DataFrame
 * 
 * 注意 ：json文件中不能嵌套json格式的内容
 * 
 * 1.读取json格式两种方式
 * 2.df.show默认显示前20行，使用df.show(行数)显示多行
 * 3.df.javaRDD/(scala df.rdd) 将DataFrame转换成RDD
 * 4.df.printSchema()显示DataFrame中的Schema信息
 * 5.dataFram自带的API 操作DataFrame ，用的少
 * 6.想使用sql查询，首先要将DataFrame注册成临时表：df.registerTempTable("jtable")，再使用sql,怎么使用sql?sqlContext.sql("sql语句")
 * 7.不能读取嵌套的json文件
 * 8.df加载过来之后将列按照ascii排序了
 *
 */
object CreateDataFrameFromJsonFile {
  
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()

    sparkConf.setMaster("local").setAppName("SparkSQLDemo-Scala")

    val sparkContext = new SparkContext(sparkConf)

    val sqlContext = new SQLContext(sparkContext)

    val dateframe = sqlContext.read
    dateframe.format("json").load("./json")

    // 关闭资源
    sparkContext.stop()

  }
}