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

print("numpy version: {}".format(np.__version__))
print("pandas version: {}".format(pd.__version__))
print("matplotlib version: {}".format(mpl.__version__))
print("seaborn version: {}".format(sns.__version__))
print("sklearn version: {}".format(sklearn.__version__))

"""
Categorical plots（分类图）

Categorical plots（分类图）可以具体分为下面三种类型，8个小图：

	1、Categorical scatterplots（分类散点图）
		stripplot（分布散点图）
		swarmplot（分布密度散点图）

	2、Categorical distribution plots（分类分布图）
		boxplot（箱线图）
		violinplot（小提琴图）
		boxenplot（字母价值图？？？）
		
	3、Categorical estimate plots（分类估计图）
		pointplot（点图）
		barplot（条形图）
		countplot（计数统计图）
"""
"""
2.2 Categorical distribution plots（分类分布图）
2.2.1 boxplot（箱线图）
boxplot（箱线图，又称为盒须图、盒式图）便于在变量之间或跨类别变量级别比较的方式,显示定量数据的分布情况。
框显示数据集的四分位数，线显示分布的其余部分，它能显示出一组数据的最大值、最小值、中位数及上下四分位数，使用四分位数范围函数的方法可以确定“离群值”的点。

"""

"""
categorical.py

def boxplot(x=None, y=None, hue=None, data=None, order=None, hue_order=None,
            orient=None, color=None, palette=None, saturation=.75,
            width=.8, dodge=True, fliersize=5, linewidth=None,
            whis=1.5, ax=None, **kwargs):
"""
"""
saturation：饱和度，可设置为1；
width：float，控制箱型图的宽度大小；
fliersize：float，用于指示离群值观察的标记大小；
whis：可理解为异常值的上限IQR比例；
notch：我也不知道……
"""


"""
准备数据
"""
data = sns.load_dataset('tips')

"""
打印数据信息
"""
print("data" + "-" * 100)
print(data)

print("data.sample(10)" + "-" * 100)
print(data.sample(10))

print("data.shape" + "-" * 100)
print(data.shape)

print("data.columns" + "-" * 100)
print(data.columns)

print("data.info()" + "-" * 100)
print(data.info())

print("data.describe(include='all')" + "-" * 100)
print(data.describe(include='all'))

print()
print("-" * 100)
print("-" * 100)
print()

f = plt.figure(figsize=(15, 15))
ax1 = f.add_subplot(3, 3, 1)
ax2 = f.add_subplot(3, 3, 2)
ax3 = f.add_subplot(3, 3, 3)
ax4 = f.add_subplot(3, 3, 4)
ax5 = f.add_subplot(3, 3, 5)
ax6 = f.add_subplot(3, 3, 6)


sns.boxplot(x="day", y="total_bill", data=data, ax=ax1)


# 这些参数不一定要加，简单最好，这里只是为了展示参数的含义
sns.boxplot(x="day", y="total_bill", hue="time", data=data, ax=ax2)
sns.boxplot(x="day", y="total_bill", hue="time", dodge=True, data=data, ax=ax3)


sns.boxplot(x="day", y="total_bill", hue="time", dodge=True, data=data, linewidth=0.5, saturation=1, width=1, fliersize=3, ax=ax4)

sns.boxplot(x="day", y="total_bill", data=data, ax=ax5)
sns.boxplot(x="day", y="tip", data=data, ax=ax5)


ax = sns.boxplot(x="day", y="total_bill", data=data, ax=ax6)
print(type(ax))
print(ax)


plt.show()
