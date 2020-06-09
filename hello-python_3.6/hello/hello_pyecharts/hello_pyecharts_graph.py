# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd


import webbrowser
import pyecharts

from pyecharts import options as opts
from pyecharts.charts import Graph, Page, Bar, Pie, Grid

print("numpy version: {}".format(np.__version__))
print("pandas version: {}".format(pd.__version__))
print("pyecharts version: {}".format(pyecharts.__version__))
print()


"""
Python webbrowser.open()打开Chrome浏览器
http://www.voidcn.com/article/p-hqbprxnr-btt.html
"""
# MacOS
MacOS_chrome_path = 'open -a /Applications/Google\ Chrome.app %s'

# Windows
Windows_chrome_path = 'C:/Program Files (x86)/Google/Chrome/Application/chrome.exe %s'

# Linux
Linux_chrome_path = '/usr/bin/google-chrome %s'



ls_a = {"A": [1, 2, 3, 4, 5, 6], "B": [2, 5, 8, 7, 9, 4], "C": [3, 6, 9, 9, 9, 9]}
df = pd.DataFrame(ls_a)
print(df)
print(df.columns)
print(df.columns.values)


"""
关系图

pyecharts graph（关系图） 官网例子weibo.json详解
https://blog.csdn.net/Kevin_HZH/article/details/91043392

"""

nodes = [
	{"name": "结点1", "symbolSize": 10},
	{"name": "结点2", "symbolSize": 20},
	{"name": "结点3", "symbolSize": 30},
	{"name": "结点4", "symbolSize": 40},
	{"name": "结点5", "symbolSize": 50},
	{"name": "结点6", "symbolSize": 40},
	{"name": "结点7", "symbolSize": 30},
	{"name": "结点8", "symbolSize": 20},
]
links = []
for i in nodes:
	for j in nodes:
		links.append({"source": i.get("name"), "target": j.get("name")})


graph = (
	Graph().add("", nodes, links, repulsion=8000).set_global_opts(title_opts=opts.TitleOpts(title="Graph-基本示例"))
)

graph.render()

webbrowser.get().open("render.html")

