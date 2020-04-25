# -*- coding: utf-8 -*-

import random

# 第一个随机数
print ("random() : ", random.random())

# 第二个随机数
print ("random() : ", random.random())

# 第三个随机数
# TypeError: randint() missing 2 required positional arguments: 'a' and 'b'
# print ("random() : ", random.randint())
# TypeError: randint() missing 1 required positional argument: 'b'
# print ("random() : ", random.randint(2))
print("randint() : ", random.randint(2, 10))

for i in range(10):
    print("randint() : ", random.randint(2, 10))