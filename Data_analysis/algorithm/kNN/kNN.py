# -*- coding: utf-8 -*-
"""
Created on Thu Nov 30 13:57:48 2017

@author: yyc
"""

import numpy as np
import operator
#import matplotlib
import matplotlib.pyplot as plt
from os import listdir


def createDataSet():
    group = np.array([
            [1.0, 1.1],
            [1.0, 1.0],
            [0, 0],
            [0, 0.1]
            ])
    labels = ['A', 'A', 'B', 'B']
    return group, labels

group = np.array([
            [1.0, 1.1],
            [1.0, 1.0],
            [0, 0],
            [0, 0.1]
            ])
#print(group.shape)
labels = ['A', 'B', 'C', 'D']

# inX:用于分类的输入向量
def classify0(inX, dataSet, labels, k):
    dataSetSize = dataSet.shape[0] # 900
    diffMat =np.tile(inX, (dataSetSize, 1)) - dataSet # <class 'numpy.ndarray'>
    sqDiffMat = diffMat ** 2
    sqDistances = sqDiffMat.sum(axis = 1)
    distances = sqDistances ** 0.5
    sortedDistIndices = distances.argsort() # [2, 3, 1, 0]
    classCount = {}
    for i in range(k):
        votelabel =labels[sortedDistIndices[i]]
        classCount[votelabel] = classCount.get(votelabel, 0) + 1
    sortedClassCount = sorted(classCount.items(), key = operator.itemgetter(1), reverse = True)
#    print(sortedClassCount)
    return sortedClassCount[0][0]
#classify0([0, 0], group, labels, 3)


def file2matrix1(filename):
    fr = open(filename)
    arrayOLines = fr.readlines() # 1000
    numberOfLines = len(arrayOLines)
    returnMat = np.zeros((numberOfLines, 3))
#    print(type(returnMat))
    classLabelVector = []
    index = 0
    for line in arrayOLines:
        line = line.strip()
        listFormLine = line.split('\t')
        returnMat[index, :] = listFormLine[0: 3]
#        print(type(listFormLine[-1]))
        if listFormLine[-1] == 'didntLike':
            classLabelVector.append(1)
        elif listFormLine[-1] == 'smallDoses':
            classLabelVector.append(2)
        elif listFormLine[-1] == 'largeDoses':
            classLabelVector.append(3)
        index += 1
    return returnMat, classLabelVector

#datingDataMat, datingLabels = file2matrix1('datingTestSet.txt')


# normalization
def autoNorm(dataset):
    minVals = dataset.min(0)
    maxVals = dataset.max(0)
    ranges = maxVals - minVals
    normalDataSet = np.zeros(np.shape(dataset))
    m = dataset.shape[0]
    normalDataSet = (dataset - np.tile(minVals, (m, 1))) / np.tile(ranges, (m, 1))
    return normalDataSet, ranges, minVals

#normalDataSet, ranges, minVals = autoNorm(datingDataMat)
def datingClassTest():
    testRatio = 0.1
    datingDataMat, datingLabels = file2matrix1('datingTestSet.txt')
    normalMat = autoNorm(datingDataMat)[0]
    m = normalMat.shape[0] # 1000
    numTestVecs = int(m * testRatio) # m * testRatio = 100.0 (float)
    errorCount = 0.0
    for i in range(numTestVecs):
        # classify0(inX, dataSet, labels, k):
        classifierResult = classify0(normalMat[i], \
            normalMat[: m - numTestVecs], datingLabels[: m - numTestVecs], 3)
        if classifierResult != datingLabels[i]:
            errorCount += 1.0
    return errorCount / float(numTestVecs)
    
datingClassTest()

def classifyPerson():
    resultList = ['not at all', 'in small doses', 'in large doses']
    ffMiles = float(input('frequent flier miles earned per year?'))
    vgpercent = float(input('percentage of tiem spent playing video games?'))
    iceCream = float(input('liters of ice cream consumed per year?'))
    datingDataMat, datingLabels = file2matrix1('DatingTestSet.txt')
    normalMat, ranges, minVals = autoNorm(datingDataMat)
    inArr = np.array([ffMiles, vgpercent,iceCream])
    classifyResult = classify0((inArr - minVals) / ranges, normalMat, datingLabels, 3)
    print(resultList[classifyResult - 1])


def img2vector(filename):
    returnVector = np.zeros((1, 1024))
    fr = open(filename)
    for i in range(32):
        lineStr = fr.readline()
        for j in range(32):
            returnVector[0, 32 * i + j] = int(lineStr[j])
    return returnVector

def handwritingClassTest():
    hwLabels = []
    trainingFileList = listdir('digits/trainingDigits')
    m = len(trainingFileList)
    trainingMat = np.zeros((m, 1024))
#    print(type(trainingFileList[0].split('.')[0].split('_')[0])) # str
    for i in range(m):
        fileNameStr = trainingFileList[i]
        fileStr = fileNameStr.split('.')[0]
        classNumStr = int(fileStr.split('_')[0])
        hwLabels.append(classNumStr)
        trainingMat[i, :] = img2vector('digits/trainingDigits/%s' % fileNameStr)
    testFileList = listdir('digits/testDigits')
    errorCount = 0.0
    nTest = len(testFileList)
    for i in range(nTest):
        fileNameStr = testFileList[i]
        fileStr = fileNameStr.split('.')[0]
        classNumStr = int(fileStr.split('_')[0])
        vectorUnderTest = img2vector('digits/testDigits/%s' % fileNameStr)
        classiferResult = classify0(vectorUnderTest, trainingMat, hwLabels, 3)
#        print('The classifier came back with: %d, the real answer is: %d' % (classiferResult, classNumStr))
        if classiferResult != classNumStr:
            errorCount += 1.0
    print('The total error rate is %f' % (errorCount / float(nTest)))
        
    
handwritingClassTest()


#classifyPerson()
#fig = plt.figure()
#ax = fig.add_subplot(111)
#ax.scatter(datingDataMat[:, 1], datingDataMat[:, 2], \
#           15.0 * np.array(datingLabels), 15.0 * np.array(datingLabels))
#plt.show()


#plt.plot([1, 2, 3, 4], [1, 4, 9, 16], 'ro')
#plt.axis([0, 5, 0, 20])
#plt.xlabel('pursue for freedom')
#plt.ylabel('Spartacus')
#plt.show()

#t = np.arange(0., 5., 0.2)
#plt.plot(t, t, 'r--', t, t ** 2, 'bs', t, t ** 3, 'g^')
#plt.show()


#def f(t):
#    return np.exp(-t) * np.cos(2 * np.pi * t)
#
#t1 = np.arange(0., 5., 0.1)
#t2 = np.arange(0., 5., 0.02)
#
#plt.figure(1)
#plt.subplot(211)
#plt.plot(t1, f(t1), 'bo', t2, f(t2), 'k')
#
#plt.subplot(212)
#plt.plot(t2, np.cos(2 * np.pi * t2), 'c')
#plt.show()


#for idx, color in enumerate('rgbyck'):
#    plt.subplot(321+idx, axisbg = color)
#plt.show()
    


