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
关系图
"""
"""
relational.py

def relplot(x=None, y=None, hue=None, size=None, style=None, data=None,
            row=None, col=None, col_wrap=None, row_order=None, col_order=None,
            palette=None, hue_order=None, hue_norm=None,
            sizes=None, size_order=None, size_norm=None,
            markers=None, dashes=None, style_order=None,
            legend="brief", kind="scatter",
            height=5, aspect=1, facet_kws=None, **kwargs):
"""
"""
relplot（关系图）可以看做是 lineplot 和 scatterplot 的归约，可以通过 kind 参数来指定画什么图形，重要参数解释如下：

kind：默认scatter（散点图），也可以选择kind='line'（线图）；
sizes：List、dict或tuple，可选，简单点就是图片大小，注意和size区分；
col、row：将决定网格的面数的分类变量，具体看实例；

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

sns.relplot(x="total_bill", y="tip", data=data)
plt.show()

# 两者效果一模一样
sns.scatterplot(x="total_bill", y="tip", data=data)
plt.show()

# 其他参数设置：
g = sns.relplot(x="total_bill", y="tip", hue="time", size="size", palette=["b", "r"], sizes=(10, 100), col="time", row='sex', data=data)
plt.show()
