# -*- coding: utf-8 -*-
"""
Created on Wed Nov 29 09:56:53 2017

@author: yyc
"""

# int
a1 = 1
b1 = 1
print(a1 == b1) # True
print(a1 is b1) # True

# str
a2 = 'string'
b2 = 'string'
print(a2 == b2) # True
print(a2 is b2) # True

# None
a7 = None
b7 = None
print(a7 == b7) # True
print(a7 is b7) # True

# list
a3 = [1, 2, 3]
b3 = [1, 2, 3]
print(a3 == b3) # True
print(a3 is b3) # False

# tuple
a4 = (1, 2, 3)
b4 = (1, 2, 3)
print(a4 == b4) # True
print(a4 is b4) # False

# dict
a5 = {'name': 'Gerg'}
b5 = {'name': 'Gerg'}
print(a5 == b5) # True
print(a5 is b5) # False

# set
a6 = {1, 2, 3}
b6 = {1, 2, 3}
print(a6 == b6) # True
print(a6 is b6) # False
