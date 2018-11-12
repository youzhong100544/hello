# -*- coding: utf-8 -*-
class Student(object):

	'学生实体类' #类文档字符串

	def __init__(self, name, age, height, weight, interest):
		self.name = name
		self.age = age

	def print_score(self):
		print('%s: %s' % (self.name, self.age))