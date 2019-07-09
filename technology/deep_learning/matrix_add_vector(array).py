# -*- coding: utf-8 -*-
"""
Created on Thu Dec 28 15:44:06 2017

@author: yyc
"""

import numpy as np

# m: matrix; na: np.array(vector); e1: evaluate
m1 = np.arange(1, 10)       # [1 2 3 4 5 6 7 8 9]
m1.shape = 3, 3
m1 = np.mat(m1)             # [[1 2 3]
                            #  [4 5 6]
                            #  [7 8 9]]

na1 = np.array([1, 10, 100])

e1 = m1 + na1
print(e1)                   # [[  2  12 103]
                            #  [  5  15 106]
                            #  [  8  18 109]]