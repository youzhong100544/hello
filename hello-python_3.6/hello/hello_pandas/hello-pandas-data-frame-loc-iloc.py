# -*- coding: utf-8 -*-

import pandas as pd


# import hello.hello_common.common
# from hello.hello_common import common

import hello.hello_pandas.common.common
from hello.hello_pandas.common import common

print("pandas version: {}".format(pd.__version__))
print()

pd.set_option('expand_frame_repr', False)
pd.set_option('display.max_columns', None)
pd.set_option('display.max_rows', None)
pd.set_option('max_colwidth', 10000)
pd.set_option('display.width', 1024)
pd.set_option('display.unicode.ambiguous_as_wide', True)
pd.set_option('display.unicode.east_asian_width', True)

print()


print("创建 DataFrame")
print()
dict_1 = {"A": [21, 22, 23, 24, 25, 26, 27], "B": [31, 32, 33, 34, 35, 36, 37], "C": [41, 42, 43, 44, 45, 46, 47], "D": [51, 52, 53, 54, 55, 56, 57], "E": [61, 62, 63, 64, 65, 66, 67]}
df_1 = pd.DataFrame(dict_1)

list_2 = [[21, 22, 23, 24, 25], [31, 32, 33, 34, 35], [41, 42, 43, 44, 45], [51, 52, 53, 54, 55], [61, 62, 26, 64, 65], [71, 72, 73, 74, 75], [81, 82, 83, 84, 85]]
df_2 = pd.DataFrame(data=list_2, index=[11, 22, 33, 44, 55, 66, 77], columns=['AA', 'BB', 'CC', 'DD', 'EE'])

list_3 = [[21, 22, 23, 24, 25], [31, 32, 33, 34, 35], [41, 42, 43, 44, 45], [51, 52, 53, 54, 55], [61, 62, 26, 64, 65], [71, 72, 73, 74, 75], [81, 82, 83, 84, 85]]
df_3 = pd.DataFrame(data=list_3, index=['e', 'f', 'g', 'h', 'i', 'j', 'k'], columns=['AA', 'BB', 'CC', 'DD', 'EE'])

print("打印数据")
print("- data frame 1 -")
print(df_1)
print()

print("- data frame 2 -")
print(df_2)
print()

print("- data frame 3 -")
print(df_3)
print()


print()
print("｜"*100)
print()


print("#" * 150)
print("# 1、loc")
print("#" * 150)

print()

print("#" * 150)
print("# 1.1、loc 索引单行数据")
print("#" * 150)

print("1.1.1、loc 索引行，label 是整型数字")

loc_ = df_1.loc[0]
print(type(loc_))
'''
<class 'pandas.core.series.Series'>
'''

for l in loc_:
    print(l)

print(loc_)
'''
A    21
B    31
C    41
D    51
E    61
Name: 0, dtype: int64
'''

print("-"*100)

# loc 索引行，label 是整型数字
# 如果对 df1 这么写：df1.loc[0]会报错，因为loc索引的是label，显然在df2的行的名字中没有叫0的。
print(df_2.loc[33])
'''
aa    11
bb    12
cc    13
Name: 11, dtype: int64
'''

print("-"*100)

# loc 索引行，label 是字符型
print(df_3.loc["g"])
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
print(df_1.loc[:1])
'''
   A  B  C
0  1  4  7
1  2  5  8
'''

print("-"*100)

print(df_1.loc[1:])
'''
   A  B  C
1  2  5  8
2  3  6  9
'''

print("-"*100)

print(df_2.loc[:1])
'''
Empty DataFrame
Columns: [aa, bb, cc]
Index: []
'''

print("-"*100)

print(df_2.loc[1:])
'''
    aa  bb  cc
11  11  12  13
22  14  15  16
33  17  18  19
'''

print("-"*100)


# print(df2.loc[:1]) # 会报错
# print(df2.loc[1:]) # 会报错

print(df_2.loc[:'f'])
'''
   aa  bb  cc
e  10  20  30
f  40  50  60
'''
print("-"*100)

print(df_3.loc['f':])
'''
   aa  bb  cc
f  40  50  60
g  70  80  90
'''

print("-"*100)


print()
print("｜"*100)
print()


print("#" * 150)
print("# 1、iloc")
print("#" * 150)

print()

print("#" * 150)
print("# iloc 索引单行数据")
print("#" * 150)

