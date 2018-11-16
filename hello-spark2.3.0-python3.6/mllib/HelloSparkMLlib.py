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
conf = SparkConf().setMaster("local").setAppName("spark_word_Count_Python_demo")
sc = SparkContext(conf = conf)


class HelloSparkMLlib(object):
    print("111")



"""
    相关性分析
"""
def correlationAnalysis(sparkContext):
    print("111")


if __name__ == "__main__":
    correlationAnalysis(sc)