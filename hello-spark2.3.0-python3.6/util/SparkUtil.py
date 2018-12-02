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


def initSparkConf():
    sparkConf = SparkConf()
    sparkConf.setMaster("local[*]").setAppName("initSparkConf")
    return sparkConf


def initSparkContext(conf):
    return SparkContext(conf=conf)

def initSparkContext():
    return SparkContext("local[*]", appName="initSparkContext")
