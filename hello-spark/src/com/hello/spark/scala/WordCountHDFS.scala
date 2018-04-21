package com.hello.spark.scala

package com.hello.spark.scala

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.rdd.RDD
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.client.Result
import org.apache.hadoop.io.MapFile
import org.apache.commons.httpclient.URI
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.BytesWritable
import org.apache.hadoop.fs.Path
import org.apache.hadoop.fs.BlockLocation
import org.apache.hadoop.fs.FileStatus
import org.apache.hadoop.fs.FSDataInputStream

object WordCountHDFS {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("WordCount")

    val sc = new SparkContext(sparkConf)
    
    val hdfsInputPath = "/user/root/test.txt"
    val hdfsOutputPath = "/user/root/test.txt"
    
    val path : Path = new Path(hdfsInputPath)
    val hc : Configuration = sc.hadoopConfiguration
    val fs : FileSystem = FileSystem.get(hc) 
		val file : FileStatus = fs.getFileStatus(path)
		val fileBlockLocations : Array[BlockLocation] = fs.getFileBlockLocations(file, 0, file.getLen())
		
		for (i <- 0 until fileBlockLocations.length){
			println(fileBlockLocations(i))
		}
		
		val input : FSDataInputStream = fs.open(path)
		val readByte : Byte = input.readByte()
		println(readByte)
		println(readByte.toChar)
    
//    sc.hadoopConfiguration.set("hbase.zookeeper.quorum ","zkNode1,zkNode2,zkNode3")  
//    sc.hadoopConfiguration.set("zookeeper.znode.parent","/hbase")  
//    sc.hadoopConfiguration.set(TableOutputFormat.OUTPUT_TABLE,"lxw1234")  
//    
//    val job = new Job(sc.hadoopConfiguration)  
//    job.setOutputKeyClass(classOf[ImmutableBytesWritable])  
//    job.setOutputValueClass(classOf[Result])  
//    job.setOutputFormatClass(classOf[TableOutputFormat[ImmutableBytesWritable]])      
//    val key = new LongWritable()  
//    val value = new BytesWritable()  

    val lineRdd = sc.textFile(hdfsInputPath)

    val wordRDD = lineRdd.flatMap ( x => {
      x.split(" ")
    })

    //(_,1) 二元组
    val pairRDD = wordRDD.map ((_,1))

    val resultRDD = pairRDD.reduceByKey((v1:Int,v2:Int) => {
      v1 + v2
    })

    resultRDD.saveAsTextFile(hdfsOutputPath)

    sc.stop()

  }
}
