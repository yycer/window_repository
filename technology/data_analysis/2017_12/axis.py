# -*- coding: utf-8 -*-
"""
Created on Sat Dec  2 17:21:48 2017

@author: yyc
"""

import numpy as np

group = np.array([[0, 1, 2],
                  [3, 4, 5],
                  [6, 7, 8]])

print(group.sum(axis = 0)) # [ 9 12 15] - down
print(group.sum(axis = 1)) # [ 3 12 21] - across