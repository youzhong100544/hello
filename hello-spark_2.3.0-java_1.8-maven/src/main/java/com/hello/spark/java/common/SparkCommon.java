package com.hello.spark.java.common;

import com.hello.spark.java.entity.Iris;
import org.apache.spark.Partition;
import org.apache.spark.Partitioner;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import scala.collection.Iterator;
import scala.io.Source;
import shapeless.Tuple;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 参考博文
 *      Spark中RDD、DataFrame和DataSet的区别
 *      https://blog.csdn.net/weixin_39793644/article/details/79050762
 *
 *      什么是过拟合和欠拟合
 *      https://blog.csdn.net/xuaho0907/article/details/88649141
 */
public class SparkCommon {

    private static final String filePathTrainSetOfTitanic = "C:\\Users\\calm\\Desktop\\hello\\titanic\\train.csv";
    private static final String filePathTestSetOfTitanic = "C:\\Users\\calm\\Desktop\\hello\\titanic\\test.csv";

    private static String appName;
    private static String master;

    private static SparkConf sparkConf;
    private static JavaSparkContext javaSparkContext;
    private static SparkSession sparkSession;

    static {
        appName = "HelloSpark";
        master = "local[*]";
    }

    public static void main(String[] args) throws IOException {

        // demo();

        /* 鸢尾花数据集 */
//        Dataset<Row> irisDataSet = getIrisDataSet();
//
//        showDatasetInfo(irisDataSet);
//        statisticalInformation(irisDataSet);

        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        /* 泰坦尼克号数据集 */
        Dataset<Row>[] titanicDataSet = getTitanicDataSet();
        Dataset<Row> titanicTrainSet = titanicDataSet[0];
        Dataset<Row> titanicTestSet = titanicDataSet[1];

        // showDatasetInfo(titanicTrainSet);
        // showDatasetInfo(titanicTestSet);

        statisticalInformation(titanicTrainSet);
        statisticalInformation(titanicTestSet);

    }

    private static void demo() {
        File file = new File("/dataset/iris.data");
        System.out.println("file.isFile : " + file.isFile()); // file.isFile : false
        System.out.println("file.exists : " + file.exists()); // file.exists : false

        System.out.println("----------------------------------------------------------");

        file = new File("./dataset/iris.data");
        System.out.println("file.isFile : " + file.isFile()); // file.isFile : false
        System.out.println("file.exists : " + file.exists()); // file.exists : false

        System.out.println("----------------------------------------------------------");

        file = new File("dataset/iris.data");
        System.out.println("file.isFile : " + file.isFile()); // file.isFile : false
        System.out.println("file.exists : " + file.exists()); // file.exists : false


        System.out.println("----------------------------------------------------------");

        // file = new File("/Users/hiahia/Downloads/iris.data"); // mac
        file = new File("C:\\Users\\calm\\Downloads\\iris.data"); // windows

        System.out.println("file.isFile : " + file.isFile()); // file.isFile : true
        System.out.println("file.exists : " + file.exists()); // file.exists : true

        System.out.println();
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println();
    }

    /**
     * 初始化 SparkConf
     *
     * @return SparkConf
     */
    private static SparkConf initSparkConf() {
        SparkConf sparkConf = new SparkConf().setMaster(master).setAppName(appName);

//		sparkConf.set("spark.driver.allowMultipleContexts", "true");
//		sparkConf.set("spark.eventLog.enabled", "true");
//		sparkConf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
//		sparkConf.set("spark.hadoop.validateOutputSpecs", "false");
//		sparkConf.set("hive.mapred.supports.subdirectories", "true");
//		sparkConf.set("mapreduce.input.fileinputformat.input.dir.recursive", "true");

        return sparkConf;
    }

    /**
     * 通过 SparkConf 初始化 JavaSparkContext
     *
     * @return JavaSparkContext
     */
    private static JavaSparkContext initJavaSparkContextBySparkConf(SparkConf sparkConf) {
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        return javaSparkContext;
    }

    /**
     * 初始化 SparkSession
     *
     * @return SparkSession
     */
    private static SparkSession initSparkSession() {
        SparkConf sparkConf = initSparkConf();
        SparkSession sparkSession = SparkSession.builder().appName(appName).config(sparkConf).getOrCreate();
        return sparkSession;
    }

