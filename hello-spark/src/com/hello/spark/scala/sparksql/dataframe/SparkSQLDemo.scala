package com.hello.spark.scala.sparksql.dataframe

import com.hello.spark.scala.bean.Student
import org.apache.spark.sql.{DataFrameReader, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

object SparkSQLDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()

    sparkConf.setMaster("local").setAppName("SparkSQLDemo")

    val sparkContext = new SparkContext(sparkConf)

    val sqlContext = new SQLContext(sparkContext)

    val lineRDD = sparkContext.textFile("student")


    /**
      * 将RDD隐式转换成DataFrame
      */
    //import sqlContext.implicits._

    // 把普通格式的RDD创建DataFrame
    val studentRDD  = lineRDD.map(line => {
      val student = Student(line.split(",")(0), line.split(",")(1), Integer.valueOf(line.split(",")(2)))
      student
    })


    //导入隐式转换，如果不导入无法将RDD转换成DataFrame
    //将RDD转换成DataFrame
    import sqlContext.implicits._

    val studentDataFrame = studentRDD.toDF();

    //注册表
    studentDataFrame.registerTempTable("student_table")
    //传入SQL
    val df = sqlContext.sql("select * from student_table order by age desc limit 2")
    df.show();
    /**
      *
      +---+------+---+
      | id|  name|age|
      +---+------+---+
      |  3|wangwu| 20|
      |  2|  lisi| 19|
      +---+------+---+
      *
      */

    // 关闭资源
    sparkContext.stop()

  }
}

