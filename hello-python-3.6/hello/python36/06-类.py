#coding=utf-8

"""""""""""""""""""""类"""""""""""""""""""""
class Student(object):

    def learn(self):
        print('learn')
    
    def __init__(self, name, age):
        self.name = name
        self.age = age
        
    def __del__(self):
        print('对象被删除')
 
    def __new__(cls, *args, **kwargs):
        print('对象被创建')
        #return object.__new__(cls, *args, **kwargs) #报错 TypeError: object() takes no parameters
        return object.__new__(cls)
#---------------------------
s = Student('pyhton', 18)
print(s) 
     
# s.__init__('pyhton', 18)
# Traceback (most recent call last):
#   File "D:\develop\workspaces\eclipse\hello\hello-python\06-类.py", line 16, in <module>
#     s = Student()
# TypeError: __init__() missing 2 required positional arguments: 'name' and 'age'
 
print(s)
print(s.name)
print(s.age)  
print(s.learn())  

s.name = 'java'
s.age = 20

print(s)
print(s.name)
print(s.age)  
print(s.learn())    

print('删除对象s')
del s

print('程序结束')



 