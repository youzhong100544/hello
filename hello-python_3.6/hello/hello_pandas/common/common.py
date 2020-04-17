# -*- coding: utf-8 -*-

import pandas as pd

print("common")
print("pandas version: {}".format(pd.__version__))
print()


class HelloPandasCommon:

    def __init__(self):
        pass

    def get_data_frame(self):
        self.createDataFrame()

    # 创建方式一:由list作为键值的字典创建
    def create_data_frame(self):
        l = {"A":[1, 4, 7], "B":[2, 5, 8], "C":[3, 6, 9]}
        df = pd.DataFrame(l)
        return df

    def create_data_frame_from_csv(self, file_path):
        df = pd.read_csv(file_path)
        return df


def create_data_frame():
    ls = {"A": [1, 4, 7], "B": [2, 5, 8], "C": [3, 6, 9]}
    df = pd.DataFrame(ls)
    return df


def create_data_frame_from_csv_with_head(file_path: str):
    df = pd.read_csv(file_path)
    return df


def create_data_frame_from_csv_without_head(file_path: str, columns_list: list = None):
    df = pd.read_csv(file_path)

    if columns_list:
        print('Not Null')
    else:
        print('Is Null')

    # df.columns = columns_list

    return df


head = create_data_frame_from_csv_without_head('../../data/iris-no-header.csv')
