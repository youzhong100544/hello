package com.hello.spark.java.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

/**
 * 1、local的模拟线程数必须大于等于2 因为一条线程被receiver(接受数据的线程)占用，另外一个线程是job执行
 * 2、Durations时间的设置，就是我们能接受的延迟度，这个我们需要根据集群的资源情况以及监控，ganglia  每一个job的执行时间
 * 3、 创建JavaStreamingContext有两种方式 （sparkconf、sparkcontext）
 * 4、业务逻辑完成后，需要有一个output operator
 * 5、JavaStreamingContext.start()
 * 6、JavaStreamingContext.stop()无参的stop方法会将sparkContext一同关闭，stop(false)
 * 7、JavaStreamingContext.stop() 停止之后是不能在调用start
 * 8、JavaStreamingContext.start() straming框架启动之后是不能在次添加业务逻辑
 */
public class HelloSparkStreaming {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local[2]").setAppName("HelloSparkStreaming");

        // 方式一：
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        JavaStreamingContext jsc = new JavaStreamingContext(sparkConf, Durations.seconds(5));


        // 方式二：
        /**
         * 在创建streaminContext的时候 设置batch Interval
         */
        // JavaStreamingContext jsc = new JavaStreamingContext(sparkConf, Durations.seconds(5));


        JavaReceiverInputDStream<String> lines = jsc.socketTextStream("node", 9999);

    }


}
