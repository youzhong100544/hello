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

    sparkConf.setMaster("local").setAppName("CreateDataFrameFromJsonFile-Scala")

    val sparkContext = new SparkContext(sparkConf)

    val sqlContext = new SQLContext(sparkContext)

   /**
      * 读取json格式两种方式
      */
    val dataFrameReader : org.apache.spark.sql.DataFrameReader = sqlContext.read
    // 方式一
    val dataFrame = dataFrameReader.format("json").load("./json")

    // 方式二
    val dataFrame1 = dataFrameReader.json("./json")

    dataFrame.show()
    dataFrame.printSchema()
    /**
     * 
     	+----+--------+
      | age|    name|
      +----+--------+
      |  20|zhangsan|
      |null|    lisi|
      |  18|  wangwu|
      |  18|  wangwu|
      +----+--------+
      
      root
       |-- age: long (nullable = true)
       |-- name: string (nullable = true)
     * 
     */
    // TODO
		System.out.println("1----------------------------------------------------------------------------------------------------------------");
		
    dataFrame1.show()
    dataFrame1.printSchema()
    /**
     * 
     	+----+--------+
      | age|    name|
      +----+--------+
      |  20|zhangsan|
      |null|    lisi|
      |  18|  wangwu|
      |  18|  wangwu|
      +----+--------+
      
      root
       |-- age: long (nullable = true)
       |-- name: string (nullable = true)
     * 
     */
    // TODO
		System.out.println("2----------------------------------------------------------------------------------------------------------------");
		
    //select * from table
    dataFrame.select(dataFrame.col("name")).show()
    //select name from table where age>19
    dataFrame.select(dataFrame.col("name"),dataFrame.col("age")).where(dataFrame.col("age").gt(19)).show()
    //select count(*) from table group by age
    dataFrame.groupBy(dataFrame.col("age")).count().show();
     
    /**
		 * 将DataFrame注册成临时的一张表，这张表相当于临时注册到内存中，是逻辑上的表，不会雾化到磁盘
		 */
    dataFrame.registerTempTable("jtable")
    val result  = sqlContext.sql("select  * from jtable")
    result.show()
    
    // 关闭资源
    sparkContext.stop()

  }
}