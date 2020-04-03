# -*- coding: utf-8 -*-

import findspark
findspark.init()

import os
import sys
os.environ['JAVA_HOME'] = "C:\Program Files\Java\jdk1.8.0_171"
os.environ['HADOOP_HOME'] = "C:/develop/hadoop-3.1.0"
os.environ['SPARK_HOME'] = "C:/develop/spark-2.3.1-bin-hadoop2.7"
sys.path.append("C:/develop/spark-2.3.1-bin-hadoop2.7/python")
sys.path.append("C:/develop/spark-2.3.1-bin-hadoop2.7/python/lib/py4j-0.10.6-src.zip")

from pyspark import SparkConf, SparkContext
# 创建SparkConf和SparkContext
conf = SparkConf().setMaster("local").setAppName("HelloSparkMLlib-python")
sc = SparkContext(conf = conf)


class HelloSparkMLlib(object):

    def __init__(self, spark_context=None):
        self._spark_context = spark_context


    '''
    相关性分析
    '''
    def test(self):
        print("test")


    """
    相关性分析
    """
    def correlationAnalysis(self):
        print("correlationAnalysis")
        self.test()






if __name__ == "__main__":

    demo = HelloSparkMLlib(sc)


    """
        相关性分析
    """
    demo.correlationAnalysis()