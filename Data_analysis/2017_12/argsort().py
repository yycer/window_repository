# -*- coding: utf-8 -*-
"""
Created on Mon Dec  4 08:23:25 2017

@author: yyc
"""
import numpy as np

array1 = np.array([9, 1, 2, 8, 5, 3])
array2 = np.array([9, 1, 2, 8, 5, 3])
array1.sort()
print(array1)           # [1 2 3 5 8 9]

# returns the indices that would sort this array.
print(array2.argsort()) # [1 2 5 4 3 0]