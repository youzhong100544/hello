# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd

from sklearn import datasets

'''
作为 Python 中经典的机器学习模块，sklearn 围绕着机器学习提供了很多可直接调用的机器学习算法以及很多经典的数据集，本文就对 sklearn 中专门用来得到已有或自定义数据集的 datasets 模块进行详细介绍；

datasets中的数据集分为很多种，本文介绍几类常用的数据集生成方法，本文总结的所有内容你都可以在 sklearn 的官网：

http://scikit-learn.org/stable/modules/classes.html#module-sklearn.datasets

中找到对应的更加详细的英文版解释；
'''


'''清空sklearn环境下所有数据'''
# datasets.clear_data_home()


'''
1、自带的经典小数据集
'''
print("1、自带的经典小数据集")
print()

'''
1.1、波士顿房价数据（适用于回归任务）
'''
print("1.1、波士顿房价数据（适用于回归任务）")
print()

'''载入波士顿房价数据'''
X, y = datasets.load_boston(return_X_y=True)

'''打印自变量数据'''
print(X)
print(type(X))
print(X.shape)

'''打印自变量数据'''
print(y)
print(type(y))
print(y.shape)

print("~" * 100)
print("加载数据")
boston = datasets.load_boston()
print(boston)
print(type(boston))         # 输出:<class 'sklearn.utils.Bunch'>

print("-" * 100)
print("数据 - filename")
boston_filename = boston.filename
print(boston_filename)             # 输出:/Users/hiahia/develop/github/hello/venv/lib/python3.8/site-packages/sklearn/datasets/data/boston_house_prices.csv
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


'''
1.2、威斯康辛州乳腺癌数据（适用于分类问题）
'''
print("1.2、威斯康辛州乳腺癌数据（适用于分类问题）")
print()

'''载入威斯康辛州乳腺癌数据'''
X, y = datasets.load_breast_cancer(return_X_y=True)

'''打印自变量数据'''
print(X)
print(type(X))          # 输出:<class 'numpy.ndarray'>
print(X.shape)

'''打印自变量数据'''
print(y)
print(type(y))          # 输出:<class 'numpy.ndarray'>
print(y.shape)


