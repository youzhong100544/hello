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
# plt.rcParams['font.sans-serif'] = ['SimHei']
# plt.rcParams['font.family'] = 'sans-serif'
# 用来正常显示负号
# plt.rcParams['axes.unicode_minus'] = False

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


num = None,               # 设定figure名称。系统默认按数字升序命名的figure_num（透视表输出窗口）e.g. “figure1”。可自行设定figure名称，名称或是INT，或是str类型；
figsize=None,             # 设定figure尺寸。系统默认命令是rcParams["figure.fig.size"] = [6.4, 4.8]，即figure长宽为6.4 * 4.8；
dpi=None,                 # 设定figure像素密度。系统默命令是rcParams["sigure.dpi"] = 100；
facecolor=None,           # 设定figure背景色。系统默认命令是rcParams["figure.facecolor"] = 'w'，即白色white；
edgecolor=None, frameon=True,    # 设定要不要绘制轮廓&轮廓颜色。系统默认绘制轮廓，轮廓染色rcParams["figure.edgecolor"]='w',即白色white；
FigureClass=<class 'matplotlib.figure.Figure'>,   # 设定使不使用一个figure模板。系统默认不使用；
clear=False,                     # 设定当同名figure存在时，是否替换它。系统默认False，即不替换。

'''

'''
折线图
'''
fig = plt.figure(figsize=(15, 10))               # 开启一个窗口，同时设置大小，分辨率
ax1 = fig.add_subplot(2, 2, 1)   # 通过fig添加子图，参数：行数，列数，第几个。
ax2 = fig.add_subplot(2, 2, 2)   # 通过fig添加子图，参数：行数，列数，第几个。
ax3 = fig.add_subplot(2, 2, 3)   # 通过fig添加子图，参数：行数，列数，第几个。
ax4 = fig.add_subplot(2, 2, 4)   # 通过fig添加子图，参数：行数，列数，第几个。

ax1.plot(A, A)
ax2.plot(A, B)
ax3.plot(A, C, marker='o', linestyle='--')

ax4.plot(A, A,
        color='#3589FF',        # 线的颜色
        linestyle=':',          # 线的风格
        linewidth=3,            # 线的宽度
        marker='.',             # 标记点的样式
        markerfacecolor='r',    # 标记点的颜色
        markersize=10,          # 标记点的大小
        alpha=0.7,              # 图形的透明度 
        label="y = x")
ax4.plot(A, B, label="y = x**2")
ax4.plot(A, C, label="y = x**3")

# plt.legend()    # 显示 label 标签
# plt.show()


'''
条状图
'''
'''
def bar(self, x, height, width=0.8, bottom=None, *, align="center", **kwargs):
'''
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
ax3.bar(a, c, width=0.8)

ax4.bar(x=c, height=c, width=0.8)
ax5.bar(x=c, height=a, width=0.8)

index = np.arange(30)

ax7.bar(x=index, height=c, width=0.8)
ax7.bar(x=index+0.8, height=a, width=0.8)

bar_width = 0.3
ax8.bar(x=index, height=c, width=bar_width, label='c')
ax8.bar(x=index + bar_width, height=a, width=bar_width, label='a')

ax9.set_xticks(index.tolist())
ax9.bar(x=index, height=c, width=bar_width, label='c')
ax9.bar(x=index - bar_width, height=a, width=bar_width, label='a')

plt.legend()
plt.show()



