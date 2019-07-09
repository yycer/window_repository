# -*- coding: utf-8 -*-
"""
Created on Sun Nov 19 20:26:47 2017

@author: yyc
"""
# According to Problem Solving with Algorithms and Data Structure using python
# Greatest Common Divisor
def gcd(m, n):
    while m % n != 0:
        old_m = m
        old_n = n
        
        m = old_n
        n = old_m % old_n
    return n
print(gcd(90, 48)) # 6