# -*- coding: utf-8 -*-

import math

print(dir(math))

# 1、取大于等于 x 的最小的整数值，如果 x 是一个整数，则返回 x
print("# 1、取大于等于x的最小的整数值，如果x是一个整数，则返回x")
print(math.ceil(4.12))      # 5
print(math.ceil(4.722))     # 5
print(math.ceil(4.02231))   # 5
print(math.ceil(4))         # 4
print()

# 2、把 y 的正负号加到 x 前面，可以使用0
print("# 2、把 y 的正负号加到 x 前面，可以使用0")
print(math.copysign(2, -3))     # -2.0
print(math.copysign(-2, 3))     # 2.0
print(math.copysign(10, -0))    # 10.0
print(math.copysign(-10, 0))    # 10.0
print(math.copysign(-0, 0))     # 0.0
print(math.copysign(0, -0))     # 0.0
print()

# 3、求x的余弦，x必须是弧度
print(math.cos(math.pi/4))

# 4、把x从弧度转换成角度
print(math.degrees(math.pi/4))

# 5、e表示一个常量
print(math.e)

# 6、exp()返回math.e(其值为2.71828)的x次方
print(math.exp(2))

# 7、expm1()返回math.e的x(其值为2.71828)次方的值减１
print(math.expm1(2))

# 8、fabs()返回x的绝对值
print(math.fabs(-0.03))

# 9、factorial()取x的阶乘的值
print(math.factorial(3))

# 10、floor()取小于等于x的最大的整数值，如果x是一个整数，则返回自身
print(math.floor(4.999))

# 11、fmod()得到x/y的余数，其值是一个浮点数
print(math.fmod(20,3))

# 12、frexp()返回一个元组(m,e),其计算方式为：x分别除0.5和1,得到一个值的范围，2e的值在这个范围内，e取符合要求的最大整数值,然后x/(2e),得到m的值。如果x等于0,则m和e的值都为0,m的绝对值的范围为(0.5,1)之间，不包括0.5和1
print(math.frexp(75))

# 13、对迭代器里的每个元素进行求和操作
print(math.fsum((1,2,3,4)))

# 14、返回x和y的最大公约数
print(math.gcd(8,6))

# 15、得到(x2+y2),平方的值
print(math.hypot(3,4))

# 16、isfinite()如果x不是无穷大的数字,则返回True,否则返回False
print(math.isfinite(0.1))

# 17、isinf()如果x是正无穷大或负无穷大，则返回True,否则返回False
print(math.isinf(234))

# 18、isnan()如果x不是数字True,否则返回False
print(math.isnan(23))

# 19、ldexp()返回x*(2**i)的值
print(math.ldexp(5,5))

# 20、log(x,a) 如果不指定a，则默认以e为基数，a参数给定时，将 x 以a为底的对数返回。
print(math.log(math.e))
print(math.log(32,2))

# 21、log10()返回x的以10为底的对数
print(math.log(10))

# 22、log2()返回x的基2对数
print(math.log2(32))

# 23、modf()返回由x的小数部分和整数部分组成的元组
print(math.modf(math.pi))

# 24、pi:数字常量，圆周率
print(math.pi)

# 25、pow()返回x的y次方，即x**y
print(math.pow(3,4))

# 26、radians()把角度x转换成弧度
print(math.radians(45))

# 27、sin()求x(x为弧度)的正弦值
print(math.sin(math.pi/4))

# 28、sqrt()求x的平方根
print(math.sqrt(100))

# 29、tan()返回x(x为弧度)的正切值
print(math.tan(math.pi/4))

# 30、trunc()返回x的整数部分
print(math.trunc(6.789))
