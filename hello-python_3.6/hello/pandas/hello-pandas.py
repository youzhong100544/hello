# -*- coding: utf-8 -*-

import pandas as pd

print("pandas version: {}".format(pd.__version__))

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





print("1、- " + "read train data" + " -" * 25)
data_train = pd.read_csv('../../dataset/titanic/train.csv')

print("2、- " + "read test data" + " -" * 25)
data_test = pd.read_csv('../../dataset/titanic/test.csv')


print()
print("|" * 100)
print()


print("3、- " + "查询训练集数据信息" + " -" * 25)
print("3.1 - " + "train data type" + " -" * 25)

print(type(data_train))
print()

print("3.2 - " + "train data info" + " -" * 25)
# def info(self, verbose=None, buf=None, max_cols=None, memory_usage=None, null_counts=None)
print(data_train.info())
print()

print("3.3 - " + "train data describe" + " -" * 25)
# def describe(self: FrameOrSeries, percentiles=None, include=None, exclude=None)
# print(data_train.describe(include='all'))
print()

print("3.4 - " + "train data isnull sum" + " -" * 25)
print(data_train.isnull().sum())
print()

print("3.5 - " + "train data sample" + " -" * 25)
# def sample(self: FrameOrSeries, n=None, frac=None, replace=False, weights=None, random_state=None, axis=None,)
print(data_train.sample(10))
print()


print()
print("|" * 100)
print()


print("4、- " + "查询测试集数据信息" + " -" * 25)
print("4.1 - " + "test data type" + " -" * 25)
print(type(data_test))
print()

print("4.2 - " + "test data info" + " -" * 25)
print(data_test.info())
print()

print("4.3 - " + "test data describe" + " -" * 25)
print(data_test.describe(include = 'all'))
print()

print("4.4 - " + "test data isnull sum" + " -" * 25)
print(data_test.isnull().sum())
print()

print("4.5 - " + "test data sample" + " -" * 25)
print(data_test.sample(10))
print()

print()
print("|" * 100)
print()


print("5、- " + "copy 训练集数据" + " -" * 25)
# copy（） 和 copy（deep= False）都是浅拷贝
# copy（deep = True）深拷贝
data_train_copy = data_train.copy(deep = True)
print(id(data_train))
print(id(data_train_copy))


print()
print("|" * 100)
print()


print("6、- " + "copy 测试集信息" + " -" * 25)
print("浅拷贝" + " -" * 25)
data_test_copy_shallow = data_test.copy()
print("id(data_test):" + str(id(data_test)))
print("id(data_test_copy_shallow):" + str(id(data_test_copy_shallow)))

print("深拷贝" + " -" * 25)
data_test_copy_deep = data_test.copy(deep = True)
print("id(data_test):" + str(id(data_test)))
print("id(data_test_copy_deep):" + str(id(data_test_copy_deep)))

data_test_copy = data_test_copy_deep

print()
print("|" * 100)
print()


print("7、- " + "合并训练集、测试集数据" + " -" * 25)
# data_all = [data_train, data_test]

data_all = pd.concat([data_train, data_test])

print("7.1 - " + "all data describe" + " -" * 25)
print(data_all.describe(include = 'all'))
print()

print("7.2 - " + "all data isnull sum" + " -" * 25)
print(data_all.isnull().sum())
print()

print("7.3 - " + "all data sample" + " -" * 25)
print(data_all.sample(10))
print()