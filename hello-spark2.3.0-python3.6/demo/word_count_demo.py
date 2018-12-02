# -*- coding: utf-8 -*-

import findspark
findspark.init()

import os
import sys
os.environ['JAVA_HOME'] = "C:/develop/Java/jdk1.8.0_161"
os.environ['HADOOP_HOME'] = "C:/develop/hadoop-3.1.0"
os.environ['SPARK_HOME'] = "C:/develop/spark-2.3.0-bin-hadoop2.7"
sys.path.append("C:/develop/spark-2.3.0-bin-hadoop2.7/python")
sys.path.append("C:/develop/spark-2.3.0-bin-hadoop2.7/python/lib/py4j-0.10.6-src.zip")

from pyspark import SparkConf, SparkContext

# 创建SparkConf和SparkContext
# conf = SparkConf().setMaster("local").setAppName("spark_word_Count_Python_demo")
# sc = SparkContext(conf = conf)

# 或者
sys.path.append(r'./../util')
import SparkUtil

sc = SparkUtil.initSparkContext()

# 输入的数据
data=["hello world","hello c","hello java","hello scala","hello python","hello hadoop","hello spark","world is good"]

# 将Collection的data转化为spark中的rdd并进行操作
rdd=sc.parallelize(data)
resultRdd = rdd.flatMap(lambda line: line.split(" ")).map(lambda word: (word, 1)).reduceByKey(lambda a, b: a + b)

# rdd转为collecton并打印
resultColl = resultRdd.collect()
for line in resultColl:
    print(line)

# 结束
sc.stop()
