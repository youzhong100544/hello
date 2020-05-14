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


# True就是可以换行显示。设置成False的时候不允许换行
pd.set_option('expand_frame_repr', False)
# 显示所有列
pd.set_option('display.max_columns', None)
# 显示所有行
pd.set_option('display.max_rows', None)
# 列长度
# 设置 value 的显示长度为100，默认为50
pd.set_option('max_colwidth', 10000)
# 横向最多显示多少个字符， 一般80不适合横向的屏幕，平时多用200.
pd.set_option('display.width', 1024)
# 输出时列名对齐列数据
# 这两个参数的默认设置都是False
pd.set_option('display.unicode.ambiguous_as_wide', True)
pd.set_option('display.unicode.east_asian_width', True)


# 指定默认字体
# win
# plt.rcParams['font.sans-serif'] = ['SimHei']
# plt.rcParams['font.family'] = 'sans-serif'
# mac
plt.rcParams['font.sans-serif'] = ['Arial Unicode MS']

# 用来正常显示负号
plt.rcParams['axes.unicode_minus'] = False


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
2.1 Categorical scatterplots（分类散点图）
2.1.1 stripplot（分布散点图）
stripplot（分布散点图）的意思就是按照不同类别对样本数据进行分布散点图绘制。
stripplot（分布散点图）一般并不单独绘制，它常常与 boxplot 和 violinplot 联合起来绘制，作为这两种图的补充。
"""

"""
categorical.py

def stripplot(x=None, y=None, hue=None, data=None, order=None, hue_order=None,
              jitter=True, dodge=False, orient=None, color=None, palette=None,
              size=5, edgecolor="gray", linewidth=0, ax=None, **kwargs):
"""
"""
x，y，data：输入数据可以多种格式传递，在大多数情况下，使用Numpy或Python对象是可能的，但是更可取的是pandas对象，因为相关的名称将用于对轴进行注释。此外，还可以对分组变量使用分类类型来控制情节元素的顺序。
order：用order参数进行筛选分类类别，例如：order=[‘sun’,‘sat’]；
jitter：抖动项，表示抖动程度，可以使float，或者True；
dodge：重叠区域是否分开，当使用hue时，将其设置为True，将沿着分类轴将不同色调级别的条带分开。
orient：“v” | “h”，vertical（垂直） 和 horizontal（水平）的意思；
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


# 基本的图
sns.stripplot(x="day", y="total_bill", data=data, ax=ax1)
sns.stripplot(x="total_bill", y="day", data=data, ax=ax2)

# 多增加几个参数的修改：
# dodge：重叠区域是否分开，当使用hue时，将其设置为True，将沿着分类轴将不同色调级别的条带分开。
# jitter：jitter:当数据点重合较多时，可用该参数做一些调整
# palette：调色板
sns.stripplot(x="day", y="total_bill", hue="smoker", dodge=True, data=data, ax=ax3)
sns.stripplot(x="day", y="total_bill", hue="smoker", dodge=True, data=data, jitter=True, ax=ax4)
sns.stripplot(x="day", y="total_bill", hue="smoker", dodge=True, data=data, jitter=True, palette="Set2", ax=ax5)
sns.stripplot(x="day", y="total_bill", hue="smoker", dodge=True, data=data, jitter=True, palette="Blues_d", ax=ax6)

plt.show()
