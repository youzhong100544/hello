# -*- coding: utf-8 -*-

ls = [12.433, 123, True, 4+3j, 'mpp', 'b', 3]
print("ls:" + str(ls))

print(type(ls[0]), type(ls[1]), type(ls[2]), type(ls[3]), type(ls[4]), type(ls[5]))

print(ls[0])
print(ls[1])
print(ls[-1])
print(ls[-3])

print()

print("#" * 100)
print("# 取值")
print("#" * 100)


print("#" * 100)
print("# 遍历")
print("#" * 100)

print("ls:" + str(ls))
print()

print("# 方式一：")
for i in ls:
    print(i)

print("-" * 100)

print("ls:" + str(ls))
print()

print("# 方式二：")
for i in range(len(ls)):
    print(ls[i])


print("#" * 100)
print("# 切片")
print("#" * 100)
print("ls:" + str(ls))
print()

# 切片是取值的一种方式
print(ls[2:])#末尾不写，一直取到结束
print(ls[:5])#如果切片前面值不写，从开头取
print(ls[2:5])#取角标2到5的元素，含头不含尾
print(ls[2:5:2])#取角标2到5的元素，步长为2
print(ls[0:-1])#
print(ls[1:-1])#
print(ls[-2:-5:-2])#从后向前(从右向左)切片
print(ls[:])#都不写，取全部


print("#" * 100)
print("# 合并")
print("#" * 100)
print("ls:" + str(ls))
print()