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

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SparkCommon {

    private static String appName;
    private static String master;

    static {
        appName = "HelloSpark";
        master = "local[*]";
    }

    public static void main(String[] args) throws IOException {

        // demo();

        // getIrisDataSet();

        String filePath = "dataset/iris.data";
        getIrisDataSetFromResourcesDirectory(filePath);


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
    private static void getIrisDataSet() {
        getIrisDataSetFromResourcesDirectory();
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
     * java spark list 转为 RDD 转为 dataset 写入表中
     * https://www.cnblogs.com/Allen-rg/p/11365013.html
     * @throws IOException
     */
    private static void getIrisDataSetFromResourcesDirectory(String filePath) throws IOException {

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

        System.out.println("- printSchema ------------------------------------");

        dataFrame.printSchema();

        System.out.println("- show --------------------------------------------");

        dataFrame.show(); // 只显示前20条记录。

        System.out.println("- show --------------------------------------------");

        dataFrame.show(10); // 显示numRows条

        System.out.println("- show --------------------------------------------");

        dataFrame.show(false); // 是否最多只显示20个字符，默认为true。

        System.out.println("- show --------------------------------------------");

        dataFrame.show(10, false); // 综合前面的显示记录条数，以及对过长字符串的显示格式。


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



}
