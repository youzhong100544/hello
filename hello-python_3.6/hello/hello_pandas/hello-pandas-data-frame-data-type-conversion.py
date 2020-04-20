# -*- coding: utf-8 -*-

import pandas as pd

from pandas.api.types import is_string_dtype
from pandas.api.types import is_numeric_dtype
from pandas.api.types import is_timedelta64_dtype
from pandas.api.types import is_object_dtype

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

"""
推荐博文
    pandas 数据类型转换
    https://www.cnblogs.com/onemorepoint/p/9404753.html
"""


ls_a = {"c_a": ["1", "4", "7"], "c_b": ["aa", "bb", "cc"], "c_c": ["2016-12-01 3:01:20", "2014-12-01 12:01:20", "2015-12-01 06:01:20"], "c_d": ["1", "2", "3"]}
df_a = pd.DataFrame(ls_a)

print("-"*100)
print(df_a)

print("-"*100)
print(df_a.dtypes)

print("-"*100)
print(df_a["c_a"].dtypes)

print("#"*100)
print("# 数据类型转换")
print("#"*100)

print("#"*100)
print("# 1、首先介绍最常用的 astype()")
print("#"*100)

df_a["c_a"] = df_a["c_a"].astype("int")

df_a["c_c"] = df_a["c_c"].astype("datetime64")

df_a["c_d"] = df_a["c_d"].astype("float")

print(df_a.dtypes)


print()
print("-"*100)
print()

print("#"*100)
print("# 2、首先介绍最常用的 astype()")
print("#"*100)
ls_b = {"c_a": ["1", "4", "7"], "c_b": ["aa", "bb", "cc"], "c_c": ["2016-12-01 3:01:20", "2014-12-01 12:01:20", "2015-12-01 06:01:20"]}
df_b = pd.DataFrame(ls_b)

format_str = '%Y-%m-%d %H:%M:%S.%f'
df_b["c_c"] = df_b["c_c"].apply(pd.to_datetime, format=format_str)

print("-"*100)
print(df_b.dtypes)

print("-"*100)

print("#"*100)
print("# 3、利用pandas中函数进行处理")
print("#"*100)




