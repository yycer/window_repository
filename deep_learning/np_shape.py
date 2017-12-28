# -*- coding: utf-8 -*-
"""
Created on Thu Dec 28 15:31:38 2017

@author: yyc
"""

import numpy as np

#m1 = np.arange(9)       # [0 1 2 3 4 5 6 7 8]

#m1.shape = 3, 3
m1_to_33 = np.reshape(np.arange(9), (3, 3))

print(m1_to_33)
#print(m1)
#    [[0 1 2]
#     [3 4 5]
#     [6 7 8]]