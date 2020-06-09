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
官网地址:http://pyecharts.org/#/

官网 quickstart 地址:http://pyecharts.org/#/zh-cn/quickstart

安装
pip3 install -i https://pypi.tuna.tsinghua.edu.cn/simple pyecharts echarts-countries-pypkg echarts-china-provinces-pypkg echarts-china-cities-pypkg

pip3 install pyecharts

pip3 install echarts-countries-pypkg
pip3 install echarts-china-provinces-pypkg
pip3 install echarts-china-cities-pypkg
pip3 install echarts-china-counties-pypkg
pip3 install echarts-china-misc-pypkg

1、全球国家地图: echarts-countries-pypkg (1.9MB): 世界地图和 213 个国家，包括中国地图-
2、中国省级地图: echarts-china-provinces-pypkg (730KB)：23 个省，5 个自治区
3、中国市级地图: echarts-china-cities-pypkg (3.8MB)：370 个中国城市
4、中国县区级地图: echarts-china-counties-pypkg (4.1MB)：2882 个中国县·区
5、中国区域地图: echarts-china-misc-pypkg (148KB)：11 个中国区域地图，比如华南、华北。


这里要专门说明一下，自从 0.3.2 开始，为了缩减项目本身的体积以及维持 pyecharts 项目的轻量化运行，pyecharts 将不再自带地图 js 文件。
如用户需要用到地图图表（Geo、Map），可自行安装对应的地图文件包。否则在用到这两个包的时候，并能完整的显示地图效果。

"""


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
"""

