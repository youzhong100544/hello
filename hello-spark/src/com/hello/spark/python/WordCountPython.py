#coding=utf-8

from pyspark import SparkContext, SparkConf

input_path = 'C:/Users/admin/Desktop/hello.txt'
output_path = 'C:/Users/admin/Desktop/output'

sc = SparkContext("local", "wordCountPython")

text_file = sc.textFile(input_path)

counts = text_file.flatMap(lambda line: line.split(" ")).map(lambda word: (word, 1)).reduceByKey(lambda a, b: a + b)
counts.saveAsTextFile(output_path)

