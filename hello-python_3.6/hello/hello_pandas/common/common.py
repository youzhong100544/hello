# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd

print("common")
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


"""
class DataFrame(NDFrame):
def __init__(self, data=None, index: Optional[Axes] = None, columns: Optional[Axes] = None, dtype: Optional[Dtype] = None, copy: bool = False, )
    
pandas.DataFrame(data=None, index=None, columns=None, dtype=None, copy=False) 

data：numpy ndarray（结构化或同类），dict或DataFrame，Dict可以包含Series，数组，常量或类似列表的对象
index：dataframe的索引，如果没有自定义，则默认为RangeIndex（0,1,2，…，n）
columns：dataframe的列标签，如果没有自定义，则默认为RangeIndex（0,1,2，…，n）
dtype：默认None，要强制的数据类型。 只允许一个dtype
"""


def create_data_frame() -> pd.core.frame.DataFrame:
    # test_dict = {'id': [1, 2, 3, 4, 5, 6], 'class': [1, 2, 1, 2, 2, 3], 'name': ['Alice','Bob','Cindy','Eric','Helen','Grace '], 'math': [90, 89, 99, 78, 97, 93], 'english': [89, 94, 80, 94, 94, 90]}
    test_dict = {'id': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 'class': [1, 2, 1, 2, 2, 3, 1, 3, 2, 3], 'name': ['aa', 'bb', 'cc', 'dd', 'ee', 'ff', 'gg', 'hh', 'ii', 'jj'], 'math': [90, 89, 99, 78, 97, 93, 44, 78, 97, 93], 'english': [89, 94, 80, 94, 94, 90, 80, 94, 94, 90]}

    # 1.直接写入参数test_dict
    test_dict_df_00 = pd.DataFrame(test_dict)
    # test_dict_df_01 = pd.DataFrame(test_dict, index=False) # 会报错

    test_dict_df_03 = pd.DataFrame(test_dict, [00, 11, 22, 33, 44, 55, 66, 77, 88, 99])
    test_dict_df_04 = pd.DataFrame(test_dict, index=[00, 11, 22, 33, 44, 55, 66, 77, 88, 99])

    # 2.字典型赋值
    test_dict_df_10 = pd.DataFrame(data=test_dict)
    test_dict_df_11 = pd.DataFrame(data=test_dict, index=[00, 11, 22, 33, 44, 55, 66, 77, 88, 99])

    test_dict_df = test_dict_df_00

    return test_dict_df


def create_data_frame_from_list() -> pd.core.frame.DataFrame:
    df1 = pd.DataFrame(data=[[1, 2, 3], [4, 5, 6], [7, 8, 9]], index=[0, 1, 2], columns=['a', 'b', 'c'])
    df2 = pd.DataFrame(data=[[1, 2, 3], [4, 5, 6], [7, 8, 9]], index=['e', 'f', 'g'], columns=['a', 'b', 'c'])
    df3 = pd.DataFrame(data=[[1, 2, 3], [4, 5, 6], [7, 8, 9]], index=['e', 'f', 'g'], columns=['a', 'b', 'c'], dtype='float64')

    # dtype：默认None，要强制的数据类型。 只允许一个dtype
    # df2 = pd.DataFrame(data=[[1, 2, 3], [4, 5, 6], [7, 8, 9]], index=['e', 'f', 'g'], columns=['a', 'b', 'c'], dtype={'a': np.float_, 'b': np.float_, 'c': np.float_})

    df = df3

    return df


# 创建 DataFrame ：利用 pandas 的 series
def create_data_frame_from_dict():
    dict = {"name": ["xm", "xh", "xq"], "age": [1, 4, 7], "gender": ["female", "male", "female"]}

    dict1 = {"name": pd.Series(["xm", "xh", "xq"]), "age": pd.Series([1, 4, 7]), "gender": pd.Series(["female", "male", "female"])}

    dict2 = {"name": pd.Series(["xm", "xh", "xq"]), "age": pd.Series([1, 4, 7]), "gender": ["female", "male", "female"]}

    dict3 = {"name": pd.Series(["xm", "xh", "xq"], index=[11, 22, 33]), "age": pd.Series([1, 4, 7], index=[111, 222, 333])}

    dict4 = {"name": pd.Series(["xm", "xh", "xq"], index=[11, 22, 33]), "age": pd.Series([1, 4, 7])}

    df = pd.DataFrame.from_dict(dict3)
    return df


