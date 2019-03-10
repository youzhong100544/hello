package com.hello.spark.scala.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Durations, StreamingContext}

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
object HelloSparkStreaming {
  /**
    * receiver  task是7*24小时一直在执行，一直接受数据，将一段时间内接收来的数据保存到batch中。
    * 假设batchInterval为5s,那么会将接收来的数据每隔5秒封装到一个batch中，batch没有分布式计算特性，这一个batch的数据又被封装到一个RDD中，RDD最终封装到一个DStream中。
    *   例如：
    *     假设batchInterval为5秒，每隔5秒通过SparkStreamin将得到一个DStream,
    *     在第6秒的时候计算这5秒的数据，
    *     假设执行任务的时间是3秒,那么第6~9秒一边在接收数据，一边在计算任务，9~10秒只是在接收数据。
    *     然后在第11秒的时候重复上面的操作。
    *
    * 如果job执行的时间大于batchInterval会有什么样的问题？
    *   如果接受过来的数据设置的级别是仅内存，接收来的数据会越堆积越多，最后可能会导致OOM（如果设置StorageLevel包含disk, 则内存存放不下的数据会溢写至disk, 加大延迟 ）。
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("HelloSparkStreaming")

    // sparkConf.set("spark.streaming.receiver.writeAheadLog.enable","true")

    val ssc = new StreamingContext(sparkConf,Durations.seconds(5))

    val checkpointPath : String  = "d://SparkStreaming/checkpointPath";

    ssc.checkpoint(checkpointPath)
  }
}

class HelloSparkStreaming {

}
