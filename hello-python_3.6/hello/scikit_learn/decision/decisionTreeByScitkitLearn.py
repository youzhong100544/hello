#coding:utf-8  

'''
Created on 2018年1月20日
@author: zfg
'''
from sklearn import tree as tr
def loadData():
    dataMat = []  
    labels = []               
    fr = open("decisiontree.txt")
    lines = fr.readlines()
    for line in lines:
        curLine = line.strip().split('\t')
        dataMat.append(curLine[0:-1])
        labels.append(curLine[len(curLine)-1])
    return dataMat,labels

def string2Float(dataMat,labels):
    string2FloatDict = {"teenager":0.0,
                        "middle":1.0,
                        "older":2.0,
                        "high":2.0,
                        "medium":1.0,
                        "low":0.0,
                        "yes":1.0,
                        "no":0.0,
                        "common":0.0,
                        "well":1.0
                        }
    def fun1(list):
        return [string2FloatDict.get(elem) for elem in list]
    def fun2(elem):
        return string2FloatDict.get(elem)
    return map(fun1,dataMat),map(fun2,labels)

if __name__ == '__main__':
    dataMat,labels = loadData()
    print(labels)
    print(dataMat)
    X,Y = string2Float(dataMat,labels)
    print(X)
    print(Y)
    clf = tr.DecisionTreeClassifier(criterion="entropy")
    clf = clf.fit(X,Y)
    print(clf)
    #青少年  中等    是    一般
    test = [0,1,0,0]
    print(clf.predict_proba(test))
    print(clf.predict(test))
        