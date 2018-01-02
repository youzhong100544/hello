package com.hello.spark.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;

import scala.Tuple2;

public class WordCount {

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf();

		sparkConf.setMaster("local").setAppName("WordCount");

		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);


		JavaRDD<String> line = sparkContext.textFile("C:\\Users\\dafochaodong\\Desktop\\wc.txt");


		JavaRDD<String> words = line.flatMap(new FlatMapFunction<String, String>() {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Iterable<String> call(String line) {
				return Arrays.asList(line.split(" "));
			}
		});

		JavaPairRDD<String,Integer> pair = words.mapToPair(new PairFunction<String, String, Integer>() {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;


			@Override
			public Tuple2<String, Integer> call(String word) throws Exception {
				return new Tuple2<String, Integer>(word, 1);
			}
		});

		JavaPairRDD<String,Integer> result = pair.reduceByKey(new Function2<Integer, Integer, Integer>() {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Integer call(Integer i1, Integer i2) throws Exception {
				return i1 + i2;
			}
		});

		// 遍历打印
		result.foreach(new VoidFunction<Tuple2<String,Integer>>() {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void call(Tuple2<String, Integer> tuple) throws Exception {
				System.out.println(tuple);
			}
		});
		// 排序
		// K V 倒置
		JavaPairRDD<Integer,String> keyValueConvertResult = result.mapToPair(new PairFunction<Tuple2<String,Integer>, Integer, String>() {

			@Override
			public Tuple2<Integer, String> call(Tuple2<String, Integer> tuple) throws Exception {
				return new Tuple2<Integer, String>(tuple._2, tuple._1);
			}
		});

		JavaPairRDD<Integer,String> resultSortByKey = keyValueConvertResult.sortByKey(false);


		resultSortByKey.foreach(new VoidFunction<Tuple2<Integer,String>>() {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void call(Tuple2<Integer, String> tuple) throws Exception {

				System.out.println(tuple._2 + "," + tuple._1);
			}
		});


		List<Tuple2<Integer,String>> take = resultSortByKey.take(3);
		for (Tuple2<Integer, String> tuple : take) {
			System.out.println(tuple._2 + "," + tuple._1);;
		}

		sparkContext.close();
	}
}

