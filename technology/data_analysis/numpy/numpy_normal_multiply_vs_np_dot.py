# -*- coding: utf-8 -*-
"""
Created on Sun Dec 10 14:47:37 2017

@author: yyc
"""

import numpy as np

a = np.array([10, 20, 30, 40])
b = np.arange(4)

a = a.reshape((2, 2))
b = b.reshape((2, 2))

normal_multiply = a * b
print(normal_multiply)      # [[  0  20]
                            #  [ 60 120]]

np_dot = np.dot(a, b)
print(np_dot)               # [[ 40  70]
                            #  [ 80 150]]
