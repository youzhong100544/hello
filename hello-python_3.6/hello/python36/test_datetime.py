# -*- coding: UTF-8 -*-

import datetime as dt
from datetime import datetime

print(dir(dt))

now = dt.datetime.now() #创建一个 datetime 类对象
print(now.year, now.month, now.day, now.hour, now.minute, now.second, now.month)

'''
格式符 说明
%a  星期的英文单词的缩写：如星期一， 则返回 Mon
%A  星期的英文单词的全拼：如星期一，返回 Monday
%b  月份的英文单词的缩写：如一月， 则返回 Jan
%B  月份的引文单词的缩写：如一月， 则返回 January
%c  返回 datetime 的字符串表示，如03/08/15 23:01:26
%d  返回的是当前时间是当前月的第几天
%f  微秒的表示： 范围: [0,999999]
%H  以24小时制表示当前小时
%I  以12小时制表示当前小时
%j  返回 当天是当年的第几天 范围[001,366]
%m  返回月份 范围[0,12]
%M  返回分钟数 范围 [0,59]
%P  返回是上午还是下午–AM or PM
%S  返回秒数 范围 [0,61]。。。手册说明的
%U  返回当周是当年的第几周 以周日为第一天
%W  返回当周是当年的第几周 以周一为第一天
%w  当天在当周的天数，范围为[0, 6]，6表示星期天
%x  日期的字符串表示 ：03/08/15
%X  时间的字符串表示 ：23:22:08
%y  两个数字表示的年份 15
%Y  四个数字表示的年份 2015
%z  与 utc 时间的间隔 （如果是本地时间，返回空字符串）
%Z  时区名称（如果是本地时间，返回空字符串）

'''

print('时间：(%Y-%m-%d %H:%M:%S %f): ' , now.strftime( '%Y-%m-%d %H:%M:%S %f' ))
print('时间：(%Y-%m-%d %H:%M:%S %p): ' , now.strftime( '%y-%m-%d %I:%M:%S %p' ))
print('星期缩写%%a: %s '  % now.strftime( '%a' ))
print('星期全拼%%A: %s '  % now.strftime( '%A' ))
print('月份缩写%%b: %s '  % now.strftime( '%b' ))
print('月份全拼%%B: %s '  % now.strftime( '%B' ))
print('日期时间%%c: %s '  % now.strftime( '%c' ))
print('今天是这周的第%s天 '  % now.strftime( '%w' ))
print('今天是今年的第%s天 '  % now.strftime( '%j' ))
print('今周是今年的第%s周 '  % now.strftime( '%U' ))
print('今天是当月的第%s天 '  % now.strftime( '%d' ))