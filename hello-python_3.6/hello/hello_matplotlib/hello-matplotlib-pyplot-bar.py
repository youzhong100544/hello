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
c = np.arange(1, 31)

print("a")
print(a)
print("a.len():" + str(len(a)))
print("a.min():" + str(a.min()))
print("a.max():" + str(a.max()))
print("b")
print(b)
print("b.len():" + str(len(b)))
print("b.min():" + str(b.min()))
print("b.max():" + str(b.max()))
print("c")
print(c)
print("c.len():" + str(len(c)))

print("-" * 100)


"""
条形图／柱状图

柱状图（纵向）
条形图（横向）

条形图和柱状图用来比较各独立类别下的单独数据的大小比较
"""

"""
def bar(self, x, height, width=0.8, bottom=None, *, align="center", **kwargs):

x：x轴的位置序列，一般采用range函数产生一个序列，但是有时候可以是字符串
height：y轴的数值序列，也就是柱形图的高度，一般就是我们需要展示的数据；
width：为柱形图的宽度，一般这是为0.8即可；
color或facecolor：柱形图填充的颜色；
alpha：透明度，值越小越透明
edgecolor：图形边缘颜色
label：解释每个图像代表的含义，这个参数是为legend()函数做铺垫的，表示该次bar的标签，其中legend()函数loc参数如下：
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

ax1.bar(c, c, width=0.8)

ax2.bar(c, a, width=0.8)
"""
def text(x,y, string, fontsize=15, verticalalignment="top", horizontalalignment="right"):

x,y:表示坐标值上的值
string:表示说明文字
fontsize:表示字体大小
verticalalignment：垂直对齐方式 ，参数：[ ‘center’ | ‘top’ | ‘bottom’ | ‘baseline’ ]
horizontalalignment：水平对齐方式 ，参数：[ ‘center’ | ‘right’ | ‘left’ ]
"""
for index in range(len(c)):
    ax2.text(c[index], a[index], s=a[index])

ax3.bar(a, c, width=0.8)
for index in range(len(a)):
    ax3.text(x=a[index], y=c[index], s=(a[index], c[index]))

ax4.bar(x=c, height=c, width=0.8)
ax5.bar(x=c, height=a, width=0.8)

index = np.arange(30)

ax7.bar(x=index, height=c, width=0.8)
ax7.bar(x=index+0.8, height=a, width=0.8)

bar_width = 0.3
ax8.bar(x=index, height=c, width=bar_width, label="c")
ax8.bar(x=index + bar_width, height=a, width=bar_width, label="a")
ax8.legend()

ax9.set_xticks(index.tolist())
ax9.bar(x=index, height=c, width=bar_width, label='c')
ax9.bar(x=index - bar_width, height=a, width=bar_width, label='a')
ax9.legend()


plt.show()
