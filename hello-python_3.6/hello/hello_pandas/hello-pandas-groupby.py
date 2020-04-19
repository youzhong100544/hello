# -*- coding: utf-8 -*-

import pandas as pd


# import hello.hello_common.common
# from hello.hello_common import common

import hello.hello_pandas.common.common
from hello.hello_pandas.common import common

print("pandas version: {}".format(pd.__version__))
print()

# 创建 data frame
data_frame = common.create_data_frame()

print("打印数据")
print(data_frame)
print()

print()
print("|" * 100)
print()

print("分组")
print("groupby('class')")
data_frame_groupby_0 = data_frame.groupby('class')
data_frame_groupby_1 = data_frame.groupby('class', as_index=False)

data_frame_groupby = data_frame_groupby_0
print("打印分组数据及信息")
print("data frame")
print()

print(data_frame_groupby)
print("data frame type")
print()

print(type(data_frame_groupby))
print()

print()
print("-" * 100)
print()

print("分组数据遍历")
for key, value in data_frame_groupby:
    print("type(key)" + str(type(key)))
    print("type(value)" + str(type(value)))

    print()
    print("~" * 100)
    print()

    print("key:")
    print(str(key))
    print("value:")
    print(str(value))

    print()
    print("=" * 100)
    print()

print()
print("|" * 100)
print()


print("分组排序")
data_frame_groupby_sort = data_frame.groupby('class').apply(lambda x: x.sort_values('math'))
data_frame_groupby_sort_1 = data_frame.groupby('class').apply(lambda x: x.sort_values('math', ascending=False))
data_frame_groupby_sort_2 = data_frame.groupby('class', as_index=False).apply(lambda x: x.sort_values('math', ascending=False))
print()

print("打印分组排序数据及信息")
print("data frame")
print(data_frame_groupby_sort.head(10))
print("-" * 100)

print("data frame type")
print(type(data_frame_groupby_sort))
print("-" * 100)

print("data frame columns")
print(data_frame_groupby_sort.columns)
print()

print()
print("|" * 100)
print()

print("分组排序数据遍历")
for item in data_frame_groupby_sort:
    print(type(item))
    print("~" * 100)
    print(item)

print()
print("-" * 100)
print()

"""
print("分组排序数据遍历")
for key, value in data_frame_groupby_sort:
    print(type(value))
    print("key:" + str(key) + " - value:" + str(value))
"""