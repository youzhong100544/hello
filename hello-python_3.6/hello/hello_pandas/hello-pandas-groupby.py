# -*- coding: utf-8 -*-

import pandas as pd


# import hello.hello_common.common
# from hello.hello_common import common

import hello.hello_pandas.common.common
from hello.hello_pandas.common import common

print("pandas version: {}".format(pd.__version__))
print()

ls_a = {"A": [1, 1, 2, 2, 2, 3], "B": [2, 5, 8, 7, 9, 4], "C": [3, 6, 9, 9, 9, 9]}
df_a = pd.DataFrame(ls_a)

print("打印数据")
print(df_a.head(10))
print()

print()
print("|" * 100)
print()

print("分组")

groupby = df_a.groupby('A')
# groupby = df_a.groupby('A', as_index=False)

print("打印分组数据及信息")
print(groupby)
print(type(groupby))

print("分组数据遍历")
for key, value in groupby:
    print(type(key))
    print(type(value))
    print("~" * 100)

    print("key:" + str(key))
    print("value:" + str(value))
    print("~" * 100)

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
# groupby_sort = df_a.groupby('A').apply(lambda x: x.sort_values('B', ascending=False))
groupby_sort = df_a.groupby('A').apply(lambda x: x.sort_values('B'))
# groupby_sort = df_a.groupby('A', as_index=False).apply(lambda x: x.sort_values('B', ascending=False))
print()

print("打印分组排序数据及信息")
print(groupby_sort.head(10))
print("-" * 100)
print(type(groupby_sort))
print("-" * 100)
print(groupby_sort.columns)
print()

print()
print("|" * 100)
print()

print("分组排序数据遍历")
for item in groupby_sort:
    print(type(item))
    print("~" * 100)
    print(item)

print()
print("-" * 100)
print()

print("分组排序数据遍历")
for key, value in groupby_sort:
    print(type(value))
    print("key:" + str(key) + " - value:" + str(value))