# coding:utf-8

"""
使用logistic regression处理音乐数据,音乐数据训练样本的获得和使用快速傅里叶变换（FFT）预处理的方法需要事先准备好
1. 把训练集扩大到每类100个首歌而不是之前的10首歌,类别仍然是六类:jazz,classical,country, pop, rock, metal
2. 同时使用logistic回归
3. 引入一些评价的标准来比较Logistic测试集上的表现 
"""
# 准备音乐数据
#  
# def create_fft(g,n):
#     rad="e:/genres/"+g+"/converted/"+g+"."+str(n).zfill(5)+".au.wav"
#     (sample_rate, X) = wavfile.read(rad)
#     fft_features = abs(fft(X)[:1000])
#     sad="d:/trainset/"+g+"."+str(n).zfill(5)+ ".fft"
#     np.save(sad, fft_features)
# #          
# # #-------create fft--------------
# #       
# genre_list = ["classical", "jazz", "country", "pop", "rock", "metal"]
# for g in genre_list:
#     for n in range(100):
#         create_fft(g,n)
# 加载训练集数据,分割训练集以及测试集,进行分类器的训练
# 构造训练集！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
#-------read fft-------------- 

from scipy import fft
from scipy.io import wavfile
from sklearn.linear_model import LogisticRegression

import numpy as np


genre_list = ["classical", "jazz", "country", "pop", "rock", "metal"]
X=[]
Y=[]
for g in genre_list:
    for n in range(100):
        rad="d:/trainset/"+g+"."+str(n).zfill(5)+ ".fft"+".npy"
        fft_features = np.load(rad)
        X.append(fft_features)
        Y.append(genre_list.index(g))
 
X=np.array(X)
Y=np.array(Y)
# 
#         
# # 接下来，我们使用sklearn，来构造和训练我们的两种分类器 
# #------train logistic classifier-------------- 
model = LogisticRegression()
model.fit(X, Y)
 
print 'Starting read wavfile...'
#prepare test data-------------------
# sample_rate, test = wavfile.read("d:/trainset/sample/outfile.wav")
sample_rate, test = wavfile.read("e:/heibao-wudizirong-remix.wav")
# sample_rate, test = wavfile.read("d:/genres/metal/converted/metal.00080.au.wav")
testdata_fft_features = abs(fft(test))[:1000]
type_index = model.predict(testdata_fft_features)[0]
print type_index
print genre_list[type_index]







