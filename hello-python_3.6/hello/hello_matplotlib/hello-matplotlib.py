# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd

import matplotlib as mp

# import matplotlib.pyplot as plt
from matplotlib import pyplot as plt

import matplotlib.pylab as plb
# from matplotlib import pylab as plb

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

