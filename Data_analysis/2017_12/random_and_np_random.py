# -*- coding: utf-8 -*-
"""
Created on Tue Dec 12 09:10:46 2017

@author: yyc
"""

import random

# random.random: x in the interval [0, 1).
a = random.random()                            # 0.9789956203536088

# random.uniform: get a random number in the range [a, b) or [a, b] depending on rounding.
b = random.uniform(1, 5)                       # 1.5791685082002123
print(b)
# random.randint: return random integer in range [a, b].
c = random.randint(10, 20)                     # 18

# random.randrange: choose a random item from range(start, stop[, step])
d = random.randrange(1, 10, 3)                 # 7

# random.choice(sequence): choose a random element from a non-empty sequence.
e = random.choice(['asan', 'Gerg', 'pangzi'])  # pangzi

# random.shuffle(x): shuffle list x in place, and return None.
l1 = ['asan', 'Gerg', 'pangzi', 'Qin']
random.shuffle(l1)
#print(l1)                                     # ['Gerg', 'Qin', 'pangzi', 'asan']

l2 = list(range(10))
f = random.sample(l2, 3)                       # [5, 8, 3]

import numpy as np

# np.random.rand(d0, d1, ..., dn)
# create an array of the given shape and populate it with random samples from a
# uniform distribution over [0, 1).
print(np.random.rand(3, 2))
#    [[ 0.19982462  0.53618899]
#     [ 0.45904821  0.36484357]
#     [ 0.3864873   0.88718363]]


# return random integers from the "discrete uniform" distribution of the specified
# dtype in the "half-open" interval [low, high). If high is None(the default), then
# results are from [0, low)
print(np.random.randint(5, size = (2, 3)))
#    [[0 2 0]
#     [2 2 4]]

print(np.random.randint(5, 10, size = (3, 2)))
#    [[9 7]
#     [9 7]
#     [6 9]]





