package com.hello.spark.scala.sparksql

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.RowFactory
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StructField

object CreateDataFrameFromRDDWithStruct {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()

    sparkConf.setMaster("local").setAppName("CreateDataFrameFromRDDWithStruct-Scala")

    val sparkContext = new SparkContext(sparkConf)

    val sqlContext = new SQLContext(sparkContext)

    val lineRDD = sparkContext.textFile("./student")
    
    val rowRDD = lineRDD.map(line => {
      RowFactory.create(line.split(",")(0), line.split(",")(1), Integer.valueOf(line.split(",")(2)))
    })
    
    val schema : StructType = StructType(List(
          StructField("id",StringType,true),
          StructField("name",StringType,true),
          StructField("age",IntegerType,true)
          ))
    

    val dataFrame = sqlContext.createDataFrame(rowRDD, schema)
    
    dataFrame.show()
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
		System.out.println("1----------------------------------------------------------------------------------------------------------------");
		
    
    dataFrame.printSchema()
    /**
     * 
				root
         |-- id: string (nullable = true)
         |-- name: string (nullable = true)
         |-- age: integer (nullable = true)
     * 
     */
    // TODO
		System.out.println("2----------------------------------------------------------------------------------------------------------------");
		 
		dataFrame.registerTempTable("student_table")
    
		val selectResult = sqlContext.sql("select * from student_table where id = '1'")
		selectResult.show()
		/**
		 * 
		 	+---+--------+---+
			| id|    name|age|
			+---+--------+---+
			|  1|zhangsan| 18|
			+---+--------+---+
		 * 
		 */
    // TODO
		System.out.println("3----------------------------------------------------------------------------------------------------------------");
		 
		
    // 关闭资源
    sparkContext.stop()
  }
}