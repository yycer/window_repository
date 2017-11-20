# -*- coding: utf-8 -*-
"""
Created on Mon Nov 20 20:34:04 2017

"""

l1 = [7, 1, 2, 8, 5, 9]
l2 = [7, 1, 2, 8, 5, 9]
l1.sort()
print(l1 == sorted(l2)) # True
print(l1)               # [1, 2, 5, 7, 8, 9]
print(l2)               # [7, 1, 2, 8, 5, 9]
