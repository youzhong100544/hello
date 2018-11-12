#coding=utf-8


# 写入数据的工具类
class FileManager(object):

	# 保存文件的名称
	filename = 'student.txt'

	# 写一个写入数据的接口
	@classmethod
	def write(cls,content,split='\n'):
		'''
		:param content: 要写入的数据
		:param split: 每条数据之间的分隔符
		:return:
		'''
		# 判断传入的参数是否为字符串类型，如果是就写入，如果不是就抛出异常
		if isinstance(content,str):
			# 1.打开文件
			f = open(cls.filename, 'a')
			# 2.写入数据
			f.write(content)
			f.write(split)
			# 3.关闭文件
			f.close()
		else:
			raise TypeError('content must be a str')

	# 写入多行数据
	@classmethod
	def writelines(cls,str_list,split='\n'):

		# 判断某个对象是否是个类型,如果是返回True，如果不是返回False
		rs = isinstance(str_list,list)
		# 如果为True
		if rs:
			# for循环遍历列表，取出每一个数据，判断数据类型是否为字符串
			for content in str_list:
				# 如果不是字符串类型，抛出异常
				if isinstance(content,str) == False:
					raise TypeError('000')
			# 如果没有抛出异常，就可以写入数据了
			# 1.打开文件
			f = open(cls.filename,'a')
			# 2.写入数据 str1\str2\str3
			string = split.join(str_list)
			f.write(string)
			# 3.关闭文件
			f.close()
		else:
			# 如果传入的不是列表，抛出异常
			raise TypeError('str_list must be a list of "str"')


# 日期格式化类，用类执行一个函数，返回一个对象，对象分别有year\month\day
'''
    2018-2-1  2018.2.1  2018 2 1
    date.year = 2018
    date.month = 2
    date.day = 1
'''
class DateTool(object):

	def __init__(self, year=1970, month=1, day=1):
		self.year = year
		self.month = month
		self.day = day
	#类函数，传递进来一个日期，返回一个该类的对象

	@classmethod
	def get_date(cls, date):
		# 判断date是否为str类型
		if not isinstance(date,str):
			# 不是str类型，直接触发异常
			raise TypeError('date must be a str!')
		# 转换
		# 判断是- 还是. 还是空格
		if '-' in date:
			# 相当于year,month,day = [2018,2,1]
			# 分别将2018赋值给year，2赋值给month，1赋值给day
			year,month,day = list(map(int,date.split('-')))
		elif '.' in date:
			year, month, day = list(map(int, date.split('.')))
		elif ' ' in date:
			year, month, day = list(map(int, date.split(' ')))

		# 创建对象
		# 相当于obj = DateTool(year,month,day)
		obj = cls(year, month, day)
		# 返回对象
		return obj

# 只有在当前文件直接运行时，才会运行以下代码
if __name__ == '__main__':

	# 指定写入文件的名称
	FileManager.filename = 'all_student.txt'

	# 执行写入功能函数
	FileManager.write('hello')

	FileManager.writelines(['hello','world','鸡帆'])

	# 开始进行日期转换
	# 转换之后 返回一个结果对象
	date = DateTool.get_date('2020-2-22')
	# date 有三个属性，分别为year month day
	print(date.year)
	print(date.month)
	print(date.day)