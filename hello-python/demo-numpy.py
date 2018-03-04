# -*- coding: utf-8 -*-

import numpy

# python 内置函数
a = [i for i in range(0,10)]
print(a)


# numpy 函数
# 创建数组并查看其属性
a = numpy.array([[1,2,3], [4, 5, 6]], dtype=int)
print(a)

print(a.shape)
print(a.size)
print(a.dtype)

a = numpy.arange(10).reshape(2, 5) # 创建2行5列的二维数组，
# 也可以创建三维数组，
# a = np.arange(12).reshape(2,3,2)
print(a)


a = numpy.random.random(6)
print(a)

numpy.ones()
