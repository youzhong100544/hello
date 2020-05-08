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
# plt.rcParams['font.sans-serif'] = ['SimHei']
# plt.rcParams['font.family'] = 'sans-serif'
# 用来正常显示负号
# plt.rcParams['axes.unicode_minus'] = False

# 使用numpy产生数据
x = np.arange(-5, 5, 0.1)
y = x*3
print(x)
print(y)

A = np.arange(-4, 5)
B = A**2
C = A**3
print(A)
print(B)
print(C)



'''
在绘图结构中，figure创建窗口，subplot创建子图。
所有的绘画只能在子图上进行。
plt表示当前子图，若没有就创建一个子图。
所有你会看到一些教程中使用plt进行设置，一些教程使用子图属性进行设置。
他们往往存在对应功能函数。
'''


''' 创建窗口、子图 '''
''' 方法1：先创建窗口，再创建子图。（一定绘制）'''
'''
def figure(num=None,  # autoincrement if None, else integer from 1-N
           figsize=None,  # defaults to rc figure.figsize
           dpi=None,  # defaults to rc figure.dpi
           facecolor=None,  # defaults to rc figure.facecolor
           edgecolor=None,  # defaults to rc figure.edgecolor
           frameon=True,
           FigureClass=Figure,
           clear=False,
           **kwargs
           ):

num: 图像编号或名称，数字为编号 ，字符串为名称
figsize: 指定 figure 的宽和高，单位为英寸；
dpi: 参数指定绘图对象的分辨率，即每英寸多少个像素，缺省值为80      1英寸等于2.5cm,A4纸是 21*30cm的纸张 
facecolor:背景颜色
edgecolor:边框颜色
frameon:是否显示边框
'''

fig = plt.figure()               # 开启一个窗口，同时设置大小，分辨率
ax1 = fig.add_subplot(4, 1, 1)   # 通过fig添加子图，参数：行数，列数，第几个。
ax2 = fig.add_subplot(4, 1, 2)   # 通过fig添加子图，参数：行数，列数，第几个。
ax3 = fig.add_subplot(4, 1, 3)   # 通过fig添加子图，参数：行数，列数，第几个。
ax4 = fig.add_subplot(4, 1, 4)   # 通过fig添加子图，参数：行数，列数，第几个。
print(fig, ax1, ax2, ax3, ax4)

ax1.plot(A, B)

ax2.set_title('title 4-3')          # 标题
ax2.set_xlabel('xlabel')            # 设置x轴名称
ax2.set_ylabel('ylabel')            # 设置y轴名称
ax2.plot(A, B)


ax3.spines['bottom'].set_position(('data', 0))  # 下边线位置放到数值为0的位置
ax3.spines['left'].set_position(('data', 0))    # 左边线位置放到数值为0的位置

ax3.set_xticks(np.arange(-6, 6, 0.5).tolist())
ax3.set_yticks(np.arange(-50, 60, 10).tolist())

ax3.plot(A, C, color='b')


# 去掉边框
ax4.spines['top'].set_visible(False)
ax4.spines['right'].set_visible(False)
# 设置极轴的位置
ax4.spines['bottom'].set_position('zero')       # 左边线位置放到数值为0的位置
ax4.spines['left'].set_position('zero')         # 左边线位置放到数值为0的位置

# 设置坐标轴刻度、文本
# xmajorLocator = MultipleLocator(20)             # 将x主刻度标签设置为20的倍数
# xmajorFormatter = FormatStrFormatter('%1.1f')   # 设置x轴标签文本的格式
# xminorLocator = MultipleLocator(5)              # 将x轴次刻度标签设置为5的倍数
ymajorLocator = MultipleLocator(10)            # 将y轴主刻度标签设置为0.5的倍数
# ymajorFormatter = FormatStrFormatter('%1.1f')   # 设置y轴标签文本的格式
yminorLocator = MultipleLocator(5)            # 将此y轴次刻度标签设置为0.1的倍数

# 设置主刻度标签的位置,标签文本的格式
# ax4.xaxis.set_major_locator(xmajorLocator)
# ax4.xaxis.set_major_formatter(xmajorFormatter)
ax4.yaxis.set_major_locator(ymajorLocator)
# ax4.yaxis.set_major_formatter(ymajorFormatter)

