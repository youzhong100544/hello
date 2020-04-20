# -*- coding: utf-8 -*-

import pandas as pd


# import hello.hello_common.common
# from hello.hello_common import common

import hello.hello_pandas.common.common
from hello.hello_pandas.common import common

print("pandas version: {}".format(pd.__version__))
print()

# True就是可以换行显示。设置成False的时候不允许换行
pd.set_option('expand_frame_repr', False)

# 显示的最大行数和列数，如果超额就显示省略号，这个指的是多少个dataFrame的列。如果比较多又不允许换行，就会显得很乱。
# pd.set_option('display.max_rows', 10)
# pd.set_option('display.max_columns', 10)
# 显示所有列
pd.set_option('display.max_columns', None)
# 显示所有行
pd.set_option('display.max_rows', None)

# 显示小数点后的位数
# pd.set_option('precision', 5)

# truncate表示截断，info表示查看信息，一般选truncate
# pd.set_option('large_repr', "info")

# 列长度
# 设置 value 的显示长度为100，默认为50
pd.set_option('max_colwidth', 10000)

# 绝对值小于0.5的显示0.0
# pd.set_option('chop_threshold', 0.5)

# 显示居中还是左边，
# pd.set_option('colheader_justify', 'left')

# 横向最多显示多少个字符， 一般80不适合横向的屏幕，平时多用200.
pd.set_option('display.width', 1024)

# 输出时列名对齐列数据
# 这两个参数的默认设置都是False
pd.set_option('display.unicode.ambiguous_as_wide', True)
pd.set_option('display.unicode.east_asian_width', True)

print()


print("创建 DataFrame")

ls_a = {"A": [1, 1, 2, 2, 3], "B": [2, 5, 8, 7, 9], "C": [3, 6, 9, 9, 1]}
df_a = pd.DataFrame(ls_a)

ls_b = {"A": [1, 1, 2, 2, 6], "B": [2, 5, 8, 7, 0], "D": [3, 6, 9, 9, 4]}
df_b = pd.DataFrame(ls_b, index=[0, 1, 2, 3, 4])

ls_c = {"B": [2, 5, 8, 7, 9], "E": [3, 6, 9, 9, 9]}
df_c = pd.DataFrame(ls_c, index=[2, 3, 4, 5, 6])


print()
print("｜"*100)
print()


print("打印数据")
print("- data frame a -")
print(df_a)
print()

print("- data frame b -")
print(df_b)
print()

print("- data frame c -")
print(df_c)
print()


print()
print("｜"*100)
print()

# 列数 3
print(df_a.columns.size)
# 行数 5
print(df_a.iloc[:, 0].size)

print(df_a.ix[[0]].index.values[0])#索引值 0
print(df_a.ix[[0]].values[0][0])#第一行第一列的值 11
print(df_a.ix[[1]].values[0][1])#第二行第二列的值 121


print()
print("｜"*100)
print()

