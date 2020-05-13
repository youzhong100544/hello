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
线图
"""
"""
relational.py

def lineplot(x=None, y=None, hue=None, size=None, style=None, data=None,
             palette=None, hue_order=None, hue_norm=None,
             sizes=None, size_order=None, size_norm=None,
             dashes=True, markers=None, style_order=None,
             units=None, estimator="mean", ci=95, n_boot=1000, seed=None,
             sort=True, err_style="band", err_kws=None,
             legend="brief", ax=None, **kwargs):
"""
"""
在所有的seaborn绘图时，里面的参数是众多的，但是不用担心，大部分参数是相同的，只有少部分存在差异，有些通过对单词的理解就可知道其含义，这里我只根据每个具体的图形重要的参数做一些解释，并简单的介绍这些常用参数的含义。

x，y：容易理解就是你需要传入的数据，一般为dataframe中的列；
hue：也是具体的某一可以用做分类的列，作用是分类；
data：是你的数据集，可要可不要，一般都是dataframe；
style：绘图的风格（后面单独介绍）；
size：绘图的大小（后面介绍）；
palette：调色板（后面单独介绍）；
markers：绘图的形状（后面介绍）；
ci：允许的误差范围（空值误差的百分比，0-100之间），可为‘sd’，则采用标准差（默认95）；
n_boot（int）：计算置信区间要使用的迭代次数；
alpha：透明度；
x_jitter，y_jitter：设置点的抖动程度。

"""


"""
准备数据
"""
data = sns.load_dataset("fmri")

"""
打印数据信息
"""
print("data" + "-" * 100)
print(data)

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

f = plt.figure()
ax1 = f.add_subplot(2, 1, 1)
ax2 = f.add_subplot(2, 1, 2)

# 还是先来个简单的：
# 阴影是默认的置信区间，可设置ci=0,将其去除
sns.lineplot(x="timepoint", y="signal", data=data, ax=ax1)
sns.lineplot(x="timepoint", y="signal", data=data, ci=0, ax=ax2)
plt.show()


# 接下来，来个复杂一点儿的：
# 使用标记而不是破折号来识别组
ax = sns.lineplot(x="timepoint", y="signal", hue="event", style="event", markers=True, dashes=False, data=data)
plt.show()
