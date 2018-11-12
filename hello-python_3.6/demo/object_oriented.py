# -*- coding: utf-8 -*-

'''
注意：通常你需要在单独的文件中定义一个类
'''

'''
面向对象技术简介
	类(Class): 用来描述具有相同的属性和方法的对象的集合。它定义了该集合中每个对象所共有的属性和方法。对象是类的实例。
	类变量：类变量在整个实例化的对象中是公用的。类变量定义在类中且在函数体之外。类变量通常不作为实例变量使用。
	数据成员：类变量或者实例变量, 用于处理类及其实例对象的相关的数据。
	方法重写：如果从父类继承的方法不能满足子类的需求，可以对其进行改写，这个过程叫方法的覆盖（override），也称为方法的重写。
	实例变量：定义在方法中的变量，只作用于当前实例的类。
	继承：即一个派生类（derived class）继承基类（base class）的字段和方法。继承也允许把一个派生类的对象作为一个基类对象对待。例如，有这样一个设计：一个Dog类型的对象派生自Animal类，这是模拟"是一个（is-a）"关系（例图，Dog是一个Animal）。
	实例化：创建一个类的实例，类的具体对象。
	方法：类中定义的函数。
	对象：通过类定义的数据结构实例。对象包括两个数据成员（类变量和实例变量）和方法。

创建类
	使用 class 语句来创建一个新类，class 之后为类的名称并以冒号结尾:

	class ClassName:
	   '类的帮助信息'   #类文档字符串
	   class_suite  #类体

	类的帮助信息可以通过ClassName.__doc__查看。
	class_suite 由类成员，方法，数据属性组成。
'''


class Student(object):

	'学生实体类' #类文档字符串

	count = 0

	def __init__(self, name, age=0):
		self.name = name
		self.age = age

		Student.count += 1

	def displayCount(self):
		print("总数 %s" % Student.count)

	def print_info(self):
		print('姓名：%s - 年龄：%s' % (self.name, self.age))


'''
	count 变量是一个类变量，它的值将在这个类的所有实例之间共享。你可以在内部类或外部类使用 Student.count 访问。
	
	第一种方法__init__()方法是一种特殊的方法，被称为类的构造函数或初始化方法，当创建了这个类的实例时就会调用该方法
	
	self 代表类的实例，self 在定义类的方法时是必须有的，虽然在调用时不必传入相应的参数。
	
'''

'''
	self代表类的实例，而非类
	
	类的方法与普通的函数只有一个特别的区别——它们必须有一个额外的第一个参数名称, 按照惯例它的名称是 self。
	
	class Test:
		def prt(self):
			print(self)
			print(self.__class__)
	
	t = Test()
	t.prt()
	
	以上实例执行结果为：
	<__main__.Test instance at 0x10d066878>
	__main__.Test
	
	
	从执行结果可以很明显的看出，self 代表的是类的实例，代表当前对象的地址，而 self.class 则指向类。
	
	self 不是 python 关键字，我们把他换成 runoob 也是可以正常执行的:

	class Test:
	    def prt(runoob):
	        print(runoob)
	        print(runoob.__class__)
	 
	t = Test()
	t.prt()
	
	以上实例执行结果为：
	
	<__main__.Test instance at 0x10d066878>
	__main__.Test
'''


'''
创建实例对象

	实例化类其他编程语言中一般用关键字 new，但是在 Python 中并没有这个关键字，类的实例化类似函数调用方式。
	
	以下使用类的名称 Employee 来实例化，并通过 __init__ 方法接收参数。
	
	"创建 Student 类的第一个对象"
	s1 = Student("Zara", 20)
	"创建 Student 类的第二个对象"
	s2 = Student("Manni", 50)
	
'''
s1 = Student("Zara", 20)
s2 = Student("Manni", 50)


'''
访问属性

	您可以使用点号 . 来访问对象的属性。使用如下类的名称访问类变量:
	
	s2.print_info()
	s2.print_info()
	print "Total Student %d" % Student.Count
'''

s1.print_info()
s2.print_info()
print("Total Student %d" % Student.count)


'''
姓名：Zara - 年龄：20
姓名：Manni - 年龄：50
Total Student 2
'''

'''
你可以添加，删除，修改类的属性，如下所示：

	s1.age = 7  # 添加一个 'age' 属性
	s1.age = 8  # 修改 'age' 属性
	del s1.age  # 删除 'age' 属性
'''
s1.age = 7  # 添加一个 'age' 属性
s1.age = 8  # 修改 'age' 属性
del s1.age  # 删除 'age' 属性

