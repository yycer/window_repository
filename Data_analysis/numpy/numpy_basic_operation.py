# -*- coding: utf-8 -*-
"""
Created on Sun Dec 10 15:09:08 2017

@author: yyc
"""

import numpy as np

# np.argmin & np.argmax
# argument min/max
# Returns the indices of the minimun(maximum) values along an axis

a = np.arange(2, 14).reshape((3, 4))
print(a)
#    [[ 2  3  4  5]
#     [ 6  7  8  9]
#     [10 11 12 13]]

print(np.argmin(a))     # 0
print(np.argmax(a))     # 11

#a_total = np.sum(a)
#a_size = np.size(a)
#a_average = a_total / a_size
#print(a_average)       # 7.5
print(np.mean(a))       # 7.5
# notice: weight
print(np.average(a))    # 7.5

# 若总数为偶数，计算最中间两数的平均数
print(np.median(a))     # 7.5

# np.cumsumsum - Returns the cumulative sum of the elements along a given axis.
print(np.cumsum(a))     # [ 2  5  9 14 20 27 35 44 54 65 77 90]

# np.diff - Calculate the n-th discrete difference along given axis.
print(np.diff(a))
#    [[1 1 1]
#     [1 1 1]
#     [1 1 1]]

print(np.nonzero(a))    # (array([0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2], dtype=int64), 
                        #  array([0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3], dtype=int64))

b = np.arange(14, 2, -1).reshape((3, 4))
print(b)
#    [[14 13 12 11]
#     [10  9  8  7]
#     [ 6  5  4  3]]

print(np.sort(b))       
#    [[11 12 13 14]
#     [ 7  8  9 10]
#     [ 3  4  5  6]]

print(np.transpose(b))
#    [[14 10  6]
#     [13  9  5]
#     [12  8  4]
#     [11  7  3]]
      
# Clip (limit) the values in an array.                  
print(np.clip(b, 5, 9))
#    [[9 9 9 9]
#     [9 9 8 7]
#     [6 5 5 5]]
                        