    /**
     * 初始化 SparkSession 并启动 hive 支持
     *
     * @return SparkSession
     */
    private static SparkSession initSparkSessionAndEnableHiveSupport() {
        SparkConf sparkConf = initSparkConf();
        SparkSession sparkSession = SparkSession.builder().appName(appName).config(sparkConf).enableHiveSupport().getOrCreate();
        return sparkSession;
    }

    /**
     * 通过 SparkSession 初始化 JavaSparkContext
     *
     * @return JavaSparkContext
     */
    private static JavaSparkContext initJavaSparkContextBySparkSession(SparkSession sparkSession) {
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
        return javaSparkContext;
    }

    /**
     * 关闭 SparkSession
     *
     */
    private static void stopSparkSession(SparkSession sparkSession) {
        sparkSession.stop();
    }

    /**
     * 关闭 JavaSparkContext
     *
     */
    private static void stopSparkSession(JavaSparkContext javaSparkContext) {
        javaSparkContext.stop();
    }






    /**
     * 读取鸢尾花数据集
     *
     * 测试数据:http://archive.ics.uci.edu/ml/machine-learning-databases/iris/
     *
     * 特征
     *  该数据集测量了所有150个样本的4个特征，分别是：
     *
     *      1、sepal length（花萼长度）
     *      2、sepal width（花萼宽度）
     *      3、petal length（花瓣长度）
     *      4、petal width（花瓣宽度）
     * 以上四个特征的单位都是厘米（cm）。
     *
     * 通常使用𝑚表示样本量的大小，𝑛表示每个样本所具有的特征数。因此在该数据集中，𝑚=150,𝑛=4
     *
     *
     */
    private static Dataset<Row> getIrisDataSet() throws IOException {
        String filePath = "dataset/iris.data";
        Dataset<Row> dataFrame = getIrisDataSetFromResourcesDirectory(filePath);
        return dataFrame;
    }

    /**
     * 读取文件问题
     *
     *  Spark读取resources目录中文件
     *  https://blog.csdn.net/LINBE_blazers/article/details/104012275
     */
    private static void getIrisDataSetFromResourcesDirectory() {
        SparkSession sparkSession = initSparkSession();

        // Exception in thread "main" org.apache.spark.sql.AnalysisException: Path does not exist: file:/Users/hiahia/develop/workspace/IntelliJ-IDEA/github/hello/dataset/iris.data;
        // Dataset<Row> irisDataSet = sparkSession.read().text("./dataset/iris.data");

        // Exception in thread "main" org.apache.spark.sql.AnalysisException: Path does not exist: file:/Users/hiahia/develop/workspace/IntelliJ-IDEA/github/hello/dataset/iris.data;
        // Dataset<Row> irisDataSet = sparkSession.read().text("dataset/iris.data");

        // Exception in thread "main" org.apache.spark.sql.AnalysisException: Path does not exist: file:/dataset/iris.data;
        // Dataset<Row> irisDataSet = sparkSession.read().text("/dataset/iris.data");

        // InputStream resourceAsStream = SparkCommon.class.getClassLoader().getResourceAsStream("./dataset/iris.data");

    }

    /**
     * 参考博文
     *      java spark list 转为 RDD 转为 dataset 写入表中
     *      https://www.cnblogs.com/Allen-rg/p/11365013.html
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    private static Dataset<Row> getIrisDataSetFromResourcesDirectory(String filePath) throws IOException {

        InputStream in = SparkCommon.class.getClassLoader().getResourceAsStream("dataset/iris.data");

        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            lines.add(line);
        }


        SparkSession sparkSession = initSparkSession();
        JavaSparkContext javaSparkContext = initJavaSparkContextBySparkSession(sparkSession);

        JavaRDD<String> linesRDD = javaSparkContext.parallelize(lines);

        /** - begin - filter */
        JavaRDD<String> filter;

