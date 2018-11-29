package com.hello.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import java.util.List;

public class HelloSpark {
    public static void main(String[] args) {
        demo_spark_1();
        demo_spark_2();
    }

    public static void demo_spark_1() {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("HelloSpark");

        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        JavaRDD<String> javaRDD = sparkContext.textFile("C:\\Users\\calm\\Desktop\\hello\\hello.txt");

        List<String> collect = javaRDD.collect();

        for (int i = 0; i < collect.size(); i++) {
            System.out.println(collect.get(i));
        }

        sparkContext.stop();
    }

    public static void demo_spark_2() {

        SparkSession spark = SparkSession.builder()
                                .master("local")
                                .appName("HelloSpark")
                                .getOrCreate();


        JavaSparkContext sparkContext = new JavaSparkContext(spark.sparkContext());

        JavaRDD<String> javaRDD = sparkContext.textFile("C:\\Users\\calm\\Desktop\\hello\\hello.txt");

        List<String> collect = javaRDD.collect();

        for (int i = 0; i < collect.size(); i++) {
            System.out.println(collect.get(i));
        }

        sparkContext.stop();

    }
}
