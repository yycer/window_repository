# -*- coding: utf-8 -*-
"""
Created on Tue Dec 12 10:46:21 2017

@author: yyc
"""

import numpy as np

a = np.array([1, 1, 1])
b = np.array([2, 2, 2])
# np.vstack: take a sequence of arrays and stack them vertically to make a single array.
# parameter: sequence of ndarrays tuple containing arrays to be stacked.
vertical_stack = np.vstack((a, b))
#print(vertical_stack)
#    [[1 1 1]
#     [2 2 2]]

horizontal_stack = np.hstack((a, b))
#print(horizontal_stack)                 # [1 1 1 2 2 2]

print(a.shape)                          # (3, )
print(a)                                # [1 1 1]
print(a[np.newaxis, :])                 # [[1 1 1]]
print(type(a[np.newaxis, :]))           # <class 'numpy.ndarray'>

print(a[:, np.newaxis])
#    [[1]
#     [1]
#     [1]]

result = np.concatenate((a, b, a), axis = 0)
print(result)
