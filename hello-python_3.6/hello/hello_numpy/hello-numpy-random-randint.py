# -*- coding: utf-8 -*-

import numpy as np

print("numpy version: {}".format(np.__version__))
print()

print()
print()
print("#" * 150)
print("# 1、random.randint()")
print("# numpy.random.randint(low, high=None, size=None, dtype='l'):")
print("# Return random integers from `low` (inclusive) to `high` (exclusive).")
print("# 生成一个整数或N维整数数组，取数范围：若high不为None时，取[low,high)之间随机整数，否则取值[0,low)之间随机整数。")
print("#" * 150)
print("# 数字区间：[low,high)")
print("# 分布：离散均匀分布")
print("# 形状：size")
print("#" * 150)

print()
print("# 1.1、产生随机数" + "-"*100)
print("# low=10 生成一个[0,10)之间随机整数")
a = np.random.randint(10)
print(a)                            # 输出:3
print(type(a))                      # 输出:<class 'int'>

print()
print("# 1.2、在区间产生随机数" + "-"*100)
print("# low=2, high=10 生成一个[2,10)之间随机整数")
# a = np.random.randint(2, 2) # 报错,high必须大于low
a = np.random.randint(2, 10)
print(a)                            # 输出:5
print(type(a))                      # 输出:<class 'int'>

print()
print("# 1.3、" + "-"*100)
print("# low=2,size=5 生成一个[0,2)之间随机整数的长度为5的一维数组")
a = np.random.randint(2, size=5)
print(a)                            # 输出:[0 1 1 1 1]
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 1.4、" + "-"*100)
print("# low=2,high=6,size=5 生成一个[0,6)之间随机整数的长度为5的一维数组")
a = np.random.randint(2, 6, size=5)
print(a)                            # 输出:[5 2 3 3 3]
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 1.5、" + "-"*100)
print("# low=2,size=(2, 3) 生成一个[0,2)之间随机整数的维度为2X3的二维维数组")
a = np.random.randint(2, size=(2, 3))
print(a)
# 输出:
'''
[[1 1 1]
 [0 0 0]]
'''
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 1.6、" + "-"*100)
print("# low=2,high=6,size=(3, 3) 生成一个[2,6)之间随机整数的维度为3X3的二维维数组")
a = np.random.randint(2, 6, size=(3, 3))
print(a)
# 输出:
'''
[[2 5 5]
 [5 3 2]
 [5 4 4]]
'''
print(type(a))                      # 输出:<class 'numpy.ndarray'>



