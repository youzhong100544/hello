# demo-python 3.6
# coding=utf-8

# 注意在python2中print不是函数，不能通过help获得相关信息
# print在python3中是一个内建函数
print('demo - python 3.6')
print("你好，3.6")


print('-------------------------------------------------------')

def demo_print():
	print("demo_print")

def demo_print_arg(str):
	print("demo_print_arg: " + str)


# 加法
def demo_add(a, b):
	return a, "+", b, a+b
# 减法
def demo_subtraction(a, b):
	return a, '-', b, a-b
# 乘法
def demo_multiplication(a, b):
	return a, '*', b, a*b
# 除法
def demo_division(a, b):
	return a, '/', b, a/b


if __name__ == '__main__':
	demo_print()
	demo_print_arg('arg')

	add = demo_add(2, 5)
	print(add)

	subtraction = demo_subtraction(2, 5)
	print(subtraction)

	multiplication = demo_multiplication(2, 5)
	print(multiplication)

	division = demo_division(2, 5)
	print(division)

