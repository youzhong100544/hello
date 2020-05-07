# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from sklearn import datasets
from sklearn.datasets import load_digits

from sklearn import linear_model
from sklearn.linear_model import LinearRegression

from sklearn.model_selection import train_test_split
from sklearn.model_selection import learning_curve, ShuffleSplit

from sklearn.metrics import mean_squared_error

'''记载数据 - 波士顿房价数据'''
digits = datasets.load_boston()
X = digits.data
y = digits.target


# 划分训练集和检验集
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25, random_state=10010)

# 使用训练集训练模型
reg = LinearRegression()
reg.fit(X_train, y_train)

# 使用模型进行预测
y_predict = reg.predict(X_test)

# 计算模型的预测值与真实值之间的均方误差MSE
print(mean_squared_error(y_test, y_predict))
