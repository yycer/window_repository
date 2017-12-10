# -*- coding: utf-8 -*-
"""
Created on Sun Dec 10 13:37:26 2017

@author: yyc
"""
import numpy as np

# ndim - n dimension.
# shape - (row, column)
# size - the numbers of elements along a given axis.

matrix = np.array([[1, 2, 3], [9, 8, 7]])
print(matrix)       # [[1 2 3]
                    #  [9 8 7]]

print(matrix.ndim)  # 2
print(matrix.shape) # (2, 3)
print(matrix.size)  # 6