# 删除的属性
# s1.print_info()
# File "C:/develop/workspace/idea/hello/hello-python-3.6/demo/object_oriented.py", line 141, in <module>
# AttributeError: 'Student' object has no attribute 'age'


'''
你也可以使用以下函数的方式来访问属性：

	getattr(obj, name[, default]) : 访问对象的属性。
	hasattr(obj,name) : 检查是否存在一个属性。
	setattr(obj,name,value) : 设置一个属性。如果属性不存在，会创建一个新属性。
	delattr(obj, name) : 删除属性。
	
	hasattr(emp1, 'age')    # 如果存在 'age' 属性返回 True。
	getattr(emp1, 'age')    # 返回 'age' 属性的值
	setattr(emp1, 'age', 8) # 添加属性 'age' 值为 8
	delattr(emp1, 'age')    # 删除属性 'age'
'''
hasattr(s1, 'age')    # 如果存在 'age' 属性返回 True。
setattr(s1, 'age', 8) # 添加属性 'age' 值为 8
getattr(s1, 'age')    # 返回 'age' 属性的值

s1.print_info()

#delattr(s1, 'age')    # 删除属性 'age'
#s1.print_info()

'''
Python内置类属性
	__dict__ : 类的属性（包含一个字典，由类的数据属性组成）
	__doc__ :类的文档字符串
	__name__: 类名
	__module__: 类定义所在的模块（类的全名是'__main__.className'，如果类位于一个导入模块mymod中，那么className.__module__ 等于 mymod）
	__bases__ : 类的所有父类构成元素（包含了一个由所有父类组成的元组）
'''

print("Student.__doc__:", Student.__doc__)
print("Student.__name__:", Student.__name__)
print("Student.__module__:", Student.__module__)
print("Student.__bases__:", Student.__bases__)
print("Students.__dict__:", Student.__dict__)

'''
Student.__doc__: 学生实体类
Student.__name__: Student
Student.__module__: __main__
Student.__bases__: (<class 'object'>,)
Students.__dict__: {'__module__': '__main__', '__doc__': '学生实体类', 'count': 2, '__init__': <function Student.__init__ at 0x00000292CD269A60>, 'displayCount': <function Student.displayCount at 0x00000292CD269AE8>, 'print_info': <function Student.print_info at 0x00000292CD269B70>, '__dict__': <attribute '__dict__' of 'Student' objects>, '__weakref__': <attribute '__weakref__' of 'Student' objects>}
'''

'''
python对象销毁(垃圾回收)
Python 使用了引用计数这一简单技术来跟踪和回收垃圾。

在 Python 内部记录着所有使用中的对象各有多少引用。
一个内部跟踪变量，称为一个引用计数器。

当对象被创建时， 就创建了一个引用计数， 当这个对象不再需要时， 也就是说， 这个对象的引用计数变为0 时， 它被垃圾回收。
但是回收不是"立即"的， 由解释器在适当的时机，将垃圾对象占用的内存空间回收。

a = 40      # 创建对象  <40>
b = a       # 增加引用， <40> 的计数
c = [b]     # 增加引用.  <40> 的计数

del a       # 减少引用 <40> 的计数
b = 100     # 减少引用 <40> 的计数
c[0] = -1   # 减少引用 <40> 的计数
垃圾回收机制不仅针对引用计数为0的对象，同样也可以处理循环引用的情况。
循环引用指的是，两个对象相互引用，但是没有其他变量引用他们。
这种情况下，仅使用引用计数是不够的。Python 的垃圾收集器实际上是一个引用计数器和一个循环垃圾收集器。
作为引用计数的补充， 垃圾收集器也会留心被分配的总量很大（及未通过引用计数销毁的那些）的对象。 
在这种情况下， 解释器会暂停下来， 试图清理所有未引用的循环。

'''

'''
析构函数 __del__ ，__del__在对象销毁的时候被调用，当对象不再被使用时，__del__方法运行：
'''

class Point:
   def __init__( self, x=0, y=0):
      self.x = x
      self.y = y
   def __del__(self):
      class_name = self.__class__.__name__
      print(class_name, "销毁")

pt1 = Point()
pt2 = pt1
pt3 = pt1
print(id(pt1), id(pt2), id(pt3)) # 打印对象的id
del pt1
del pt2
del pt3

'''
1547557833360 1547557833360 1547557833360
Point 销毁
'''


'''
注意：通常你需要在单独的文件中定义一个类
'''
