# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd

import matplotlib as mpl

# import matplotlib.pyplot as plt
from matplotlib import pyplot as plt

import matplotlib.pylab as plb
# from matplotlib import pylab as plb

from matplotlib.ticker import MultipleLocator, FormatStrFormatter

import seaborn as sb

import sklearn
from sklearn import datasets

print("numpy version: {}".format(np.__version__))
print("pandas version: {}".format(pd.__version__))
print("matplotlib version: {}".format(mpl.__version__))
print("seaborn version: {}".format(sb.__version__))
print("sklearn version: {}".format(sklearn.__version__))

np.set_printoptions(threshold=np.inf)  

pd.set_option('expand_frame_repr', False)
pd.set_option('display.max_columns', None)
pd.set_option('display.max_rows', None)
pd.set_option('max_colwidth', 10240)
pd.set_option('display.width', 1024)
pd.set_option('display.unicode.ambiguous_as_wide', True)
pd.set_option('display.unicode.east_asian_width', True)

# 查看字体路径
print(mpl.matplotlib_fname())
# 查看 matplotlib 的字体缓存路径：
print(mpl.get_cachedir())

# 指定默认字体
# win
# plt.rcParams['font.sans-serif'] = ['SimHei']
# plt.rcParams['font.family'] = 'sans-serif'
# mac
plt.rcParams['font.sans-serif'] = ['Arial Unicode MS']

# 用来正常显示负号
plt.rcParams['axes.unicode_minus'] = False

# 使用numpy产生数据
A = np.arange(-4, 5)
B = A**2
C = A**3
print(A)
print(B)
print(C)
print("~" * 100)

# np.random.seed(0)
a = np.random.randint(-10, 20, size=30)
b = np.random.randint(-10, 20, size=30)
c = np.arange(1,31)

print("a")
print(a)
print("a.min()")
print(a.min())
print("a.max()")
print(a.max())
print("b")
print(b)
print("a.min()")
print(b.min())
print("b.max()")
print(b.max())
print("c")
print(c)

print("-" * 100)

"""
条形图／柱状图

柱状图（纵向）
条形图（横向）

条形图和柱状图用来比较各独立类别下的单独数据的大小比较
"""

"""
def barh(self, y, width, height=0.8, left=None, *, align="center", **kwargs):

"""
fig = plt.figure(figsize=(15, 15))               # 开启一个窗口，同时设置大小，分辨率
ax1 = fig.add_subplot(3, 3, 1)   # 通过fig添加子图，参数：行数，列数，第几个。
ax2 = fig.add_subplot(3, 3, 2)   # 通过fig添加子图，参数：行数，列数，第几个。
ax3 = fig.add_subplot(3, 3, 3)   # 通过fig添加子图，参数：行数，列数，第几个。
ax4 = fig.add_subplot(3, 3, 4)   # 通过fig添加子图，参数：行数，列数，第几个。
ax5 = fig.add_subplot(3, 3, 5)   # 通过fig添加子图，参数：行数，列数，第几个。
ax6 = fig.add_subplot(3, 3, 6)   # 通过fig添加子图，参数：行数，列数，第几个。
ax7 = fig.add_subplot(3, 3, 7)   # 通过fig添加子图，参数：行数，列数，第几个。
ax8 = fig.add_subplot(3, 3, 8)   # 通过fig添加子图，参数：行数，列数，第几个。
ax9 = fig.add_subplot(3, 3, 9)   # 通过fig添加子图，参数：行数，列数，第几个。

region = ["北京", "上海", "长春", "天津", "南京", "深圳"]
price = [4313, 1222, 3424, 2234, 3334, 2934]
ax1_barh = ax1.barh(region, price, height=0.3)
ax1_barh[-1].set_color('green')
ax1_barh[-4].set_color('r')
# 给条形图添加数据标注
"""
def text(self, x, y, s, fontdict=None, withdash=False, **kwargs):
"""
for y, x in enumerate(price):
    ax1.text(x+5, y-0.1, "%s" %x)

plt.show()


