#coding=utf-8

"""""""""""""""""""""函数"""""""""""""""""""""
print(max(1, 2))

# 数据类型转换
# Python内置的常用函数还包括数据类型转换函数，比如int()函数可以把其他数据类型转换为整数：
a = int('123')
print(a)
print(str(1.23))
print(str(100))
print(bool(1))
print(bool(''))

# 定义函数 ====================================================

# 空函数 ====================================================
# 如果想定义一个什么事也不做的空函数，可以用pass语句：
def nop():
    pass

# pass语句什么都不做，那有什么用？实际上pass可以用来作为占位符，比如现在还没想好怎么写函数的代码，就可以先放一个pass，让代码能运行起来。
# pass还可以用在其他语句里，比如：
age = 19
if age >= 18:
    pass

# 缺少了pass，代码运行就会有语法错误。

"""
返回多个值
"""
# 函数可以返回多个值吗？答案是肯定的。
# 比如在游戏中经常需要从一个点移动到另一个点，给出坐标、位移和角度，就可以计算出新的新的坐标：

import math

def move(x, y, step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx, ny
# 调用
x, y = move(100, 100, 60, math.pi / 6)
print(x, y)

# 但其实这只是一种假象，Python函数返回的仍然是单一值：
r = move(100, 100, 60, math.pi / 6)
print(r)


def power(x):
    return x * x

print(power(5))

def power(x, n):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s
print(power(5,3))
# print(power(5))
# TypeError: power() missing 1 required positional argument: 'n'

# 新的power(x, n)函数定义没有问题，但是，旧的调用代码失败了，原因是我们增加了一个参数，导致旧的代码因为缺少一个参数而无法正常调用：
# Python的错误信息很明确：调用函数power()缺少了一个位置参数n。
# 这个时候，默认参数就排上用场了。由于我们经常计算x2，所以，完全可以把第二个参数n的默认值设定为2：

def power(x, n = 2):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s
print(power(5))



"""""""""""""""""""""变量"""""""""""""""""""""
print('变量')

a = 400 # """全局变量"""
names = ['jeck', 'rose'] # """全局变量"""
def test(a):
    return a + 100
print(test(200)) # 输出 300
print(a)# 输出 400
print('-----------------------------')
def test1():
    a = 300
    return a + 100
print(test1()) # 输出 400
print(a)# 输出 400
print('-----------------------------')
def test2():
    global a
    a = 300
    
    names.append("object")
    print(names) # 输出['jeck', 'rose', 'object']
    return a + 100
print(test2()) # 输出 400
print(a)# 输出300
print(names) # 输出['jeck', 'rose', 'object']
print('-----------------------------')

"""可变参数""" #=========
def test3(a, *b): 
    return a ,b

print(test3(1)) # 输出(1, ())
print(test3(1,2,3)) # 输出(1, (2, 3))
print(test3(1,2,3,4,5)) # 输出(1, (2, 3, 4, 5))
print(test3(1,2,[3,4,5])) # 输出(1, (2, [3, 4, 5]))



"""匿名函数""" #=========
def test4(a, b): 
    return a + b
def test5(a, b): 
    return a * b
def test6(a, b, func): 
    return func(a, b)

      
print(test6(6, 2, lambda x,y : x + y)) # 输出8

print(test6(6, 2, test5))# 输出12
