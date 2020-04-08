# -*- coding: UTF-8 -*-\
import os
import platform
import subprocess

"""
Python中执行系统命令常见的几种方法
"""

"""
可以执行shell命令的相关模块和函数有：

os.system
os.spawn
os.popen --废弃
popen2.* --废弃
commands.* --废弃，3.x中被移除
"""

"""
(1) os.system
仅仅在一个子终端运行系统命令，而不能获取命令执行后的返回信息
如果再命令行下执行，结果直接打印出来
"""
system = os.system('ls')
print(system)

print("|" * 50)

"""
(2) os.popen
该方法不但执行命令还返回执行后的信息对象
好处在于：将返回的结果赋于一变量，便于程序的处理。
"""
popen = os.popen('ls')
print(popen)
readlines = popen.readlines()
print(readlines)

print("|" * 50)

"""
(3) 使用模块subprocess
Subprocess是一个功能强大的子进程管理模块，是替换os.system ,os.spawn* 等方法的一个模块。
"""
subprocess_popen = subprocess.Popen('ls', shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
print(subprocess_popen)

stdout_readlines = subprocess_popen.stdout.readlines()
print(stdout_readlines)

for line in stdout_readlines:
    print(line)

# return_value = subprocess_popen.wait()


print("|" * 50)



"""
Python中判断当前系统是Windows、Linux还是Mac，以及获得对应的系统版本信息

参考博文
    Python中判断当前系统是Windows还是Linux（Ubuntu等）还是Mac，以及获得对应的系统版本信息
    https://www.crifan.com/python_get_current_system_os_type_and_version_info/
"""
machine = platform.machine()
print("platform.machine()=", machine)

print("platform.machine()=%s" % (platform.machine()))

print("platform.node()=%s" % platform.node())
print("platform.platform()=%s" % platform.platform())
print("platform.processor()=%s" % platform.processor())
print("platform.python_build()=%s", platform.python_build())
print("platform.python_compiler()=%s" % platform.python_compiler())
print("platform.python_branch()=%s" % platform.python_branch())
print("platform.python_implementation()=%s" % platform.python_implementation())
print("platform.python_revision()=%s" % platform.python_revision())
print("platform.python_version()=%s" % platform.python_version())
print("platform.python_version_tuple()=%s", platform.python_version_tuple())

print("platform.system()=%s" % platform.system())
print("platform.release()=%s" % platform.release())
print("platform.version()=%s" % platform.version())

print("platform.uname()=%s", platform.uname())


alias = platform.system_alias(platform.system(), platform.release(), platform.version())
print(type(alias))
print(isinstance(alias, tuple))

print("platform.system_alias()=", alias)

# Python判断类型，基本类型主要使用type() ,  对象类型使用  instance()