# 创建 DataFrame ：利用 numpy 的 random
def create_data_frame_from_dict_of_numpy_random():

    dict_0 = {'item': np.random.randint(0, 4, 50),
              'level': np.random.randint(0, high=3, size=50),
              'price': np.random.rand(50)*100,
              'price_1': np.random.rand(50)*100,
              'price_2': np.around(np.random.rand(50)*100, 4), # 保留 4 位小数
              'weight': np.random.randint(50, 100, size=50),
              'sailer': np.random.randint(0, 3, size=50, dtype=int)
              }

    dict = {'item': np.random.randint(0, 4, 50),
            'level': np.random.randint(0, high=3, size=50),
            'price': np.random.rand(50)*100,
            'weight': np.random.randint(50, 100, size=50),
            'sailer': np.random.randint(0, 3, size=50, dtype=int)
            }

    dict_price = {
            'price_1': np.random.rand(50)*100,
            'price_2': np.around(np.random.rand(50)*100, 4) # 保留 4 位小数
            }

    df_0 = pd.DataFrame(dict)
    df_1 = pd.DataFrame.from_dict(dict)

    df = df_0

    # 赋值转换
    df['item'] = df['item'].map({0: '萝卜', 1: '白菜', 2: '西红柿', 3: '黄瓜'})
    df['level'] = df['level'].map({0: '差', 1: '中', 2: '优'})
    df['sailer'] = df['sailer'].map({0: '张大妈', 1: '李大妈', 2: '赵大叔'})

    # 添加列
    df_0 = pd.DataFrame(dict_price)

    return df


def create_data_frame_from_numpy_random():
    data = np.random.rand(6, 3)
    data_1 = np.random.rand(6, 3) * 10

    index = pd.date_range("2020-04-28", periods=6)
    column = ["apple", "banana", "watermelon"]

    df_1 = pd.DataFrame(data=data, index=index, columns=column)
    df_2 = pd.DataFrame(data=data_1, index=index, columns=column)

    df = df_2
    return df


def create_data_frame_from_numpy_arange_reshape():
    data = np.arange(15).reshape(5, 3)
    index = pd.date_range("2020-04-28", periods=5)
    column = ["apple", "banana", "watermelon"]

    df_1 = pd.DataFrame(data=data, index=index, columns=column)

    df_2 = pd.DataFrame(data=data, columns=column)

    df = df_2
    return df


def create_data_frame_from_csv_with_head(file_path: str):
    df = pd.read_csv(file_path)
    return df


def create_data_frame_from_csv_without_head(file_path: str, columns_list: list = None):
    df = pd.read_csv(file_path)

    # columns_list 为空时
    if (not columns_list) or (len(df.columns) != len(columns_list)):
        print("columns_list 为空 或者 columns_list 的长度错误")
        columns_list = []
        for i in range(len(df.columns)):
            columns_list.append("column_" + str(i))

    df.columns = columns_list

    return df


def show_data_frame_info(data_frame: pd.core.frame.DataFrame):
    print()
    print(" | "*100)
    print()

    print("打印 data_frame ")
    # print(data_frame)

    print()
    print("～"*100)
    print()

    print("data_frame head(5)")
    print(data_frame.head(5))

    print()
    print("～"*100)
    print()

    print("data_frame tail(5)")
    print(data_frame.tail(5))

    print()
    print("～"*100)
    print()

    print("data_frame index")
    data_frame_index = data_frame.index
    print(type(data_frame_index))
    print(data_frame_index)

    print()
    print("～"*100)
    print()

    print("data_frame columns")
    data_frame_columns = data_frame.columns
    print(type(data_frame_columns))
    print(data_frame_columns)

    print()
    print("～"*100)
    print()

    print()
    print(" | "*100)
    print()


if __name__ == '__main__':
    frame = create_data_frame_from_numpy_arange_reshape()

    print(frame)

    # show_data_frame_info(frame)

