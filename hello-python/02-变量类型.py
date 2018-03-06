#coding=utf-8

"""""""""""""""""""""变量类型"""""""""""""""""""""
from anaconda_project.internal.keyring import set
"""
变量存储在内存中的值。这就意味着在创建变量时会在内存中开辟一个空间。
基于变量的数据类型，解释器会分配指定内存，并决定什么数据可以被存储在内存中。
因此，变量可以指定不同的数据类型，这些变量可以存储整数，小数或字符。
"""

"""
# 变量赋值================================================================================
"""
# Python 中的变量赋值不需要类型声明。
# 每个变量在内存中创建，都包括变量的标识，名称和数据这些信息。
# 每个变量在使用前都必须赋值，变量赋值以后该变量才会被创建。
# 等号（=）用来给变量赋值。
# 等号（=）运算符左边是一个变量名,等号（=）运算符右边是存储在变量中的值。例如：
counter = 100 # 赋值整型变量
miles = 1000.0 # 浮点型
name = "John" # 字符串
 
print(counter)
print(miles)
print(name)

# 多个变量赋值
# Python允许你同时为多个变量赋值。例如：
a = b = c = 1
print(a, b, c)
# 以上实例，创建一个整型对象，值为1，三个变量被分配到相同的内存空间上。
# 您也可以为多个对象指定多个变量。例如：

a, b, c = 1, 2, "john"
print(a, b, c)

"""
# 标准数据类型================================================================================
"""
"""
Python 定义了一些标准类型，用于存储各种类型的数据。
Python有五个标准的数据类型：
    Numbers（数字）
    String（字符串）
    List（列表）
    Tuple（元组）
    Dictionary（字典）
"""
"""
Python3 中有六个标准的数据类型：
    Number（数字）
    String（字符串）
    List（列表）
    Tuple（元组）
    Sets（集合）
    Dictionary（字典）
"""

# Number（数字）==============================================
"""
Python支持四种不同的数字类型：
    int（有符号整型）
    long（长整型[也可以代表八进制和十六进制]）
    float（浮点型）
    complex（复数）
"""
"""
Python3 支持 int、float、bool、complex（复数）。
在Python 3里，只有一种整数类型 int，表示为长整型，没有 python2 中的 Long。
"""

# 数字数据类型用于存储数值。
# 他们是不可改变的数据类型，这意味着改变数字数据类型会分配一个新的对象。
# 当你指定一个值时，Number对象就会被创建：
var1 = 1
var2 = True
var3 = 15.20 
var4 = 45.j
print(type(var1), type(var2), type(var3), type(var4))
print(isinstance(var1, int))
# 您也可以使用del语句删除一些对象的引用。
# del语句的语法是：
# del var1[,var2[,var3[....,varN]]]]
# 您可以通过使用del语句删除单个或多个对象的引用。例如：

del var1
del var2, var3
# print(var1, var2, var3)

# String（字符串）==============================================
str = 'python'
print (str[0:-1])    # 输出第一个到倒数第二个的所有字符
print (str[0])       # 输出字符串第一个字符
print (str[2:5])     # 输出从第三个开始到第五个的字符
print (str[2:])      # 输出从第三个开始的后的所有字符
print (str * 2)      # 输出字符串两次
print (str + "TEST") # 连接字符串

# Python 使用反斜杠(\)转义特殊字符，如果你不想让反斜杠发生转义，可以在字符串前面添加一个 r，表示原始字符串：
print('Ru\noob')
print(r'Ru\noob')



# List（列表）==============================================
list = [1,'abd', [3,'2f']]
tinylist = [123, 'runoob']
 
print (list)            # 输出完整列表
print (list[0])         # 输出列表第一个元素
print (list[1:3])       # 从第二个开始输出到第三个元素
print (list[2:])        # 输出从第三个元素开始的所有元素
print (tinylist * 2)    # 输出两次列表
print (list + tinylist) # 连接列表

print (list.append('append'))


# Tuple（元组）==============================================
tuple = ( 'abcd', 786 , 2.23, 'runoob', 70.2  )
tinytuple = (123, 'runoob')
 
print (tuple)             # 输出完整元组
print (tuple[0])          # 输出元组的第一个元素
print (tuple[1:3])        # 输出从第二个元素开始到第三个元素
print (tuple[2:])         # 输出从第三个元素开始的所有元素
print (tinytuple * 2)     # 输出两次元组
print (tuple + tinytuple) # 连接元组

# Set（集合）==============================================
# 集合（set）是一个无序不重复元素的序列。
# 基本功能是进行成员关系测试和删除重复元素。
# 可以使用大括号 { } 或者 set() 函数创建集合，注意：创建一个空集合必须用 set() 而不是 { }，因为 { } 是用来创建一个空字典。
# 创建格式：
names = {'lemon','zw','lr', 'lr'}
print ('set-names =' ,names) 
print ('set-names add =' ,names.add('jerry'))

names_set = set('lemon','zw','lr')
print ('set-names_set =' ,names_set)

# set_1 = set(1,2,3)
# print ('set_1 =' ,set_1)

# set可以进行集合运算
# a = set('abracadabra')
# b = set('alacazam')
# print(a)
# print(a - b)     # a和b的差集
# print(a | b)     # a和b的并集
# print(a & b)     # a和b的交集
# print(a ^ b)     # a和b中不同时存在的元素


# Dictionary（字典）==============================================
dict = {}
dict['one'] = "1 - 菜鸟教程"
dict[2]     = "2 - 菜鸟工具"
 
tinydict = {'name': 'runoob','code':1, 'site': 'www.runoob.com'}
 
print (dict)
print (dict['one'])       # 输出键为 'one' 的值
print (dict[2])           # 输出键为 2 的值
print (tinydict)          # 输出完整的字典
print (tinydict.keys())   # 输出所有键
print (tinydict.values()) # 输出所有值

# 构造函数 dict() 可以直接从键值对序列中构建字典如下：
# dict_a = dict([('Runoob', 1), ('Google', 2), ('Taobao', 3)])
# print (dict_a)
#     dict_a = dict([('Runoob', 1), ('Google', 2), ('Taobao', 3)])
# TypeError: 'dict' object is not callable

