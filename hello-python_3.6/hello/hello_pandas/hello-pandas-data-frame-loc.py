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

ls_a = {"A": [1, 2, 3], "B": [4, 5, 6], "C": [7, 8, 9]}
df_a = pd.DataFrame(ls_a)

df1 = pd.DataFrame(data=[[11, 12, 13], [14, 15, 16], [17, 18, 19]], index=[11, 22, 33], columns=['aa', 'bb', 'cc'])

df2 = pd.DataFrame(data=[[10, 20, 30], [40, 50, 60], [70, 80, 90]], index=['e', 'f', 'g'], columns=['aa', 'bb', 'cc'])



print()
print("｜"*100)
print()


print("打印数据")
print("- data frame a -")
print(df_a)
print()

print("- data frame b -")
print(df1)
print()

print("- data frame c -")
print(df2)
print()


print("#" * 150)
print("# loc 索引单行数据")
print("#" * 150)

# loc 索引单行数据

# loc 索引行，label 是整型数字
print(df_a.loc[0])
'''
A    1
B    4
C    7
Name: 0, dtype: int64
'''

print("-"*100)

# loc 索引行，label 是整型数字
print(df1.loc[11])
'''
aa    11
bb    12
cc    13
Name: 11, dtype: int64
'''

print("-"*100)

# loc 索引行，label 是字符型
print(df2.loc["e"])
'''
aa    10
bb    20
cc    30
Name: e, dtype: int64
'''

print("#" * 150)
print("loc 索引多行数据")
print("#" * 150)

# loc 索引多行数据
print(df_a.loc[:1])
'''
   A  B  C
0  1  4  7
1  2  5  8
'''

print("-"*100)

print(df_a.loc[1:])
'''
   A  B  C
1  2  5  8
2  3  6  9
'''

print("-"*100)