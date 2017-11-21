# -*- coding: utf-8 -*-
"""
Created on Tue Nov 21 14:06:00 2017

@author: yyc
"""

l1 = [1, 2]
l2 = [True, False]

l1_copy = [1, 2]
l2_copy = [True, False]

l1.append(l2)
print(l1)                   # [1, 2, [True, False]]

l1_copy.extend(l2_copy)
print(l1_copy)              # [1, 2, True, False]