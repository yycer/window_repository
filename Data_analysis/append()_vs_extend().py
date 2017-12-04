# -*- coding: utf-8 -*-
"""
Created on Mon Dec  4 20:57:27 2017

@author: yyc
"""

l1 = [1, 2, 3]
l2 = [1, 2, 3]

tmp = [4, 5, 6]
l1.append(tmp)
print(l1) # [1, 2, 3, [4, 5, 6]]

l2.extend(tmp)
print(l2) # [1, 2, 3, 4, 5, 6]