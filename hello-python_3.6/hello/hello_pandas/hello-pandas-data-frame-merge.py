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

ls_a = {"id": [1, 2, 2, 3], "class": [1, 1, 1, 2], "name": ["aa", "bb", "cc", "dd"], "Score": [3, 6, 9, 10]}
df_a = pd.DataFrame(ls_a)

ls_b = {"id": [1, 2, 2, 3], "class": [1, 1, 1, 2], "name": ["aa", "bb", "cc", "dd"], "mathematics": [3, 6, 9, 10]}
df_b = pd.DataFrame(ls_b)

ls_c = {"id": [1, 1, 2, 4], "class": [1, 1, 1, 2], "name": ["aa", "bb", "cc", "dd"], "chinese": [3, 6, 9, 10]}
df_c = pd.DataFrame(ls_c)


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

print("#" * 150)
print("# 1、merge")
print("#" * 150)

"""
def merge(
        self,
        right,
        how="inner",
        on=None,
        left_on=None,
        right_on=None,
        left_index=False,
        right_index=False,
        sort=False,
        suffixes=("_x", "_y"),
        copy=True,
        indicator=False,
        validate=None,
    )
"""

print("#" * 150)
print("# 1.1、df_b.merge(df_c)")
print("#" * 150)

result = df_b.merge(df_c)
print(result)

"""
   id  class name  mathematics  chinese
0   1      1   aa            3        3
1   2      1   cc            9        9
"""

del result

print("#" * 150)
print("# 1.2、df_b.merge(df_c, on='id')")
print("#" * 150)

result = df_b.merge(df_c, on='id')
print(result)

"""
   id  class_x name_x  mathematics  class_y name_y  chinese
0   1        1     aa            3        1     aa        3
1   1        1     aa            3        1     bb        6
2   2        1     bb            6        1     cc        9
3   2        1     cc            9        1     cc        9
"""

del result


print("#" * 150)
print("# 1.3、df_b.merge(df_c, left_on='id', right_on='id')")
print("#" * 150)

result = df_b.merge(df_c, left_on='id', right_on='id')
print(result)

"""
   id  class_x name_x  mathematics  class_y name_y  chinese
0   1        1     aa            3        1     aa        3
1   1        1     aa            3        1     bb        6
2   2        1     bb            6        1     cc        9
3   2        1     cc            9        1     cc        9
"""

del result

print()
print("｜"*100)
print()

