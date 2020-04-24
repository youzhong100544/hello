# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd
import matplotlib as mp
# import matplotlib.pyplot as plt
from matplotlib import pyplot as plt

import matplotlib.pylab as plb
# from matplotlib import pylab as plb

import seaborn as sns

print("numpy version: {}".format(np.__version__))
print("pandas version: {}".format(pd.__version__))
print("matplotlib version: {}".format(mp.__version__))

ls_a = {"A": [1, 1, 2, 2, 2, 3], "B": [2, 5, 8, 7, 9, 4], "C": [3, 6, 9, 9, 9, 9]}
df = pd.DataFrame(ls_a)

fig,ax=plt.subplots()
# Gaussian=np.random.normal(0,1,1000) #创建一组平均数为0，标准差为1，总个数为1000的符合标准正态分布的数据
ax.hist(df["A"],bins=25,histtype="stepfilled",normed=True,alpha=0.6)
sns.kdeplot(df["A"],shade=True)
plt.show()

fig, ax=plt.subplots()
for dsf in df.columns:
    ax.hist(df[dsf],bins=25,histtype="stepfilled",normed=True,alpha=0.6)
    sns.kdeplot(df[dsf],shade=True)
    # plt.show()

plt.show()

# 保存图片
# plt.savefig("1212")
