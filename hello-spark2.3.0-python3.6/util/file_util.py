# -*- coding: utf-8 -*-
import os

def del_file(path):
	for i in os.listdir(path):
		path_file = os.path.join(path, i)
		# 取文件绝对路径
		if os.path.isfile(path_file):
			os.remove(path_file)
		else:
			del_file(path_file)


#import os
'''
import shutil
import traceback
import globalvar
def misc_init():

	# clean the test result folder
	# get the current path
	current_path = os.path.split(os.path.realpath(__file__))[0]
	# some folder not delete
	except_folders = globalvar.Except_Folders
	# get the folder uder current path
	current_filelist = os.listdir(current_path)
	for f in current_filelist:
	# f should be a absolute path, if python is not run on current path
	if os.path.isdir(os.path.join(current_path,f)):
		if f in except_folders:
			continue
		else:
			real_folder_path = os.path.join(current_path, f)
			try:
				for root, dirs, files in os.walk(real_folder_path):
					for name in files:
						# delete the log and test result
						del_file = os.path.join(root, name)
						os.remove(del_file)
						logger.info('remove file[%s] successfully' % del_file)
				shutil.rmtree(real_folder_path)
				logger.info('remove foler[%s] successfully' % real_folder_path)
			except Exception, e:
				traceback.print_exc()

'''

