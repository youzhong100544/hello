package com.hello.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparkDemo {

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf();

		sparkConf.setMaster("local").setAppName("SparkDemo-Java");

		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

		// 创建RDD 方式一：SparkContext.textFile(xxx,numPartitions)
		JavaRDD<String> stringJavaRDD = sparkContext.textFile("C:\\Users\\dafochaodong\\Desktop\\wc.txt");


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

		// 创建RDD 方式二：SparkContext.parallelize(seq[],numPartitions)
		// 将集合转换成RDD
		JavaRDD<Integer> javaRDD = sparkContext.parallelize(intList);// 只有这一种方式


		// 创建RDD 方式三：SparkContext.parallelizePairs(seq[Tuple2],numPartitions)
		// TODO ????????????????????????????????????????
		// List<Tuple2> tuple2List = new ArrayList<Tuple2>(); List<Tuple2> 会报错 ？？？？？
		List coursesList = new ArrayList<Tuple2>();
		coursesList.add(new Tuple2<Integer, String>(1, "Spark"));
		coursesList.add(new Tuple2<Integer, String>(2, "Java"));
		coursesList.add(new Tuple2<Integer, String>(3, "Hadoop"));


		List scoresList = Arrays.asList (new Tuple2<Integer, Integer>(1, 100), new Tuple2<Integer, Integer>(2, 90), new Tuple2<Integer, Integer>(3, 70),
										new Tuple2<Integer, Integer>(1, 110), new Tuple2<Integer, Integer>(2, 95), new Tuple2<Integer, Integer>(3, 60));


		JavaPairRDD<Integer, String> courses = sparkContext.parallelizePairs(coursesList);

		JavaPairRDD<Integer, Integer> scroes = sparkContext.parallelizePairs(scoresList);

		// cogroup 算子
		JavaPairRDD<Integer, Tuple2<Iterable<String>, Iterable<Integer>>> coursesScores = courses.cogroup(scroes);

		coursesScores.foreach(new VoidFunction<Tuple2<Integer, Tuple2<Iterable<String>, Iterable<Integer>>>>() {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public void call(Tuple2<Integer, Tuple2<Iterable<String>, Iterable<Integer>>> integerTuple2Tuple2) throws Exception {
				System. out.println("Student ID:" + integerTuple2Tuple2 ._1);

				System. out.println("Student course:" + integerTuple2Tuple2 ._2 ._1);

				System. out.println("Student Score:" + integerTuple2Tuple2 ._2 ._2);

				System. out.println("------------");
			}
		});




		// 关闭资源
		sparkContext.close();

	}

}
