import numpy as np


a1 = np.arange(4).reshape((2, 2))
# print(a)               # [[0 1]
                         #  [2 3]]

# numpy.mat(data, dtype = None): Unlike matrix, asmatrix does not make a copy if the input is already a matrix or an ndarray
# [千丝万缕]当输入的数据为矩阵或数组时，指向同一个引用。
m = np.mat(a1)
a1[1, 1] = 666
# print(a)               # [[  0   1]
                         # [  2 666]]
# print(m)               # [[  0   1]
                         # [  2 666]]


a2 = np.arange(4).reshape((2, 2))
# numpy.matrix(data, dtype, copy): Returns a matrix from an array-like object, or from a string of data.
# A matrix is a specilizied 2-D array that retains its 2-D nature through operations.
# [一刀斩断]通过np.matrix()生成的是一个全新的对象
n = np.matrix(a2)
a2[1, 1] = 999
# print(a2)              # [[  0   1]
                         #  [  2 999]]
# print(n)               # [[0 1]
                         #  [2 3]]


a3 = np.arange(4).reshape((2, 2))
# numpy.asmatrix(data, dtype): asmatrix does not make a copy if the input is already a matrix or an ndarray.
# Equivalent to matrix(data, copt = False)
# [千丝万缕]
j = np.asmatrix(a3)
a3[1, 1] = 888
# print(a3)              # [[  0   1]
#                        #  [  2 888]]
# print(j)               # [[  0   1]
#                        #  [  2 888]]
