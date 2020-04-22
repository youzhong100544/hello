#coding=utf-8

import re

# line = "werq阿迪舒服5800万人民币"
# line = "werq阿2323迪舒服5800万人民币"

line = "0.231万人民币"
reg = "-?\d+(.\d+)?"

matchObj = re.search(reg, line, re.M | re.I)

print(matchObj.group())

print()
print("|"*100)
print()

line1 = "0.231元/万元"
reg1 = "-?\d+(.\d+)?(万人民币|万|元/万元|万元)"

matchObj1 = re.search(reg1, line1, re.M | re.I)

print(matchObj1.group())

print()
print("|"*100)
print()

print("正则替换")



strinfo = re.compile(reg)
d4 = strinfo.sub('', line)
print(d4)


print()
print("|"*100)
print()


line2 = "0.231元/英镑"
reg2 = "(英镑|澳大利亚元|香港元|港币|美元|港币)+"
matchObj2 = re.search(reg2, line2, re.M | re.I)
print(matchObj2.group())

