package com.hello.test.spark.java.macOS;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import java.util.List;

public class TestSparkLocal {
    private static String filePath = "file:///Users/hiahia/develop/hello/hello.txt";

    public static void main(String[] args) {
        test_spark_1x();
        System.out.println("-----------------------------");
        test_spark_2x();
    }

    public static void test_spark_1x() {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("macOS-TestSparkLocal");

        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        JavaRDD<String> javaRDD = sparkContext.textFile(filePath);

        List<String> collect = javaRDD.collect();

        for (int i = 0; i < collect.size(); i++) {
            System.out.println(collect.get(i));
        }

        sparkContext.stop();
    }

    public static void test_spark_2x() {

        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("macOS-TestSparkLocal")
                .getOrCreate();


        JavaSparkContext sparkContext = new JavaSparkContext(spark.sparkContext());

        JavaRDD<String> javaRDD = sparkContext.textFile(filePath);

        List<String> collect = javaRDD.collect();

        for (int i = 0; i < collect.size(); i++) {
            System.out.println(collect.get(i));
        }

        sparkContext.stop();

    }
}
