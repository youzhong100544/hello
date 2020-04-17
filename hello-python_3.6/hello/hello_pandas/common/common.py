# -*- coding: utf-8 -*-

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


def create_data_frame() -> pd.core.frame.DataFrame:
    ls = {"A": [1, 4, 7], "B": [2, 5, 8], "C": [3, 6, 9]}
    df = pd.DataFrame(ls)
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
    frame = create_data_frame()
    print(frame)

    show_data_frame_info(frame)