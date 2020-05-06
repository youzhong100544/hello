# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn import datasets

'''
推荐博文
    sklearn.datasets常用功能详解
    https://blog.csdn.net/rocling/article/details/85239441

'''

'''
作为 Python 中经典的机器学习模块，sklearn 围绕着机器学习提供了很多可直接调用的机器学习算法以及很多经典的数据集，本文就对 sklearn 中专门用来得到已有或自定义数据集的 datasets 模块进行详细介绍；

datasets中的数据集分为很多种，本文介绍几类常用的数据集生成方法，本文总结的所有内容你都可以在 sklearn 的官网：

http://scikit-learn.org/stable/modules/classes.html#module-sklearn.datasets

中找到对应的更加详细的英文版解释；
'''


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

这个数据集包含了威斯康辛州记录的569个病人的乳腺癌恶性/良性（1/0）类别型数据（训练目标），以及与之对应的30个维度的生理指标数据；
因此这是个非常标准的二类判别数据集，
在这里使用load_breast_cancer(return_X_y)来导出数据：
'''
print("1.2、威斯康辛州乳腺癌数据（适用于分类问题）")
print()

'''载入威斯康辛州乳腺癌数据'''
X, y = datasets.load_breast_cancer(return_X_y=True)

'''打印自变量数据'''
print(X)
print(type(X))          # 输出:<class 'numpy.ndarray'>
print(X.shape)

'''打印因变量数据'''
print(y)
print(type(y))          # 输出:<class 'numpy.ndarray'>
print(y.shape)


'''
1.3、糖尿病数据（适用于回归任务）

这是一个糖尿病的数据集，主要包括442行数据，10个属性值，
分别是：Age(年龄)、性别(Sex)、Body mass index(体质指数)、Average Blood Pressure(平均血压)、S1~S6一年后疾病级数指标。
Target为一年后患疾病的定量指标，因此适合与回归任务；
这里使用load_diabetes(return_X_y)来导出数据：

'''
print("1.3、糖尿病数据（适用于回归任务）")
print()

'''载入糖尿病数据'''
X, y = datasets.load_diabetes(return_X_y=True)

'''打印自变量数据'''
print(X)
print(type(X))
print(X.shape)

'''打印因变量数据'''
print(y)
print(type(y))
print(y.shape)


'''
1.4、手写数字数据集（适用于分类任务）

这个数据集是结构化数据的经典数据，共有1797个样本，每个样本有64的元素，对应到一个8x8像素点组成的矩阵，每一个值是其灰度值，
我们都知道图片在计算机的底层实际是矩阵，每个位置对应一个像素点，有二值图，灰度图，1600万色图等类型，
在这个样本中对应的是灰度图，控制每一个像素的黑白浓淡，所以每个样本还原到矩阵后代表一个手写体数字，这与我们之前接触的数据有很大区别；
在这里我们使用load_digits(return_X_y)来导出数据：

'''
print("1.4、手写数字数据集（适用于分类任务）")
print()

'''载入手写数字数据'''
data, target = datasets.load_digits(return_X_y=True)

'''打印自变量数据'''
print(data)
print(type(data))
print(data.shape)

'''打印因变量数据'''
print(target)
print(type(target))
print(target.shape)

'''
这里我们利用matshow()来绘制这种矩阵形式的数据示意图：
'''
'''绘制数字0'''
num = np.array(data[0]).reshape((8,8))
plt.matshow(num)
print(target[0])

'''绘制数字5'''
num = np.array(data[15]).reshape((8,8))
plt.matshow(num)
print(target[15])

'''绘制数字9'''
num = np.array(data[9]).reshape((8,8))
plt.matshow(num)
print(target[9])

plt.show()

'''
1.5、Fisher的鸢尾花数据（适用于分类问题）

著名的统计学家Fisher在研究判别分析问题时收集了关于鸢尾花的一些数据，这是个非常经典的数据集，datasets中自然也带有这个数据集；
这个数据集包含了150个鸢尾花样本，对应3种鸢尾花，各50个样本（target），以及它们各自对应的4种关于花外形的数据（自变量）；
这里我们使用load_iris(return_X_y)来导出数据：

'''
print("1.5、Fisher的鸢尾花数据（适用于分类问题）")
print()

data, target = datasets.load_iris(return_X_y=True)
print(data)
print(target)


'''
1.6、红酒数据（适用于分类问题）

这是一个共178个样本，代表了红酒的三个档次（分别有59,71,48个样本），以及与之对应的13维的属性数据，非常适合用来练习各种分类算法；
在这里我们使用load_wine(return_X_y)来导出数据：
'''
print("1.6、红酒数据（适用于分类问题）")
print()

data, target = datasets.load_wine(return_X_y=True)
print(data)
print(target)

'''
2、自定义数据集
'''
print("#" * 150)
print("#2、自定义数据集")
print("#" * 150)


'''
2.1、产生服从正态分布的聚类用数据

datasets.make_blobs(n_samples=100, n_features=2, centers=3, cluster_std=1.0, center_box=(-10.0, 10.0), shuffle=True, random_state=None):

n_samples：控制随机样本点的个数
n_features：控制产生样本点的维度（对应n维正态分布）
centers：控制产生的聚类簇的个数：

'''
print("2.1、产生服从正态分布的聚类用数据")
print()

X, y = datasets.make_blobs(n_samples=1000, n_features=2, centers=4, cluster_std=1.0, center_box=(-10.0, 10.0), shuffle=True, random_state=None)
print(X)
print(y)
plt.scatter(X[:, 0], X[:, 1], c=y, s=8)
plt.show()


'''
2.2、产生同心圆样本点

datasets.make_circles(n_samples=100, shuffle=True, noise=0.04, random_state=None, factor=0.8)

n_samples：控制样本点总数
noise：控制属于同一个圈的样本点附加的漂移程度
factor：控制内外圈的接近程度，越大越接近，上限为1

'''
print("2.2、产生同心圆样本点")
print()

X, y = datasets.make_circles(n_samples=10000, shuffle=True, noise=0.04, random_state=None, factor=0.8)

plt.scatter(X[:, 0], X[:, 1], c=y, s=8)
plt.show()


'''
2.3、生成模拟分类数据集

datasets.make_classification(n_samples=100, n_features=20, n_informative=2, n_redundant=2, n_repeated=0, n_classes=2, n_clusters_per_class=2, weights=None, flip_y=0.01, class_sep=1.0, hypercube=True, shift=0.0, scale=1.0, shuffle=True, random_state=None)

n_samples：控制生成的样本点的个数
n_features：控制与类别有关的自变量的维数
n_classes：控制生成的分类数据类别的数量

'''
print("2.3、生成模拟分类数据集")
print()

X, y = datasets.make_classification(n_samples=100, n_features=20, n_informative=2, n_redundant=2, n_repeated=0, n_classes=2, n_clusters_per_class=2, weights=None, flip_y=0.01, class_sep=1.0, hypercube=True, shift=0.0, scale=1.0, shuffle=True, random_state=None)

print(X.shape)
print(y.shape)
set(y)


'''
2.4、生成太极型非凸集样本点

datasets.make_moons(n_samples,shuffle,noise,random_state)

'''
print("2.4、生成太极型非凸集样本点")
print()

X, y = datasets.make_moons(n_samples=1000, shuffle=True, noise=0.05, random_state=None)

plt.scatter(X[:, 0], X[:, 1], c=y, s=8)
plt.show()

