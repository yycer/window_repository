# -*- coding: utf-8 -*-
"""
Created on Thu Dec 28 15:54:30 2017

@author: yyc
"""

import numpy as np


a1 = np.arange(1, 10)
a2 = np.arange(1, 10)
# np.array.reshape() - 千丝万缕
print(a1.reshape((3, 3)))       # [[1 2 3]
                                #  [4 5 6]
                                #  [7 8 9]]
                                
print(a1)                       # [1 2 3 4 5 6 7 8 9]

# np.array.shape - 一刀斩断
a2.shape = (3, 3)
print(a2)                       # [[1 2 3]
                                #  [4 5 6]
                                #  [7 8 9]]