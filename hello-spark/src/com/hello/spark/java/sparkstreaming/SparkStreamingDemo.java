package com.hello.spark.java.sparkstreaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkStreamingDemo {

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf();

		sparkConf.setMaster("local").setAppName("SparkDemo-Java");

		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
		
		// 关闭资源
		sparkContext.close();
	}
	
}
