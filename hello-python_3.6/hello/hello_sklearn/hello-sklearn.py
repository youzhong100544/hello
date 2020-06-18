# -*- coding: utf-8 -*-

import numpy as np

import pandas as pd

import matplotlib as mpl

import matplotlib.pyplot as plt
# from matplotlib import pyplot as plt

# import matplotlib.pylab as plb
from matplotlib import pylab as plb

import seaborn as sns

import sklearn

from sklearn import datasets

from sklearn.preprocessing import OneHotEncoder, LabelEncoder

from sklearn.cluster import KMeans
from sklearn.cluster import k_means

from sklearn.datasets import make_blobs

# from sklearn import svm, tree, linear_model, neighbors, naive_bayes, ensemble, discriminant_analysis, gaussian_process

from sklearn import svm
from sklearn import tree
from sklearn import linear_model
from sklearn import neighbors
from sklearn import naive_bayes
from sklearn import ensemble
from sklearn import discriminant_analysis
from sklearn import gaussian_process

from sklearn import feature_selection
from sklearn import model_selection
from sklearn import metrics

from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import euclidean_distances
from sklearn.feature_extraction.text import TfidfVectorizer


print("numpy version: {}". format(np.__version__))
print("pandas version: {}". format(pd.__version__))
print("matplotlib version: {}". format(mpl.__version__))
print("seaborn version: {}". format(sns.__version__))
print("scikit-learn(sklearn) version: {}". format(sklearn.__version__))


'''清空sklearn环境下所有数据'''
datasets.clear_data_home()

'''
1、自带的经典小数据集
'''
print("#" * 150)
print("# 1、自带的经典小数据集")
print("#" * 150)
print()


'''
1.1、波士顿房价数据（适用于回归任务）

这个数据集包含了506处波士顿不同地理位置的房产的房价数据（因变量），和与之对应的包含房屋以及房屋周围的详细信息（自变量），
其中包含城镇犯罪率、一氧化氮浓度、住宅平均房间数、到中心区域的加权距离以及自住房平均房价等13个维度的数据，
因此，波士顿房价数据集能够应用到回归问题上，
这里使用load_boston(return_X_y=False)方法来导出数据，其中参数return_X_y控制输出数据的结构，若选为True，则将因变量和自变量独立导出；

'''
print("1.1、波士顿房价数据（适用于回归任务）")
print()

print("加载数据")
boston = datasets.load_boston()
print(boston)
print(type(boston))         # 输出:<class 'sklearn.utils.Bunch'>

print("-" * 100)
print("数据 - filename")
boston_filename = boston.filename
print(boston_filename)
# 输出:/Users/hiahia/develop/github/hello/venv/lib/python3.8/site-packages/sklearn/datasets/data/boston_house_prices.csv
# 输出:C:\develop\Python\Python36\lib\site-packages\sklearn\datasets\data\boston_house_prices.csv
print(type(boston_filename))       # 输出:<class 'str'>

print("-" * 100)
print("数据 - data")
boston_data = boston.data
print(boston_data)
print(type(boston_data))    # 输出:<class 'numpy.ndarray'>

print("-" * 100)
print("数据 - target")
boston_target = boston.target
print(boston_target)
print(type(boston_target))    # 输出:<class 'numpy.ndarray'>

print("-" * 100)
print("数据 - feature_names")
boston_feature_names = boston.feature_names
print(boston_feature_names)             # 输出:['CRIM' 'ZN' 'INDUS' 'CHAS' 'NOX' 'RM' 'AGE' 'DIS' 'RAD' 'TAX' 'PTRATIO' 'B' 'LSTAT']
print(type(boston_feature_names))       # 输出:<class 'numpy.ndarray'>

print("-" * 100)
print("数据 - DESCR")
boston_DESCR = boston.DESCR
print(boston_DESCR)             # 输出:
print(type(boston_DESCR))       # 输出:<class 'str'>

print("~" * 100)

'''载入波士顿房价数据'''
X, y = datasets.load_boston(return_X_y=True)

'''打印自变量数据'''
print(X)
print(type(X))
print(X.shape)

'''打印因变量数据'''
print(y)
print(type(y))
print(y.shape)



