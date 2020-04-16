# -*- coding: utf-8 -*-

import pandas as pd

print("hello hello_common common.py")
print("pandas version: {}".format(pd.__version__))
print()


def get_data_frame():
    return create_data_frame_from_python_dictionary()


# 用Python中的字典生成
def create_data_frame_from_python_dictionary():
    # ls = {"column_name_A": [1, 4, 7], "column_name_B": [1, 4, 7], "column_name_C": [1, 4, 7]}
    dictionary = {"name": "xm", "age": 18, "hobby": ["singing", "running"]}
    data_frame = pd.DataFrame(dictionary)
    return data_frame

def create_data_frame_from_cvs(file_path):
    data_frame = pd.read_csv(file_path)
    return data_frame
