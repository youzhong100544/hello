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
		boxenplot（增强的箱型图）
		
	3、Categorical estimate plots（分类估计图）
		pointplot（点图）
		barplot（条形图）
		countplot（计数统计图）
"""
"""
2.2 Categorical distribution plots（分类分布图）
2.2.3 boxenplot
boxenplot是为更大的数据集绘制增强的箱型图。
这种风格的绘图最初被命名为“信值图"，因为它显示了大量被定义为“置信区间"的分位数。
它类似于绘制分布的非参数表示的箱形图，其中所有特征对应于实际观察的数值点。
通过绘制更多分位数，它提供了有关分布形状的更多信息，特别是尾部数据的分布。

"""

"""
categorical.py

def boxenplot(x=None, y=None, hue=None, data=None, order=None, hue_order=None,
              orient=None, color=None, palette=None, saturation=.75,
              width=.8, dodge=True, k_depth='proportion', linewidth=None,
              scale='exponential', outlier_prop=None, showfliers=True, ax=None,
              **kwargs):
"""
"""
作为增强版的boxplot，boxenplot很多参数和boxplot是相似的。现在就剩下不同的参数进行详解

k_depth："proportion" 或 "tukey" 或 "trustworthy"；
通过增大百分比的粒度控制绘制的盒形图数目。每个参数代表利用不同的统计特性对异常值的数量做出不同的假设。

scale："linear" 或 "exponential" 或 "area"；
用于控制增强箱型图宽度的方法。所有参数都会给显示效果造成影响。 "linear" 通过恒定的线性因子减小宽度，"exponential" 使用未覆盖的数据的比例调整宽度， "area" 与所覆盖的数据的百分比成比例。

outlier_prop：float；
被认为是异常值的数据比例。与 k_depth 结合使用以确定要绘制的百分位数。默认值为 0.007 作为异常值的比例。该参数取值应在[0,1]范围内。

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

ax1.set_title("标题 9-1")
sns.boxenplot(x="day", y="total_bill", data=data, ax=ax1)

sns.boxenplot(x="day", y="total_bill", hue="sex", data=data, ax=ax2)
sns.boxenplot(x="day", y="total_bill", hue="sex", dodge=True, data=data, ax=ax3)
sns.boxenplot(x="day", y="total_bill", hue="sex", dodge=False, data=data, ax=ax4)

plt.show()
