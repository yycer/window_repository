# -*- coding: utf-8 -*-
"""
Created on Sun Dec 10 13:49:06 2017

@author: yyc
"""

import numpy as np

# default np.int = int 32
a = np.array([1, 2, 3], dtype = np.int)
print(a.dtype) # int32

b = np.array([1, 2, 3], dtype = np.int64)
print(b.dtype)  # int64

# default np.float = float64
c = np.array([1, 2, 3], dtype = np.float)
print(c.dtype)   # float64

d = np.array([1, 2, 3], dtype = np.float32)
print(d.dtype)    # float32


