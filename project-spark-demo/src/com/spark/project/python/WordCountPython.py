#coding=utf-8

from pyspark import SparkContext, SparkConf

conf = SparkConf().setAppName("WordCountPython").setMaster("local")
sc = SparkContext(conf = conf)
path = 'C:\Users\dell\Desktop\hello.txt'
sc.textFile(path).flatMap(lambda line : line.split(" ")).map(lambda word : (word, 1)).reduceByKey(lambda x, y : x + y).saveAsTextFile("hdfs://mini1:9000/wordcount/ceshi/")