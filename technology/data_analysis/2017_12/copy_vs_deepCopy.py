# -*- coding: utf-8 -*-
"""
Created on Tue Dec 12 13:45:29 2017

@author: yyc
"""
import numpy as np

a1 = np.array([[1, 2 ,3], [11, 22, 33]])
a2 = np.array([[1, 2 ,3], [11, 22, 33]])

#print(a1)
#    [[ 1  2  3]
#     [11 22 33]]

# shallow copy: 千丝万缕，纠缠不清
b1 = a1
c1 = b1
print(b1 is a1)       # True
print(c1 is a1)       # True

# if a1 changed
a1[1][1] = 55
print(a1)
#    [[ 1  2  3]
#     [11 55 33]]
print(b1)
#    [[ 1  2  3]
#     [11 55 33]]
print(c1)
#    [[ 1  2  3]
#     [11 55 33]]

# if b1 changed
b1[1][1] = 555
print(a1)
#    [[  1   2   3]
#     [ 11 555  33]]
print(c1)
#    [[  1   2   3]
#     [ 11 555  33]]

# if c1 changed
c1[1][1] = 5555
print(a1)
#    [[   1    2    3]
#     [  11 5555   33]]
print(b1)
#    [[   1    2    3]
#     [  11 5555   33]]


# obj.copy(): deep copy 一刀斩断
b2 = a2.copy()
c2 = b2.copy()
print(b2 is a2)       # False
print(c2 is a2)       # False


# if a2 changed
a2[1][1] = 88
print(a2)
#    [[ 1  2  3]
#     [11 88 33]]
#
print(b2)
#    [[ 1  2  3]
#     [11 22 33]]

print(c2)
#    [[ 1  2  3]
#     [11 22 33]]

# if b2 changed
b2[1][1] = 888
print(b2)
#    [[  1   2   3]
#     [ 11 888  33]]

print(a2)
#    [[ 1  2  3]
#     [11 88 33]]

print(c2)
#    [[ 1  2  3]
#     [11 22 33]]


# if c2 changed
c2[1][1] = 8888
print(a2)
#    [[ 1  2  3]
#     [11 88 33]]

print(b2)
#    [[  1   2   3]
#     [ 11 888  33]]

print(c2)
#    [[   1    2    3]
#     [  11 8888   33]]




