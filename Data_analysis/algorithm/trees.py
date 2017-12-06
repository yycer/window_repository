# -*- coding: utf-8 -*-
"""
Created on Mon Dec  4 16:39:40 2017

@author: yyc
"""

from math import log
import operator
import json
import treePlotter

try:
    import cPickle as pickle
except ImportError:
    import pickle

#tmp = [[1, 'no'], [1, 'no']]
def calcShannonEnt(dataset):
    numEntries = len(dataset) # 5
    labelCounts = {}
#    print(dataset[0][-1])
    for featVec in dataset:
        currentLabel = featVec[-1]
        if not currentLabel in labelCounts.keys():
            labelCounts[currentLabel] = 0
        labelCounts[currentLabel] += 1
#    print(labelCounts) # {'yes': 2, 'no': 3}
    shannonEnt = 0.0
    for v in labelCounts.values():
        prob = float(v) / numEntries
        shannonEnt -= prob * log(prob, 2)
#    print(shannonEnt)
    return shannonEnt

#calcShannonEnt(tmp)

def createDataset():
    dataset = [[1, 1, 'yes'],
               [1, 1, 'yes'],
               [1, 0, 'no'],
               [0, 1, 'no'],
               [0, 1, 'no']]
    labels = ['no surfacing', 'flippers']
    return dataset, labels

dataset, labels = createDataset()
#calcShannonEnt(dataset)

def splitDataset(dataset, axis, value):
    retDataset = []
    for item in dataset:
        if item[axis] == value:
            reducedFeatVec = item[: axis]
            reducedFeatVec.extend(item[axis + 1:])
            retDataset.append(reducedFeatVec)
#    print(retDataset)
    return retDataset

#splitDataset(dataset, 1, 1)


#[1, 1, 'yes']
#[1, 1, 'yes']
#[1, 0, 'no']
#[0, 1, 'no']
#[0, 1, 'no']
#print(dataset)

def chooseBestFeatureToSplit(dataset):
    numFeatures = len(dataset[0]) - 1 # 2
    baseEntropy = calcShannonEnt(dataset) # 0.9709505944546686
    bestInfoGain = 0.0
    bestFeature = -1
#    print(dataset[4][0])
    for i in range(numFeatures):
#        [1, 1, 1, 0, 0]
#        [1, 1, 0, 1, 1]
        featList = [example[i] for example in dataset]
        uniqueVals = set(featList) # {0, 1}
        newEntropy = 0.0
        for value in uniqueVals:
            subDataset = splitDataset(dataset, i, value)
#            [[1, 'no'], [1, 'no']]
#            [[1, 'yes'], [1, 'yes'], [0, 'no']]
#            --------------------------------------------
#            [[1, 'no']]
#            [[1, 'yes'], [1, 'yes'], [0, 'no'], [0, 'no']]
            prob = len(subDataset) / len(dataset)
#            print(calcShannonEnt(subDataset))
            newEntropy += prob * calcShannonEnt(subDataset)
        infoGain = baseEntropy - newEntropy
#        print(infoGain)
        if (infoGain > bestInfoGain):
            bestInfoGain = infoGain
            bestFeature = i
    return bestFeature            
#    print(bestFeature) # 0

#chooseBestFeatureToSplit(dataset)
    


def majorityCnt(classList):
    classCount = {}
    for vote in classList:
        if not vote in classCount.keys():
            classCount[vote] = 0
        classCount[vote] += 1
#    print(classCount) # {'yes': 2, 'no': 3}
    sortedClassCount = sorted(classCount.items(), \
            key = operator.itemgetter(1), reverse = True)
    return sortedClassCount[0][0]
#    print(sortedClassCount[0][0]) # 'no'

#tmp = ['yes', 'yes', 'no', 'no', 'no']
#majorityCnt(tmp)

#myTree: {'not fish': {0: 'no', 1: {'fish': {0: 'no', 1: 'yes'}}}}
    

def createTree(dataset, labels):
    # ['yes', 'yes', 'no', 'no', 'no']
    classList = [example[-1] for example in dataset]
    # 递归函数终止的第一个条件：所有类标签完全相同
    if classList.count(classList[0]) == len(classList): # 2
        return classList[0]
    # 使用完了所有特征，仍不能将将数据集分成仅包含唯一类别的分组
    if len(dataset[0]) == 1: # 3
        return majorityCnt(classList)
    bestFeat = chooseBestFeatureToSplit(dataset) # 0
    bestFeatLabel = labels[bestFeat] # 'not fish'
    myTree = {bestFeatLabel: {}}
    del(labels[bestFeat]) # labels: ['fish']
    # [1, 1, 1, 0, 0]
    featValues = [example[bestFeat] for example in dataset]
    uniqueVals = set(featValues) # {0, 1}
#    myTree[bestFeatLabel][0] = 'yyc'
    for value in uniqueVals:
        subLabels = labels[:] # ['fish']
        myTree[bestFeatLabel][value] = createTree(splitDataset\
              (dataset, bestFeat, value), subLabels)
    return myTree

myTree = createTree(dataset, labels)
#print(json.dumps(myTree, indent = 4))
#    {
#        "not fish": {
#            "0": "no",
#            "1": {
#                "fish": {
#                    "0": "no",
#                    "1": "yes"
#                }
#            }
#        }
#    }



def classify(inputTree, featLabels, testVec):
    firstStr = list(inputTree.keys())[0]
    secondDict = inputTree[firstStr]
    featIndex = featLabels.index(firstStr) # 0 1
    # secondDict.keys() --- [0, 1]
    for key in secondDict.keys():
        if testVec[featIndex] == key:
            if type(secondDict[key]).__name__ == 'dict':
                classLabel = classify(secondDict[key], featLabels, testVec)
            else:
                classLabel = secondDict[key]
    return classLabel


def storeTree(inputTree, filename):
    fw = open(filename, 'wb')
    pickle.dump(inputTree, fw)
    fw.close()

def grabTree(filename):
    fr = open(filename, 'rb')
    return pickle.load(fr)



myDat, labels = createDataset()
# {'no surfacing': {0: 'no', 1: {'flippers': {0: 'no', 1: 'yes'}}}}
myTree = treePlotter.retrieveTree(0)
#print(classify(myTree, labels, [1, 0]))


storeTree(myTree, 'classifierStorage.txt')
print(grabTree('classifierStorage.txt'))












