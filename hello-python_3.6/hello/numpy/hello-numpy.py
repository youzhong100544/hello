# -*- coding: utf-8 -*-

import numpy


# NumPy Ndarray 对象
a = numpy.array([1, 2, 3])
print(a)

print('shape:', a.shape)
print('shape:', numpy.shape(a))

print('size:', a.size)
print('size:', numpy.size(a))

print('dtype:', a.dtype)
print('dtype:', numpy.dtype(a))



b = numpy.array([[1, 2, 3], [4, 5, 6]], dtype=int)
print(b)

print('shape:', b.shape)
print('shape:', numpy.shape(b))
print('shape:', numpy.shape(b, 0))
print('shape:', numpy.shape(b, 1))

print('size:', b.size)
print('size:', numpy.size(b))
print('size:', numpy.size(b, 0))
print('size:', numpy.size(b, 1))

print('dtype:', b.dtype)
print('dtype:', numpy.dtype(b))
print('dtype:', numpy.dtype(b, 0))
print('dtype:', numpy.dtype(b, 0))


a = numpy.arange(10).reshape(2, 5) # 创建2行5列的二维数组，
# 也可以创建三维数组，
# a = np.arange(12).reshape(2,3,2)
print(a)


a = numpy.random.random(6)
print(a)

