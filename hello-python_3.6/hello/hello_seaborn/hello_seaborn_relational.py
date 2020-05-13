# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd
import matplotlib as mpl

import matplotlib.pyplot as plt
# from matplotlib import pyplot as plt

# import matplotlib.pylab as plb
from matplotlib import pylab as plb

import seaborn as sns

import sklearn
from sklearn import datasets

print("numpy version: {}".format(np.__version__))
print("pandas version: {}".format(pd.__version__))
print("matplotlib version: {}".format(mpl.__version__))
print("seaborn version: {}".format(sns.__version__))
print("sklearn version: {}".format(sklearn.__version__))

"""
1.Relational plots（关系图）
Seaborn中介绍的第一种类型的图就是Relational plots（关系图），这里翻译一下官网对他的解释：“统计分析是理解数据集中变量如何相互关联以及这些关系如何依赖于其他变量的过程。可视化可能是这个过程的核心部分，因为当数据被正确地可视化时，人类视觉系统可以看到指示某种关系的趋势和模式。”
Relational plots（关系图）中主要讨论的是三个seaborn函数。我们最常用的是relplot()。这是一个图形级函数使用两种常用方法可视化统计关系：散点图（scatter plots）和线图（line plots）。

"""


"""
1.1 scatterplot（散点图）
散点图是统计可视化的重要组成部分。它使用点云来描述两个变量的联合分布，其中每个点代表数据集中的一个观察。这种描绘可以推断出大量关于它们之间是否有任何有意义的关系的信息。
在seaborn中有几种（后面介绍）绘制散点图的方法，当两个变量都是数字时，应该使用的最基本的是scatterplot()功能。在Categorical plots（分类图）中，我们将看到使用散点图可视化分类数据的专门工具。————————————————
版权声明：本文为CSDN博主「不会写作文的李华」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_40195360/java/article/details/86605860
"""


"""
1.2 lineplot（线图）
"""


"""
1.3 relplot（关系图）
"""
"""
relplot（关系图）可以看做是lineplot和scatterplot的归约，可以通过kind参数来指定画什么图形，重要参数解释如下：

kind：默认scatter（散点图），也可以选择kind=‘line’（线图）；
sizes：List、dict或tuple，可选，简单点就是图片大小，注意和size区分；
col、row：将决定网格的面数的分类变量，具体看实例；
"""

