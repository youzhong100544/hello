# -*- coding: utf-8 -*-

import numpy as np

print("numpy version: {}".format(np.__version__))
print()

print()
print()
print("#" * 150)
print("# 1、demo random.randn()")
print("# 生成一个浮点数或N维浮点数组，取数范围：正态分布的随机样本数。")
print("#" * 150)
print("# 数字区间：数字区间：（负无穷，正无穷）")
print("# 分布：标准正态分布")
print("# 形状：[d0,d1,...,dn]")
print("#" * 150)

print()
print("# 1.1、无参" + "-"*100)
a = np.random.randn()
print(a)                            # 输出:-0.4736282716772786
print(type(a))                      # 输出:<class 'float'>

print()
print("# 1.2、一个参数" + "-"*100)
a = np.random.randn(3)
print(a)                            # 输出:[ 1.04947543 -0.74796317  0.64841714]
print(type(a))                      # 输出:<class 'numpy.ndarray'>

print()
print("# 1.3、两个参数" + "-"*100)
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
print("# 1.4、" + "-"*100)
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
