package com.hello.spark.java.mllib;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class HelloSparkMLlib {
	public static void main(String[] args) {
		// 初始化
		SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkJavaWordCountLocal");
		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);


	}

	/**
	 * 相关性分析
	 *
	 * @param sparkContext
	 */
	private static void correlationAnalysis(JavaSparkContext sparkContext){

	}
}
