# -*- coding: utf-8 -*-

"""""""""""""""""""""高级特性"""""""""""""""""""""
print('高级特性')
"""
# 切片 ===============================================================================
"""
list = [1,2,3,4,5]
print(list)
# 取一个list或tuple的部分元素是非常常见的操作。比如，一个list如下：
# 取前3个元素，应该怎么做？
# 笨办法：
print([list[0], list[1]], list[4])

# 之所以是笨办法是因为扩展一下，取前N个元素就没辙了。
# 取前N个元素，也就是索引为0-(N-1)的元素，可以用循环：
for i in list:
    print(i)
    
r = []
n = 3
for i in range(n):
    r.append(list[i])

print(r)

# 对这种经常取指定索引范围的操作，用循环十分繁琐，因此，Python提供了切片（Slice）操作符，能大大简化这种操作。
# 对应上面的问题，取前3个元素，用一行代码就可以完成切片：
print(list[0:2])
print(list[:2]) # 取前两个
print(list[-2:]) # 取后两个
print(list[-2:-1])
print(list[::2])

"""tuple也是一种list，唯一区别是tuple不可变。因此，tuple也可以用切片操作，只是操作的结果仍是tuple："""
print(('a','b','c','d','e')[-2:-1])
print(('a','b','c','d','e')[0:2])
print(('a','b','c','d','e')[::2])

"""
# 迭代 ===============================================================================
"""
# 如果给定一个list或tuple，我们可以通过for循环来遍历这个list或tuple，这种遍历我们称为迭代（Iteration）。
# 在Python中，迭代是通过for ... in来完成的

# Python的for循环不仅可以用在list或tuple上，还可以作用在其他可迭代对象上。
# list这种数据类型虽然有下标，但很多其他数据类型是没有下标的，但是，只要是可迭代对象，无论有无下标，都可以迭代，比如dict就可以迭代
d = {'a': 1, 'b': 2, 'c': 3}
for key in d:
    print(key)

# 因为dict的存储不是按照list的方式顺序排列，所以，迭代出的结果顺序很可能不一样。
# 默认情况下，dict迭代的是key。如果要迭代value，可以用for value in d.values()，
# 如果要同时迭代key和value，可以用for k, v in d.items()

for value in d.values():
    print(value)

for k, v in d.items():
    print(k, v)

for item in d.items():
    print(item)

# 由于字符串也是可迭代对象，因此，也可以作用于for循环：

for ch in 'ABC':
    print(ch)

"""
所以，当我们使用for循环时，只要作用于一个可迭代对象，for循环就可以正常运行，而我们不太关心该对象究竟是list还是其他数据类型。
那么，如何判断一个对象是可迭代对象呢？方法是通过collections模块的Iterable类型判断：
"""

from collections import Iterable

isinstance('abc', Iterable) # str是否可迭代
isinstance([1,2,3], Iterable) # list是否可迭代
isinstance(123, Iterable) # 整数是否可迭代

print(isinstance('abc', Iterable))
print(isinstance([1,2,3], Iterable))
print(isinstance(123, Iterable))

"""
# 如果要对list实现类似Java那样的下标循环怎么办？
# Python内置的enumerate函数可以把一个list变成索引-元素对，这样就可以在for循环中同时迭代索引和元素本身：
"""
name_list = ['tom', 'jerry', 'jeck', 'rose']
for i,v in enumerate(name_list):
    print(i,v)
    
for i in enumerate(name_list):
    print(i)



"""
# 列表生成式 ===============================================================================
"""
# 列表生成式即List Comprehensions，是Python内置的非常简单却强大的可以用来创建list的生成式。
# 举个例子，要生成list [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]可以用list(range(1, 11))：
#通过列表生成式可以生成格式各样的list,这种list 一般是容量小的list
#导入os模块，模块的概念后面讲到
import os
print(range(1, 11))
print(type(range(1,4)))
# 输出
#    range(1, 11)

# 在paython3中
# print(range(10))
# 得出的结果是 range(0,10) ，而不是[0,1,2,3,4,5,6,7,8,9] ，为什么呢？

# 官网原话：
# In many ways the object returned by range() behaves as if it is a list, but in fact it isn’t. It is an object which returns the successive items of the desired sequence when you iterate over it, but it doesn’t really make the list, thus saving space.
# We say such an object is iterable, that is, suitable as a target for functions and constructs that expect something from which they can obtain successive items until the supply is exhausted. We have seen that the for statement is such an iterator. The function list() is another; it creates lists from iterables:
# 翻译：
# 可以看到上面这个很奇怪，在很多种情况下，range()函数返回的对象的行为都很像一个列表，但是它确实不是一个列表，它只是在迭代的情况下返回指定索引的值，但是它并不会在内存中真正产生一个列表对象，这样也是为了节约内存空间。
# 我们称这种对象是可迭代的，或者是可迭代对象，还有一种对象叫迭代器，它们需要从一个可迭代对象中连续获取指定索引的值，一直到索引结束。list()函数就是这样一个迭代器，它可以把range()函数返回的对象变成一个列表。
# 总结：
# range() 函数返回的是一个可迭代对象（类型是对象），而不是列表类型， 所以打印的时候不会打印列表。
# list() 函数是对象迭代器，把对象转为一个列表。返回的变量类型为列表。


