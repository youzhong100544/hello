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


"""
def concat(
    objs: Union[
        Iterable[FrameOrSeriesUnion], Mapping[Optional[Hashable], FrameOrSeriesUnion]
    ],
    axis=0,
    join="outer",
    ignore_index: bool = False,
    keys=None,
    levels=None,
    names=None,
    verify_integrity: bool = False,
    sort: bool = False,
    copy: bool = True,
)

参数含义
    objs：Series，DataFrame或Panel对象的序列或映射。如果传递了dict，则排序的键将用作键参数，除非它被传递，在这种情况下，将选择值（见下文）。任何无对象将被静默删除，除非它们都是无，在这种情况下将引发一个ValueError。
    axis：{0,1，...}，默认为0。沿着连接的轴。
    join：{'inner'，'outer'}，默认为“outer”。如何处理其他轴上的索引。outer为联合和inner为交集。
    ignore_index：boolean，default False。如果为True，请不要使用并置轴上的索引值。结果轴将被标记为0，...，n-1。如果要连接其中并置轴没有有意义的索引信息的对象，这将非常有用。注意，其他轴上的索引值在连接中仍然受到尊重。
    # join_axes：Index对象列表。用于其他n-1轴的特定索引，而不是执行内部/外部设置逻辑。
    keys：序列，默认值无。使用传递的键作为最外层构建层次索引。如果为多索引，应该使用元组。
    levels：序列列表，默认值无。用于构建MultiIndex的特定级别（唯一值）。否则，它们将从键推断。
    names：list，default无。结果层次索引中的级别的名称。
    verify_integrity：boolean，default False。检查新连接的轴是否包含重复项。这相对于实际的数据串联可能是非常昂贵的。
    copy：boolean，default True。如果为False，请勿不必要地复制数据。
"""
print("#" * 100)
print("合并两个数据集")
print("#" * 100)

print("#" * 100)
print("1、数据合并 — 纵向拓展")
print("#" * 100)

frames = [df_a, df_b]
result = pd.concat(frames)
print(result)

"""
   A  B    C    D
0  1  2  3.0  NaN
1  1  5  6.0  NaN
2  2  8  9.0  NaN
3  2  7  9.0  NaN
4  2  9  9.0  NaN
5  3  4  9.0  NaN
0  1  2  NaN  3.0
1  1  5  NaN  6.0
2  2  8  NaN  9.0
3  2  7  NaN  9.0
4  2  9  NaN  9.0
5  3  4  NaN  9.0
"""

del frames
del result

print()
print("-"*100)
print()

print("#" * 100)
print("1.1、数据合并 — 纵向拓展 - 重新生成索引")
print("#" * 100)

frames = [df_a, df_b]
result = pd.concat(frames)
result = result.reset_index(drop=True)
print(result)

"""
   A  B    C    D
0  1  2  3.0  NaN
1  1  5  6.0  NaN
2  2  8  9.0  NaN
3  2  7  9.0  NaN
4  3  9  1.0  NaN
5  1  2  NaN  3.0
6  1  5  NaN  6.0
7  2  8  NaN  9.0
8  2  7  NaN  9.0
9  6  0  NaN  4.0
"""

del frames
del result

print()
print("="*100)
print()

print("#" * 100)
print("2、数据合并 — 横向延伸")
print("#" * 100)

frames = [df_a, df_c]
result = pd.concat(frames, axis=1)
print(result)

"""
     A    B    C    B    E
0  1.0  2.0  3.0  NaN  NaN
1  1.0  5.0  6.0  NaN  NaN
2  2.0  8.0  9.0  2.0  3.0
3  2.0  7.0  9.0  5.0  6.0
4  3.0  9.0  1.0  8.0  9.0
5  NaN  NaN  NaN  7.0  9.0
6  NaN  NaN  NaN  9.0  9.0
"""

del frames
del result

print()
print("-"*100)
print()

print("#" * 100)
print("2.1、数据合并 — 横向延伸 - (内连接，指定join='inner')")
print("#" * 100)

frames = [df_a, df_c]
result = pd.concat(frames, axis=1, join='inner')
print(result)

"""
   A  B  C  B  E
2  2  8  9  2  3
3  2  7  9  5  6
4  3  9  1  8  9
"""

del frames
del result

print()
print("-"*100)
print()




print()
print("="*100)
print()

