# -*- coding: utf-8 -*-
"""
Created on Sat Dec 16 13:19:48 2017

@author: yyc
"""

def conflict(state, nextX):
    nextY = len(state)
    for i in range(nextY):
        if abs(state[i] - nextX) in (0, nextY - i):
            return True
    return False


def queens(num, state = ()):
    for i in range(num):
        if not conflict(state, i):
            if len(state) == num - 1:
                yield (i, )
            else:
                for result in queens(num, state + (i,)):
                    yield (i, ) + state


print(len(list(queens(8)))) # 92