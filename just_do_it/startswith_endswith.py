# -*- coding: utf-8 -*-
"""
Created on Mon Nov 27 14:43:45 2017

@author: yyc
"""

str = 'Spartacus pursue for freedom'
print(len(str))                             # 28
print(str.index('freedom'))                 # 21
# S.startswith(prefix[, start[, end]]) -> bool
print(str.startswith('Spartacus'))          # True
print(str.startswith('Spartacus', 0))       # True
print(str.startswith('Spartacus', 1))       # False
print(str.startswith('pursue', 10, 16))     # True

# prefix can also be a tuple of strings to try.
print(str.startswith(('s', 'a', 'S')))      # True

print(str.endswith('freedom'))              # True
print(str.endswith('freedom', 21))          # True
print(str.endswith('freedom', 0))           # True
print(str.endswith('freedom', 0, 21))       # False

print(str.endswith(('a', 'b', 'c', 'm')))   # True
