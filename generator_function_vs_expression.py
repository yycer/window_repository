# -*- coding: utf-8 -*-
"""
Created on Thu Nov 23 16:30:31 2017

@author: yyc
"""

def f(x):
    for i in range(x):
        yield i ** 2

gen = f(6)

gen_expr = list(i ** 2 for i in range(6))
print(list(gen) == gen_expr) # True