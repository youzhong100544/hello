package com.hello.spark.java;

import com.hello.spark.java.common.SparkCommon;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.SparkSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelloSpark {

	public static void main(String[] args) throws IOException {

		getIrisDataSetFromResourcesDirectory();


	}


	private static void getIrisDataSetFromResourcesDirectory() throws IOException {

		InputStream in = SparkCommon.class.getClassLoader().getResourceAsStream("dataset/iris.data");
		InputStreamReader isr = new InputStreamReader (in);
		BufferedReader br = new BufferedReader(isr);
		String line;
		List<String> lines = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			lines.add(line);
		}

		SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("HelloSpark");
		JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
		SparkSession sparkSession = SparkSession.builder().appName("HelloSpark").config(sparkConf).getOrCreate();

		JavaRDD<String> linesRDD = javaSparkContext.parallelize(lines);

		Integer defaultParallelism = javaSparkContext.defaultParallelism();
		System.out.println("defaultParallelism:" + defaultParallelism);

		int numPartitions = linesRDD.getNumPartitions();
		System.out.println("getNumPartitions:" + numPartitions);

		// foreach 遍历
		System.out.println("_ begin _ foreach 遍历-----------------------------");
		linesRDD.foreach(new VoidFunction<String>(){
			private static final long serialVersionUID = 1L;
			@Override
			public void call(String line) throws Exception {
				System.out.println("___________begin_______________");
				System.out.println(line);
				System.out.println("___________end_________________");
			}

		});
		System.out.println("_ end _ foreach 遍历-----------------------------");
        /*
 _ begin _ foreach 遍历-----------------------------
20/04/02 20:47:12 INFO SparkContext: Starting job: foreach at SparkCommon.java:261
20/04/02 20:47:12 INFO DAGScheduler: Got job 0 (foreach at SparkCommon.java:261) with 4 output partitions
20/04/02 20:47:12 INFO DAGScheduler: Final stage: ResultStage 0 (foreach at SparkCommon.java:261)
......
___________begin_______________
5.1,3.5,1.4,0.2,Iris-setosa
___________end_________________
___________begin_______________
4.9,3.1,1.5,0.1,Iris-setosa
___________end_________________
___________begin_______________
4.4,3.0,1.3,0.2,Iris-setosa
___________end_________________

......

___________begin_______________
5.5,3.5,1.3,0.2,Iris-setosa
___________end_________________
20/04/02 20:47:13 INFO Executor: Finished task 2.0 in stage 0.0 (TID 2). 708 bytes result sent to driver
20/04/02 20:47:13 INFO Executor: Finished task 3.0 in stage 0.0 (TID 3). 622 bytes result sent to driver
20/04/02 20:47:13 INFO DAGScheduler: ResultStage 0 (foreach at SparkCommon.java:261) finished in 0.404 s
20/04/02 20:47:13 INFO DAGScheduler: Job 0 finished: foreach at SparkCommon.java:261, took 0.477976 s
_ end _ foreach 遍历-----------------------------
        * */


		// foreachPartition 遍历
		System.out.println("_begin_ foreachPartition 遍历");
		linesRDD.foreachPartition(new VoidFunction<java.util.Iterator<String>>() {
			private static final long serialVersionUID = 1L;
			@Override
			public void call(java.util.Iterator<String> partition) throws Exception {
				System.out.println("___________begin_______________");
				while (partition.hasNext()) {
					System.out.println(partition.next());
				}
				System.out.println("___________end_________________");
			}
		});
		System.out.println("_end_ foreachPartition 遍历-----------------------------");
        /*
_begin_ foreachPartition 遍历
20/04/02 20:47:13 INFO SparkContext: Starting job: foreachPartition at SparkCommon.java:276
20/04/02 20:47:13 INFO DAGScheduler: Got job 1 (foreachPartition at SparkCommon.java:276) with 4 output partitions
20/04/02 20:47:13 INFO DAGScheduler: Final stage: ResultStage 1 (foreachPartition at SparkCommon.java:276)
20/04/02 20:47:13 INFO DAGScheduler: Parents of final stage: List()
20/04/02 20:47:13 INFO DAGScheduler: Missing parents: List()
20/04/02 20:47:13 INFO DAGScheduler: Submitting ResultStage 1 (ParallelCollectionRDD[0] at parallelize at SparkCommon.java:251), which has no missing parents
20/04/02 20:47:13 INFO MemoryStore: Block broadcast_1 stored as values in memory (estimated size 1688.0 B, free 1990.8 MB)
20/04/02 20:47:13 INFO MemoryStore: Block broadcast_1_piece0 stored as bytes in memory (estimated size 1148.0 B, free 1990.8 MB)
20/04/02 20:47:13 INFO BlockManagerInfo: Added broadcast_1_piece0 in memory on DESKTOP-8BP3NLN.mshome.net:4804 (size: 1148.0 B, free: 1990.8 MB)
20/04/02 20:47:13 INFO SparkContext: Created broadcast 1 from broadcast at DAGScheduler.scala:1039
20/04/02 20:47:13 INFO DAGScheduler: Submitting 4 missing tasks from ResultStage 1 (ParallelCollectionRDD[0] at parallelize at SparkCommon.java:251) (first 15 tasks are for partitions Vector(0, 1, 2, 3))
20/04/02 20:47:13 INFO TaskSchedulerImpl: Adding task set 1.0 with 4 tasks
20/04/02 20:47:13 INFO TaskSetManager: Starting task 0.0 in stage 1.0 (TID 4, localhost, executor driver, partition 0, PROCESS_LOCAL, 8965 bytes)
20/04/02 20:47:13 INFO TaskSetManager: Starting task 1.0 in stage 1.0 (TID 5, localhost, executor driver, partition 1, PROCESS_LOCAL, 9095 bytes)
20/04/02 20:47:13 INFO TaskSetManager: Starting task 2.0 in stage 1.0 (TID 6, localhost, executor driver, partition 2, PROCESS_LOCAL, 9134 bytes)
20/04/02 20:47:13 INFO TaskSetManager: Starting task 3.0 in stage 1.0 (TID 7, localhost, executor driver, partition 3, PROCESS_LOCAL, 9079 bytes)
20/04/02 20:47:13 INFO Executor: Running task 0.0 in stage 1.0 (TID 4)
20/04/02 20:47:13 INFO Executor: Running task 1.0 in stage 1.0 (TID 5)
20/04/02 20:47:13 INFO Executor: Running task 3.0 in stage 1.0 (TID 7)
20/04/02 20:47:13 INFO Executor: Running task 2.0 in stage 1.0 (TID 6)
20/04/02 20:47:13 INFO Executor: Finished task 0.0 in stage 1.0 (TID 4). 622 bytes result sent to driver
20/04/02 20:47:13 INFO Executor: Finished task 2.0 in stage 1.0 (TID 6). 665 bytes result sent to driver
20/04/02 20:47:13 INFO TaskSetManager: Finished task 0.0 in stage 1.0 (TID 4) in 16 ms on localhost (executor driver) (1/4)
20/04/02 20:47:13 INFO TaskSetManager: Finished task 2.0 in stage 1.0 (TID 6) in 13 ms on localhost (executor driver) (2/4)
___________begin_______________
5.1,3.5,1.4,0.2,Iris-setosa
4.9,3.0,1.4,0.2,Iris-setosa
4.7,3.2,1.3,0.2,Iris-setosa

......

4.9,3.1,1.5,0.1,Iris-setosa
5.0,3.2,1.2,0.2,Iris-setosa
5.5,3.5,1.3,0.2,Iris-setosa
___________end_________________
___________begin_______________
6.6,3.0,4.4,1.4,Iris-versicolor
6.8,2.8,4.8,1.4,Iris-versicolor
6.7,3.0,5.0,1.7,Iris-versicolor

......

6.5,3.2,5.1,2.0,Iris-virginica
6.4,2.7,5.3,1.9,Iris-virginica
6.8,3.0,5.5,2.1,Iris-virginica
___________end_________________
___________begin_______________
4.9,3.1,1.5,0.1,Iris-setosa
4.4,3.0,1.3,0.2,Iris-setosa
5.1,3.4,1.5,0.2,Iris-setosa

......

6.3,2.5,4.9,1.5,Iris-versicolor
6.1,2.8,4.7,1.2,Iris-versicolor
6.4,2.9,4.3,1.3,Iris-versicolor
___________end_________________
___________begin_______________
5.7,2.5,5.0,2.0,Iris-virginica
5.8,2.8,5.1,2.4,Iris-virginica
6.4,3.2,5.3,2.3,Iris-virginica

......

6.5,3.0,5.2,2.0,Iris-virginica
6.2,3.4,5.4,2.3,Iris-virginica
5.9,3.0,5.1,1.8,Iris-virginica

___________end_________________
_end_ foreachPartition 遍历-----------------------------
20/04/02 20:47:13 INFO Executor: Finished task 1.0 in stage 1.0 (TID 5). 665 bytes result sent to driver
......

        * */


		/*
		 * mapPartitions 遍历
		 *
		 * mapPartitions 算子, transformation类算子
		 * 针对partition的操作,一次会处理一个partition的所有数据
		 *
		 */
		System.out.println("_begin_ mapPartitions 遍历");
		linesRDD.mapPartitions(new FlatMapFunction<Iterator<String>, Object>() {
			private static final long serialVersionUID = 1L;
			@Override
			public java.util.Iterator<Object> call(java.util.Iterator<String> partition) throws Exception {
				System.out.println("___________begin_______________");
				while (partition.hasNext()) {
					System.out.println(partition.next());
				}
				System.out.println("___________end_________________");

				return null;
			}
		});
		System.out.println("_end_ mapPartitions 遍历");

		System.out.println("_begin_ mapPartitions 遍历");
		JavaRDD<String> stringRDD = linesRDD.mapPartitions(new FlatMapFunction<java.util.Iterator<String>, String>() {
			private static final long serialVersionUID = 1L;

			@Override
			public java.util.Iterator<String> call(java.util.Iterator<String> iterator) throws Exception {
				List<String> list = new ArrayList<>();
				System.out.println("___________begin_______________");
				while (iterator.hasNext()) {
					String line = iterator.next();
					System.out.println(line);
					list.add(line);
				}
				System.out.println("___________end_________________");
				return list.iterator();
			}
		});
        /*
_begin_ mapPartitions 遍历
_end_ mapPartitions 遍历
        */

		stringRDD.foreach(new VoidFunction<String>() {
			@Override
			public void call(String line) throws Exception {
				System.err.println("mapPartitions算子:" + line);
			}
		});
		System.out.println("_end_ mapPartitions 遍历");
        /*
_begin_ mapPartitions 遍历
20/04/02 21:13:40 INFO SparkContext: Starting job: foreach at SparkCommon.java:434
20/04/02 21:13:40 INFO DAGScheduler: Got job 2 (foreach at SparkCommon.java:434) with 4 output partitions
20/04/02 21:13:40 INFO DAGScheduler: Final stage: ResultStage 2 (foreach at SparkCommon.java:434)
20/04/02 21:13:40 INFO DAGScheduler: Parents of final stage: List()
20/04/02 21:13:40 INFO DAGScheduler: Missing parents: List()
20/04/02 21:13:40 INFO DAGScheduler: Submitting ResultStage 2 (MapPartitionsRDD[2] at mapPartitions at SparkCommon.java:418), which has no missing parents
20/04/02 21:13:40 INFO MemoryStore: Block broadcast_2 stored as values in memory (estimated size 2.3 KB, free 1990.8 MB)
20/04/02 21:13:40 INFO MemoryStore: Block broadcast_2_piece0 stored as bytes in memory (estimated size 1445.0 B, free 1990.8 MB)
20/04/02 21:13:40 INFO BlockManagerInfo: Added broadcast_2_piece0 in memory on DESKTOP-8BP3NLN.mshome.net:5260 (size: 1445.0 B, free: 1990.8 MB)
20/04/02 21:13:40 INFO SparkContext: Created broadcast 2 from broadcast at DAGScheduler.scala:1039
20/04/02 21:13:40 INFO DAGScheduler: Submitting 4 missing tasks from ResultStage 2 (MapPartitionsRDD[2] at mapPartitions at SparkCommon.java:418) (first 15 tasks are for partitions Vector(0, 1, 2, 3))
20/04/02 21:13:40 INFO TaskSchedulerImpl: Adding task set 2.0 with 4 tasks
20/04/02 21:13:40 INFO TaskSetManager: Starting task 0.0 in stage 2.0 (TID 8, localhost, executor driver, partition 0, PROCESS_LOCAL, 8965 bytes)
20/04/02 21:13:40 INFO TaskSetManager: Starting task 1.0 in stage 2.0 (TID 9, localhost, executor driver, partition 1, PROCESS_LOCAL, 9095 bytes)
20/04/02 21:13:40 INFO TaskSetManager: Starting task 2.0 in stage 2.0 (TID 10, localhost, executor driver, partition 2, PROCESS_LOCAL, 9134 bytes)
20/04/02 21:13:40 INFO TaskSetManager: Starting task 3.0 in stage 2.0 (TID 11, localhost, executor driver, partition 3, PROCESS_LOCAL, 9079 bytes)
20/04/02 21:13:40 INFO Executor: Running task 0.0 in stage 2.0 (TID 8)
20/04/02 21:13:40 INFO Executor: Running task 1.0 in stage 2.0 (TID 9)
20/04/02 21:13:40 INFO Executor: Running task 2.0 in stage 2.0 (TID 10)
mapPartitions算子:5.1,3.5,1.4,0.2,Iris-setosa
mapPartitions算子:4.9,3.0,1.4,0.2,Iris-setosa
mapPartitions算子:5.5,4.2,1.4,0.2,Iris-setosa

.......

mapPartitions算子:4.9,3.1,1.5,0.1,Iris-setosa
mapPartitions算子:5.0,3.2,1.2,0.2,Iris-setosa
mapPartitions算子:5.5,3.5,1.3,0.2,Iris-setosa
20/04/02 21:13:40 INFO Executor: Finished task 0.0 in stage 2.0 (TID 8). 622 bytes result sent to driver
20/04/02 21:13:40 INFO Executor: Running task 3.0 in stage 2.0 (TID 11)
mapPartitions算子:4.9,3.1,1.5,0.1,Iris-setosa
mapPartitions算子:4.4,3.0,1.3,0.2,Iris-setosa
mapPartitions算子:5.1,3.4,1.5,0.2,Iris-setosa

.......

mapPartitions算子:6.3,2.5,4.9,1.5,Iris-versicolor
mapPartitions算子:6.1,2.8,4.7,1.2,Iris-versicolor
mapPartitions算子:6.4,2.9,4.3,1.3,Iris-versicolor
20/04/02 21:13:40 INFO Executor: Finished task 1.0 in stage 2.0 (TID 9). 665 bytes result sent to driver
20/04/02 21:13:40 INFO TaskSetManager: Finished task 0.0 in stage 2.0 (TID 8) in 10 ms on localhost (executor driver) (1/4)
mapPartitions算子:6.6,3.0,4.4,1.4,Iris-versicolor
mapPartitions算子:6.8,2.8,4.8,1.4,Iris-versicolor
mapPartitions算子:6.7,3.0,5.0,1.7,Iris-versicolor

.......

mapPartitions算子:6.5,3.2,5.1,2.0,Iris-virginica
mapPartitions算子:6.4,2.7,5.3,1.9,Iris-virginica
mapPartitions算子:6.8,3.0,5.5,2.1,Iris-virginica
20/04/02 21:13:40 INFO Executor: Finished task 2.0 in stage 2.0 (TID 10). 622 bytes result sent to driver
20/04/02 21:13:40 INFO TaskSetManager: Finished task 1.0 in stage 2.0 (TID 9) in 15 ms on localhost (executor driver) (2/4)
mapPartitions算子:5.7,2.5,5.0,2.0,Iris-virginica
mapPartitions算子:5.8,2.8,5.1,2.4,Iris-virginica
mapPartitions算子:6.4,3.2,5.3,2.3,Iris-virginica

.......

mapPartitions算子:6.5,3.0,5.2,2.0,Iris-virginica
mapPartitions算子:6.2,3.4,5.4,2.3,Iris-virginica
mapPartitions算子:5.9,3.0,5.1,1.8,Iris-virginica
mapPartitions算子:
20/04/02 21:13:40 INFO TaskSetManager: Finished task 2.0 in stage 2.0 (TID 10) in 16 ms on localhost (executor driver) (3/4)
20/04/02 21:13:40 INFO Executor: Finished task 3.0 in stage 2.0 (TID 11). 665 bytes result sent to driver
20/04/02 21:13:40 INFO TaskSetManager: Finished task 3.0 in stage 2.0 (TID 11) in 16 ms on localhost (executor driver) (4/4)
20/04/02 21:13:40 INFO TaskSchedulerImpl: Removed TaskSet 2.0, whose tasks have all completed, from pool
20/04/02 21:13:40 INFO DAGScheduler: ResultStage 2 (foreach at SparkCommon.java:434) finished in 0.029 s
20/04/02 21:13:40 INFO DAGScheduler: Job 2 finished: foreach at SparkCommon.java:434, took 0.032938 s
___________begin_______________
5.1,3.5,1.4,0.2,Iris-setosa
4.9,3.0,1.4,0.2,Iris-setosa
4.7,3.2,1.3,0.2,Iris-setosa

.......

4.9,3.1,1.5,0.1,Iris-setosa
5.0,3.2,1.2,0.2,Iris-setosa
5.5,3.5,1.3,0.2,Iris-setosa
___________end_________________
___________begin_______________
4.9,3.1,1.5,0.1,Iris-setosa
4.4,3.0,1.3,0.2,Iris-setosa
5.1,3.4,1.5,0.2,Iris-setosa

.......

6.3,2.5,4.9,1.5,Iris-versicolor
6.1,2.8,4.7,1.2,Iris-versicolor
6.4,2.9,4.3,1.3,Iris-versicolor
___________end_________________
___________begin_______________
6.6,3.0,4.4,1.4,Iris-versicolor
6.8,2.8,4.8,1.4,Iris-versicolor
6.7,3.0,5.0,1.7,Iris-versicolor

.......

6.5,3.2,5.1,2.0,Iris-virginica
6.4,2.7,5.3,1.9,Iris-virginica
6.8,3.0,5.5,2.1,Iris-virginica
___________end_________________
___________begin_______________
5.7,2.5,5.0,2.0,Iris-virginica
5.8,2.8,5.1,2.4,Iris-virginica
6.4,3.2,5.3,2.3,Iris-virginica

.......

6.5,3.0,5.2,2.0,Iris-virginica
6.2,3.4,5.4,2.3,Iris-virginica
5.9,3.0,5.1,1.8,Iris-virginica

___________end_________________
_end_ mapPartitions 遍历
20/04/02 21:13:40 INFO SparkContext: Invoking stop() from shutdown hook


Process finished with exit code 0
        */

	}

}
