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

print()

print("1、- " + "读取 csv 文件" + " -" * 25)
"""
# header=0——表示csv文件的第一行默认为dataframe数据的行名称,
# index_col=0——表示使用第0列作为dataframe的行索引,
# squeeze=True——表示如果文件只包含一列，则返回一个序列。

sep分隔符，encoding编码header=None自动列名，names自定义列名，index_col作为行索引的列（主键）,skiprows跳过行索引,na_values缺失值的替代字符串
"""


print("创建 DataFrame")

ls_a = {"A": [1, 1, 2, 2, 2, 3], "B": [2, 5, 8, 7, 9, 4], "C": [3, 6, 9, 9, 9, 9]}
df = pd.DataFrame(ls_a)

print("打印数据" + " -" * 25)

print("- df -")
print(df)
print()

print("- head(5) -")
print(df.head(5))
print()

print("打印数据相关信息" + " -" * 25)

print("- index -")
df_index = df.index
print(type(df_index))
print(df_index)
print()

print("- columns -" + "-"*50)
df_columns = df.columns
print(type(df_columns))
print(df_columns)
print()


print("- info -" + "-"*50)
df.info()


print()
print("-"*40)
print()


print("遍历 data frame" + " -" * 25)
print("方法一：df.iterrows()" + " -" * 25)
for index, row in df.iterrows():
    print(type(index))      # 输出：<class 'int'>
    print(index)            # 输出每行的索引值

    print(type(row))        # 输出：<class 'pandas.core.series.Series'>
    print(row)              # 输出每行数据

    print("------------------------------")

    print(row["A"])
    print(row["B"])
    print(row["C"])

    print("------------------------------")

    for i in row:
        print(i)
    print("================================")

print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")

print("方法二：df.iterrows" + " -" * 25)
for index, row in df.iteritems():
    print(type(index))      # 输出：<class 'int'>
    print(index)            # 输出每行的索引值

    print(type(row))        # 输出：<class 'pandas.core.series.Series'>
    print(row)              # 输出每行数据