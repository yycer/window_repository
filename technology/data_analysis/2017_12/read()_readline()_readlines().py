# -*- coding: utf-8 -*-
"""
Created on Sun Dec  3 13:30:37 2017

@author: yyc
"""
#
with open('test1203.txt') as f:
    print(f.read())
    
#   <class 'str'>
#    0.Spartacus pursue for freedom.
#    1.Spartacus pursue for freedom.
#    2.Spartacus pursue for freedom.
#    3.Spartacus pursue for freedom.
#    4.Spartacus pursue for freedom.
#    5.Spartacus pursue for freedom.
#    6.Spartacus pursue for freedom.
#    7.Spartacus pursue for freedom.
#    8.Spartacus pursue for freedom.
#    9.Spartacus pursue for freedom.

with open('test1203.txt') as f:
    print(f.readline())
    print(f.readline())
    
#   <class 'str'>
#    0.Spartacus pursue for freedom.
#    
#    1.Spartacus pursue for freedom.

with open('test1203.txt') as f:
    print(f.readlines())
    
#   <class 'list'>
#    ['0.Spartacus pursue for freedom.\n', 
#     '1.Spartacus pursue for freedom.\n', 
#     '2.Spartacus pursue for freedom.\n', 
#     '3.Spartacus pursue for freedom.\n', 
#     '4.Spartacus pursue for freedom.\n', 
#     '5.Spartacus pursue for freedom.\n', 
#     '6.Spartacus pursue for freedom.\n', 
#     '7.Spartacus pursue for freedom.\n', 
#     '8.Spartacus pursue for freedom.\n', 
#     '9.Spartacus pursue for freedom.']