for x in range(1, 11):
    print(x)
    
list_range = [ x for x in range(1, 11)]
print(list_range)

# for循环后面还可以加上if判断，这样我们就可以筛选出仅偶数的平方：
print([x * x for x in range(1, 11) if x % 2 == 0])
# 还可以使用两层循环，可以生成全排列
print([m + n for m in 'ABC' for n in 'XYZ'])


"""
# 生成器 ===============================================================================
"""
L = [x * x for x in range(10)]
print(L)
# 输出
#    [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]
g = (gx * gx for gx in range(10))
print('g = ',g)
# 输出
#    <generator object <genexpr> at 0x00000000028301A8>
"""
创建L和g的区别仅在于最外层的[]和()，L是一个list，而g是一个generator。
我们可以直接打印出list的每一个元素，但我们怎么打印出generator的每一个元素呢？
如果要一个一个打印出来，可以通过next()函数获得generator的下一个返回值：
"""
print('next' ,next(g))
print('next' ,next(g))
print('next' ,next(g))
for i in g:
    print(i)

# 著名的斐波拉契数列（Fibonacci），除第一个和第二个数外，任意一个数都可由前两个数相加得到：
def fib(max):
    if max == 1:
        return 1
    elif max == 2:
        return 1
    elif max > 2:
        return fib(max-1)+ fib(max-2)
    else:
        return None

print('fib = ' ,fib(7))
print('----------------------------------')
def print_fib(max):
    n,a,b = 0, 0, 1
    while n < max:
        print(b)
        c = a
        a = b
        b = c + b
        
        n = n + 1
    return 'done'

print('print_fib = ' ,print_fib(7))
print('----------------------------------')

def print_fib_(max):
    n, a, b = 0, 0, 1
    while n < max:
        print(b)
        a, b = b, a + b
        n = n + 1
    return 'done'
print('print_fib_ = ' ,print_fib_(7))
print('----------------------------------')

"""
注意，赋值语句：
a, b = b, a + b
相当于：
"""
"""# 第191行 == 177~179行"""
# t = (b, a + b) # t是一个tuple
# a = t[0]
# b = t[1]

"""
仔细观察，可以看出，fib函数实际上是定义了斐波拉契数列的推算规则，可以从第一个元素开始，推算出后续任意的元素，这种逻辑其实非常类似generator。
也就是说，上面的函数和generator仅一步之遥。要把fib函数变成generator，只需要把print(b)改为yield b就可以了：
"""
def yield_fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b = b, a + b
        n = n + 1
    return 'done'
# 这就是定义generator的另一种方法。如果一个函数定义中包含yield关键字，那么这个函数就不再是一个普通函数，而是一个generator：
y = yield_fib(6)
print(y)
# 输出
#     <generator object yield_fib at 0x0000000002850308>
for yf in y:
    print(yf)

"""
# 迭代器 ===============================================================================================================================================
"""
# 我们已经知道，可以直接作用于for循环的数据类型有以下几种：
# 一类是集合数据类型，如list、tuple、dict、set、str等；
# 一类是generator，包括生成器和带yield的generator function。
# 这些可以直接作用于for循环的对象统称为可迭代对象：Iterable。
# 可以使用isinstance()判断一个对象是否是Iterable对象：
from collections import Iterable

isinstance([], Iterable)
isinstance({}, Iterable)
isinstance('abc', Iterable)
isinstance((x for x in range(10)), Iterable)
isinstance(100, Iterable)


print(isinstance([], Iterable)) #True
print(isinstance({}, Iterable)) #True
print(isinstance('abc', Iterable)) #True
print(isinstance((x for x in range(10)), Iterable)) #True
print(isinstance(100, Iterable)) #False

"""
而生成器不但可以作用于for循环，还可以被next()函数不断调用并返回下一个值，直到最后抛出StopIteration错误表示无法继续返回下一个值了。
可以被next()函数调用并不断返回下一个值的对象称为迭代器：Iterator。
可以使用isinstance()判断一个对象是否是Iterator对象：
"""
from collections import Iterator

isinstance((x for x in range(10)), Iterator)
isinstance([], Iterator)
isinstance({}, Iterator)
isinstance('abc', Iterator)

print(isinstance((x for x in range(10)), Iterator)) #True
print(isinstance([], Iterator)) #False
print(isinstance({}, Iterator)) #False
print(isinstance('abc', Iterator)) #False

"""
生成器都是Iterator对象，但list、dict、str虽然是Iterable，却不是Iterator。
把list、dict、str等Iterable变成Iterator可以使用iter()函数：
"""
print(isinstance(iter([]), Iterator)) #True
print(isinstance(iter('abc'), Iterator)) #True

"""
这是因为Python的Iterator对象表示的是一个数据流，Iterator对象可以被next()函数调用并不断返回下一个数据，直到没有数据时抛出StopIteration错误。可以把这个数据流看做是一个有序序列，但我们却不能提前知道序列的长度，只能不断通过next()函数实现按需计算下一个数据，所以Iterator的计算是惰性的，只有在需要返回下一个数据时它才会计算。
Iterator甚至可以表示一个无限大的数据流，例如全体自然数。而使用list是永远不可能存储全体自然数的。
"""


