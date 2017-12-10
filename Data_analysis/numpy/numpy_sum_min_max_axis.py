# -*- coding: utf-8 -*-
"""
Created on Sun Dec 10 14:54:51 2017

@author: yyc
"""

import numpy as np

a = np.random.random((2, 4))
print(a)
# [[ 0.86942046  0.31502649  0.56575223  0.85477847]
#  [ 0.82476669  0.0248576   0.30639993  0.09684966]]

print(np.sum(a))                # 3.85785153081
print(np.min(a))                # 0.0248576020448
print(np.max(a))                # 0.869420457472

# axis = 0 - down
# axis = 1 - across
print(np.min(a, axis = 0))      # [ 0.82476669  0.0248576   0.30639993  0.09684966]
print(np.min(a, axis = 1))      # [ 0.31502649  0.0248576 ]