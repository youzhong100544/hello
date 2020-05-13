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
推荐博文
	seaborn 常见绘图总结
	https://blog.csdn.net/qq_40195360/article/details/86605860
"""

"""
seaborn 装载了一些默认主题风格，通过 sns.set() 方法实现。
sns.set()可以设置5种风格的图表背景：darkgrid, whitegrid, dark, white, ticks，通过参数style设置，默认情况下为 darkgrid 风格：
"""
sns.set(style="darkgrid")

"""
加载内置数据

解决超市问题
	1、下载数据
		https://github.com/mwaskom/seaborn-data
		
	2、把下载好的数据放到用户的家目录下
"""
data_anscombe = sns.load_dataset('anscombe')
data_anscombe = sns.load_dataset('anscombe')
data_attention = sns.load_dataset('attention')
data_brain_networks = sns.load_dataset('brain_networks')
data_car_crashes = sns.load_dataset('car_crashes')
data_diamonds = sns.load_dataset('diamonds')

data_dots = sns.load_dataset('dots')
data_exercise = sns.load_dataset('exercise')
data_flights = sns.load_dataset('flights')
data_fmri = sns.load_dataset('fmri')
data_gammas = sns.load_dataset('gammas')

data_iris = sns.load_dataset('iris')
data_mpg = sns.load_dataset('mpg')
data_planets = sns.load_dataset('planets')

"""
tips 数据集

total_bill: 总账单
tip: 小费
sex: 性别;2种取值(Female 和 Female)
smoker: 是否抽烟;2种取值(Yes 和 No)
day: 日期;4种取值(Thur、Fri、Sat、Sun)
time: 2种取值(Dinner 和 Lunch)
size: 人数
"""
data_tips = sns.load_dataset('tips')

"""
titanic 数据集

"""
data_titanic = sns.load_dataset('titanic')

"""
打印数据信息
"""
print(data_anscombe)
print(type(data_anscombe))		# 输出:<class 'pandas.core.frame.DataFrame'>
