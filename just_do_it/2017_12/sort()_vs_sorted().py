# -*- coding: utf-8 -*-
"""
Created on Sat Dec  2 20:11:00 2017

@author: yyc
"""

l1 = [3, 1, 9, 10, 6]
# seq.sort(),在原容器内排序,该函数返回值为None
l1.sort()
print(l1.sort()) # None
print(l1)        # [1, 3, 6, 9, 10]


# sorted(seq)，生成并返回一个排序好的新容器，原容器不变
l2 = [3, 1, 9, 10, 6]
print(sorted(l2)) # [1, 3, 6, 9, 10]
print(l2)         # [3, 1, 9, 10, 6]