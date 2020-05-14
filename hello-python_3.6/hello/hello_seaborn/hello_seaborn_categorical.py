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
2.1 Categorical scatterplots（分类散点图）
"""
"""
2.1.1 stripplot（分布散点图）
stripplot（分布散点图）的意思就是按照不同类别对样本数据进行分布散点图绘制。
stripplot（分布散点图）一般并不单独绘制，它常常与boxplot和violinplot联合起来绘制，作为这两种图的补充。
"""
"""
2.1.2 swarmplot（分布密度散点图）
这个函数类似于stripplot()，但是对点进行了调整(只沿着分类轴)，这样它们就不会重叠。这更好地表示了值的分布，但它不能很好地扩展到大量的观测。
"""


"""
2.2 Categorical distribution plots（分类分布图）
"""
"""
2.2.1 boxplot（箱线图）
boxplot（箱线图，又称为盒须图、盒式图）便于在变量之间或跨类别变量级别比较的方式,显示定量数据的分布情况。
框显示数据集的四分位数，线显示分布的其余部分，它能显示出一组数据的最大值、最小值、中位数及上下四分位数，使用四分位数范围函数的方法可以确定“离群值”的点。
"""
"""
2.2.2 violinplot（小提琴图）
violinplot与boxplot扮演类似的角色，箱线图展示了分位数的位置，它显示了定量数据在一个（或多个）分类变量的多个层次上的分布，这些分布可以进行比较。
不像箱形图中所有绘图组件都对应于实际数据点，小提琴绘图以基础分布的核密度估计为特征，通过小提琴图可以知道哪些位置的密度较高。
在图中，白点是中位数，黑色盒型的范围是下四分位点到上四分位点，细黑线表示须。外部形状即为核密度估计。

这是一种可以同时显示多个数据分布的有效和有吸引力的方法，但请记住，估计过程受样本大小的影响，相对较小的样本的小提琴手看起来可能会显得非常平滑。
"""
"""
2.2.3 violinplot + stripplot（小提琴图+分布散点图）
"""
"""
2.2.4 violinplot + swarmplot（小提琴图+分布密度散点图）
"""
"""
2.2.5 boxplot + stripplot（箱线图+分布散点图）
"""
"""
2.2.6 boxplot + swarmplot（箱线图+分布密度散点图）
"""


"""
2.3 Categorical estimate plots（分类估计图）
"""
"""
2.3.1 barplot（条形图）
条形图表示数值变量与每个矩形高度的中心趋势的估计值，用矩形条表示点估计和置信区间，并使用误差线提供关于该估计值附近的不确定性的一些指示。
"""
"""
2.3.2 countplot（计数图）
一个计数图可以被认为是一个分类直方图，而不是定量的变量。基本的api和选项与barplot（）相同，因此您可以比较嵌套变量中的计数。（工作原理就是对输入的数据分类，条形图显示各个分类的数量）。
"""
"""
2.3.3 piontplot（点图）
用散点图符号表示点估计和置信区间，点图代表散点图位置的数值变量的中心趋势估计，并使用误差线提供关于该估计的不确定性的一些指示。
点图可能比条形图（barplot）更有用于聚焦一个或多个分类变量的不同级别之间的比较。
他们尤其善于表现交互作用：一个分类变量的层次之间的关系如何在第二个分类变量的层次之间变化。
连接来自相同色调等级的每个点的线允许交互作用通过斜率的差异进行判断，这比对几组点或条的高度比较容易。
"""
"""
2.3.4 catplot（）
该函数提供了对几个轴级函数的访问，这些函数使用几种可视化表示形式之一显示一个数字变量和一个或多个分类变量之间的关系。其实说白了就是利用kind参数来画前面Categorical plots（分类图）中的任意8个图形。
"""

