# -*- coding: utf-8 -*-

import numpy as np
import scipy as sp
from scipy import io as spio
from scipy import special

print("numpy version: {}".format(np.__version__))
print("scipy version: {}".format(sp.__version__))

"""
官网地址:https://www.scipy.org/

"""

# 立方根函数
print("立方根函数")
res = special.cbrt([1000, 27, 8, 23])
print(res)



