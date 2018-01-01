# coding: UTF-8
import math
import numpy as np
import random


def loadDataset():
    dataMat = []
    labelMat = []
    fr = open('testSet.txt')
    for line in fr.readlines():
        lineArr = line.strip().split()
        dataMat.append([1.0, float(lineArr[0]), float(lineArr[1])])
        labelMat.append(int(lineArr[2]))
    # dataMat: 有100个子列表组成的列表，每个字列表中包含三个元素 - 初始化的回归系数、x、y
    # labelMat: 是一个包含100个元素的列表
    return dataMat, labelMat


def sigmoid(x):
    return 1.0 / (1 + np.exp(-x))


def gradAscent(dataMatIn, classLabels):
    dataMatrix = np.mat(dataMatIn)                  # (100L, 3L)
    labelMatrix = np.mat(classLabels).transpose()   # (100L, 1L)
    m, n = np.shape(dataMatrix)
    alpha = 0.001
    maxCycles = 500
    weights = np.ones((n, 1))
    for k in range(maxCycles):
        # dataMatrix - (100, 3) * weights - (3, 1) --> result - (100, 1)
        h = sigmoid(dataMatrix * weights)
        # error - (100, 1)
        error = labelMatrix - h
        # dataMatrix.transpose() - (3, 100)
        weights = weights + alpha * dataMatrix.transpose() * error
    return weights


def stocGradAscent0(dataMatrix, classLabels):
    m, n = np.shape(dataMatrix)
    alpha = 0.01
    weights = np.ones(n)
    # print weights   # (1, 3)
    for i in range(m):
        # dataMatrix[i] - (1, 3)
        h = sigmoid(sum(dataMatrix[i] * weights))
        error = classLabels[i] - h
        weights = weights + alpha * error * dataMatrix[i]
    return weights


def stoGradAscent1(dataMatrix, classLabels, numIter = 150):
    m, n = np.shape(dataMatrix)
    weights = np.ones(n)
    for j in range(numIter):
        dataIndex = range(m)
        for i in range(m):
            alpha = 4 / (1.0 + j + i) + 0.01
            randIndex = int(random.uniform(0, len(dataIndex)))
            h = sigmoid(sum(dataMatrix[randIndex] * weights))
            error = classLabels[randIndex] - h
            weights = weights + alpha * error * dataMatrix[randIndex]
            del(dataIndex[randIndex])
    return weights

#paramter: weights is a ndarray
def plotBestFit(weights):
    import matplotlib.pyplot as plt
    dataMat, labelMat = loadDataset()
    dataArr = np.array(dataMat)        # (100, 3)
    m = np.shape(dataArr)[0]
    xcord1 = []; ycord1 = []
    xcord2 = []; ycord2 = []
    # print np.mat(labelMat).transpose()
    for i in range(m):
        if  int(labelMat[i]) == 1:
            xcord1.append(dataArr[i, 1])
            ycord1.append(dataArr[i, 2])
        else:
            xcord2.append(dataArr[i, 1])
            ycord2.append(dataArr[i, 2])

    fig = plt.figure()
    ax = fig.add_subplot(111)
    # s: 'scalar'
    # marker = 's': square; '^': 正三角; 'v': 倒三角; '*': 星号; 'D': Diamond, 'd': 细钻
    ax.scatter(xcord1, ycord1, s = 30, c = 'red', marker = 's')
    ax.scatter(xcord2, ycord2, s = 30, c = 'green')
    x = np.arange(-3.0, 3.0, 0.1)
    y = (-weights[0] - weights[1] * x) / weights[2]
    print len(y)      # 60
    ax.plot(x, y)
    plt.xlabel('X1')
    plt.ylabel('X2')
    plt.show()


# dataArr, labelMat = loadDataset()
# stocGradAscent(dataArr, labelMat)
# weights = stoGradAscent1(np.array(dataArr), labelMat)
# plotBestFit(weights)
# print type(weights.getA())


def classifyVector(inX, weights):
    prob = sigmoid(sum(inX * weights))
    if prob > 0.5:
        return 1.0
    else:
        return 0.0


# stoGradAscent1()需要三个参数:  数据集(ndarray或matrix)、类别标签、迭代次数
# stoGradAscent1()函数的作用？ 返回最佳回归系数 - weights
# weights(最佳回归系数)的作用？ 与特征向量乘积的和作为z,传入sigmoid函数,若大于0.5,则相应标签为1,否则为0.
# 如何获得数据集和类别标签？ 按行读取本地的文件中数据, 将每行的前21个特征元素存入一个子列表(curr_line),
# 通过循环(readlines)将每个子列表存入总列表(curr_line同名),同时将每行的第22个元素(class)存入training_labels变量。

# classifyVector()需要参数: 特征向量、最佳回归系数
# classifyVector()作用: 看上面(weights)
# error_count: 如何判断一个错误？ classifyVector(); 将对应的特征向量与计算得来的最佳回归系数乘积并求和(sum)
# 若prob(概率)大于0.5,则表示正确，否则为一个error.

def colicTest():
    frTrain = open('horseColicTraining.txt')
    frTest = open('horseColicTest.txt')
    training_set = []
    training_labels = []
    # print len(frTrain.readlines()[0].split()  # 22
    for line in frTrain.readlines():
        curr_line = line.strip().split()
        line_arr = []
        for i in range(21):
            line_arr.append(float(curr_line[i]))
        # 0-20 is feature; 21 is class
        training_set.append(line_arr)
        training_labels.append(float(curr_line[21]))
    training_weights = stoGradAscent1(np.array(training_set), training_labels, 500)

    error_count = 0
    num_test_vec = 0.0
    for line in frTest.readlines():
        num_test_vec += 1.0
        curr_line = line.strip().split('\t')
        line_arr = []
        for i in range(21):
            line_arr.append(float(curr_line[i]))
        if int(classifyVector(np.array(line_arr), training_weights) != int(curr_line[21])):
            error_count += 1
    error_rate = (float(error_count) / num_test_vec)
    print "The error rate of this test is: %f" % error_rate
    return error_rate


# colicTest()

# 计算多次,取其均值
def multiTest(num_tests):
    num_tests = num_tests
    error_sum = 0.0
    for k in range(num_tests):
        error_sum += colicTest()
    print "After %d interations the average error rate is: %f" % (num_tests, error_sum / float(num_tests))


multiTest(10)

