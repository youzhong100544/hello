package com.hello.spark.scala.sql

import com.hello.spark.scala.clazz.Student
import com.hello.spark.scala.sql.HelloSparkSQL.inputPath
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql._

object HelloSparkSQL {

  val inputPath = "C:\\Users\\calm\\Desktop\\hello\\"
  val outputPath = "C:\\Users\\calm\\Desktop\\hello\\output\\spark\\scala\\sql"

  val helloSparkSQL : HelloSparkSQL = new HelloSparkSQL

  def main(args: Array[String]): Unit = {

    // helloSparkSQL.demo_1()
    // helloSparkSQL.demo_2()

    // helloSparkSQL.readTextFile_1(inputPath + "hello.txt")

    helloSparkSQL.readTextFile_2(inputPath + "hello.txt")

  }

}
class HelloSparkSQL {

  def demo_init_1(): Unit ={
    val sparkConf = new SparkConf().setMaster("local[4]").setAppName("hello spark sql")
    val sparkContext = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sparkContext)
  }

  def demo_1() : Unit = {
    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("hello spark sql")

    val sparkContext : SparkContext= new SparkContext(sparkConf)

    val sqlContext = new SQLContext(sparkContext)
    import sqlContext.implicits._

    val lineRDD : RDD[String] = sparkContext.textFile(inputPath + "spark-sql-demo.txt")

    val lineArrayRDD: RDD[Array[String]] = lineRDD.map(_.split(","))

    val tupleRDD : RDD[(String, String, String)] = lineArrayRDD.map(array =>(array(0),array(1),array(2)))

    tupleRDD.foreach(println)

    val studentRDD: RDD[Student] = lineArrayRDD.map((array : Array[String]) => Student(array(0).trim().toInt, array(1).trim().toString, array(2).trim().toInt))

    val studentDataFrame: DataFrame = studentRDD.toDF()

    studentDataFrame.show()

    // 查询方式一：
    //查看某一列 类似于MySQL： select name from people
    studentDataFrame.select(studentDataFrame("name")).show();
    /*
    +------+
    |  name|
    +------+
    |    小明|
    |    小红|
    |    小王|
    |    小强|
    |    张三|
    |    里斯|
    |   tom|
    | jerry|
    |  jack|
    |  ross|
    |rechcy|
    |  jory|
    +------+
    * */
    //查看多列并作计算 类似于MySQL: select name ,age+1 from people
    studentDataFrame.select(studentDataFrame("name"), studentDataFrame("age").plus(1)).show();
    /*
    +------+---------+
    |  name|(age + 1)|
    +------+---------+
    |    小明|       21|
    |    小红|       13|
    |    小王|       19|
    |    小强|       22|
    |    张三|       21|
    |    里斯|       13|
    |   tom|       19|
    | jerry|       22|
    |  jack|       21|
    |  ross|       13|
    |rechcy|       19|
    |  jory|       22|
    +------+---------+
    * */
    //设置过滤条件 类似于MySQL:select * from people where age>21
    studentDataFrame.filter(studentDataFrame("age").gt(20)).show();
    /*
    +---+-----+---+
    | id| name|age|
    +---+-----+---+
    |  4|   小强| 21|
    |  8|jerry| 21|
    | 13| jory| 21|
    +---+-----+---+
    * */


    studentDataFrame.registerTempTable("Student")



    val result : DataFrame = sqlContext.sql("SELECT id, name, age FROM Student WHERE age >= 6 AND age <= 19")

    result.show()
    /*
    +---+------+---+
    | id|  name|age|
    +---+------+---+
    |  2|    小红| 12|
    |  3|    小王| 18|
    |  6|    里斯| 12|
    |  7|   tom| 18|
    | 10|  ross| 12|
    | 11|rechcy| 18|
    +---+------+---+
    * */

    // 对dataFrame使用map算子后，返回类型是RDD<Row>
    result.map(t => "name: " + t(1)).collect().foreach(println)

    // 通过列名获取对应的值
    result.map(t => "Name: " + t.getAs[String]("name")).collect().foreach(println)

    sparkContext.stop()
  }
