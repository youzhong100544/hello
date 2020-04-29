# -*- coding: utf-8 -*-

import numpy as np

print("numpy version: {}".format(np.__version__))
print()

'''
np.loadtxt(filepath,delimiter,usecols,unpack)

    filepath:加载文件路径
    delimiter:加载文件分隔符
    usecols:加载数据文件中列索引
    unpack:当加载多列数据时是否需要将数据列进行解耦赋值给不同的变量

'''

# iris_csv = np.loadtxt("../../dataset/iris/iris.csv", delimiter=",")
# print(iris_csv)

path = r'../../dataset/iris/iris.csv'
with open(path, encoding='utf-8') as file:
    # data = np.loadtxt(file, delimiter=",") # ValueError: could not convert string to float: 'SepalLength'

    # data = np.loadtxt(file, delimiter=",", skiprows=1) # ValueError: could not convert string to float: 'Iris-setosa'

    data = np.loadtxt(file, str, delimiter=",", skiprows=1)

    print(type(data))
    print()

    # 取第一行
    print(data[1])
    print()

    # 取第一列
    print(data[:, 1])
    print()

    # 取前5行
    print(data[:5])
    print()

    # 取第0、2、3列数据
    print(data[:, [0, 2, 3]])
    print()

    # 取第0、2、3列数据的前5行
    print(data[:, [0, 2, 3]][:5])
    print()

print()
print()
iris_csv = np.loadtxt("../../dataset/iris/iris.csv", str, delimiter=",", skiprows=1)
print(type(iris_csv))
print(iris_csv[:5])
