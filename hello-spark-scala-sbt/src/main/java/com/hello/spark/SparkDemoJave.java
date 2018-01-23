package com.hello.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SparkDemo
 *
 * @author
 * @version
 */
public class SparkDemoJave {

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf();

		sparkConf.setMaster("local").setAppName("SparkDemo-Java");

		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

		// 创建数组
		String[] strArray = {"hello world", "hello java", "hello hadoop", "world is good"};

		Integer[] intArray = new Integer[]{11,22,33,44};

		// 创建集合
		List<String> strList = Arrays.asList(strArray);

		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);

		// 将集合转换成RDD
		JavaRDD<Integer> parallelize = sparkContext.parallelize(intList);// 只有这一种方式


		// 关闭资源
		sparkContext.close();

	}

}
