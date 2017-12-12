# -*- coding: utf-8 -*-
"""
Created on Tue Dec 12 10:37:57 2017

@author: yyc
"""

import numpy as np

a = np.arange(15).reshape((3, 5))
print(a)
#    [[ 0  1  2  3  4]
#     [ 5  6  7  8  9]
#     [10 11 12 13 14]]

print(a[1])                 # [5 6 7 8 9]
print(a[1][2])              # 7
print(a[1][1: 3])           # [6 7]

a_to_one_row = a.flatten()
print(a_to_one_row)         # [ 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14]

