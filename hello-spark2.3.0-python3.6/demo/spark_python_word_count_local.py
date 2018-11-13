#coding=utf-8

import findspark
findspark.init()

from pyspark import SparkConf, SparkContext

import os
import sys
os.environ['SPARK_HOME'] = "C:\\develop\\spark-2.3.0-bin-hadoop2.7"
os.environ['JAVA_HOME'] = "C:\\develop\\Java\\jdk1.8.0_161"
sys.path.append("C:\\develop\\spark-2.3.0-bin-hadoop2.7")
os.environ['HADOOP_HOME'] = "C:\\develop\\hadoop-3.1.0"

input_path = 'C://Users/calm/Desktop/hello.txt'
output_path = 'C://Users/calm/Desktop/output'

sc = SparkContext("local", "wordCountPython")

text_file = sc.textFile(input_path)

counts = text_file.flatMap(lambda line: line.split(" ")).map(lambda word: (word, 1)).reduceByKey(lambda a, b: a + b)
counts.saveAsTextFile(output_path)