package com.hello.spark.java.sparksql;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SaveMode;


public class CreateDataFrameFromMysql {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf();
		conf.setMaster("local").setAppName("CreateDataFrameFromMysql-Java");
		/**
		 * 	配置join或者聚合操作shuffle数据时分区的数量
		 */
//		conf.set("spark.sql.shuffle.partitions", "1");
		
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		SQLContext sqlContext = new SQLContext(sc);
		/**
		 * 第一种方式读取MySql数据库表，加载为DataFrame
		 */
		Map<String, String> options = new HashMap<String,String>();
		options.put("url", "jdbc:mysql://192.168.11.61:3306/spark");
		options.put("driver", "com.mysql.jdbc.Driver");
		options.put("user", "root");
		options.put("password", "100200");
		options.put("dbtable", "student");
		
		DataFrame student = sqlContext.read().format("jdbc").options(options).load();
		student.show();
		student.registerTempTable("student_table");
		/**
		 * 第二种方式读取MySql数据表加载为DataFrame
		 */
		DataFrameReader reader = sqlContext.read().format("jdbc");
		reader.option("url", "jdbc:mysql://192.168.11.61:3306/spark");
		reader.option("driver", "com.mysql.jdbc.Driver");
		reader.option("user", "root");
		reader.option("password", "100200");
		reader.option("dbtable", "score");
		DataFrame score = reader.load();
		score.show();
		score.registerTempTable("score_table");
		
		DataFrame result = 
				sqlContext.sql("select student_table.id,student_table.name,student_table.age,score_table.score "
						+ "from student_table, score_table "
						+ "where student_table.id = score_table.id");
		result.show();
		
		/**
		 * 将DataFrame结果保存到Mysql中
		 */
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "100200");
		/**
		 * SaveMode:
		 * Overwrite：覆盖
		 * Append:追加
		 * ErrorIfExists:如果存在就报错
		 * Ignore:如果存在就忽略
		 * 
		 */
		
		result.write().mode(SaveMode.Overwrite).jdbc("jdbc:mysql://192.168.11.61:3306/spark", "result", properties);
		System.out.println("----Finish----");
		sc.stop();
		
		
	}
}
