package com.hello.spark.scala.mllib

import java.io.File

import com.hello.spark.scala.util.CommomUtil
import org.apache.spark.ml.feature.{Normalizer, StandardScaler}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}


/**
  * 从Spark 2.0开始，Spark机器学习API是基于DataFrame的spark.ml。而之前的基于RDD的API spark.mllib已进入维护模式。
  * 也就是说，Spark ML是Spark MLlib的一种新的API，它主要有以下几个优点：
  *   面向DataFrame，在RDD基础上进一步封装，提供更强大更方便的API
  *   Pipeline功能，便于实现复杂的机器学习模型
  *   性能提升
  *
  *
  * 基于Pipeline的Spark ML中的几个概念：
  *   DataFrame：从Spark SQL 的引用的概念，表示一个数据集，它可以容纳多种数据类型。例如可以存储文本，特征向量，标签和预测值等
  *   Transformer：是可以将一个DataFrame变换成另一个DataFrame的算法。例如，一个训练好的模型是一个Transformer，通过transform方法，将原始DataFrame转化为一个包含预测值的DataFrame
  *   Estimator：是一个算法，接受一个DataFrame，产生一个Transformer。例如，一个学习算法（如PCA,SVM）是一个Estimator，通过fit方法，训练DataFrame并产生模型Transformer
  *   Pipeline： Pipeline将多个Transformers和Estimators连接起来组合成一个机器学习工作流程
  *   Parameter：用于对Transformers和Estimators指定参数的统一接口
  *
  */
object DemoFeature {
  def main(args: Array[String]): Unit = {

    val demoFeature = new DemoFeature

    // demoFeature.testNormalizer()

    demoFeature.testStandardScaler()

  }
}


class DemoFeature {

  val sparkSession: SparkSession = SparkSession.builder().master("local[*]").appName("DemoFeature").getOrCreate()
  // import sparkSession.implicits._

  val inputPath = "C:\\Users\\calm\\Desktop\\hello\\"
  val outputPath = "C:\\Users\\calm\\Desktop\\hello\\output\\spark\\scala\\mllib\\feature\\"

  val output: File = new File(outputPath)
  // 删除输出目录
  if (output.exists()){
    CommomUtil.deleteDir(output)
  }

  def readData1(): DataFrame = {
    val date : DataFrame = sparkSession.createDataFrame(Seq(
      (1, Vectors.dense(1.0, 12.5, -108.0)),
      (2, Vectors.dense(2.5, 36.0, 198.0)),
      (3, Vectors.dense(6.8, 24.0, 459.0))
    )).toDF("id","features")

    return date
  }

  def readData2(): DataFrame = {


    // LibSVMFile的格式：标签 索引：值
    // 0 2:51 3:253 5:253
    // 1 2:124 3:253 4:255
    // 1 2:145 3:253 5:211
    val date : DataFrame = sparkSession.read.format("").load(inputPath + "kmeans.txt")
    return date
  }

  def prepareData(): DataFrame = {

    val data1: DataFrame = readData1()
    val data2: DataFrame = readData2()

    return data2
  }

  /**
    * DemoNormalizer
    */
  def testNormalizer(): Unit = {

    val sparkSession: SparkSession = SparkSession.builder().master("local[*]").appName("testNormalizer").getOrCreate()
    // import sparkSession.implicits._


    val df =  sparkSession.createDataFrame(Seq(
      (1, Vectors.dense(1.0, 12.5, -108.0)),
      (2, Vectors.dense(2.5, 36.0, 198.0)),
      (3, Vectors.dense(6.8, 24.0, 459.0))
    )).toDF("id","features")


    //Normalizer的作用范围是每一行，使每一个行向量的范数变换为一个单位范数
    val normalizer = new Normalizer()
      .setInputCol("features")
      .setOutputCol("normalizer_features")
      .setP(1.0)
    val L1 = normalizer.transform(df)
    L1.show(false)

    /*
      +---+-----------------+------------------------------------------------------------+
      |id |features         |normalizer_features                                         |
      +---+-----------------+------------------------------------------------------------+
      |1  |[1.0,12.5,-108.0]|[0.00823045267489712,0.102880658436214,-0.8888888888888888] |
      |2  |[2.5,36.0,198.0] |[0.010570824524312896,0.1522198731501057,0.8372093023255814]|
      |3  |[6.8,24.0,459.0] |[0.013883217639853,0.04899959167006941,0.9371171906900776]  |
      +---+-----------------+------------------------------------------------------------+
    */


  }


  /**
    * StandardScaler
    *
    * @param sparkContext
    */
  def testStandardScaler(): Unit = {

    // 加载训练数据，生成DataFrame
    val data: DataFrame = prepareData()

    data.show()
    println(data.count())

    // 归一化
    val standardScaler = new StandardScaler()
      .setInputCol("features")
      .setOutputCol("scaledFeatures")
      .setWithMean(true)
      .setWithStd(true)
      .fit(data)

    val dataStandardScaler = standardScaler.transform(data).select("label", "scaledFeatures").toDF("label","features")


    dataStandardScaler.show()

    //dataStandardScaler.
  }
}
