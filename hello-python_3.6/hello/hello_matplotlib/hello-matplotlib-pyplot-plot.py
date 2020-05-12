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


"""
折线图

折线图用于显示随时间或有序类别的变化趋势

def plot(self, *args, scalex=True, scaley=True, data=None, **kwargs):

Plot y versus x as lines and/or markers.

Call signatures::

    plot([x], y, [fmt], *, data=None, **kwargs)
    plot([x], y, [fmt], [x2], y2, [fmt2], ..., **kwargs)

The coordinates of the points or line nodes are given by *x*, *y*.

The optional parameter *fmt* is a convenient way for defining basic
formatting like color, marker and linestyle. It's a shortcut string
notation described in the *Notes* section below.

>>> plot(x, y)        # plot x and y using default line style and color
>>> plot(x, y, 'bo')  # plot x and y using blue circle markers
>>> plot(y)           # plot y using x as index array 0..N-1
>>> plot(y, 'r+')     # ditto, but with red plusses

You can use `.Line2D` properties as keyword arguments for more
control on the appearance. Line properties and *fmt* can be mixed.
The following two calls yield identical results:

>>> plot(x, y, 'go--', linewidth=2, markersize=12)
>>> plot(x, y, color='green', marker='o', linestyle='dashed',
...      linewidth=2, markersize=12)

When conflicting with *fmt*, keyword arguments take precedence.


**Plotting labelled data**

There's a convenient way for plotting objects with labelled data (i.e.
data that can be accessed by index ``obj['y']``). Instead of giving
the data in *x* and *y*, you can provide the object in the *data*
parameter and just give the labels for *x* and *y*::

>>> plot('xlabel', 'ylabel', data=obj)

All indexable objects are supported. This could e.g. be a `dict`, a
`pandas.DataFame` or a structured numpy array.


**Plotting multiple sets of data**

There are various ways to plot multiple sets of data.

- The most straight forward way is just to call `plot` multiple times.
  Example:

  >>> plot(x1, y1, 'bo')
  >>> plot(x2, y2, 'go')

- Alternatively, if your data is already a 2d array, you can pass it
  directly to *x*, *y*. A separate data set will be drawn for every
  column.

  Example: an array ``a`` where the first column represents the *x*
  values and the other columns are the *y* columns::

  >>> plot(a[0], a[1:])

- The third way is to specify multiple sets of *[x]*, *y*, *[fmt]*
  groups::

  >>> plot(x1, y1, 'g^', x2, y2, 'g-')

  In this case, any additional keyword argument applies to all
  datasets. Also this syntax cannot be combined with the *data*
  parameter.

By default, each line is assigned a different style specified by a
'style cycle'. The *fmt* and line property parameters are only
necessary if you want explicit deviations from these defaults.
Alternatively, you can also change the style cycle using
:rc:`axes.prop_cycle`.


Parameters
----------
x, y : array-like or scalar
    The horizontal / vertical coordinates of the data points.
    *x* values are optional and default to `range(len(y))`.

    Commonly, these parameters are 1D arrays.

    They can also be scalars, or two-dimensional (in that case, the
    columns represent separate data sets).

    These arguments cannot be passed as keywords.

fmt : str, optional
    A format string, e.g. 'ro' for red circles. See the *Notes*
    section for a full description of the format strings.

    Format strings are just an abbreviation for quickly setting
    basic line properties. All of these and more can also be
    controlled by keyword arguments.

    This argument cannot be passed as keyword.

data : indexable object, optional
    An object with labelled data. If given, provide the label names to
    plot in *x* and *y*.

    .. note::
        Technically there's a slight ambiguity in calls where the
        second label is a valid *fmt*. `plot('n', 'o', data=obj)`
        could be `plt(x, y)` or `plt(y, fmt)`. In such cases,
        the former interpretation is chosen, but a warning is issued.
        You may suppress the warning by adding an empty format string
        `plot('n', 'o', '', data=obj)`.

Other Parameters
----------------
scalex, scaley : bool, optional, default: True
    These parameters determined if the view limits are adapted to
    the data limits. The values are passed on to `autoscale_view`.

**kwargs : `.Line2D` properties, optional
    *kwargs* are used to specify properties like a line label (for
    auto legends), linewidth, antialiasing, marker face color.
    Example::

    >>> plot([1, 2, 3], [1, 2, 3], 'go-', label='line 1', linewidth=2)
    >>> plot([1, 2, 3], [1, 4, 9], 'rs', label='line 2')

    If you make multiple lines with one plot command, the kwargs
    apply to all those lines.

    Here is a list of available `.Line2D` properties:

    %(_Line2D_docstr)s

Returns
-------
lines
    A list of `.Line2D` objects representing the plotted data.

See Also
--------
scatter : XY scatter plot with markers of varying size and/or color (
    sometimes also called bubble chart).

Notes
-----
**Format Strings**

A format string consists of a part for color, marker and line::

    fmt = '[marker][line][color]'

Each of them is optional. If not provided, the value from the style
cycle is used. Exception: If ``line`` is given, but no ``marker``,
the data will be a line without markers.

Other combinations such as ``[color][marker][line]`` are also
supported, but note that their parsing may be ambiguous.

**Markers**

=============    ===============================
character        description
=============    ===============================
``'.'``          point marker
``','``          pixel marker
``'o'``          circle marker
``'v'``          triangle_down marker
``'^'``          triangle_up marker
``'<'``          triangle_left marker
``'>'``          triangle_right marker
``'1'``          tri_down marker
``'2'``          tri_up marker
``'3'``          tri_left marker
``'4'``          tri_right marker
``'s'``          square marker
``'p'``          pentagon marker
``'*'``          star marker
``'h'``          hexagon1 marker
``'H'``          hexagon2 marker
``'+'``          plus marker
``'x'``          x marker
``'D'``          diamond marker
``'d'``          thin_diamond marker
``'|'``          vline marker
``'_'``          hline marker
=============    ===============================

**Line Styles**

=============    ===============================
character        description
=============    ===============================
``'-'``          solid line style
``'--'``         dashed line style
``'-.'``         dash-dot line style
``':'``          dotted line style
=============    ===============================

Example format strings::

    'b'    # blue markers with default shape
    'or'   # red circles
    '-g'   # green solid line
    '--'   # dashed line with default color
    '^k:'  # black triangle_up markers connected by a dotted line

**Colors**

The supported color abbreviations are the single letter codes

=============    ===============================
character        color
=============    ===============================
``'b'``          blue
``'g'``          green
``'r'``          red
``'c'``          cyan
``'m'``          magenta
``'y'``          yellow
``'k'``          black
``'w'``          white
=============    ===============================

and the ``'CN'`` colors that index into the default property cycle.

If the color is the only part of the format string, you can
additionally use any  `matplotlib.colors` spec, e.g. full names
(``'green'``) or hex strings (``'#008000'``).
"""

