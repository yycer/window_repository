# -*- coding: utf-8 -*-
"""
Created on Thu Dec 28 16:03:02 2017

@author: yyc
"""

import numpy as np


# np.mat?
# Interpret the input as a matrix.
# Unlike `matrix`, `asmatrix` does not make a copy if the input is already
# a matrix or an ndarray.  Equivalent to ``matrix(data, copy=False)``.

m1 = np.mat(np.arange(1, 10))
print(m1)                     # [[1 2 3 4 5 6 7 8 9]]
print(type(m1))               # <class 'numpy.matrixlib.defmatrix.matrix'>


# np.matrix?
# Returns a matrix from an array-like object, or from a string of data.
# A matrix is a specialized 2-D array that retains its 2-D nature
# through operations

m2 = np.matrix('1 2; 3 4')
#    [[1 2]
#     [3 4]]

m3 = np.matrix(np.array([[1, 2, 3], [4, 5, 6]]))
#    [[1 2 3]
#     [4 5 6]]

m4 = np.matrix(np.arange(1, 7).reshape((2, 3)))
#    [[1 2 3]
#     [4 5 6]]