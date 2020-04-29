# -*- coding: utf-8 -*-

import numpy as np

print("numpy version: {}".format(np.__version__))
print()

print()
print()
print("#" * 150)
print("# random.random_sample()")
print("# ")
print("#" * 150)
print("# 数字区间：[0,1)")
print("# 分布：连续均匀分布")
print("# 形状：size")
print("#" * 150)
print("# 注意：ranf、random、sample、random_sample 都是使用的random_sample方法，要想得到a到b之间的随机数，使用  (b - a) * random_sample() + a")
print("#" * 150)

print()
print("# 1.1、" + "-"*100)
print("# 无参")
a = np.random.random_sample()
print(a)                            # 输出:0.0.9194337482330686
print(type(a))                      # 输出:<class 'float'>


print()
print("# 1.2、" + "-"*100)
print("# 一个参数")
a = np.random.random_sample(5)
print(a)                            # 输出:[0.36493237 0.71272472 0.19953047 0.546822   0.4100222 ]
print(type(a))                      # 输出:<class 'numpy.ndarray'>


print()
print("# 1.3、" + "-"*100)
print("# 必须以元组形式指定size：")
# a = np.random.random_sample(2, 3)   # TypeError: random_sample() takes at most 1 positional argument (2 given)
a = np.random.random_sample((2, 3))
print(a)
# 输出:
'''
[[0.16593524 0.72060495 0.02479002]
 [0.26713841 0.19652155 0.04393423]]
'''
print(type(a))                      # 输出:<class 'numpy.ndarray'>
