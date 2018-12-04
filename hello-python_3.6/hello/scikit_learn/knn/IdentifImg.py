#coding:utf-8  
'''
Created on 2018年1月20日
@author: zfg
'''

import os
from KNNDateOnHand import *

def img2vector(filename):
    returnVect = np.zeros((1,1024))
    fr = open(filename)
    for i in range(32):
        lineStr = fr.readline()
        for j in range(32):
            returnVect[0,32*i+j] = int(lineStr[j])
    return returnVect

def IdentifImgClassTest():
    hwLabels = []
    trainingFileList = os.listdir('TrainData')           
    m = len(trainingFileList)
    trainingMat = np.zeros((m,1024))
    for i in range(m):
        fileNameStr = trainingFileList[i]
        fileStr = fileNameStr.split('.')[0]      
        classNumStr = int(fileStr.split('_')[0])
        hwLabels.append(classNumStr)
        trainingMat[i,:] = img2vector('TrainData/%s' % fileNameStr)
    testFileList = os.listdir('TestData')         
    errorCount = 0.0
    mTest = len(testFileList)
    for i in range(mTest):
        fileNameStr = testFileList[i]
        fileStr = fileNameStr.split('.')[0]     
        classNumStr = int(fileStr.split('_')[0])
        vectorUnderTest = img2vector('TestData/%s' % fileNameStr)
        classifierResult = classify(vectorUnderTest, trainingMat, hwLabels, 3)
        print "识别出的数字是: %d, 真实数字是: %d" % (classifierResult, classNumStr)
        if (classifierResult != classNumStr): errorCount += 1.0
    print "\n识别错误次数 %d" % errorCount
    errorRate = errorCount/float(mTest)
    print "\n正确率: %f" % (1-errorRate)

if __name__ == '__main__':
    IdentifImgClassTest()