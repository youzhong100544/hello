# -*- coding: utf-8 -*-

import pandas as pd

print("common")
print("pandas version: {}".format(pd.__version__))
print()


def create_data_frame() -> pd.core.frame.DataFrame:
    ls = {"A": [1, 4, 7], "B": [2, 5, 8], "C": [3, 6, 9]}
    df = pd.DataFrame(ls)
    return df


def create_data_frame_from_csv_with_head(file_path: str):
    df = pd.read_csv(file_path)
    return df


def create_data_frame_from_csv_without_head(file_path: str, columns_list: list = None):
    df = pd.read_csv(file_path)

    if not columns_list:
        columns_list = []
        for i in range(len(df.columns)):
            columns_list.append("column_" + str(i))

    df.columns = columns_list

    return df


head = create_data_frame_from_csv_without_head('../../../data/iris-no-header.csv')
print(head)
print(type(head))

print(len(head.columns))

print(head.columns)

print("1234123412341234123412341234123")

head = create_data_frame_from_csv_without_head('../../../data/iris-no-header.csv', ['SepalLength', 'SepalWidth', 'PetalLength', 'PetalWidth', 'Species'])
print(head)

print(len(head.columns))

print(head.columns)