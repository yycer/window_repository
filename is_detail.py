# -*- coding: utf-8 -*-
"""
Created on Mon Nov 20 16:12:31 2017

"""

l1 = [1, 2]
l2 = [1, 2]
print('list: {}'.format(l1 is l2))      # False

t1 = (1, 2)
t2 = (1, 2)
print('tuple: {}'.format(t1 is t2))     # False

d1 = {'name': 'yyc'}
d2 = {'name': 'yyc'}
print('dict: {}'.format(d1 is d2))      # False

s1 = 'asan'
s2 = 'asan'
print('str: {}'.format(s1 is s2))       # True

n1 = None
n2 = None
print('None: {}'.format(n1 is n2))      # True