# 显示次刻度标签的位置,没有标签文本
# ax4.xaxis.set_minor_locator(xminorLocator)
ax4.yaxis.set_minor_locator(yminorLocator)

# 网格使用刻度
# ax4.xaxis.grid(True, which='major')     # x坐标轴的网格使用主刻度
# ax4.yaxis.grid(True, which='minor')     # y坐标轴的网格使用次刻度

# 线图：linestyle 线性, alpha透明度, color颜色, label图例文本
ax4.plot(A, A, marker='.', linestyle='--', alpha=0.5, color='r', label='A-A')
ax4.plot(A, B, label='A-B')
ax4.plot(A, C, label='A-C')

plt.show()



fig = plt.figure()               # 开启一个窗口，同时设置大小，分辨率
ax1 = fig.add_subplot(2, 3, 1)   # 通过fig添加子图，参数：行数，列数，第几个。
ax2 = fig.add_subplot(2, 3, 2)   # 通过fig添加子图，参数：行数，列数，第几个。
ax3 = fig.add_subplot(2, 3, 3)   # 通过fig添加子图，参数：行数，列数，第几个。
ax4 = fig.add_subplot(2, 3, 4)   # 通过fig添加子图，参数：行数，列数，第几个。
ax5 = fig.add_subplot(2, 3, 5)   # 通过fig添加子图，参数：行数，列数，第几个。
ax6 = fig.add_subplot(2, 3, 6)   # 通过fig添加子图，参数：行数，列数，第几个。

# 设置子图的基本元素
ax1.set_title('python-drawing')     # 设置图体,plt.title

ax1.set_xlabel('x-name')            # 设置x轴名称,plt.xlabel
ax1.set_ylabel('y-name')            # 设置y轴名称,plt.ylabel

plt.axis([-6, 6, -10, 10])          # 设置横纵坐标轴范围，这个在子图中被分解为下面两个函数
ax1.set_xlim(-5, 5)                 # 设置横轴范围，会覆盖上面的横坐标,plt.xlim
ax1.set_ylim(-10, 10)               # 设置纵轴范围，会覆盖上面的纵坐标,plt.ylim

xmajorLocator = MultipleLocator(2)   # 定义横向主刻度标签的刻度差为2的倍数。就是隔几个刻度才显示一个标签文本
ymajorLocator = MultipleLocator(3)   # 定义纵向主刻度标签的刻度差为3的倍数。就是隔几个刻度才显示一个标签文本

ax1.xaxis.set_major_locator(xmajorLocator)  # x轴 应用定义的横向主刻度格式。如果不应用将采用默认刻度格式
ax1.yaxis.set_major_locator(ymajorLocator)  # y轴 应用定义的纵向主刻度格式。如果不应用将采用默认刻度格式

ax1.xaxis.grid(True, which='major')      # x坐标轴的网格使用定义的主刻度格式
ax1.yaxis.grid(True, which='major')      # y坐标轴的网格使用定义的主刻度格式

ax1.set_xticks([])     # 去除坐标轴刻度
ax1.set_xticks((-5, -3, -1, 1, 3, 5))  # 设置坐标轴刻度
# ax1.set_xticklabels(labels=['x1', 'x2', 'x3', 'x4', 'x5'], rotation=-30, fontsize='small')  # 设置刻度的显示文本，rotation旋转角度，fontsize字体大小

plot1 = ax1.plot(x, y, marker='o', color='g', label='legend1')   # 点图:marker图标

plot2 = ax2.plot(x, y, linestyle='--', alpha=0.5, color='r', label='legend2')   # 线图:linestyle线性，alpha透明度，color颜色，label图例文本

plt.show()


fig = plt.figure(num=1, figsize=(15, 8), dpi=80)    # 开启一个窗口，同时设置大小，分辨率
ax1 = fig.add_subplot(2, 1, 1)                      # 通过fig添加子图，参数：行数，列数，第几个。
ax2 = fig.add_subplot(2, 1, 2)                      # 通过fig添加子图，参数：行数，列数，第几个。
print(fig, ax1, ax2)
plt.show()

