#coding=utf-8

import findspark
findspark.init()


import os
import sys
os.environ['JAVA_HOME'] = "C:/develop/Java/jdk1.8.0_161"
os.environ['HADOOP_HOME'] = "C:/develop/hadoop-3.1.0"
os.environ['SPARK_HOME'] = "C:/develop/spark-2.3.0-bin-hadoop2.7"
sys.path.append("C:/develop/spark-2.3.0-bin-hadoop2.7/python")
sys.path.append("C:/develop/spark-2.3.0-bin-hadoop2.7/python/lib/py4j-0.10.6-src.zip")


input_path = 'C:/Users/calm/Desktop/hello/hello.txt'
output_path = 'C:/Users/calm/Desktop/hello/output/spark/python'


import shutil
if os.path.exists(output_path):
    shutil.rmtree(output_path)

from pyspark import SparkConf, SparkContext
sc = SparkContext(master="local", appName="spark_word_Count_Python_local")
# sc = SparkContext(master="local[*]", appName="spark_word_Count_Python_local")

text_file = sc.textFile(input_path)

counts = text_file.flatMap(lambda line: line.split(" ")).map(lambda word: (word, 1)).reduceByKey(lambda a, b: a + b)
counts.saveAsTextFile(output_path)