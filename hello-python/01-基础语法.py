# -*- coding: utf-8 -*-
from click._compat import raw_input

# 基础语法

# Python注释  ==============================================================================================
# python中单行注释采用 # 开头。
# ※※※且只有单行注释※※※

# 第一个注释
print ('Hello, Python!')  # 第二个注释



# Python 标识符  ==============================================================================================

# 在 Python 里，标识符由字母、数字、下划线组成。
# 在 Python 中，所有标识符可以包括英文、数字以及下划线(_)，但不能以数字开头。
# Python 中的标识符是区分大小写的。
# 以下划线开头的标识符是有特殊意义的。以单下划线开头 _foo 的代表不能直接访问的类属性，需通过类提供的接口进行访问，不能用 from xxx import * 而导入；
# 以双下划线开头的 __foo 代表类的私有成员；以双下划线开头和结尾的 __foo__ 代表 Python 里特殊方法专用的标识，如 __init__() 代表类的构造函数。



# 同一行显示多条语句   ==============================================================================================

# Python 可以同一行显示多条语句，方法是用分号 ; 分开，如：
print('hello'); print("world"); print("""python""")
# 输出
# hello
# world
# pythonn

import sys; x = 'hello'; sys.stdout.write(x + '\n'); y = 'python!!'; sys.stdout.write(y + '\n')
# 输出
# hello
# python!!



# Python 保留字符  ==============================================================================================

# 下面的列表显示了在Python中的保留字。这些保留字不能用作常数或变数，或任何其他标识符名称。
# 所有 Python 的关键字只包含小写字母。
# and         exec        not
# assert      finally     or
# break       for         pass
# class       from        print
# continue    global      raise
# def         if          return
# del         import      try
# elif        in          while
# else        is          with
# except      lambda      yield



# 行和缩进  ======================================================================================================

# 学习 Python 与其他语言最大的区别就是，Python 的代码块不使用大括号 {} 来控制类，函数以及其他逻辑判断。python 最具特色的就是用缩进来写模块。



# 多行语句  ======================================================================================================

# Python语句中一般以新行作为为语句的结束符。
# 但是我们可以使用斜杠（ \）将一行的语句分为多行显示，如下所示：
item_one = 10
item_two = 20
item_three = 30

total = item_one + \
        item_two + \
        item_three
print(total)
# 输出
# 60

# 语句中包含 [], {} 或 () 括号就不需要使用多行连接符。如下实例：
days = ['Monday', 'Tuesday', 'Wednesday',
        'Thursday', 'Friday']
print(days)
# 输出
# ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday']



# 输入输出  ======================================================================================================
# 输入
# 如果要让用户从电脑输入一些字符怎么办？
# Python 提供了一个 input() ，可以让用户输入字符串，并存放到一个变量里

# python2.X
# python2.X 版本中提供了两个方法raw_input() 和 input()
# 函数的小括号中放入的是，提示信息，用来在获取数据之前给用户的一个简单提示
# 函数在从键盘获取了数据以后，会存放到等号右边的变量中

# 区别嘛，就是raw_input()随便输都是字符串，而input()必须按照Python的规则来，其接受的输入作为是表达式

name = raw_input("请输出姓名：")
age = raw_input("请输出年龄：")
print("姓名：%s" %(name))
print("年龄：%s" %age)

name = input("请输出姓名：")
age = input("请输出年龄：")
age_str = str(age)
height = input("请输出身高：")
height_str = str(height)
print("姓名：%s" %name)
#print("年龄：%d" %age) # TypeError: %d format: a number is required, not str
print("年龄：%s" %age)

# python3.X
# python3.X 版本中,没有 raw_input() 函数，只有 input(); 并且 python3 中的 input 与 python2 中的 raw_input() 功能一样



# 输出






