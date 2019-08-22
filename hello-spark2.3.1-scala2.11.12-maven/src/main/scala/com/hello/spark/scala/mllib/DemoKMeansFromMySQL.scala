package com.hello.spark.scala.mllib

import org.apache.spark.SparkConf
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.{StringIndexer, VectorAssembler}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}


object DemoKMeansFromMySQL {
  def main(args: Array[String]): Unit = {
    val demo = new DemoKMeansFromMySQL
    demo.demo()
  }
}

class DemoKMeansFromMySQL {

  def demo(): Unit = {
    val spark = new SparkSession.Builder()
      .master("local")
      .appName("source_data_mysql001")
      .getOrCreate()

    val jdbc_conf: Map[String, String] = Map(
      "url" -> "jdbc:mysql://192.168.15.70:23306/dmp?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true",   //设置mysql的链接地址和指定数据库
      // "driver" -> "com.mysql.jdbc.Driver",    //设置MySQL的链接驱动
      "driver" -> "com.mysql.cj.jdbc.Driver",    //设置MySQL的链接驱动
      "dbtable" -> "action_word",      //获取数据所在表的名成
      "user" -> "dmp",        //连接mysql的用户
      "password" -> "123456"   //连接用户的密码
    )
    val df: DataFrame = spark.read.format("jdbc")   //设置读取方式
      .options(jdbc_conf)    //放入jdbc的配置信息
      .load()

    df.show()   //使用一个action算子来检查是否能读取数据

    val labelIndexer = new StringIndexer()
      .setInputCol("label")
      .setOutputCol("indexedLabel")

    val vectorAssembler = new VectorAssembler()
      .setInputCols(Array("f0","f1","f2","f3"))
      .setOutputCol("features")

    // create the trainer and set its parameters
    val trainer = new KMeans()
      .setFeaturesCol("features")
      .setK(3)
      .setSeed(1L)
      .setMaxIter(5)
      .setInitMode("k-means||")
      .setTol(0.01)

    //Step 6
    //Randomly split the input data by 8:2, while 80% is for training, the rest is for testing.
    //var array: Array[Dataset[Row]] = df.randomSplit(Array(0.7, 0.3))
    val Array(trainingData, testData) = df.randomSplit(Array(0.7, 0.3))

    /**
      * Step 7
      * Create a ML pipeline which is constructed by for 4 PipelineStage objects.
      * and then call fit method to perform defined operations on training data.
      */
    val pipeline = new Pipeline().setStages(Array(labelIndexer, vectorAssembler, trainer))

    // train the model
    val model = pipeline.fit(trainingData)

    // compute precision on the test set
    val result = model.transform(testData)

    result.select("*").show(150)

    spark.stop()
  }



}