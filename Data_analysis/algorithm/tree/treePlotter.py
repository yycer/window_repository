import matplotlib.pyplot as plt

# facing color = background color; 0 - black; 1 - white
decisionNode = dict(boxstyle = 'sawtooth', fc = '0.8')
# round4 != round
leafNode = dict(boxstyle = 'round4', fc = '0.8')
arrow_args = dict(arrowstyle = '<-')

# va: verticalAlignment; ha: horizontalAlignment
# bbox: bounding box; arrowprops: arrow properties
#def plotNode(nodeTxt, centerPt, parentPt, nodeType):
def plotNode(nodeTxt, endpoint, startpoint, nodeType):
    createPlot.ax1.annotate(nodeTxt, xy = startpoint, \
        xycoords = 'axes fraction', xytext = endpoint, \
        textcoords = 'axes fraction', va = 'center', ha = 'center', \
        bbox = nodeType, arrowprops = arrow_args)
  
#def createPlot():
#    fig = plt.figure(1, facecolor = 'white')
#    # cla: clear axis; clf: clear figure
#    # close: close a figure window
#    fig.clf()
#    # frameon: bool, optional, default: True
#    # If False, suppress drawing the figure frame.
#    # createPlot.ax1 = plt.subplot(111, frameon = False)
#    createPlot.ax1 = plt.subplot(111)
#    plotNode('a decision node', (0.5, 0.1), (0.1, 0.5), decisionNode)
#    plotNode('a leaf node', (0.8, 0.1), (0.3, 0.8), leafNode)
#    plt.show()
#
def createPlot(inTree):
    fig = plt.figure(1, facecolor = 'white')
    fig.clf()
    # x,y轴记号, 不显示刻度
    axprops = dict(xticks = [], yticks = [])
    createPlot.ax1 = plt.subplot(111, frameon = False, **axprops)
#    createPlot.ax1 = plt.subplot(111)
    # width, depth
    plotTree.totalW = float(getNumLeafs(inTree))    # 3.0
    plotTree.totalD = float(getTreeDepth(inTree))   # 2.0
    plotTree.xOff = -0.5 / plotTree.totalW # -0.16666666666666666
    plotTree.yOff = 1.0
    plotTree(inTree, (0.5, 1.0), '')
    plt.show()
# myTree
# {'no surfacing': {0: 'no', 1: {'flippers': {0: 'no', 1: 'yes'}}}}
def plotTree(myTree, startpoint, nodeText):
    width = getNumLeafs(myTree)
    depth = getTreeDepth(myTree)
    firstStr = list(myTree.keys())[0] # no surfacing
#    (0.5, 1.0)
#    (0.6666666666666666, 0.5)
    centerPoint = (plotTree.xOff + (1.0 + float(width)) / 2.0 / \
              plotTree.totalW, plotTree.yOff)
    plotMidText(centerPoint, startpoint, nodeText)
    secondDict = myTree[firstStr]
    plotNode(firstStr, centerPoint, startpoint, decisionNode)
    plotTree.yOff = plotTree.yOff - 1.0 / plotTree.totalD
    for key in secondDict.keys():
        if type(secondDict[key]).__name__ == 'dict':
            plotTree(secondDict[key], centerPoint, str(key))
        else:
            plotTree.xOff = plotTree.xOff + 1.0 / plotTree.totalW
            plotNode(secondDict[key], (plotTree.xOff, plotTree.yOff),\
                     centerPoint, leafNode)
            plotMidText((plotTree.xOff, plotTree.yOff), centerPoint, str(key))
    plotTree.yOff = plotTree.yOff + 1.0 / plotTree.totalD


def plotMidText(centerPoint, startPoint, txtString):
    xMid = (startPoint[0] - centerPoint[0]) / 2.0 + centerPoint[0]
    yMid = (startPoint[1] - centerPoint[1]) / 2.0 + centerPoint[1]
    createPlot.ax1.text(xMid, yMid, txtString)
#    createPlot.ax1.text(xMid, yMid, txtString, va="center", ha="center", rotation=30)

#createPlot()

# recursive function
def getNumLeafs(myTree):
    numLeafs = 0
    firstStr = list(myTree.keys())[0] # no surfacing
    # {0: 'no', 1: {'flippers': {0: 'no', 1: 'yes'}}}
    secondDict = myTree[firstStr]
    for key in list(secondDict.keys()):
        # 若节点的类型为字典，则该节点为判断节点
        if type(secondDict[key]).__name__ == 'dict':
            numLeafs += getNumLeafs(secondDict[key])
        # 否则为叶子节点
        else:
            numLeafs += 1
    return numLeafs

# recursive function
def getTreeDepth(myTree):
    maxDepth = 0
    firstStr = list(myTree.keys())[0] # no surfacing
    # {0: 'no', 1: {'flippers': {0: 'no', 1: 'yes'}}}
    secondDict = myTree[firstStr]
    for key in list(secondDict.keys()):
        if type(secondDict[key]).__name__ == 'dict':
            thisDepth = 1 + getTreeDepth(secondDict[key])
        else:
            thisDepth = 1
        if thisDepth > maxDepth:
            maxDepth = thisDepth
    return maxDepth

def retrieveTree(i):
    listOfTrees = [{'no surfacing': {0: 'no', 1: {'flippers': \
                    {0: 'no', 1: 'yes'}}}},
                    {'no surfacing': {0: 'no', 1: {'flippers': \
                    {0: {'head': {0: 'no', 1: 'yes'}}, 1: 'no'}}}}]
    return listOfTrees[i]

myTree = retrieveTree(0)
#print(getNumLeafs(myTree))  # 3
#print(getTreeDepth(myTree)) # 2
#myTree['no surfacing'][2] = 'yyc'
#createPlot(myTree)


                

















