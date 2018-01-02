package com.hello.spark.scala.sparksql

import com.hello.spark.scala.bean.Student
import org.apache.spark.sql.{SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

object SparkSQLDemo {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()

    sparkConf.setMaster("local").setAppName("SparkSQLDemo-Scala")

    val sparkContext = new SparkContext(sparkConf)

    val sqlContext = new SQLContext(sparkContext)

    val lineRDD = sparkContext.textFile("./student")
    
    lineRDD.map(line => {
      
    })
    // TODO
		System.out.println("1----------------------------------------------------------------------------------------------------------------");
		

    // 关闭资源
    sparkContext.stop()

  }
}

