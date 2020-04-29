# -*- coding: utf-8 -*-

import numpy as np

print("numpy version: {}".format(np.__version__))
print()

print()
print()
print("#" * 150)
print("# 1、demo random.rand()")
print("# 通过本函数可以返回一个或一组服从“0~1”均匀分布的随机样本值。随机样本取值范围是[0,1)，不包括1。")
print("#" * 150)
print("# 数字区间：[0,1)")
print("# 分布：均匀分布")
print("# 形状：[d0,d1,...,dn]")
print("#" * 150)

print()
print("# 1.1、" + "-"*100)
print("# 无参 - 生成生成[0,1)之间随机浮点数")
a = np.random.rand()
print(a)                            # 输出:0.24474998882022803
print(type(a))                      # 输出:<class 'float'>

print()
print("# 1.2、" + "-"*100)
print("# 一个参数 - 生成一个长度为X的一维数组")
a = np.random.rand(3)
print(a)                            # 输出:[0.25417153 0.60665774 0.47014132]
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 1.3、" + "-"*100)
print("# 两个参数 - 生成 X Y 的二维数组")
a = np.random.rand(3, 4)
print(a)
# 输出:
'''
[[0.51646841 0.56390296 0.39921814 0.11151246]
 [0.07394481 0.87282465 0.24646819 0.08676065]
 [0.14218745 0.05025686 0.95804425 0.3505817 ]]
'''
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 1.4、" + "-"*100)
print("# 三个参数 - 生成 X Y Z的三维数组")
a = np.random.rand(3, 4, 3)
print(a)
# 输出:
'''
[[[0.59070515 0.22179834 0.11576126]
  [0.80957472 0.96100718 0.96253156]
  [0.86917416 0.1152876  0.90227399]
  [0.11158793 0.25665294 0.95425668]]

 [[0.250072   0.36757396 0.13881288]
  [0.06372784 0.28503196 0.27737362]
  [0.08982125 0.11469674 0.73860329]
  [0.6187439  0.41550613 0.09239269]]

 [[0.61918204 0.08633798 0.12406332]
  [0.87664307 0.76247956 0.90745935]
  [0.77600081 0.80652427 0.77139555]
  [0.95552545 0.29447777 0.30193095]]]
'''
print(type(a))                      # 输出:<class 'numpy.ndarray'>

