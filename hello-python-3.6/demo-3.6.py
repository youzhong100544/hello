# demo-python 3.6
# coding=utf-8

# 注意在python2中print不是函数，不能通过help获得相关信息
# print在python3中是一个内建函数
print('demo - python 3.6')
print("你好，3.6")


print('-------------------------------------------------------')

def demo_print():
    print ("demo_print")

def demo_print_arg(str):
    print ("demo_print_arg: " + str)


if __name__ == '__main__':
    demo_print()
    demo_print_arg('arg')

