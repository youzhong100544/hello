# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd

import matplotlib as mp

# import matplotlib.pyplot as plt
from matplotlib import pyplot as plt

import matplotlib.pylab as plb
# from matplotlib import pylab as plb

from matplotlib.ticker import MultipleLocator

import seaborn as sb

import sklearn
from sklearn import datasets

print("numpy version: {}".format(np.__version__))
print("pandas version: {}".format(pd.__version__))
print("matplotlib version: {}".format(mp.__version__))
print("seaborn version: {}".format(sb.__version__))
print("sklearn version: {}".format(sklearn.__version__))

pd.set_option('expand_frame_repr', False)
pd.set_option('display.max_columns', None)
pd.set_option('display.max_rows', None)
pd.set_option('max_colwidth', 10240)
pd.set_option('display.width', 1024)
pd.set_option('display.unicode.ambiguous_as_wide', True)
pd.set_option('display.unicode.east_asian_width', True)


''' 记载数据 - 波士顿房价数据 '''
print("记载数据 - 波士顿房价数据")
boston = datasets.load_boston()
X = boston.data
y = boston.target

feature_names = boston.feature_names

''' 合并数据 '''
print("合并数据")
feature_names_list = feature_names.tolist()
label = ["label"]
feature = label + feature_names_list

df_data = np.append(y.reshape((y.shape[0], 1)), X, axis=1)
data_frame = pd.DataFrame(data=df_data, columns=feature)

''' 查看数据及信息 '''
print("查看数据及信息")
print(data_frame.head(5))
print()
print(data_frame.info())
print()
print(data_frame.describe())
print()


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
ax1 = fig.add_subplot(2, 1, 1)   # 通过fig添加子图，参数：行数，列数，第几个。
ax2 = fig.add_subplot(2, 1, 2)   # 通过fig添加子图，参数：行数，列数，第几个。
print(fig, ax1, ax2)

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
ax1.yaxis.grid(True, which='major')      # x坐标轴的网格使用定义的主刻度格式

ax1.set_xticks([])     # 去除坐标轴刻度
ax1.set_xticks((-5, -3, -1, 1, 3, 5))  # 设置坐标轴刻度
ax1.set_xticklabels(labels=['x1', 'x2', 'x3', 'x4', 'x5'], rotation=-30, fontsize='small')  # 设置刻度的显示文本，rotation旋转角度，fontsize字体大小

plot1 = ax1.plot(x, y, marker='o', color='g', label='legend1')   # 点图：marker图标
plot2 = ax1.plot(x, y, linestyle='--', alpha=0.5, color='r', label='legend2')   # 线图：linestyle线性，alpha透明度，color颜色，label图例文本

plt.show()


fig = plt.figure()               # 开启一个窗口，同时设置大小，分辨率
ax1 = fig.add_subplot(2, 2, 1)   # 通过fig添加子图，参数：行数，列数，第几个。
ax2 = fig.add_subplot(2, 2, 2)   # 通过fig添加子图，参数：行数，列数，第几个。
ax3 = fig.add_subplot(2, 2, 3)   # 通过fig添加子图，参数：行数，列数，第几个。
ax4 = fig.add_subplot(2, 2, 4)   # 通过fig添加子图，参数：行数，列数，第几个。
print(fig, ax1, ax2, ax3, ax4)
plt.show()


fig = plt.figure(num=1, figsize=(15, 8), dpi=80)    # 开启一个窗口，同时设置大小，分辨率
ax1 = fig.add_subplot(2, 1, 1)                      # 通过fig添加子图，参数：行数，列数，第几个。
ax2 = fig.add_subplot(2, 1, 2)                      # 通过fig添加子图，参数：行数，列数，第几个。
print(fig, ax1, ax2)
plt.show()

'''方法2：一次性创建窗口和多个子图。（空白不绘制）'''
'''
def subplots(nrows=1, ncols=1, sharex=False, sharey=False, squeeze=True, subplot_kw=None, gridspec_kw=None, **fig_kw):
nrows: subplot 的行数
ncols: subplot 的列数
sharex: 所有 subplot 应该使用相同的 X 轴刻度（调节xlim将会影响所有subplot）
sharey: 所有 subplot 应该使用相同的 Y 轴刻度（调节ylim将会影响所有subplot）
subplot_kw: 用于创建各 subplot 的关键字字典
**fig_kw: 创建 figure 时的其他关键字，如plt.subplot(2, 2, figsize=(15, 8))

subplot可以规划figure划分为n个子图，但每条subplot命令只会创建一个子图 ，
'''

'''
fig, ax = plt.subplots()等价于：
    1、fig = plt.figure()
    2、ax = fig.add_subplot(1,1,1)
'''
fig, ax = plt.subplots(4, 1)     # 开一个新窗口，并添加4个子图，返回子图数组
ax1 = ax[0]                      # 通过子图数组获取一个子图
print(fig, ax1)
plt.show()

'''方法3：一次性创建窗口和一个子图。（空白不绘制）'''
ax1 = plt.subplot(1, 1, 1, facecolor='white')   # 开一个新窗口，创建1个子图。facecolor 设置背景颜色
print(ax1)
plt.show()

# 获取对窗口的引用，适用于上面三种方法
# fig = plt.gcf()   # 获得当前figure
# fig=ax1.figure    # 获得指定子图所属窗口

# fig.subplots_adjust(left=0)                         #设置窗口左内边距为0，即左边留白为0。


'''
ls_a = {"A": [1, 1, 2, 2, 2, 3], "B": [2, 5, 8, 7, 9, 4], "C": [3, 6, 9, 9, 9, 9]}
df = pd.DataFrame(ls_a)

fig, ax = plt.subplots()
# Gaussian=np.random.normal(0,1,1000) #创建一组平均数为0，标准差为1，总个数为1000的符合标准正态分布的数据
ax.hist(df["A"], bins=25, histtype="stepfilled", normed=True, alpha=0.6)
sb.kdeplot(df["A"], shade=True)
plt.show()

fig, ax = plt.subplots()
for dsf in df.columns:
    ax.hist(df[dsf], bins=25, histtype="stepfilled", normed=True, alpha=0.6)
    sb.kdeplot(df[dsf], shade=True)
    # plt.show()

plt.show()

# 保存图片
# plt.savefig("1212")
'''

