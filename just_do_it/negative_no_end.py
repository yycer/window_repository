# -*- coding: utf-8 -*-
"""
Created on Fri Nov 24 08:43:01 2017

@author: yyc
"""

l = [i for i in range(15)] # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]

print(l[-10:] == l[-10 + len(l):]) # True
