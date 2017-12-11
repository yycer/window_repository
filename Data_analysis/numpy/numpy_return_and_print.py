# -*- coding: utf-8 -*-
"""
Created on Sun Dec 10 14:10:50 2017

@author: yyc
"""

import numpy as np

a = np.arange(-2, 2)     # [-2 -1  0  1]
b = np.arange(10)        # [False False False False False False  True  True  True  True]
print(b > 5)

print(10 * np.sin(a))    # [-9.09297427 -8.41470985  0.          8.41470985]

def test(data):
    result = 10 * np.sin(data)
    return print(result < 0)

test(a)                  # [ True  True False False]