graph.render()
json_content = graph.json_contents
print(json_content)
"""
{
    "animation": true,
    "animationThreshold": 2000,
    "animationDuration": 1000,
    "animationEasing": "cubicOut",
    "animationDelay": 0,
    "animationDurationUpdate": 300,
    "animationEasingUpdate": "cubicOut",
    "animationDelayUpdate": 0,
    "color": [
        "#c23531",
        "#2f4554",
        "#61a0a8",
        "#d48265",
        "#749f83",
        "#ca8622",
        "#bda29a",
        "#6e7074",
        "#546570",
        "#c4ccd3",
        "#f05b72",
        "#ef5b9c",
        "#f47920",
        "#905a3d",
        "#fab27b",
        "#2a5caa",
        "#444693",
        "#726930",
        "#b2d235",
        "#6d8346",
        "#ac6767",
        "#1d953f",
        "#6950a1",
        "#918597"
    ],
    "series": [
        {
            "type": "graph",
            "layout": "force",
            "symbolSize": 10,
            "circular": {
                "rotateLabel": false
            },
            "force": {
                "repulsion": 8000,
                "edgeLength": 50,
                "gravity": 0.2
            },
            "label": {
                "show": true,
                "position": "top",
                "margin": 8
            },
            "lineStyle": {
                "show": true,
                "width": 1,
                "opacity": 1,
                "curveness": 0,
                "type": "solid"
            },
            "roam": true,
            "draggable": false,
            "focusNodeAdjacency": true,
            "data": [
                {
                    "name": "\u7ed3\u70b91",
                    "symbolSize": 10
                },
                {
                    "name": "\u7ed3\u70b92",
                    "symbolSize": 20
                },
                {
                    "name": "\u7ed3\u70b93",
                    "symbolSize": 30
                },
                {
                    "name": "\u7ed3\u70b94",
                    "symbolSize": 40
                },
                {
                    "name": "\u7ed3\u70b95",
                    "symbolSize": 50
                },
                {
                    "name": "\u7ed3\u70b96",
                    "symbolSize": 40
                },
                {
                    "name": "\u7ed3\u70b97",
                    "symbolSize": 30
                },
                {
                    "name": "\u7ed3\u70b98",
                    "symbolSize": 20
                }
            ],
            "edgeLabel": {
                "show": false,
                "position": "top",
                "margin": 8
            },
            "edgeSymbol": [
                null,
                null
            ],
            "edgeSymbolSize": 10,
            "links": [
                {
                    "source": "\u7ed3\u70b91",
                    "target": "\u7ed3\u70b91"
                },
                {
                    "source": "\u7ed3\u70b91",
                    "target": "\u7ed3\u70b92"
                },
                {
                    "source": "\u7ed3\u70b91",
                    "target": "\u7ed3\u70b93"
                },
                {
                    "source": "\u7ed3\u70b91",
                    "target": "\u7ed3\u70b94"
                },
                {
                    "source": "\u7ed3\u70b91",
                    "target": "\u7ed3\u70b95"
                },
                {
                    "source": "\u7ed3\u70b91",
                    "target": "\u7ed3\u70b96"
                },
                {
                    "source": "\u7ed3\u70b91",
                    "target": "\u7ed3\u70b97"
                },
                {
                    "source": "\u7ed3\u70b91",
                    "target": "\u7ed3\u70b98"
                },
                {
                    "source": "\u7ed3\u70b92",
                    "target": "\u7ed3\u70b91"
                },
                {
                    "source": "\u7ed3\u70b92",
                    "target": "\u7ed3\u70b92"
                },
                {
                    "source": "\u7ed3\u70b92",
                    "target": "\u7ed3\u70b93"
                },
                {
                    "source": "\u7ed3\u70b92",
                    "target": "\u7ed3\u70b94"
                },
                {
                    "source": "\u7ed3\u70b92",
                    "target": "\u7ed3\u70b95"
                },
                {
                    "source": "\u7ed3\u70b92",
                    "target": "\u7ed3\u70b96"
                },
                {
                    "source": "\u7ed3\u70b92",
                    "target": "\u7ed3\u70b97"
                },
                {
                    "source": "\u7ed3\u70b92",
                    "target": "\u7ed3\u70b98"
                },
                {
                    "source": "\u7ed3\u70b93",
                    "target": "\u7ed3\u70b91"
                },
                {
                    "source": "\u7ed3\u70b93",
                    "target": "\u7ed3\u70b92"
                },
                {
                    "source": "\u7ed3\u70b93",
                    "target": "\u7ed3\u70b93"
                },
                {
                    "source": "\u7ed3\u70b93",
                    "target": "\u7ed3\u70b94"
                },
                {
                    "source": "\u7ed3\u70b93",
                    "target": "\u7ed3\u70b95"
                },
                {
                    "source": "\u7ed3\u70b93",
                    "target": "\u7ed3\u70b96"
                },
                {
                    "source": "\u7ed3\u70b93",
                    "target": "\u7ed3\u70b97"
                },
                {
                    "source": "\u7ed3\u70b93",
                    "target": "\u7ed3\u70b98"
                },
                {
                    "source": "\u7ed3\u70b94",
                    "target": "\u7ed3\u70b91"
                },
                {
                    "source": "\u7ed3\u70b94",
                    "target": "\u7ed3\u70b92"
                },
                {
                    "source": "\u7ed3\u70b94",
                    "target": "\u7ed3\u70b93"
                },
                {
                    "source": "\u7ed3\u70b94",
                    "target": "\u7ed3\u70b94"
                },
                {
                    "source": "\u7ed3\u70b94",
                    "target": "\u7ed3\u70b95"
                },
                {
                    "source": "\u7ed3\u70b94",
                    "target": "\u7ed3\u70b96"
                },
                {
                    "source": "\u7ed3\u70b94",
                    "target": "\u7ed3\u70b97"
                },
                {
                    "source": "\u7ed3\u70b94",
                    "target": "\u7ed3\u70b98"
                },
                {
                    "source": "\u7ed3\u70b95",
                    "target": "\u7ed3\u70b91"
                },
                {
                    "source": "\u7ed3\u70b95",
                    "target": "\u7ed3\u70b92"
                },
                {
                    "source": "\u7ed3\u70b95",
                    "target": "\u7ed3\u70b93"
                },
                {
                    "source": "\u7ed3\u70b95",
                    "target": "\u7ed3\u70b94"
                },
                {
                    "source": "\u7ed3\u70b95",
                    "target": "\u7ed3\u70b95"
                },
                {
                    "source": "\u7ed3\u70b95",
                    "target": "\u7ed3\u70b96"
                },
                {
                    "source": "\u7ed3\u70b95",
                    "target": "\u7ed3\u70b97"
                },
                {
                    "source": "\u7ed3\u70b95",
                    "target": "\u7ed3\u70b98"
                },
                {
                    "source": "\u7ed3\u70b96",
                    "target": "\u7ed3\u70b91"
                },
                {
                    "source": "\u7ed3\u70b96",
                    "target": "\u7ed3\u70b92"
                },
                {
                    "source": "\u7ed3\u70b96",
                    "target": "\u7ed3\u70b93"
                },
                {
                    "source": "\u7ed3\u70b96",
                    "target": "\u7ed3\u70b94"
                },
                {
                    "source": "\u7ed3\u70b96",
                    "target": "\u7ed3\u70b95"
                },
                {
                    "source": "\u7ed3\u70b96",
                    "target": "\u7ed3\u70b96"
                },
                {
                    "source": "\u7ed3\u70b96",
                    "target": "\u7ed3\u70b97"
                },
                {
                    "source": "\u7ed3\u70b96",
                    "target": "\u7ed3\u70b98"
                },
                {
                    "source": "\u7ed3\u70b97",
                    "target": "\u7ed3\u70b91"
                },
                {
                    "source": "\u7ed3\u70b97",
                    "target": "\u7ed3\u70b92"
                },
                {
                    "source": "\u7ed3\u70b97",
                    "target": "\u7ed3\u70b93"
                },
                {
                    "source": "\u7ed3\u70b97",
                    "target": "\u7ed3\u70b94"
                },
                {
                    "source": "\u7ed3\u70b97",
                    "target": "\u7ed3\u70b95"
                },
                {
                    "source": "\u7ed3\u70b97",
                    "target": "\u7ed3\u70b96"
                },
                {
                    "source": "\u7ed3\u70b97",
                    "target": "\u7ed3\u70b97"
                },
                {
                    "source": "\u7ed3\u70b97",
                    "target": "\u7ed3\u70b98"
                },
                {
                    "source": "\u7ed3\u70b98",
                    "target": "\u7ed3\u70b91"
                },
                {
                    "source": "\u7ed3\u70b98",
                    "target": "\u7ed3\u70b92"
                },
                {
                    "source": "\u7ed3\u70b98",
                    "target": "\u7ed3\u70b93"
                },
                {
                    "source": "\u7ed3\u70b98",
                    "target": "\u7ed3\u70b94"
                },
                {
                    "source": "\u7ed3\u70b98",
                    "target": "\u7ed3\u70b95"
                },
                {
                    "source": "\u7ed3\u70b98",
                    "target": "\u7ed3\u70b96"
                },
                {
                    "source": "\u7ed3\u70b98",
                    "target": "\u7ed3\u70b97"
                },
                {
                    "source": "\u7ed3\u70b98",
                    "target": "\u7ed3\u70b98"
                }
            ]
        }
    ],
    "legend": [
        {
            "data": [],
            "selected": {},
            "show": true,
            "padding": 5,
            "itemGap": 10,
            "itemWidth": 25,
            "itemHeight": 14
        }
    ],
    "tooltip": {
        "show": true,
        "trigger": "item",
        "triggerOn": "mousemove|click",
        "axisPointer": {
            "type": "line"
        },
        "showContent": true,
        "alwaysShowContent": false,
        "showDelay": 0,
        "hideDelay": 100,
        "textStyle": {
            "fontSize": 14
        },
        "borderWidth": 0,
        "padding": 5
    },
    "title": [
        {
            "text": "Graph-\u57fa\u672c\u793a\u4f8b",
            "padding": 5,
            "itemGap": 10
        }
    ]
}

"""

webbrowser.get(chrome_path).open("render.html")

