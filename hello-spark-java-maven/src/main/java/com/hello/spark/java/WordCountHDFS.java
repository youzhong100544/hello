package com.hello.spark.java;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WordCountHDFS {

	public static void main(String[] args) throws IOException {
		SparkConf sparkConf = new SparkConf();

		sparkConf.setMaster("local").setAppName("WordCountHDFS");

		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

		Configuration hadoopConfiguration = sparkContext.hadoopConfiguration();
		FileSystem fileSystem = FileSystem.get(hadoopConfiguration);

		String hdfsInputPath = "hdfs://node:9000/user/root/wc.txt";
		String hdfsOutputPath = "hdfs://node:9000/output/spark/wordcount";

		JavaRDD<String> line = sparkContext.textFile(hdfsInputPath);
		FsStatus status = fileSystem.getStatus(new Path(hdfsInputPath));
		System.out.println(status.toString());
		FileStatus fileStatus = fileSystem.getFileStatus(new Path(hdfsInputPath));
		BlockLocation[] fileBlockLocations = fileSystem.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
		for (int i = 0; i < fileBlockLocations.length; i++) {
			System.out.println(fileBlockLocations[i]);
		}

		JavaRDD<String> words = line.flatMap(new FlatMapFunction<String,String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Iterator<String> call(String line) throws Exception {

				return Arrays.asList(line.split(" ")).iterator();
			}

		});


		JavaPairRDD<String,Integer> pair = words.mapToPair(new PairFunction<String, String, Integer>() {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;


			public Tuple2<String, Integer> call(String word) throws Exception {
				return new Tuple2<String, Integer>(word, 1);
			}
		});

		JavaPairRDD<String,Integer> result = pair.reduceByKey(new Function2<Integer, Integer, Integer>() {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

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

			public void call(Tuple2<String, Integer> tuple) throws Exception {
				System.out.println(tuple);
			}
		});
		// 排序
		// K V 倒置
		JavaPairRDD<Integer, String> keyValueConvertResult = result.mapToPair(new PairFunction<Tuple2<String,Integer>, Integer, String>() {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

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

			public void call(Tuple2<Integer, String> tuple) throws Exception {

				System.out.println(tuple._2 + "," + tuple._1);
			}
		});


		List<Tuple2<Integer,String>> take = resultSortByKey.take(3);
		for (Tuple2<Integer, String> tuple : take) {
			System.out.println(tuple._2 + "," + tuple._1);;
		}

		if (fileSystem.exists(new Path(hdfsOutputPath))) {
			fileSystem.delete(new Path(hdfsOutputPath),true);
		}

		resultSortByKey.saveAsTextFile(hdfsOutputPath);

		sparkContext.close();
	}
}

