# -*- coding: utf-8 -*-
"""
Created on Fri Dec  8 15:46:08 2017

@author: yyc
"""

import numpy as np

# zeros(shape, dtype=float, order='C')
# Return a new array of given shape and type, filled with zeros.
# dtype: Default is `numpy.float64`
a = np.zeros(5)            # [ 0.  0.  0.  0.  0.]
b = np.zeros((5))          # [ 0.  0.  0.  0.  0.]
c = np.zeros((5, ))        # [ 0.  0.  0.  0.  0.]
# <class 'numpy.ndarray'> n dimentsional array object
print(type(a) == type(b) == type(c)) # True

# result
r1 = c + 10
print(r1)                  # [ 10.  10.  10.  10.  10.]
l1 = [1, 2, 3, 4, 5]
print(c + l1)               # [ 1.  2.  3.  4.  5.]
