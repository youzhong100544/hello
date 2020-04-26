# -*- coding: utf-8 -*-

import numpy as np

print("numpy version: {}".format(np.__version__))

# NumPy Ndarray 对象
a: np.ndarray = np.array([1, 2, 3])
print(a) # 输出：[1 2 3]
print(type(a)) # 输出：<class 'numpy.ndarray'>

print('shape:', a.shape)
print('shape:', np.shape(a))

print('size:', a.size)
print('size:', np.size(a))

print('dtype:', a.dtype)
# print('dtype:', numpy.dtype(a))

print()
print("-" * 100)
print()

b = np.array([[1, 2, 3], [4, 5, 6]], dtype=int)
print(b)
print(type(b)) # 输出：<class 'numpy.ndarray'>

print('shape:', b.shape)
print('shape:', np.shape(b))
# print('shape:', numpy.shape(b, 0))
# print('shape:', numpy.shape(b, 1))

print('size:', b.size)
print('size:', np.size(b))
print('size:', np.size(b, 0))
print('size:', np.size(b, 1))

print('dtype:', b.dtype)
# print('dtype:', numpy.dtype(b))
# print('dtype:', numpy.dtype(b, 0))
# print('dtype:', numpy.dtype(b, 0))

print()
print("|" * 100)
print()

a = np.arange(10).reshape(2, 5) # 创建2行5列的二维数组，
# 也可以创建三维数组，
# a = np.arange(12).reshape(2,3,2)
print(a)

print()
print("|" * 100)
print()


a = np.random.random(6)
print(a)

print()
print("|" * 100)
print()


"""
def randint(low, high=None, size=None, dtype='l'):

从[low, high)中随机生成整数。若 high=None， 则从[0,low)生成

参数如下：
    low: int
        生成的数值最低要大于等于low。
        （hign = None时，生成的数值要在[0, low)区间内）
        
    high: int (可选)
        如果使用这个值，则生成的数值在[low, high)区间。
        
    size: int or tuple of ints(可选)
        输出随机数的尺寸，比如size = (m * n* k)则输出同规模即m * n* k个随机数。默认是None的，仅仅返回满足要求的单一随机数。
        
    dtype: dtype(可选)：
        想要输出的格式。如int64、int等等
"""
a = np.random.randint(4)
print(a)
# 输出：3
print("-" * 100)

a = np.random.randint(low=4)
print(a)
# 输出：3
print("-" * 100)


# a = np.random.randint(high=4) # 会报错
# print("-" * 100)
"""
Traceback (most recent call last):
File "C:/develop/workspace/github/hello/hello-python_3.6/hello/hello_numpy/hello-numpy.py", line 83, in <module>
a = np.random.randint(high=4)
File "mtrand.pyx", line 641, in numpy.random.mtrand.RandomState.randint
TypeError: randint() takes at least 1 positional argument (0 given)
"""

a = np.random.randint(0, 10)
print(a)
# 输出：5
print("-" * 100)

a = np.random.randint(0, 10, 3)
print(a)
# 输出：[5 2 6]
print("-" * 100)

a = np.random.randint(0, 10, [3, 2])
print(a)
# 输出：
#  [[2 1]
#  [6 3]
#  [1 5]]
print("-" * 100)

a = np.random.randint(0, 10, [3, 2, 3])
print(a)
# 输出：
# [[[2 8 8]
#   [6 2 7]]
#
#  [[0 0 2]
#   [4 6 1]]
#
#  [[7 9 2]
#   [7 8 4]]]
print("-" * 100)
