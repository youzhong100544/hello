package com.hello.spark.java.sparksql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class CreateDataFrameFromJsonFile {

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf();
		sparkConf.setMaster("local").setAppName("CreateDataFrameFromJsonFile-Java");
		
		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
		
		SQLContext sqlContext = new SQLContext(sparkContext);
		
		/**
		 * DataFrame的底层是一个一个的RDD  RDD的泛型是Row类型。
		 * 以下两种方式都可以读取json格式的文件
		 */
		org.apache.spark.sql.DataFrameReader dateFrameReader = sqlContext.read();
		
		DataFrame dataFrame = dateFrameReader.format("json").load("./json");

	    // 方式二
		DataFrame dataFrame1 = dateFrameReader.json("./json");
		
		/**
		 * dataFram自带的API 操作DataFrame
		 */
		dataFrame.select("name").show();
		//select name ,age+10 as addage from table
		dataFrame.select(dataFrame.col("name"), dataFrame.col("age").plus(10).alias("addage")).show();
		//select name ,age from table where age>19
		dataFrame.select(dataFrame.col("name"), dataFrame.col("age")).where(dataFrame.col("age").gt(19)).show();
		//select age,count(*) from table group by age
		dataFrame.groupBy(dataFrame.col("age")).count().show();

		/**
		 * 将DataFrame注册成临时的一张表，这张表相当于临时注册到内存中，是逻辑上的表，不会雾化到磁盘
		 */
		dataFrame.registerTempTable("student_table");
		DataFrame sql = sqlContext.sql("select age, count(*) as gg from student_table group by age");
		sql.show();
		DataFrame sql2 = sqlContext.sql("select name, age from student_table");
		sql2.show();
		
		
		// 关闭资源
		sparkContext.close();
	}
}
