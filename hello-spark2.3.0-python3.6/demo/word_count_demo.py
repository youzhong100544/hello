# -*- coding: utf-8 -*-

import findspark
findspark.init()

from pyspark import SparkConf, SparkContext

import os
import sys
os.environ['SPARK_HOME'] = "C:\\develop\\spark-2.3.0-bin-hadoop2.7"
os.environ['JAVA_HOME'] = "C:\\develop\\Java\\jdk1.8.0_161"
sys.path.append("C:\\develop\\spark-2.3.0-bin-hadoop2.7")
os.environ['HADOOP_HOME'] = "C:\\develop\\hadoop-3.1.0"


# 创建SparkConf和SparkContext
conf = SparkConf().setMaster("local").setAppName("word_count_demo")
sc = SparkContext(conf = conf)

# 输入的数据
data=["hello","world","hello","word","count","count","hello"]

# 将Collection的data转化为spark中的rdd并进行操作
rdd=sc.parallelize(data)
resultRdd = rdd.map(lambda word: (word, 1)).reduceByKey(lambda a, b: a + b)

# rdd转为collecton并打印
resultColl = resultRdd.collect()
for line in resultColl:
    print(line)

# 结束
sc.stop()
