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
a = [15, 5, 9, 22, 4, -5, 45, -22]
"""
案例：某班级a/b/c三组学员数学成绩统计分析可视化

组别\编号   1   2   3   4   5   6   7   8
a   42  55  79  68  15  98      
b   32  59  77  100 92  88  5   0
c   92  98  78  65  97  100 0
"""
a = [42, 55, 79, 68, 15, 98]
b = [32, 59, 77, 100, 92, 88, 5, 0]
c = [92, 98, 78, 65, 97, 100, 0]

d = [880, 880, 880, 860, 720, 720, 620, 860, 970, 950, 880, 910, 850, 870, 840, 840, 850, 840, 840, 840]
e = [880, 880, 880, 860, 720, 710, 620, 860, 970, 950, 880, 910, 850, 870, 840, 840, 850, 840, 840, 840]
print("-" * 100)

"""
箱线图

箱线图又名盒须图，是一种用作显示一组数据离散情况的统计图表，常用作多组数据的综合统计比较

四分位数：
    第一四分位数(Q1)，又称“较小四分位数”，等于该样本中所有数值由小到大排列后第25%的数字。
    第二四分位数(Q2)，又称“中位数”，等于该样本中所有数值由小到大排列后第50%的数字。
    第三四分位数(Q3)，又称“较大四分位数”，等于该样本中所有数值由小到大排列后第75%的数字。

箱线图主要包含5个统计量，从上到下，从高到低：
    最大非异常值，上边线
    Q3，箱体上边缘上四分位数
    Q2，中位数线
    Q1，箱体下边缘下四分位数
    最小非异常值，下边线
    除了上面5个统计量，上下边缘外侧可能还有异常值
    
Q3和Q1的差值，即四分位数差
    大于Q3 1.5倍四分位数差的值，或者小于Q1 1.5倍四分位数差的值，划为异常值


众数、平均数，中位数的区别

    众数：出现频率最高的数，没什么用
    平均数：对极端值非常敏感
    中位数：对极端值不敏感

"""

"""
def boxplot(self, x, notch=None, sym=None, vert=None, whis=None,
                positions=None, widths=None, patch_artist=None,
                bootstrap=None, usermedians=None, conf_intervals=None,
                meanline=None, showmeans=None, showcaps=None,
                showbox=None, showfliers=None, boxprops=None,
                labels=None, flierprops=None, medianprops=None,
                meanprops=None, capprops=None, whiskerprops=None,
                manage_ticks=True, autorange=False, zorder=None):
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

ax1_boxplot = ax1.boxplot(a)
print(type(ax1_boxplot))    # 输出:<class 'dict'>
print(ax1_boxplot)
"""
输出
{
    'whiskers': [<matplotlib.lines.Line2D object at 0x12130f580>, <matplotlib.lines.Line2D object at 0x12130f8e0>], 
    'caps': [<matplotlib.lines.Line2D object at 0x12130fc40>, <matplotlib.lines.Line2D object at 0x12130ffa0>], 
    'boxes': [<matplotlib.lines.Line2D object at 0x12130f220>], 
    'medians': [<matplotlib.lines.Line2D object at 0x12131f340>], 
    'fliers': [<matplotlib.lines.Line2D object at 0x12131f640>], 
    'means': []
}

"""
whiskers = ax1_boxplot['whiskers']
print(type(whiskers))    # 输出:<class 'list'>
print(len(whiskers))     # 输出:2
print(whiskers)          # 输出:[<matplotlib.lines.Line2D object at 0x122831580>, <matplotlib.lines.Line2D object at 0x1228318e0>]

whiskers_0 = whiskers[0]
print(type(whiskers_0))       # 输出:<class 'matplotlib.lines.Line2D'>
print(whiskers_0)             # 输出:Line2D(_line1)


ax2_boxplot = ax2.boxplot(
    x=(d, e)
)
fliers = ax2_boxplot['fliers']
print(type(fliers))         # 输出:<class 'list'>
print(fliers)               # 输出:[<matplotlib.lines.Line2D object at 0x12866afa0>, <matplotlib.lines.Line2D object at 0x1286817c0>]

for i in range(len(fliers)):
    print("第" + str(i) + "各数据")
    x = fliers[i].get_xdata()
    print(x)
    y = fliers[i].get_ydata()
    print(y)

    # #使用annotate添加注释，xy表示标注点坐标, xytext表示注释坐标
    for j in range(len(x)):
        ax2.annotate(y[j], xy=(x[j], y[j]), xytext=(x[j]+0.08, y[j]))

"""
第0各数据
[1. 1. 1. 1. 1.]
[720 720 620 970 950]
第1各数据
[2. 2. 2. 2. 2.]
[720 710 620 970 950]
"""


ax3.boxplot(
    (a, c, b),
    labels=('a', 'c', 'b'),     # 标签

    showfliers=True,            # 是否显示异常值，默认显示
    whis=1.5,                   # 指定异常值参数：默认1.5倍四分位差
    showmeans=True,             # 是否显示平均值，默认不显示
    meanline=True,              # 是否用线标示平均值，默认用点

    widths=0.5,                 # 柱子宽度

    # vert = False,             # 默认True纵向，False横向
    patch_artist=True,          # 是否填充颜色
    boxprops={'facecolor': '#ffff00', 'color': 'green'},    # 箱体样式
)

plt.show()


