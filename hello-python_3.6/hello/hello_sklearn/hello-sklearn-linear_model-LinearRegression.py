# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from sklearn import datasets

from sklearn import linear_model
from sklearn.linear_model import LinearRegression

from sklearn import model_selection
from sklearn.model_selection import train_test_split

from sklearn.metrics import mean_squared_error


'''
简单线性回归
'''

''' 记载数据 - 波士顿房价数据 '''
print("记载数据 - 波士顿房价数据")
boston = datasets.load_boston()
X = boston.data
y = boston.target

''' 划分训练集和检验集 '''
print("划分训练集和检验集")
'''
def train_test_split(*arrays, **options):

主要参数说明：
*arrays：可以是列表、numpy数组、scipy稀疏矩阵或pandas的数据框

test_size：可以为浮点、整数或None，默认为None
    ①若为浮点时，表示测试集占总样本的百分比
    ②若为整数时，表示测试样本样本数
    ③若为None时，test size自动设置成0.25

train_size：可以为浮点、整数或None，默认为None
    ①若为浮点时，表示训练集占总样本的百分比
    ②若为整数时，表示训练样本的样本数
    ③若为None时，train_size自动被设置成0.75

random_state：可以为整数、RandomState实例或None，默认为None
    ①若为None时，每次生成的数据都是随机，可能不一样
    ②若为整数时，每次生成的数据都相同

stratify：可以为类似数组或None
    ①若为None时，划分出来的测试集或训练集中，其类标签的比例也是随机的
    ②若不为None时，划分出来的测试集或训练集中，其类标签的比例同输入的数组中类标签的比例相同，可以用于处理不均衡的数据集

'''
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25, random_state=10010)

''' 使用训练集训练模型 '''
print("使用训练集训练模型")
lr = LinearRegression()
lr.fit(X_train, y_train)

''' 使用模型进行预测 '''
print("使用模型进行预测")
y_predict = lr.predict(X_test)

''' 计算模型的预测值与真实值之间的均方误差MSE '''
print("计算模型的预测值与真实值之间的均方误差MSE")
error = mean_squared_error(y_test, y_predict)
print(error)
