# -*- coding: utf-8 -*-
"""
Created on Thu Nov 23 16:38:30 2017

@author: yyc
"""

def fib():
    former, latter = 0, 1
    yield former
    yield latter
    while True:
        former, latter = latter, former + latter
        yield latter

gen = fib()

print(next(gen))    #0
print(next(gen))    #1 
print(next(gen))    #1
print(next(gen))    #2
print(next(gen))    #3
print(next(gen))    #5
print(next(gen))    #8
print(next(gen))    #13
print(next(gen))    #21
print(next(gen))    #34
print(next(gen))    #55

