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


# np.random.seed(0)
a = np.random.randint(-10, 20, size=30)
b = np.random.randint(-10, 20, size=30)
c = np.arange(0, 30)

print("a")
print(a)
print("a.len():" + str(len(a)))
print("a.min():" + a.min())
print("a.max():" + a.max())
print("b")
print(b)
print("b.len():" + str(len(b)))
print("b.min():" + b.min())
print("b.max():" + b.max())
print("c")
print(c)
print("c.len():" + str(len(c)))

print("-" * 100)

"""
python中'zip' is not subscriptable
原因就是在Python3中，zip()返回值变了，Python2中zip()返回一个元组列表，但是Python3中返回一个迭代器，所以需要list(zip())返回一个列表。
"""
zip_np = zip(a.tolist(), b.tolist())
print(zip_np)
print(type(zip_np))

txt = list(zip_np)
print(txt)
print(type(txt))

print("-" * 100)

"""
散点图
"""
"""
def scatter(x, y, s=None, c=None, marker=None, cmap=None, norm=None,
        vmin=None, vmax=None, alpha=None, linewidths=None, verts=None,
        edgecolors=None, *, data=None, **kwargs):
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

ax1.scatter(a, b)


ax2.set_title("标题 9-2")     # 设置图体,plt.title
ax2.set_xlabel("x-label-a")    # 设置x轴名称,plt.xlabel
ax2.set_ylabel("y-label-b")    # 设置y轴名称,plt.ylabel
ax2.scatter(x=a, y=b)


# python 散点图上给每个点打标签方便看到数据
"""
def annotate(self, s, xy, *args, **kwargs):
s 为注释文本内容 
xy 为被注释的坐标点
xytext 为注释文字的坐标位置
"""
for i in range(len(a)):
    # 这里xy是需要标记的坐标，xytext是对应的标签坐标
    ax2.annotate(s=txt[i], xy=(a[i], b[i]), xytext=(a[i]+0.1, b[i]+0.1))


ax3.scatter(a, b)
ax3.scatter(b, a, s=100, color='r', marker='o', linewidth=1)


ax4.scatter(a, b, label="a-b")
txt = list(zip(a.tolist(), b.tolist()))
for i in range(len(a)):
    # 这里xy是需要标记的坐标，xytext是对应的标签坐标
    ax4.annotate(txt[i], xy=(a[i], b[i]), xytext=(a[i]+0.1, b[i]+0.1))

ax4.scatter(b, a, label="b-a")
txt = list(zip(b.tolist(), a.tolist()))
for i in range(len(b)):
    # 这里xy是需要标记的坐标，xytext是对应的标签坐标
    ax4.annotate(txt[i], xy=(b[i], a[i]), xytext=(b[i]+0.1, a[i]+0.1))

ax4.legend()


plt.show()
