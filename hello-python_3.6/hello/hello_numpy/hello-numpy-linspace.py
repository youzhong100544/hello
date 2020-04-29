# -*- coding: utf-8 -*-

import numpy as np

print("numpy version: {}".format(np.__version__))
print()

print()
print("#" * 150)
print("# 1")
print("# numpy.linspace(start,stop,num=50,endpoint=True,retstep=False,dtype=None)")
print("# 作用为：在指定的大间隔内，返回固定间隔的数据。他将返回“num”个等间距的样本，在区间[start, stop]中。其中，区间的结束端点可以被排除在外。")
print("#" * 150)

'''
参数：
    start：scalar类型（个人理解是标量的意思，这不是一个具体的数据类型，而是指某一些数据类型，比如int,float,bool,long,str等等都属于sclar类型）。
            这个数参数表示这个序列的开始值。
    
    stop：scalar类型。
            如果endpoint=True。那么stop就是序列的终止数值。
            当endpoint=False时，返回值中不包含最后一个端点，并且步长会改变。
    
    num：int型，可选参数，默认值为50。
            表示要生成的样本数，必须是非负值。
    
    endpoint：bool类型。
            可选参数，默认值为True，这时stop就是最后的样本。为False时，不包含stop的值。
    
    retstep：bool类型。
            可选参数，默认值为True，这时返回值是(samples,step)，前面的是数组，后面是步长。
    
    dtype：表示输出的数组的数据类型，如果没有给出就从其他输入中推断输出的类型
    
返回值：
    samples：ndarray类型。在[start，stop]闭区间，或者[start，stop)半闭合区间中，数量为num，步长相等的样本。至于包不包含stop取决于endpoint参数的取值。
    
    step：float类型。可选。只有restep参数取值为True时才会返回这个返回值，表示样本中步长。

'''

# a, b = np.linspace(1, 49, 25, True, True)


print()
print("# 1.1、" + "-"*100)
print("# start=1,stop=5")
a = np.linspace(1, 5)
print(a)
'''
[1.         1.08163265 1.16326531 1.24489796 1.32653061 1.40816327
 1.48979592 1.57142857 1.65306122 1.73469388 1.81632653 1.89795918
 1.97959184 2.06122449 2.14285714 2.2244898  2.30612245 2.3877551
 2.46938776 2.55102041 2.63265306 2.71428571 2.79591837 2.87755102
 2.95918367 3.04081633 3.12244898 3.20408163 3.28571429 3.36734694
 3.44897959 3.53061224 3.6122449  3.69387755 3.7755102  3.85714286
 3.93877551 4.02040816 4.10204082 4.18367347 4.26530612 4.34693878
 4.42857143 4.51020408 4.59183673 4.67346939 4.75510204 4.83673469
 4.91836735 5.        ]
'''
print(type(a))      # 输出:<class 'numpy.ndarray'>

print()
print("# 1.2、" + "-"*100)
print("# start=1,stop=5,num=5")
a = np.linspace(1, 5, 5)
print(a)            # 输出:[1. 2. 3. 4. 5.]
print(type(a))      # 输出:<class 'numpy.ndarray'>