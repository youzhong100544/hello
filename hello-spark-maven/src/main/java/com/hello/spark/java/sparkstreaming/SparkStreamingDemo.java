package com.hello.spark.java.sparkstreaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaStreamingContext;


public class SparkStreamingDemo {

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf();
		/**
		 * 1、local的模拟线程数必须大于等于2 因为一条线程被receiver(接受数据的线程)占用，另外一个线程是job执行
		 * 2、Durations时间的设置，就是我们能接受的延迟度，这个我们需要根据集群的资源情况以及监控每一个job的执行时间来调节出最佳时间。
		 * 3、 创建JavaStreamingContext有两种方式 （sparkconf、sparkcontext）
		 * 4、业务逻辑完成后，需要有一个output operator
		 */
		sparkConf.setMaster("local[2]").setAppName("SparkStreamingDemo-Java");

		// 方式一：sparkcontext
		
		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
		JavaStreamingContext javaStreamingContext = new JavaStreamingContext(sparkContext, Durations.seconds(5));
		
		// 方式二：sparkconf
		JavaStreamingContext streamingContext = new JavaStreamingContext(sparkConf, Durations.seconds(5));
		
		
		
		/**
		 * 5、JavaStreamingContext.start()straming框架启动之后是不能在次添加业务逻辑
		 * 6、JavaStreamingContext.stop()无参的stop方法会将sparkContext一同关闭，stop(false) ,默认为true，会一同关闭
		 * 7、JavaStreamingContext.stop()停止之后是不能在调用start   
		 */
		streamingContext.start();
		//等待spark程序被终止
		streamingContext.awaitTermination();
		streamingContext.stop(false);
	}
	
}
