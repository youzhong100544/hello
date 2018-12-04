# -*- coding: utf-8 -*-

# List 的内置方法
li = [1, 2, 3, 4]
print(li)
li_1 = list([1, 2, 3, 4])  # 接收一个iterable，可迭代即可
print(li[0])  # 可以使用下标访问元素

# Demo1 append 从list的尾部添加一个元素
print(li)
li.append("aabb")
print(li)
# [1, 2, 3, 4, 'aabb']

li.append(1234)
print(li)
# [1, 2, 3, 4, 'aabb', 1234]

# Demo2 clear 清空list内所有元素
print(li)
# [1, 2, 3, 4, 'aabb', 1234]

li.clear()
print(li)
# [] 空list

# Demo3 copy 值拷贝（浅拷贝）
l3 = [[1, 2], "aa", [3, 4]]
print(l3)
# [[1, 2], 'aa', [3, 4]]

li = l3.copy()
print(li)
# [[1, 2], 'aa', [3, 4]]

for i in li:
    print(id(i))
# 4326966920
# 4326703824
# 4326967048

for i in l3:
    print(id(i))
# 4326966920
# 4326703824
# 4326967048

# Demo4 count 返回指定字符或者字符串在list内的个数
li.append('aa')
print(li)
# [[1, 2], 'aa', [3, 4]]

print(li.count('aa'))
# 2
print(li.count(123))
# 0

# Demo5 extend 把一个iterable内所有元素加入到list，append是把一个iterable作为一个元素添加到list
print(li)
# [[1, 2], 'aa', [3, 4], 'aa']

li.extend([1, 2, 3, 4])
print(li)
# [[1, 2], 'aa', [3, 4], 'aa', 1, 2, 3, 4]

# Demo6 index 返回第一个指定元素的下标（第一个出现的）
print(li)
# [[1, 2], 'aa', [3, 4], 'aa', 1, 2, 3, 4]

print(li.index('aa'))
# 1

print(li.index('aa', 2, 6))  # 包含第一个位置，不包含最后一个位置
# 3

# Demo 7 insert 在指定位置前插入数据
li = [1, 2, 3, 4]
print(li)
# [1, 2, 3, 4]

li.insert(2, 999)
print(li)
# [1, 2, 999, 3, 4]

# Demo 8 pop 删除最后一个元素，并且返回所删除的元素
# 参数可以指定位置，如果不设置默认为最后一个元素
print(li)
# [1, 2, 999, 3, 4]

print(li.pop())
# 4

print(li)
# [1, 2, 999, 3]

# Demo 9 remove 删除第一次出现的指定元素，如果找不到，就报错
print(li)
# [1, 2, 999, 3]

li.remove(999)
print(li)
# [1, 2, 3]

# li.remove('a')
# ValueError: list.remove(x): x not in list

# Demo10 reverse 反转list的元素
print(li)
# [1, 2, 3]

li.reverse()
print(li)
# [3, 2, 1]

# Demo 11 sort
li = [1, 99, 2, 33, 0, 55, 66]
li.sort()
print(li)
# [0, 1, 2, 33, 55, 66, 99]

li.sort(reverse=True)
print(li)
# [99, 66, 55, 33, 2, 1, 0]

# 假设一个数据，为姓名，性别，年龄的tuple，我需要按照年龄来排序
# 通过key这个参数设置一个lamda表达式，获取list每一个元素，然后取出index=2的元素，进行排序
li = [('jack', 'male', 18), ('tom', 'male', 20), ('alice', 'female', 12)]
li.sort(key=lambda x: x[2])
print(li)

