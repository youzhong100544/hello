# -*- coding: utf-8 -*-

import pandas as pd

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

CSV_FILE_PATH = '../../data/iris.csv'
CSV_FILE_NO_HEADER_PATH = '../../data/iris-no-header.csv'

print("1.1、- " + "读取 csv 文件，带标题行" + " -" * 25)
df = pd.read_csv(CSV_FILE_PATH)
print(df.head(5))
df.info()

del df

print()
print("-"*40)
print()


print("1.2、- " + "读取 csv 文件, 不带标题行" + " -" * 25)
df = pd.read_csv(CSV_FILE_NO_HEADER_PATH)
print(df.head(5))
df.info()

del df

print()
print("-"*40)
print()


print("1.3、- " + "读取 csv 文件, 不带标题行，添加列名" + " -" * 25)
df = pd.read_csv(CSV_FILE_NO_HEADER_PATH)
print(df.head(5))
df.info()

print()
print("- 设置列名" + " -" * 25)
print()
df.columns = ['SepalLength', 'SepalWidth', 'PetalLength', 'PetalWidth', 'Species']
print(df.head(5))
df.info()

del df

print()
print("-"*40)
print()


print("1.4、- " + "读取 csv 文件, 不带标题行，添加列名" + " -" * 25)
df = pd.read_csv(CSV_FILE_NO_HEADER_PATH, header=None)
print(df.head(5))
df.info()

print()
print("- 设置列名" + " -" * 25)
print()
df.columns = ['SepalLength', 'SepalWidth', 'PetalLength', 'PetalWidth', 'Species']
print(df.head(5))
df.info()

del df

print()
print("-"*40)
print()





print()
print("|"*50)
print()

print("2、- " + "查看 dataframe 信息" + " -" * 25)





