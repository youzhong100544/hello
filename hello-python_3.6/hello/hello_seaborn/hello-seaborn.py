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
seaborn 装载了一些默认主题风格，通过 sns.set() 方法实现。
sns.set()可以设置5种风格的图表背景：darkgrid, whitegrid, dark, white, ticks，通过参数style设置，默认情况下为 darkgrid 风格：
"""
sns.set(style="darkgrid")

"""
加载内置数据
"""
# data_anscombe = sns.load_dataset('../../dataset/seaborn-data/anscombe.csv')
data_anscombe = sns.load_dataset('anscombe.csv')

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
data_tips = sns.load_dataset('tips')
data_titanic = sns.load_dataset('titanic')

"""
打印数据信息
"""
print(data_titanic)
print(type(data_titanic))
