# -*- coding: utf-8 -*-
# hello-python-3.6

# 注意在python2中print不是函数，不能通过help获得相关信息
# print在python3中是一个内建函数
print("hello - python 3.6")
print('你好，3.6')



# 导入内置math模块

import sys as system

print('system.platform:' + system.platform)


import math

content = dir(math)
print(content)

if __name__ == '__main__':
    # para1 = system.argv[1]

    # print(para1)



    str1 = ' 132 4232'
    print(str1.strip()) #132 4232
