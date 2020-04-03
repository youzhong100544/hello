package com.hello.spark.java.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

public class WordCount {

    public static void main(String[] args) throws InterruptedException {

        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("WordCountOnline");
        /**
         * 在创建streaminContext的时候 设置batch Interval
         */
        JavaStreamingContext jsc = new JavaStreamingContext(conf, Durations.seconds(5));


        JavaReceiverInputDStream<String> lines = jsc.socketTextStream("hadoop1", 9999);

        JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public Iterator<String> call(String line) throws Exception {
                return Arrays.asList(line.split(" ")).iterator();
            }
        });

        JavaPairDStream<String, Integer> pair = words.mapToPair(new PairFunction<String, String, Integer>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public Tuple2<String, Integer> call(String word) {
                return new Tuple2<String, Integer>(word, 1);
            }
        });

        JavaPairDStream<String, Integer> countResult = pair.reduceByKey(new Function2<Integer, Integer, Integer>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public Integer call(Integer i1, Integer i2) {
                return i1 + i2;
            }
        });

        countResult.print();

        jsc.start();
        jsc.awaitTermination();
 	    jsc.stop(false);

    }
}
