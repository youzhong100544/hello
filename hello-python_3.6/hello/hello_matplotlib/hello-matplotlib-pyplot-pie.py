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
# 数据，会被饼图自动转换为百分比
p = [15, 30, 45, 10]

print("-" * 100)

"""
饼图

饼图用于显示各项相对总和的百分比大小
"""

"""
def pie(self, x, explode=None, labels=None, colors=None,
            autopct=None, pctdistance=0.6, shadow=False, labeldistance=1.1,
            startangle=None, radius=None, counterclock=True,
            wedgeprops=None, textprops=None, center=(0, 0),
            frame=False, rotatelabels=False):
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

ax1.pie(p)

"""
案例：2017年9国军费占比数据可视化

国家  军费占比
美国  0.5548467
中国  0.14444868
印度  0.05094268
沙特  0.04846696
俄国  0.046753
日本  0.04418206
英国  0.04161112
德国  0.03799276
法国  0.03075605

"""
# 国名
mark = ['America', 'China', 'India', 'Saudi', 'Russia', 'Japan', 'Britain', 'Germany', 'France']
# 各国占9国总军费的比例
percent = [0.5548467, 0.14444868, 0.05094268, 0.04846696, 0.046753, 0.04418206, 0.04161112, 0.03799276, 0.03075605]

ax2.pie(
    percent,                                # 百分比
    labels=mark,                            # 名称
    explode=(0, 0.1, 0, 0, 0, 0, 0, 0, 0),  # 突出块，突出比例
    autopct='%1.1f%%',                      # 显示百分比方式
    startangle=-110,                        # 饼图起始的角度,度数,默认0为右侧水平180度开始，逆时针旋转
)

ax2.axis('equal')  # 正圆形饼图,x/y轴尺寸相等.默认是扁图

plt.show()
