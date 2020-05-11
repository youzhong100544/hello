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

# 设置网格线
# ax2.grid(True)
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
ax4.legend()    # 显示 label 标签

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
'''
def text(x,y,string,fontsize=15,verticalalignment="top",horizontalalignment="right"):

x,y:表示坐标值上的值
string:表示说明文字
fontsize:表示字体大小
verticalalignment：垂直对齐方式 ，参数：[ ‘center’ | ‘top’ | ‘bottom’ | ‘baseline’ ]
horizontalalignment：水平对齐方式 ，参数：[ ‘center’ | ‘right’ | ‘left’ ]
'''
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


'''
def barh(self, y, width, height=0.8, left=None, *, align="center", **kwargs):
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

region = ["北京", "上海", "长春", "天津", "南京", "深圳"]
price = [4313, 1222, 3424, 2234, 3334, 2934]
ax1_barh = ax1.barh(region, price, height=0.3)
ax1_barh[-1].set_color('green')
ax1_barh[-4].set_color('r')
# 给条形图添加数据标注
'''
def text(self, x, y, s, fontdict=None, withdash=False, **kwargs):
'''
for y, x in enumerate(price):
    ax1.text(x+5, y-0.1, "%s" %x)

plt.show()


'''
散点图
'''
'''
def scatter(x, y, s=None, c=None, marker=None, cmap=None, norm=None,
        vmin=None, vmax=None, alpha=None, linewidths=None, verts=None,
        edgecolors=None, *, data=None, **kwargs):
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

ax1.scatter(a, b)

# python 散点图上给每个点打标签方便看到数据
'''
def annotate(self, s, xy, *args, **kwargs):
'''
'''
python中'zip' is not subscriptable
原因就是在Python3中，zip()返回值变了，Python2中zip()返回一个元组列表，但是Python3中返回一个迭代器，所以需要list(zip())返回一个列表。
'''
ax2.set_title('标题 9-2')     # 设置图体,plt.title
ax2.set_xlabel('x-label-a')    # 设置x轴名称,plt.xlabel
ax2.set_ylabel('y-label-b')    # 设置y轴名称,plt.ylabel
ax2.scatter(a, b)

zip_np = zip(a.tolist(), b.tolist())
print(zip_np)
print(type(zip_np))
txt = list(zip_np)
print(txt)
print(type(txt))
'''
def annotate(self, s, xy, *args, **kwargs):
s 为注释文本内容 
xy 为被注释的坐标点
xytext 为注释文字的坐标位置
'''
for i in range(len(a)):
    # 这里xy是需要标记的坐标，xytext是对应的标签坐标
    ax2.annotate(txt[i], xy=(a[i], b[i]), xytext=(a[i]+0.1, b[i]+0.1))


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
