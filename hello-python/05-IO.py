#coding=utf-8

"""""""""""""""""""""IO"""""""""""""""""""""
print('IO')

#path = 'C:\\Users\\dell\\Desktop\\hello.txt'
path = r'C:\Users\dell\Desktop\hello.txt'
"""
r 标识不转义字符串
"""

"""
# 文件读写 ===============================================================================
"""
f = open(path, 'r')
# f.read()
r = f.read()
print(r)
f.close()
print('---------------------------')
# 由于文件读写时都有可能产生IOError，一旦出错，后面的f.close()就不会调用。所以，为了保证无论是否出错都能正确地关闭文件，我们可以使用try ... finally来实现：
print('try---------------------------')
try:
    f = open(path, 'r')
    print(f.read())
except (IOError,Exception) as e:
    print('except:', e)
finally:
    print('finally...')
    if f:
        f.close()
print('END')