        JavaRDD<String> filter_1 = linesRDD.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String line) throws Exception {
                if (line != null && line.length() > 0 && line.trim().length() > 0) {
                    return true;
                }
                return false;
            }
        });

        JavaRDD<String> filter_2 = linesRDD.filter((String line_1) -> {
            if (line_1 != null && line_1.length() > 0 && line_1.trim().length() > 0) {
                return true;
            }
            return false;
        });

        filter = filter_2;

        /** - end - filter */

        /** - begin - map */

        /** - end - map */

        /** - begin - get DataFrame */

        // Dataset<Row> dataFrame = reflectTransform(sparkSession, filter);
        Dataset<Row> dataFrame = dataFrame = dynamicTransform(sparkSession, filter);

        /** - end - get DataFrame */



        return dataFrame;

    }

    /**
     * 通过Java反射转换
     * @param sparkSession
     *          sparkSession
     * @return Dataset<Row>
     */
    private static Dataset<Row> reflectTransform(SparkSession sparkSession, JavaRDD<String> linesRDD) {
        JavaRDD<Iris> irisRDD;

        JavaRDD<Iris> irisRDD_1 = linesRDD.map(new Function<String, Iris>() {

            @Override
            public Iris call(String line) throws Exception {
                String[] split = line.split(",");

                Iris iris = new Iris();

                iris.setSepalLengthCm(Float.parseFloat(split[0].trim()));
                iris.setSepalWidthCm(Float.parseFloat(split[1].trim()));
                iris.setPetalLengthCm(Float.parseFloat(split[2].trim()));
                iris.setPetalWidthCm(Float.parseFloat(split[3].trim()));

                iris.setSpecies(split[4].trim());

                return iris;
            }
        });

        JavaRDD<Iris> irisRDD_2 = linesRDD.map(line -> {
            String[] split = line.split(",");

            Iris iris = new Iris();

            iris.setSepalLengthCm(Float.parseFloat(split[0].trim()));
            iris.setSepalWidthCm(Float.parseFloat(split[1].trim()));
            iris.setPetalLengthCm(Float.parseFloat(split[2].trim()));
            iris.setPetalWidthCm(Float.parseFloat(split[3].trim()));

            iris.setSpecies(split[4].trim());

            return iris;
        });

        irisRDD = irisRDD_2;

        Dataset<Row> dataFrame = sparkSession.createDataFrame(irisRDD, Iris.class);

        return dataFrame;
    }

    /**
     * 动态转换
     * @param sparkSession
     *          sparkSession
     * @return Dataset<Row>
     */
    private static Dataset<Row> dynamicTransform(SparkSession sparkSession, JavaRDD<String> linesRDD) {

        JavaRDD<Row> rowRDD;

        JavaRDD<Row> rowRDD_1 = linesRDD.map(new Function<String, Row>() {

            @Override
            public Row call(String line) throws Exception {
                String[] split = line.split(",");

                float sepalLengthCm = Float.parseFloat(split[0].trim());
                float sepalWidthCm = Float.parseFloat(split[1].trim());
                float petalLengthCm = Float.parseFloat(split[2].trim());
                float petalWidthCm = Float.parseFloat(split[3].trim());

                String species = split[4].trim();

                Row row = RowFactory.create(sepalLengthCm, sepalWidthCm, petalLengthCm, petalWidthCm, species);

                return row;
            }
        });

        JavaRDD<Row> rowRDD_2 = linesRDD.map((String line) -> {
            String[] split = line.split(",");

            float sepalLengthCm = Float.parseFloat(split[0].trim());
            float sepalWidthCm = Float.parseFloat(split[1].trim());
            float petalLengthCm = Float.parseFloat(split[2].trim());
            float petalWidthCm = Float.parseFloat(split[3].trim());

            String species = split[4].trim();

            Row row = RowFactory.create(sepalLengthCm, sepalWidthCm, petalLengthCm, petalWidthCm, species);

            return row;
        });

        rowRDD = rowRDD_2;

        List<StructField> fields = new ArrayList<>();
        StructField field = null;

        field = DataTypes.createStructField("sepalLength", DataTypes.FloatType, true);
        fields.add(field);

        field = DataTypes.createStructField("sepalWidth", DataTypes.FloatType, true);
        fields.add(field);

        field = DataTypes.createStructField("petalLength", DataTypes.FloatType, true);
        fields.add(field);

        field = DataTypes.createStructField("petalWidth", DataTypes.FloatType, true);
        fields.add(field);

        field = DataTypes.createStructField("species", DataTypes.StringType, true);
        fields.add(field);

        StructType schema = DataTypes.createStructType(fields);

        Dataset<Row> dataFrame = sparkSession.createDataFrame(rowRDD, schema);

        return dataFrame;

    }

    /**
     * 泰坦尼克数据集
     *
     * 题目提供的训练数据集包含11个特征，分别是：
     *      PassengerId:乘客id
     *      Survived:0代表死亡，1代表存活
     *      Pclass:乘客所持票类，有三种值(1,2,3)
     *      Name:乘客姓名
     *      Sex:乘客性别
     *      Age:乘客年龄(有缺失)
     *      SibSp:乘客兄弟姐妹/配偶的个数(整数值)
     *      Parch:乘客父母/孩子的个数(整数值)
     *      Ticket:票号(字符串)
     *      Fare:乘客所持票的价格(浮点数，0-500不等)
     *      Cabin:乘客所在船舱(有缺失)
     *      Embark:乘客登船港口:S、C、Q(有缺失)
     *
     * @return
     * @throws IOException
     */
    private static Dataset<Row>[] getTitanicDataSet() throws IOException {

        // 训练集
        Dataset<Row> titanicTrainSet = getTitanicTrainSet();

        // double[] split = {0.9d, 0.1d};
        // Dataset<Row>[] datasets = titanicTrainSet.randomSplit(split);

        // 测试集
        Dataset<Row> titanicTestSet = getTitanicTestSet();

        // 合并数组
        Dataset<Row>[] datasets = new Dataset[]{titanicTrainSet, titanicTestSet};

        return datasets;
    }
    private static Dataset<Row> getTitanicTrainSet() throws IOException {
        Dataset<Row> titanicTrainSet = getTitanicTrainSetFromFileCSV(filePathTrainSetOfTitanic);
        return titanicTrainSet;
    }
    private static Dataset<Row> getTitanicTestSet() throws IOException {
        Dataset<Row> titanicTestSet = getTitanicTestSetFromFileCSV(filePathTestSetOfTitanic);
        return titanicTestSet;
    }

    private static Dataset<Row> getTitanicDataSetFromResourcesDirectory(String filePath) throws IOException {
        return null;
    }

    private static Dataset<Row> getTitanicTrainSetFromFileCSV(String filePath) throws IOException {
        SparkSession sparkSession = initSparkSession();
        Dataset<Row> dataset = sparkSession.read()

                // .format("com.databricks.spark.csv")
                // 或者
                .format("csv")

                // 推断数据类型
                // .option("inferSchema", "true")

                // 可设置分隔符，默认，
                // .option("delimiter",",")

                // 设置空值
                // .option("nullValue", "?")

                // 表示有表头，若没有则为false
                .option("header", true)

                // 文件路径
                .load("file:///" + filePath);

        return dataset;
    }

    private static Dataset<Row> getTitanicTestSetFromFileCSV(String filePath) throws IOException {
        SparkSession sparkSession = initSparkSession();
        Dataset<Row> dataset = sparkSession.read()
                // 推断数据类型
                // .option("inferSchema", "true")

                // 可设置分隔符，默认，
                // .option("delimiter",",")

                // 设置空值
                // .option("nullValue", "?")

                // 表示有表头，若没有则为false
                .option("header", true)

                // 文件路径
                .csv("file:///" + filePath);

        return dataset;
    }

    private static void showDatasetInfo(Dataset<Row> dataset) {
        System.out.println("- printSchema() ------------------------------------");
        dataset.printSchema();

        System.out.println("- show() --------------------------------------------");
        dataset.show(); // 只显示前20条记录。

        System.out.println("- show(10) --------------------------------------------");
        dataset.show(10); // 显示numRows条

        System.out.println("- show(false) --------------------------------------------");
        dataset.show(false); // 是否最多只显示20个字符，默认为true。

        System.out.println("- show(10, false) --------------------------------------------");
        dataset.show(10, false); // 综合前面的显示记录条数，以及对过长字符串的显示格式。


    }
    /**
     * 统计信息
     *
     * @param dataFrame
     */
    private static Dataset<Row> statisticalInformation(Dataset<Row> dataFrame) {
        Dataset<Row> dataFrameDescribe = dataFrame.describe();
        dataFrame.describe().show(100, false);
        return dataFrameDescribe;
    }


}