/*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
  def demo_2() : Unit = {

    // val warehouseLocation: String = System.getProperty("user.dir") + "spark-warehouse" //用户的当前工作目录

    val sparkConf : SparkConf = new SparkConf().setMaster("local[*]").setAppName("hello spark sql")
    // sparkConf.set("spark.sql.warehouse.dir", warehouseLocation)

    val sparkContext : SparkContext= new SparkContext(sparkConf)

    val lineRDD: RDD[String] = sparkContext.textFile(inputPath + "spark-sql-demo.txt")
    println("分区数：" + lineRDD.getNumPartitions)

    lineRDD.foreach(println)

    val sparkSession: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    import sparkSession.implicits._

    val lineArrayRDD: RDD[Array[String]] = lineRDD.map(_.split(","))

    val tupleRDD : RDD[(String, String, String)]  = lineArrayRDD.map(array =>(array(0),array(1),array(2)))
    tupleRDD.foreach(println)

    val studentRDD: RDD[Student] = lineArrayRDD.map((array : Array[String]) => Student(array(0).trim().toInt, array(1).trim().toString, array(2).trim().toInt))

    val studentDataFrame: DataFrame = studentRDD.toDF()

    studentDataFrame.show()
    /*
    +---+------+---+
    | id|  name|age|
    +---+------+---+
    |  1|    小明| 20|
    |  2|    小红| 12|
    |  3|    小王| 18|
    |  4|    小强| 21|
    |  5|    张三| 20|
    |  6|    里斯| 12|
    |  7|   tom| 18|
    |  8| jerry| 21|
    |  9|  jack| 20|
    | 10|  ross| 12|
    | 11|rechcy| 18|
    | 13|  jory| 21|
    +---+------+---+
    * */

    studentDataFrame.printSchema
    /*
    root
     |-- id: integer (nullable = false)
     |-- name: string (nullable = true)
     |-- age: integer (nullable = false)
    * */


    // 查询方式一：
    //查看某一列 类似于MySQL： select name from people
    studentDataFrame.select("name").show();
    /*
    +------+
    |  name|
    +------+
    |    小明|
    |    小红|
    |    小王|
    |    小强|
    |    张三|
    |    里斯|
    |   tom|
    | jerry|
    |  jack|
    |  ross|
    |rechcy|
    |  jory|
    +------+
    * */
    //查看多列并作计算 类似于MySQL: select name ,age+1 from people
    studentDataFrame.select($"name", $"age" + 1).show();
    /*
    +------+---------+
    |  name|(age + 1)|
    +------+---------+
    |    小明|       21|
    |    小红|       13|
    |    小王|       19|
    |    小强|       22|
    |    张三|       21|
    |    里斯|       13|
    |   tom|       19|
    | jerry|       22|
    |  jack|       21|
    |  ross|       13|
    |rechcy|       19|
    |  jory|       22|
    +------+---------+
    * */
    //设置过滤条件 类似于MySQL:select * from people where age>21
    studentDataFrame.filter($"age">20).show();
    /*
    +---+-----+---+
    | id| name|age|
    +---+-----+---+
    |  4|   小强| 21|
    |  8|jerry| 21|
    | 13| jory| 21|
    +---+-----+---+
    * */
    //做聚合操作 类似于MySQL:select age,count(*) from people group by age
    studentDataFrame.groupBy("age").count().show();
    /*
    +---+-----+
    |age|count|
    +---+-----+
    | 12|    3|
    | 20|    3|
    | 21|    3|
    | 18|    3|
    +---+-----+
    * */
    //上述多个条件进行组合 select ta.age,count(*) from (select name,age+1 as "age" from people) as ta where ta.age>21 group by ta.age
    studentDataFrame.select( $"name", $"age" ).alias("age").filter($"age" >= 21).groupBy("age").count().show();

    // 查询方式二：
    // 直接使用spark SQL进行查询
    // 先注册为临时表
    studentDataFrame.createOrReplaceTempView("student");
    val resule = sparkSession.sql("SELECT * FROM student ");
    resule.show();

    sparkContext.stop()

  }


  def demo_init_2(): SparkSession ={
    val sparkSession: SparkSession = SparkSession.builder().master("local[*]").appName("hello spark sql").getOrCreate()
    return sparkSession
  }

  def demo_init_2_1(): SparkSession ={
    val sparkSession: SparkSession = SparkSession.builder().master("local[*]").appName("hello spark sql").getOrCreate()

    //可以得到之前的版本定义的sc,sqlContext对象,特点...
    val sparkContext: SparkContext = sparkSession.sparkContext
    // Supplied level WARN, console did not match one of: ALL,DEBUG,ERROR,FATAL,TRACE,WARN,INFO,OFF
    sparkContext.setLogLevel("WARN")
    val sparkConf: SparkConf = sparkContext.getConf
    val sqlContext: SQLContext = sparkSession.sqlContext

    return sparkSession
  }
  def demo_init_2_2(): Unit ={
    val conf = new SparkConf().setMaster("local[*]").setAppName("hello spark sql")
    conf.set("", "")
    val sparkSession: SparkSession = SparkSession.builder().config(conf).getOrCreate()

  }

  def demo_init_2_3(): Unit ={
    val sparkSession: SparkSession = SparkSession.builder().master("local[*]").appName("hello spark sql hive").enableHiveSupport().getOrCreate()
  }

  def init(): SparkSession ={
    // val sparkSession: SparkSession = demo_init_2()
    val sparkSession: SparkSession = demo_init_2_1()
    return sparkSession
  }

  def readTextFile_1(path: String): Unit ={
    val sparkSession: SparkSession = init()

    val line: Dataset[String] = sparkSession.read.textFile(path)
    println("line.show-----------------------------------------------------------------")
    line.show()

    /*
    val arr: Array[String] = line.collect()
    arr.foreach(println)
    */

    import sparkSession.implicits._
    // 需要导入session对象中的隐式转换
    // 否则会报错
    val word: Dataset[String] = line.flatMap(_.split(" "))
    println("word.show-----------------------------------------------------------------")
    word.show()


    /* 写到这一步我们就有两种选择，一种是写sql，另一种就是写DSL. */
    /* 1 */
    /* 1.1 */
    /*
      我们接下来先写DSL:
      我们在语句中写的$意思是告诉他这是一列
      为了可以使用agg中的聚合函数，我们还需要导入spark sql中的函数
    */

    import org.apache.spark.sql.functions._
    val result: Dataset[Row] = word.groupBy($"value" as "word").agg(count("*") as "counts").sort($"counts" desc)
    println("result.show-----------------------------------------------------------------")
    result.show()
    /* 1.2 */
    // 或者我们也可以这样实现：
    val groupedDataset: RelationalGroupedDataset = word.groupBy($"value" as "word")
    val cou: DataFrame = groupedDataset.count()
    val result1: Dataset[Row] = cou.sort($"count" desc)
    println("result.show-----------------------------------------------------------------")
    result1.show()

    /* 2 */
    // 接着我们通过sql的方式来写WordCount
    val df: DataFrame = word.withColumnRenamed("value","word")
    //先创建视图，再执行sql
    df.createTempView("v_wc")
    val result2: DataFrame = sparkSession.sql("select word, count(*) as counts from v_wc group by word order by counts desc")
    println("result.show-----------------------------------------------------------------")
    result2.show()

    sparkSession.stop()
  }

  def readTextFile_2(path: String): Unit ={
    val sparkSession: SparkSession = init()

    // val line: Dataset[String] = sparkSession.read.textFile(path)
    val line: DataFrame = sparkSession.read.format("text").load(path)
    println("line.show-----------------------------------------------------------------")
    line.show()

    //导入sparksession中的隐式转换
    import sparkSession.implicits._
    val word: Dataset[String] = line.flatMap(_.getAs[String]("value").split(" "))
    println("word.show-----------------------------------------------------------------")
    word.show()

    val dataFrame: DataFrame = word.withColumnRenamed("value","word")
    //先创建视图，再执行sql
    dataFrame.createTempView("v_wc")
    val result: DataFrame = sparkSession.sql("select word,count(*) as counts from v_wc group by word order by counts desc")
    println("result.show-----------------------------------------------------------------")
    result.show()

    //DSL方式
    import org.apache.spark.sql.functions._
    val result1: Dataset[Row] = word.groupBy($"value").agg(count("*") as "counts").sort($"counts" desc)
    println("result.show-----------------------------------------------------------------")
    result1.show()

    //SQL方式：
    val df: DataFrame = word.toDF()
    df.createTempView("wc")
    val result2: DataFrame = sparkSession.sql("select value as word,count(*) as counts from wc group by word order by counts desc")
    println("result.show-----------------------------------------------------------------")
    result2.show()


    sparkSession.stop()


  }

  def prepareData_textFile(path: String): Unit ={
    val sparkSession: SparkSession = init()

    val line: Dataset[String] = sparkSession.read.textFile(path)

    val frame: DataFrame = line.select()

    frame.show()
  }

  def prepareData_csv(path: String): Unit ={
    val sparkSession: SparkSession = init()

    val frame: DataFrame = sparkSession.read.format("csv").option("header", "true").option("mode", "DROPMALFORMED").csv(path)
  }



  def prepareData(): Unit ={
    val sparkSession: SparkSession = init()

  }


}