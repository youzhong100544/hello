# -*- coding: utf-8 -*-

import numpy as np
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

'''
Pandas中关于 loc \ iloc 用法的理解
https://www.cnblogs.com/loubin/p/11299214.html
'''

'''
loc和iloc的区别

pandas以类似字典的方式来获取某一列的值，比如df[‘A’]，这会得到df的A列。
如果我们对某一行感兴趣呢？
这个时候有两种方法，一种是iloc方法，另一种方法是loc方法。
loc是指location的意思，iloc中的i是指integer。

这两者的区别如下：
    loc：works on labels in the index.
    iloc：works on the positions in the index (so it only takes integers).

也就是说loc是根据index来索引，比如下边的df定义了一个index，那么loc就根据这个index来索引对应的行。
iloc并不是根据index来索引，而是根据行号来索引，行号从0开始，逐次加1。
'''

print("创建 DataFrame")
print()

ls = np.arange(56).reshape(8, 7)
df_1 = pd.DataFrame(data=ls, columns=['c_1', 'c_2', 'c_3', 'c_4', 'c_5', 'c_6', 'c_7'])
df_2 = pd.DataFrame(data=ls, index=[11, 12, 13, 14, 15, 16, 17, 18], columns=['c_1', 'c_2', 'c_3', 'c_4', 'c_5', 'c_6', 'c_7'])
df_3 = pd.DataFrame(data=ls, index=[11, 12, 15, 14, 13, 16, 17, 18], columns=['c_1', 'c_2', 'c_3', 'c_4', 'c_5', 'c_6', 'c_7'])
df_4 = pd.DataFrame(data=ls, index=['e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'], columns=['c_1', 'c_2', 'c_3', 'c_4', 'c_5', 'c_6', 'c_7'])
df_5 = pd.DataFrame(data=ls, index=['e', 'f', 'i', 'h', 'g', 'j', 'k', 'l'], columns=['c_1', 'c_2', 'c_3', 'c_4', 'c_5', 'c_6', 'c_7'])

print("打印数据")
print("- data frame 1 -" + "-" * 100)
print(df_1)
print()

print("- data frame 2 -" + "-" * 100)
print(df_2)
print()

print("- data frame 3 -" + "-" * 100)
print(df_3)
print()

print("- data frame 4 -" + "-" * 100)
print(df_4)
print()

print("- data frame 5 -" + "-" * 100)
print(df_5)
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
print("1.1.1.1、df_1.loc[0]")
print("获取 df_1 的第一行数据")
_loc = df_1.loc[0]
print(type(_loc))
'''
<class 'pandas.core.series.Series'>
'''
print(_loc)
'''
c_1    0
c_2    1
c_3    2
c_4    3
c_5    4
c_6    5
c_7    6
Name: 0, dtype: int64
'''

print("-"*100)

print("1.1.1.2、df_2.loc[13]")
print("loc 索引行，label 是整型数字")
print("获取 df_2 的第3行数据")
# 如果对 df_2 这么写：df_2.loc[0]会报错，因为loc索引的是label，显然在 df_2 的行的名字中没有叫0的。
print(df_2.loc[13])
'''
c_1    14
c_2    15
c_3    16
c_4    17
c_5    18
c_6    19
c_7    20
Name: 13, dtype: int64
'''

print("-"*100)

print("1.1.1.3、df_4.loc[\"g\"]")
print("loc 索引行，label 是字符型")
print("获取 df_4 的索引的 'g' 的那行数据")
print(df_4.loc["g"])
'''
c_1    14
c_2    15
c_3    16
c_4    17
c_5    18
c_6    19
c_7    20
Name: g, dtype: int64
'''

print("-"*100)

print("1.1.1.4、df_1.loc[1, 3]")
print("获取索引为 1 和 3 的行的数据")
# print(df_1.loc[1, 3]) # TypeError: cannot do label indexing on <class 'pandas.core.indexes.base.Index'> with these indexers [3] of <class 'int'>
_loc = df_1.loc[[1, 3]]
print(type(_loc))
'''
<class 'pandas.core.frame.DataFrame'>
'''
print(_loc)
'''
   c_1  c_2  c_3  c_4  c_5  c_6  c_7
1    7    8    9   10   11   12   13
3   21   22   23   24   25   26   27
'''

print("-"*100)


print("1.1.2、df_1.loc[[0]]")
print("返回值为 DataFrame")
_loc = df_1.loc[[0]]
print(type(_loc))
'''
<class 'pandas.core.frame.DataFrame'>
'''

print(_loc)
'''
   c_1  c_2  c_3  c_4  c_5  c_6  c_7
0    0    1    2    3    4    5    6
'''

print("#" * 150)
print("# 1.2、loc 索引多行数据")
print("#" * 150)

# loc 索引多行数据
print("loc 索引多行数据")
print("从第一行开始到索引为 1 的那行")
_loc = df_1.loc[:1]
print(type(_loc))
print()
'''
<class 'pandas.core.frame.DataFrame'>
'''
print(_loc)
'''
   c_1  c_2  c_3  c_4  c_5  c_6  c_7
0    0    1    2    3    4    5    6
1    7    8    9   10   11   12   13
'''

print("-"*100)

print("loc 索引多行数据")
print("从索引为 1 的那行开始到最后")
print(df_1.loc[1:])
'''
   c_1  c_2  c_3  c_4  c_5  c_6  c_7
1    7    8    9   10   11   12   13
2   14   15   16   17   18   19   20
3   21   22   23   24   25   26   27
4   28   29   30   31   32   33   34
5   35   36   37   38   39   40   41
6   42   43   44   45   46   47   48
7   49   50   51   52   53   54   55
'''

print("-"*100)


print(df_4.loc[:'f'])
'''
   c_1  c_2  c_3  c_4  c_5  c_6  c_7
e    0    1    2    3    4    5    6
f    7    8    9   10   11   12   13
'''
print("-"*100)

print(df_4.loc['f':])
'''
   c_1  c_2  c_3  c_4  c_5  c_6  c_7
f    7    8    9   10   11   12   13
g   14   15   16   17   18   19   20
h   21   22   23   24   25   26   27
i   28   29   30   31   32   33   34
j   35   36   37   38   39   40   41
k   42   43   44   45   46   47   48
l   49   50   51   52   53   54   55
'''

print("-"*100)


print()
print("|"*150)
print()


print("#" * 150)
print("# 2、iloc")
print("#" * 150)

print()

print("#" * 150)
print("# 2.1、iloc 索引单行数据")
print("#" * 150)

