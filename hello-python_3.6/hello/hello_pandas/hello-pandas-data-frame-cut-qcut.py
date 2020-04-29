# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd

pd.set_option('expand_frame_repr', False)
pd.set_option('display.max_columns', None)
pd.set_option('display.max_rows', None)
pd.set_option('max_colwidth', 10000)
pd.set_option('display.width', 1024)
pd.set_option('display.unicode.ambiguous_as_wide', True)
pd.set_option('display.unicode.east_asian_width', True)

print()

data = np.random.randint(0, 100, size=(50, 3))
column = ["apple", "banana", "watermelon"]
df = pd.DataFrame(data, columns=column)

print(df)

print()
print("｜"*100)
print()

print("#" * 150)
print("# 1、cut()")
print("#" * 150)
'''
pandas.cut(x, bins, right=True, labels=None, retbins=False, precision=3, include_lowest=False)
参数：
    x : 输入待cut的一维数组
    bins : cut的段数，一般为整型，但也可以为序列向量(若不在该序列中，则是NaN)。
    right : 布尔值，确定右区间是否开闭，取True时右区间闭合
    labels : 数组或布尔值，默认为None，用来标识分后的bins，长度必须与结果bins相等，返回值为整数或者对bins的标识
    retbins : 布尔值，可选。是否返回数值所在分组，Ture则返回
    precision : 整型，bins小数精度，也就是数据以几位小数显示
    include_lowest : 布尔类型，是否包含左区间
'''
df_cut = pd.cut(df['apple'], 10)
print(type(df_cut))
print(df_cut.dtype)
print(df_cut)

print()
print("遍历 cut() 结果")
for cut_element in df_cut:
    print(type(cut_element))
    # print(cut_element.dtype)
    print(cut_element)

print()
'''
list.sort(cmp=None, key=None, reverse=False)
参数
    cmp -- 可选参数, 如果指定了该参数会使用该参数的方法进行排序。
    key -- 主要是用来进行比较的元素，只有一个参数，具体的函数的参数就是取自于可迭代对象中，指定可迭代对象中的一个元素来进行排序。
    reverse -- 排序规则，reverse = True 降序， reverse = False 升序（默认）。
'''
ids = list(set(df_cut))
print(type(ids))
print(ids)

print()
ids = ids.sort()
print(type(ids))
print(ids)


