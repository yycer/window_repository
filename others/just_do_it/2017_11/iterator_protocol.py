# -*- coding: utf-8 -*-
"""
Created on Mon Nov 20 13:46:27 2017

"""

def isiterable(obj):
    try:
        iter(obj)
        return True
    except TypeError:
        return False

print(isiterable('a string'))       # True
print(isiterable([1, 2, 3]))        # True
print(isiterable((1, 2, 3)))        # True
print(isiterable({'name': 'Gerg'})) # True
print(isiterable({'name', 'age'}))  # True

# if not isinstance(x, list) and isiterable(x):
#    x = list(x)
