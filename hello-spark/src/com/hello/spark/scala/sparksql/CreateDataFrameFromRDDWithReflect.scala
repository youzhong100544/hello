package com.hello.spark.scala.sparksql

import com.hello.spark.scala.bean.Student
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext


object CreateDataFrameFromRDDWithReflect {
  def main(args: Array[String]): Unit = {
    
    val sparkConf = new SparkConf().setMaster("local").setAppName("CreateDataFrameFromRDDWithReflect-Scala")

    val sparkContext = new SparkContext(sparkConf)

    val sqlContext = new SQLContext(sparkContext)

    val path = "C:\\Users\\dell\\Desktop\\student.txt"

    val lineRDD : RDD[String] = sparkContext.textFile(path)

    val studentRDD  = lineRDD.map(line => {
      val student = Student(line.split(",")(0), line.split(",")(1), Integer.valueOf(line.split(",")(2)))
      student
    })
    

    /**
     * 将RDD隐式转换成DataFrame
     */
    //导入隐式转换，如果不导入无法将RDD转换成DataFrame
    import sqlContext.implicits._

    val studentDataFrame = studentRDD.toDF();

    studentDataFrame.show()
    /**
     * 
			+---+--------+---+
      | id|    name|age|
      +---+--------+---+
      |  1|zhangsan| 18|
      |  2|    lisi| 19|
      |  3|  wangwu| 20|
      +---+--------+---+	
     * 
     */
    // TODO
    println("1----------------------------------------------------------------------------------------------------------------")
    
    studentDataFrame.printSchema()
    /**
     * 
				root
         |-- id: string (nullable = true)
         |-- name: string (nullable = true)
         |-- age: integer (nullable = true)
     * 
     */
    // TODO
    println("2----------------------------------------------------------------------------------------------------------------")
    //注册表
    studentDataFrame.registerTempTable("student_table")
    
    //传入SQL
    val df = sqlContext.sql("select * from student_table order by age desc limit 2")
    df.show()
    // TODO
    println("3----------------------------------------------------------------------------------------------------------------")
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