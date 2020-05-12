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


# 数据
# 案例：1班和2班语文成绩统计数据可视化
# 成绩数据
h1 = [ 88.2,  83.5,  68.8,  85.4,  78.6,  69.3,  60.6,  91.2,  52.7,
       85.9,  57.1,  68. ,  66.6,  78.2,  78.8,  85. ,  89.1,  74.4,
       93.6,  75.7,  54.3,  55. ,  90.9,  79.4,  94.4,  86.7,  82.4,
       76.7,  78.7,  72.3,  83.9,  78.6,  80. ,  70.5,  87.1,  80.3,
       87.9,  65.1,  67.4,  61.5,  49.7,  77.1,  91.4,  72. ,  61.5,
       73.9,  76.9,  88.2,  51.2,  53.9]

h2 = [ 79.5,  99. ,  80. ,  71. ,  79.2,  85.6,  79.2,  68.8,  68.7,
       96.5,  63.8,  81.8,  76.9,  80. ,  73.8,  77.1,  79.6,  76.8,
       73.9,  73.2,  66. ,  76.2,  76.4,  65.3,  75.2,  74.5,  87.5,
       78.4,  95. ,  72.6,  86. ,  71.7,  71. ,  87.7,  83.9,  76.8,
       72.3,  67. ,  67.8,  79.6,  81.9,  83. ,  65.6,  91.6,  75.5,
       77.6,  82.8,  87.5,  75.1,  79.4]

print("-" * 100)

"""
直方图

直方图是表达数据的分布情况的统计图表，一般用来表示同等区间内,某类数值出现的个数或频率(频率=出现次数/总数)

x轴表示分组数据，y轴表示分布情况

从频率分布直方图可以直观估计出：
    众 数：频率分布直方图中最高矩形的底边中点的横坐标
    中位数：把频率分布直方图分成两个面积相等部分的平行于Y轴的直线横坐标

直方图与柱状图的区别：
    直方图：分区之间连续无间断，表示连续变量；值用矩形面积表示
    条形图：各柱之间有间隙，表示孤立的、不连续分类变量；值用矩形长度表示

"""

"""
def hist(self, x, bins=None, range=None, density=False, weights=None,
             cumulative=False, bottom=None, histtype='bar', align='mid',
             orientation='vertical', rwidth=None, log=False,
             color=None, label=None, stacked=False, **kwargs):
"""
fig = plt.figure(figsize=(15, 15))      # 开启一个窗口，同时设置大小，分辨率
ax1 = fig.add_subplot(3, 3, 1)          # 通过fig添加子图，参数：行数，列数，第几个。
ax2 = fig.add_subplot(3, 3, 2)          # 通过fig添加子图，参数：行数，列数，第几个。
ax3 = fig.add_subplot(3, 3, 3)          # 通过fig添加子图，参数：行数，列数，第几个。
ax4 = fig.add_subplot(3, 3, 4)          # 通过fig添加子图，参数：行数，列数，第几个。
ax5 = fig.add_subplot(3, 3, 5)          # 通过fig添加子图，参数：行数，列数，第几个。
ax6 = fig.add_subplot(3, 3, 6)          # 通过fig添加子图，参数：行数，列数，第几个。
ax7 = fig.add_subplot(3, 3, 7)          # 通过fig添加子图，参数：行数，列数，第几个。
ax8 = fig.add_subplot(3, 3, 8)          # 通过fig添加子图，参数：行数，列数，第几个。
ax9 = fig.add_subplot(3, 3, 9)          # 通过fig添加子图，参数：行数，列数，第几个。

ax1_hist = ax1.hist(h1)
print(type(ax1_hist))   # 输出:<class 'tuple'>
print(len(ax1_hist))    # 输出:2
print(ax1_hist)         # 输出:(array([ 4.,  3.,  3.,  3.,  5.,  4., 11.,  5.,  7.,  5.]), array([49.7 , 54.17, 58.64, 63.11, 67.58, 72.05, 76.52, 80.99, 85.46, 89.93, 94.4 ]), <a list of 10 Patch objects>)

print()

tops = ax1_hist[0]
print(type(tops))       # 输出:<class 'numpy.ndarray'>
print(tops)          # 输出:[ 4.  3.  3.  3.  5.  4. 11.  5.  7.  5.]

print()

bins = ax1_hist[1]
print(type(bins))       # 输出:<class 'numpy.ndarray'>
print(bins)          # 输出:[49.7  54.17 58.64 63.11 67.58 72.05 76.52 80.99 85.46 89.93 94.4 ]

print()

silent_list = ax1_hist[2]
print(type(silent_list))       # 输出:<class 'matplotlib.cbook.silent_list'>
print(silent_list)          # 输出:<a list of 10 Patch objects>

print()


ax2_hist = ax2.hist(
    h1,                     # 直方图数据
    10,                     # 直方个数
    density=1,              # 默认0 数据出现个数，1 出现个数归一化为出现的频率
    histtype='bar',         # 直方图样式：默认bar，stepfilled填充颜色，step不填充只有线条
    facecolor='gray',       # 直方图颜色
    edgecolor='black',      # 直方图边框颜色
    alpha=0.3,
)
print(ax2_hist)
"""
(
array([0.01789709, 0.01342282, 0.01342282, 0.01342282, 0.02237136, 0.01789709, 0.049217  , 0.02237136, 0.03131991, 0.02237136]), 
array([49.7 , 54.17, 58.64, 63.11, 67.58, 72.05, 76.52, 80.99, 85.46, 89.93, 94.4 ]), 
<a list of 10 Patch objects>
)
"""

plt.show()
