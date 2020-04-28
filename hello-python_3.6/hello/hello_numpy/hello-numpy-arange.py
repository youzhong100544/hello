# -*- coding: utf-8 -*-

import numpy as np

print("numpy version: {}".format(np.__version__))
print()

'''
arange([start,] stop[, step,], dtype=None)
np.arange()函数返回一个有终点和起点的固定步长的排列，如[1,2,3,4,5]，起点是1，终点是5，步长为1。 
参数个数情况： np.arange()函数分为一个参数，两个参数，三个参数三种情况 
    1）一个参数时，参数值为终点，起点取默认值0，步长取默认值1。 
    2）两个参数时，第一个参数为起点，第二个参数为终点，步长取默认值1。 
    3）三个参数时，第一个参数为起点，第二个参数为终点，第三个参数为步长。其中步长支持小数。
'''

print()
print()
print("#" * 150)
print("# arange([start,] stop[, step,], dtype=None)")
print("#" * 150)

a: np.ndarray = np.arange(3)
print(a)                            # 输出：[0 1 2]
print(type(a))                      # 输出：<class 'numpy.ndarray'>

b = np.arange(3, 6)
print(b)                            # 输出：[3 4 5]
print(type(b))                      # 输出：<class 'numpy.ndarray'>

c = np.arange(3, 10, 3)
print(c)                            # 输出：[3 6 9]
print(type(c))                      # 输出：<class 'numpy.ndarray'>
print('dtype:', c.dtype)            # 输出:dtype: int64
print('dtype.name:', c.dtype.name)  # 输出:dtype.name: int64

d = np.arange(3, 4, 0.3)
print(d)                            # 输出：[3.  3.3 3.6 3.9]
print(type(d))                      # 输出：<class 'numpy.ndarray'>
print('dtype:', d.dtype)            # 输出:dtype: float64
print('dtype.name:', d.dtype.name)  # 输出:dtype.name: float64


print()
print()
print("#" * 150)
print("# 1、")
print("#" * 150)