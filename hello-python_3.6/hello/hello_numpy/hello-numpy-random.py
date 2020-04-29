# -*- coding: utf-8 -*-

import numpy as np

print("numpy version: {}".format(np.__version__))
print()

'''
np.arange()函数返回一个有终点和起点的固定步长的排列，如[1,2,3,4,5]，起点是1，终点是5，步长为1。 
参数个数情况： np.arange()函数分为一个参数，两个参数，三个参数三种情况 
    1）一个参数时，参数值为终点，起点取默认值0，步长取默认值1。 
    2）两个参数时，第一个参数为起点，第二个参数为终点，步长取默认值1。 
    3）三个参数时，第一个参数为起点，第二个参数为终点，第三个参数为步长。其中步长支持小数。
'''

print("#" * 150)
print("# demo")
print("#" * 150)

a = np.random
print(a)                            # 输出:<module 'numpy.random' from '/Users/hiahia/develop/github/hello/venv/lib/python3.8/site-packages/numpy/random/__init__.py'>
print(type(a))                      # 输出:<class 'module'>


print()
print()
print("#" * 150)
print("# 1、demo random.randint()")
print("# numpy.random.randint(low, high=None, size=None, dtype='l'):")
print("# 生成一个整数或N维整数数组，取数范围：若high不为None时，取[low,high)之间随机整数，否则取值[0,low)之间随机整数。")
print("#" * 150)

print()
print("# 1.1、产生随机数" + "-"*100)
print("# low=10 生成一个[0,10)之间随机整数")
a = np.random.randint(10)
print(a)                            # 输出:3
print(type(a))                      # 输出:<class 'int'>

print()
print("# 1.2、在区间产生随机数" + "-"*100)
print("# low=2, high=10 生成一个[2,10)之间随机整数")
# a = np.random.randint(2, 2) # 报错,high必须大于low
a = np.random.randint(2, 10)
print(a)                            # 输出:5
print(type(a))                      # 输出:<class 'int'>

print()
print("# 1.3、" + "-"*100)
print("# low=2,size=5 生成一个[0,2)之间随机整数的长度为5的一维数组")
a = np.random.randint(2, size=5)
print(a)                            # 输出:[0 1 1 1 1]
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 1.4、" + "-"*100)
print("# low=2,high=6,size=5 生成一个[0,6)之间随机整数的长度为5的一维数组")
a = np.random.randint(2, 6, size=5)
print(a)                            # 输出:[5 2 3 3 3]
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 1.5、" + "-"*100)
print("# low=2,size=(2, 3) 生成一个[0,2)之间随机整数的维度为2X3的二维维数组")
a = np.random.randint(2, size=(2, 3))
print(a)
# 输出:
'''
[[1 1 1]
 [0 0 0]]
'''
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 1.6、" + "-"*100)
print("# low=2,high=6,size=(3, 3) 生成一个[2,6)之间随机整数的维度为3X3的二维维数组")
a = np.random.randint(2, 6, size=(3, 3))
print(a)
# 输出:
'''
[[2 5 5]
 [5 3 2]
 [5 4 4]]
'''
print(type(a))                      # 输出:<class 'numpy.ndarray'>


print()
print()
print("#" * 150)
print("# 2、demo random.rand()")
print("# 通过本函数可以返回一个或一组服从“0~1”均匀分布的随机样本值。随机样本取值范围是[0,1)，不包括1。")
print("#" * 150)

print()
print("# 2.1、" + "-"*100)
print("# 无参 - 生成生成[0,1)之间随机浮点数")
a = np.random.rand()
print(a)                            # 输出:0.24474998882022803
print(type(a))                      # 输出:<class 'float'>

print()
print("# 2.2、" + "-"*100)
print("# 一个参数 - 生成一个长度为X的一维数组")
a = np.random.rand(3)
print(a)                            # 输出:[0.25417153 0.60665774 0.47014132]
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 2.3、" + "-"*100)
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
print("# 2.4、" + "-"*100)
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


print()
print()
print("#" * 150)
print("# 3、demo random.randn()")
print("# 生成一个浮点数或N维浮点数组，取数范围：正态分布的随机样本数。")
print("#" * 150)

print()
print("# 3.1、无参" + "-"*100)
a = np.random.randn()
print(a)                            # 输出:-0.4736282716772786
print(type(a))                      # 输出:<class 'float'>

print()
print("# 3.2、一个参数" + "-"*100)
a = np.random.randn(3)
print(a)                            # 输出:[ 1.04947543 -0.74796317  0.64841714]
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 3.3、两个参数" + "-"*100)
a = np.random.randn(3, 3)
print(a)
# 输出:
'''
[[ 0.15692605  0.38805159 -0.31689713]
 [ 1.39776129  1.0011283  -1.11464804]
 [-0.21085902  0.71662165 -0.14766392]]
'''
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 3.4、" + "-"*100)
print("# 三个参数 - 生成 X Y Z的三维数组")
a = np.random.randn(3, 4, 3)
print(a)
# 输出:
'''
[[[ 1.62959324 -0.89654551  0.65737322]
  [ 0.45167149  0.28636558 -0.73251286]
  [ 1.55574996 -0.75205273 -0.45252403]
  [-2.04598816  0.01863067 -0.288296  ]]

 [[-0.50352956 -0.52401756 -0.40446588]
  [ 0.54467623  0.90034104  0.04241988]
  [-0.90209512  0.00671769  0.53099773]
  [ 0.06718672 -1.81231899 -2.4917181 ]]

 [[-1.390649   -1.59815086  0.5890171 ]
  [ 0.88216299  0.59361464  0.90104781]
  [ 0.44688067 -0.1486467   0.2868008 ]
  [ 0.38923347 -1.08003832 -1.41526916]]]
'''
print(type(a))                      # 输出:<class 'numpy.ndarray'>


