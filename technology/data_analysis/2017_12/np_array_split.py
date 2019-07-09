# -*- coding: utf-8 -*-
"""
Created on Tue Dec 12 13:42:55 2017

@author: yyc
"""
import numpy as np

a = np.arange(15).reshape((3,5))
#print(a)
#    [[ 0  1  2  3  4]
#     [ 5  6  7  8  9]
#     [10 11 12 13 14]]

# np.split: split an array into multiple sub-arrays.
# np.split(a, 3, axis = 0) == np.vsplit(a, 3)
# 补充(2018_02_21)：axis = 0 --> down，也就是纵向分离
print(np.split(a, 3, axis = 0))         # [array([[0, 1, 2, 3, 4]]), array([[5, 6, 7, 8, 9]]), array([[10, 11, 12, 13, 14]])]

# np.split(a, 3, axis = 1) == np.hsplit(a, 3)
print(np.split(a, 5, axis = 1))         # [array([[ 0],[ 5],[10]]), array([[ 1],[ 6],[11]]), array([[ 2],[ 7],[12]]), array([[ 3],[ 8],[13]]), array([[ 4],[ 9],[14]])]


# np.array_split: The only difference between these functions is that array_split
# allow indices_or_sections to be an integer that does not equally divide the axis.

print(np.split(a, 4, axis = 0))         # ValueError: array split does not result in an equal division
print(np.array_split(a, 4, axis = 0))   # [array([[0, 1, 2, 3, 4]]), array([[5, 6, 7, 8, 9]]), array([[10, 11, 12, 13, 14]]), array([], shape=(0, 5), dtype=int32)]


    
