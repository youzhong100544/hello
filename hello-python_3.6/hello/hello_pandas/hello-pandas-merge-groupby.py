# -*- coding: utf-8 -*-

import pandas as pd


# import hello.hello_common.common
# from hello.hello_common import common

import hello.hello_pandas.common.common
from hello.hello_pandas.common import common

print("pandas version: {}".format(pd.__version__))
print()

ls_a = {"A": [1, 1, 2, 3], "B": [2, 5, 8, 8], "C": [3, 6, 9, 9]}
df_a = pd.DataFrame(ls_a)

ls_b = {"D": [1, 2, 2, 4], "B": [2, 5, 8, 8], "F": [3, 6, 9, 9]}
df_b = pd.DataFrame(ls_b)

print("data frame a")
print(df_a.head(10))
print()

print("data frame b")
print(df_b.head(10))
print()

print()
print("merge" + "~"*100)
print()
df_merge = pd.merge(df_a, df_b, how='left', left_on='A', right_on='D')

print(df_merge.head(10))

print()
print("group by" + "~"*100)
print()
df_merge = df_merge.groupby('A', as_index=False)
print(len(df_merge))
print(df_merge.head(10))


print()
print("组内遍历" + "~"*100)
print()

i = 1
for group in df_merge:
    print("组：" + str(i))
    i = i + 1
    for iteam in group:
        print(iteam)