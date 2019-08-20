package com.hello.spark.scala.mllib

import java.io.File

import org.apache.spark.{SparkConf, SparkContext}
import com.hello.spark.scala.util.CommomUtil
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object DemoKmeans {
  def main(args: Array[String]): Unit = {
    val demoKmeans = new DemoKmeans
    demoKmeans.demo_ml()
  }
}
class DemoKmeans {
  val inputPath = "C:\\Users\\calm\\Desktop\\hello\\"
  val outputPath = "C:\\Users\\calm\\Desktop\\hello\\output\\spark\\scala\\mllib\\kmeans\\"

  def demo_mllib(): Unit = {
    // 初始化
    val conf = new SparkConf().setMaster("local[4]").setAppName("DemoKmeans")
    val sc = new SparkContext(conf)

    // 装载数据集
    val data = sc.textFile(inputPath + "kmeans.txt", 1)
    val parsedData= data.map(s => org.apache.spark.mllib.linalg.Vectors.dense(s.split(' ').map(_.toDouble)))

    // 将数据集聚类，2个类，20次迭代，进行模型训练形成数据模型
    val numClusters = 2
    val numIterations = 20
    val model = org.apache.spark.mllib.clustering.KMeans.train(parsedData, numClusters, numIterations)


    // 打印数据模型的中心点
    println("Cluster centers:")
    for (c <- model.clusterCenters) {
      println("  " + c.toString)
    }

    // 使用误差平方之和来评估数据模型
    val cost = model.computeCost(parsedData)
    println("Within Set Sum of Squared Errors = " + cost)


    parsedData.collect().foreach(testDataLine => {
      val predictedClusterIndex: Int = model.predict(testDataLine)
      println("The data " + testDataLine.toString + " belongs to cluster " +predictedClusterIndex)
    })

    println("------------------------------------------------------------------------")
    // 使用模型测试单点数据
    println("Vectors 0.2 0.2 0.2 is belongs to clusters:" + model.predict(org.apache.spark.mllib.linalg.Vectors.dense("0.2 0.2 0.2".split(' ').map(_.toDouble))))
    println("Vectors 0.25 0.25 0.25 is belongs to clusters:" + model.predict(org.apache.spark.mllib.linalg.Vectors.dense("0.25 0.25 0.25".split(' ').map(_.toDouble))))
    println("Vectors 8 8 8 is belongs to clusters:" + model.predict(org.apache.spark.mllib.linalg.Vectors.dense("8 8 8".split(' ').map(_.toDouble))))

    val output: File = new File(outputPath)
    // 删除输出目录
    if (output.exists())
      CommomUtil.deleteDir(output)

    // 交叉评估1，只返回结果
    val testdata = data.map(s => org.apache.spark.mllib.linalg.Vectors.dense(s.split(' ').map(_.toDouble)))
    val result1 = model.predict(testdata)

    result1.foreach(println)

    result1.saveAsTextFile(outputPath + "test1")

    // 交叉评估2，返回数据集和结果
    val result2 = data.map {

      line =>

        val linevectore = org.apache.spark.mllib.linalg.Vectors.dense(line.split(' ').map(_.toDouble))

        val prediction = model.predict(linevectore)

        line + " " + prediction

    }.saveAsTextFile(outputPath + "test2")

    sc.stop()
  }

  def prepareData_1(sparkSession:SparkSession): DataFrame = {

    val date : DataFrame = sparkSession.createDataFrame(Seq(
      (1, org.apache.spark.ml.linalg.Vectors.dense(1.0, 12.5, -108.0)),
      (2, org.apache.spark.ml.linalg.Vectors.dense(2.5, 36.0, 198.0)),
      (3, org.apache.spark.ml.linalg.Vectors.dense(6.8, 24.0, 459.0))
    )).toDF("id","features")

    return date
  }

  def prepareData_2(sparkSession:SparkSession, path: String): DataFrame = {

    // val date : DataFrame = sparkSession.read.format("csv").load(path)
    val date : DataFrame = sparkSession.read.csv(path)

      // 推断数据类型
      // .option("inferSchema", "true")
      // 可设置分隔符，默认，
      //.option("delimiter",",")
      // 设置空值
      // .option("nullValue", "?")
      // 表示有表头，若没有则为false
    // .option("header", true)
      // 文件路径

    val line: DataFrame = sparkSession.read.option("header", "true")csv(path)
    println("line.show-----------------------------------------------------------------")
    line.show()

    /*val arr: Array[Row] = line.collect()
    println("println-----------------------------------------------------------------")
    arr.foreach(println)
    println("println-----------------------------------------------------------------")
    line.head(2).foreach(println)*/

    //sparkSession.createDataFrame()


    return date
  }

  def demo_ml(): Unit = {
    val sparkSession: SparkSession = SparkSession.builder().master("local[*]").appName("DemoFeature").getOrCreate()
    val sparkContext: SparkContext = sparkSession.sparkContext
    sparkContext.setLogLevel("WARN")

    val output: File = new File(outputPath)
    // 删除输出目录
    if (output.exists()){
      CommomUtil.deleteDir(output)
    }

    // val date : DataFrame = prepareData_1(sparkSession:SparkSession)

    val date : DataFrame = prepareData_2(sparkSession, inputPath + "test1.csv")


    val kmeansmodel = new org.apache.spark.ml.clustering.KMeans().
      setK(3).
      setFeaturesCol("features").
      setPredictionCol("prediction").
      fit(date)


    // 与MLlib中的实现不同，KMeansModel作为一个Transformer，不再提供predict()样式的方法，而是提供了一致性的transform()方法，用于将存储在DataFrame中的给定数据集进行整体处理，生成带有预测簇标签的数据集：
    val results = kmeansmodel.transform(date)
    println("result.show-----------------------------------------------------------------")
    results.show(false)


    // 为了方便观察，我们可以使用collect()方法，该方法将DataFrame中所有的数据组织成一个Array对象进行返回：
    /*results.collect().foreach(
      row => {
        println( row(0) + " is predicted as cluster " + row(1))
      }
    )*/

    // 也可以通过KMeansModel类自带的clusterCenters属性获取到模型的所有聚类中心情况：
    /*kmeansmodel.clusterCenters.foreach(
      center => {
        println("Clustering Center:"+center)
      }
    )*/



  }

}