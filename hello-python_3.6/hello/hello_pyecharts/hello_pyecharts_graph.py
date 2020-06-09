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
chrome_path = 'open -a /Applications/Google\ Chrome.app %s'

# Windows
# chrome_path = 'C:\Program Files (x86)\Google\Chrome\Application\chrome.exe %s'

# Linux
# chrome_path = '/usr/bin/google-chrome %s'


df = pd.read_excel(r'/Users/hiahia/Downloads/pycharts.xlsx')
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

"""
graph = (
	Graph().add("", nodes, links, repulsion=8000).set_global_opts(title_opts=opts.TitleOpts(title="Graph-基本示例"))
)
"""

graph = Graph("Graph-基本示例")
graph.add("", nodes, links,
	categories=None,			# 结点分类的类目，结点可以指定分类，也可以不指定。
	is_focusnode=True,			# 是否在鼠标移到节点上的时候突出显示节点以及节点的边和邻接节点。默认为 True
	is_roam=True,
	is_rotatelabel=True,		# 是否旋转标签，默认为 False
	graph_layout="force",		# 布局类型，默认force=力引导图，circular=环形布局
	graph_edge_length=300,		# 力布局下边的两个节点之间的距离，这个距离也会受 repulsion 影响。默认为 50，TODO 值越大则长度越长
	graph_gravity=0.5,			# 点受到的向中心的引力因子。TODO 该值越大节点越往中心点靠拢。默认为 0.2
	graph_repulsion=100,		# 节点之间的斥力因子。默认为 50，TODO 值越大则斥力越大
	is_label_show=True,
	line_curve=0.2				# 线的弯曲度
)

graph.render()

webbrowser.get(chrome_path).open("render.html")

