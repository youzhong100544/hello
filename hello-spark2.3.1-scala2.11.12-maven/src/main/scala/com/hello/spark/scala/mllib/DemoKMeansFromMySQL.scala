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
      "url" -> "jdbc:mysql://192.168.15.70:23306/dmp-data?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true",   //设置mysql的链接地址和指定数据库
      // "driver" -> "com.mysql.jdbc.Driver",    //设置MySQL的链接驱动
      "driver" -> "com.mysql.cj.jdbc.Driver",    //设置MySQL的链接驱动
      "user" -> "dmp",        //连接mysql的用户
      "password" -> "123456",  //连接用户的密码
      "dbtable" -> "demo_ml_test"      //获取数据所在表的名成
    )
    val df: DataFrame = spark.read.format("jdbc")   //设置读取方式
      .options(jdbc_conf)    //放入jdbc的配置信息
      .load()

    df.show()   //使用一个action算子来检查是否能读取数据

    /*
 CREATE TABLE `dmp-data`.`demo_ml_test` (
	`id` int DEFAULT NULL COMMENT 'id',
	`name` VARCHAR(32) NOT NULL COMMENT '名称',
	`salary_decimal` decimal(11,2) DEFAULT NULL,
    `salary_double` double(11,3) DEFAULT NULL,
    `c_1` double(11,3) DEFAULT NULL,
	`c_2` VARCHAR(32) DEFAULT NULL,
	`c_3` VARCHAR(32) DEFAULT NULL,
	`c_l` int DEFAULT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ml_test';

+---+----+--------------+-------------+-----+-----+-----+---+
| id|name|salary_decimal|salary_double|  c_1|  c_2|  c_3|c_l|
+---+----+--------------+-------------+-----+-----+-----+---+
|  1|  zs|        -96.84|      -96.845| 9.45|-9.45| 1.23|  1|
|  2|  ls|        -16.84|       36.845| 5.45| 6.45|553.3|  1|
|  3|  ls|          6.45|      326.845|56.45| 6.45|  5.3|  0|
|  4|  ls|         46.45|       -7.845| 9.45| 6.45|-53.3|  0|
|  5|  ls|        -66.45|       36.845| 7.45| 6.45|  6.3|  1|
|  6|  ls|          0.84|      -36.845| 9.45| 6.45|111.3|  1|
|  7|  ls|          1.85|       36.845|10.45| 6.45|  1.3|  1|
|  1|  zs|        -96.84|      -96.845| 9.45|-9.45| 1.23|  1|
|  2|  ls|        -16.84|       36.845| 5.45| 6.45|553.3|  1|
|  3|  ls|          6.45|      326.845|56.45| 6.45|  5.3|  0|
|  4|  ls|         46.45|       -7.845| 9.45| 6.45|-53.3|  0|
|  5|  ls|        -66.45|       36.845| 7.45| 6.45|  6.3|  1|
|  6|  ls|          0.84|      -36.845| 9.45| 6.45|111.3|  1|
|  7|  ls|          1.85|       36.845|10.45| 6.45|  1.3|  1|
+---+----+--------------+-------------+-----+-----+-----+---+
    * */


    val labelIndexer = new StringIndexer()
      // .setInputCol("label")
      .setInputCol("c_l")
      .setOutputCol("indexedLabel")

    val vectorAssembler = new VectorAssembler()
      // .setInputCols(Array("salary_decimal","salary_double","c_1","c_2","c_3"))// Exception in thread "main" java.lang.IllegalArgumentException: Data type StringType of column c_2 is not supported.
      .setInputCols(Array("salary_decimal","salary_double","c_1"))
      .setOutputCol("features11")

    // create the trainer and set its parameters
    val trainer = new KMeans()
      .setFeaturesCol("features11") // 必须和上面一样
      .setK(3)
      .setSeed(1L)
      .setMaxIter(5)
      .setInitMode("k-means||")
      .setTol(0.01)

    //Step 6
    //Randomly split the input data by 8:2, while 80% is for training, the rest is for testing.
    //var array: Array[Dataset[Row]] = df.randomSplit(Array(0.7, 0.3))
    // val Array(trainingData, testData) = df.randomSplit(Array(0.7, 0.3))
    val Array(trainingData:DataFrame, testData:DataFrame) = df.randomSplit(Array(1, 1))

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

    /*
+---+----+--------------+-------------+-----+-----+-----+---+------------+--------------------+----------+
| id|name|salary_decimal|salary_double|  c_1|  c_2|  c_3|c_l|indexedLabel|            features|prediction|
+---+----+--------------+-------------+-----+-----+-----+---+------------+--------------------+----------+
|  1|  zs|        -96.84|      -96.845| 9.45|-9.45| 1.23|  1|         0.0|[-96.84,-96.845,9...|         1|
|  2|  ls|        -16.84|       36.845| 5.45| 6.45|553.3|  1|         0.0|[-16.84,36.845,5.45]|         0|
|  2|  ls|        -16.84|       36.845| 5.45| 6.45|553.3|  1|         0.0|[-16.84,36.845,5.45]|         0|
|  3|  ls|          6.45|      326.845|56.45| 6.45|  5.3|  0|         1.0|[6.45,326.845,56.45]|         2|
|  4|  ls|         46.45|       -7.845| 9.45| 6.45|-53.3|  0|         1.0| [46.45,-7.845,9.45]|         0|
|  4|  ls|         46.45|       -7.845| 9.45| 6.45|-53.3|  0|         1.0| [46.45,-7.845,9.45]|         0|
|  7|  ls|          1.85|       36.845|10.45| 6.45|  1.3|  1|         0.0| [1.85,36.845,10.45]|         0|
+---+----+--------------+-------------+-----+-----+-----+---+------------+--------------------+----------+
     */

    spark.stop()
  }



}