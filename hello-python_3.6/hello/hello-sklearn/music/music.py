# coding:utf-8

from scipy import fft
from scipy.io import wavfile
from matplotlib.pyplot import specgram
import matplotlib.pyplot as plt

# 可以先把一个wav文件读入python,然后绘制它的频谱图(spectrogram)来看看是什么样的

#画框设置
#figsize=(10, 4)宽度和高度的英寸
# dpi=80 分辨率
# plt.figure(figsize=(10, 4),dpi=80)
#              
# (sample_rate, X) = wavfile.read("E:/genres/metal/converted/metal.00065.au.wav")
# print sample_rate, X.shape
# specgram(X, Fs=sample_rate, xextent=(0,30))
# plt.xlabel("time")
# plt.ylabel("frequency")
##线的形状和颜色              
# plt.grid(True, linestyle='-', color='0.75')
##tight紧凑一点
# plt.savefig("E:/metal.00065.au.wav5.png", bbox_inches="tight")


# 当然,我们也可以把每一种的音乐都抽一些出来打印频谱图以便比较,如下图:
# def plotSpec(g,n):
#     sample_rate, X = wavfile.read("E:/genres/"+g+"/converted/"+g+"."+n+".au.wav")
#     specgram(X, Fs=sample_rate, xextent=(0,30))
#     plt.title(g+"_"+n[-1])
#              
# plt.figure(num=None, figsize=(18, 9), dpi=80, facecolor='w', edgecolor='k')  
# plt.subplot(6,3,1);plotSpec("classical","00001");plt.subplot(6,3,2);plotSpec("classical","00002")
# plt.subplot(6,3,3);plotSpec("classical","00003");plt.subplot(6,3,4);plotSpec("jazz","00001")
# plt.subplot(6,3,5);plotSpec("jazz","00002");plt.subplot(6,3,6);plotSpec("jazz","00003")
# plt.subplot(6,3,7);plotSpec("country","00001");plt.subplot(6,3,8);plotSpec("country","00002")
# plt.subplot(6,3,9);plotSpec("country","00003");plt.subplot(6,3,10);plotSpec("pop","00001")
# plt.subplot(6,3,11);plotSpec("pop","00002");plt.subplot(6,3,12);plotSpec("pop","00003")
# plt.subplot(6,3,13);plotSpec("rock","00001");plt.subplot(6,3,14);plotSpec("rock","00002")
# plt.subplot(6,3,15);plotSpec("rock","00003");plt.subplot(6,3,16);plotSpec("metal","00001")
# plt.subplot(6,3,17);plotSpec("metal","00002");plt.subplot(6,3,18);plotSpec("metal","00003")
# plt.tight_layout(pad=0.4, w_pad=0, h_pad=1.0)
# plt.savefig("D:/compare.au.wav.png", bbox_inches="tight")


# 对单首音乐进行傅里叶变换
plt.figure(figsize=(9, 6), dpi=80) 
sample_rate, X = wavfile.read("E:/genres/jazz/converted/jazz.00000.au.wav")
print(sample_rate,X)
plt.subplot(211)
specgram(X, Fs=sample_rate)
plt.xlabel("time")
plt.ylabel("frequency")
plt.subplot(212)
fft_X = abs(fft(X))
specgram(fft_X)
plt.xlabel("frequency")
plt.ylabel("amplitude")
plt.savefig("E:/jazz.00000.au.wav.fft.png")
