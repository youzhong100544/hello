package com.hello.spark.java.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

/**
 * Driver HA（Standalone或者Mesos）
 *     因为SparkStreaming是7*24小时运行，Driver只是一个简单的进程，有可能挂掉，所以实现Driver的HA就有必要（如果使用的Client模式就无法实现Driver HA ，这里针对的是cluster模式）。
 *     Yarn平台cluster模式提交任务，AM(AplicationMaster)相当于Driver，如果挂掉会自动启动AM。
 *     这里所说的DriverHA针对的是Spark的standalone和Mesos资源调度的情况下。
 *
 *     实现Driver的高可用有两个步骤:
 *         第一：提交任务层面，在提交任务的时候加上选项 --supervise,当Driver挂掉的时候会自动重启Driver。
 *         第二：代码层面，使用JavaStreamingContext.getOrCreate（checkpoint路径，JavaStreamingContextFactory）
 *
 *     Driver中元数据包括：
 *       1.创建应用程序的配置信息。
 *       2.DStream的操作逻辑。
 *       3.job中没有完成的批次数据，也就是job的执行进度。
 */
public class HelloSparkStreamingOnHDFSWithDriverHA {
    public static void main(String[] args) {
        final SparkConf sparkConf = new SparkConf().setMaster("local[2]").setAppName("HelloSparkStreamingWithDriverHA");

        // JavaStreamingContext jsc = new JavaStreamingContext(conf,
        // Durations.seconds(5));

        final String checkpointPath = "hdfs://node:9000/SparkStreaming/CheckPoint_20170731";

        Function0<JavaStreamingContext> creatingFunc = new Function0<JavaStreamingContext>() {
            @Override
            public JavaStreamingContext call() throws Exception {
                return new JavaStreamingContext(sparkConf, Durations.seconds(5));
            }
        };

        JavaStreamingContext ssc = JavaStreamingContext.getOrCreate(checkpointPath, creatingFunc);

    }


}
