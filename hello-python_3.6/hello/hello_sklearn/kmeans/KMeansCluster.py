#coding:utf-8  
'''
Created on 2018年1月20日

@author: root
'''
import numpy as np       
import matplotlib.pyplot as plt       
from sklearn.cluster import KMeans        
from sklearn.datasets import make_blobs  
  
dataMat = []                
fr = open("C:\\Users\\calm\\Desktop\\hello\\testSet.txt","r")
for line in fr.readlines():

    if line.strip() != "":
        curLine = line.strip().split('\t')
        fltLine = map(float, curLine)

        print(fltLine)