fig = plt.figure(figsize=(15, 15))      # 开启一个窗口，同时设置大小，分辨率
ax1 = fig.add_subplot(3, 3, 1)          # 通过fig添加子图，参数：行数，列数，第几个。
ax2 = fig.add_subplot(3, 3, 2)          # 通过fig添加子图，参数：行数，列数，第几个。
ax3 = fig.add_subplot(3, 3, 3)          # 通过fig添加子图，参数：行数，列数，第几个。
ax4 = fig.add_subplot(3, 3, 4)          # 通过fig添加子图，参数：行数，列数，第几个。
ax5 = fig.add_subplot(3, 3, 5)          # 通过fig添加子图，参数：行数，列数，第几个。
ax6 = fig.add_subplot(3, 3, 6)          # 通过fig添加子图，参数：行数，列数，第几个。

ax1.plot(A, A)


"""
color                   # 线的颜色
linestyle               # 线的风格
linewidth               # 线的宽度
marker                  # 标记点的样式
markerfacecolor         # 标记点的颜色
markersize              # 标记点的大小
alpha                   # 图形的透明度 
label                   # 标签
"""
ax2.plot(A, A, color='g', linestyle='--', linewidth=1, marker='o', markerfacecolor='r', markersize=10, alpha=0.7, label="y = x")
ax2.legend()


# 设置网格线
ax3.grid(True)
# 设置标题
ax3.set_title("标题 9-2")
# 设置x轴名称
"""
def set_xlabel(self, xlabel, fontdict=None, labelpad=None, **kwargs):
"""
ax3.set_xlabel("x-label-a")
# 设置y轴名称
ax3.set_ylabel("y-label-b")
ax3.plot(A, A)


ax4.plot(A, B, linestyle='-.', marker='o',)
for index in range(len(A)):
    ax4.text(A[index], B[index], B[index])
ax4.grid(True)


ax5.plot(A, B, linestyle='-.', marker='o',)
for index in range(len(A)):
    ax5.text(x=A[index], y=B[index], s=(A[index], B[index]))


ax6.plot(A, A, linestyle='-', marker='.', label="y = x")
ax6.plot(A, B, linestyle='--', marker='.', label="y = x**2")
ax6.plot(A, C, linestyle='-.', marker='o', label="y = x**3")
ax6.legend()    # 显示 label 标签
for index in range(len(A)):
    ax6.text(x=A[index], y=B[index], s=(A[index], B[index]))

'''
def annotate(self, s, xy, *args, **kwargs):
s 为注释文本内容 
xy 为被注释的坐标点
xytext 为注释文字的坐标位置
'''
for i in range(len(A)):
    # 这里xy是需要标记的坐标，xytext是对应的标签坐标
    ax6.annotate(s=(A[i], B[i]), xy=(A[i], B[i]), xytext=(A[i], B[i]))

for i in range(len(A)):
    # 这里xy是需要标记的坐标，xytext是对应的标签坐标
    ax6.annotate(s=(A[i], C[i]), xy=(A[i], C[i]), xytext=(A[i], C[i]))


plt.show()


