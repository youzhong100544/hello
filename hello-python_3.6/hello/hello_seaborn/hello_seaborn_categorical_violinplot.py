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
2.2.2 violinplot（小提琴图）
violinplot 与 boxplot 扮演类似的角色，箱线图展示了分位数的位置，它显示了定量数据在一个（或多个）分类变量的多个层次上的分布，这些分布可以进行比较。
不像箱形图中所有绘图组件都对应于实际数据点，小提琴绘图以基础分布的核密度估计为特征，通过小提琴图可以知道哪些位置的密度较高。
在图中，白点是中位数，黑色盒型的范围是下四分位点到上四分位点，细黑线表示须。
外部形状即为核密度估计。

这是一种可以同时显示多个数据分布的有效和有吸引力的方法，但请记住，估计过程受样本大小的影响，相对较小的样本的小提琴手看起来可能会显得非常平滑。

"""

"""
categorical.py

def violinplot(x=None, y=None, hue=None, data=None, order=None, hue_order=None,
               bw="scott", cut=2, scale="area", scale_hue=True, gridsize=100,
               width=.8, inner="box", split=False, dodge=True, orient=None,
               linewidth=None, color=None, palette=None, saturation=.75,
               ax=None, **kwargs):
"""
"""
bw："scott", "silverman", float，控制拟合程度。在计算内核带宽时，可以引用规则的名称（"scott", "silverman"）或者使用比例（float）。实际内核大小将通过将比例乘以每个bin内数据的标准差来确定；
cut：空值外壳的延伸超过极值点的密度，float；
scale："area", "count", "width"，用来缩放每把小提琴的宽度的方法；
scale_hue：当使用hue分类后，设置为True时，此参数确定是否在主分组变量进行缩放；
gridsize：设置小提琴图的平滑度，越高越平滑；
inner："box", "quartile", "point", "stick", None,小提琴内部数据点的表示。分别表示：箱子，四分位，点，数据线和不表示；
split：是否拆分，当设置为True时，绘制经hue分类的每个级别画出一半的小提琴；

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
sns.violinplot(x="day", y="total_bill", data=data, ax=ax1)

# 设置按性别分类，调色为“Set2”，分割，以计数的方式，不表示内部。
sns.violinplot(x="day", y="total_bill", hue="sex", data=data, ax=ax2)
sns.violinplot(x="day", y="total_bill", hue="sex", dodge=True, data=data, ax=ax3)


sns.violinplot(x="day", y="total_bill", hue="sex", data=data, split=True, scale="count", ax=ax4)

sns.violinplot(x="day", y="total_bill", hue="sex", data=data, split=True, scale="count", inner=None, ax=ax5)

sns.violinplot(x="day", y="total_bill", hue="sex", data=data, palette="Set2", split=True, scale="count", inner=None, ax=ax6)


plt.show()
