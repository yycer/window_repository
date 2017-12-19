# -*- coding: utf-8 -*-
"""
Created on Tue Dec 19 10:36:50 2017

@author: yyc
"""

import re

a = 'spartacus purse the freedo\nm'
b = r'spartacus purse the freedo\nm'

print(a)                            # spartacus purse the freedo
                                    # m
print(b)                            # spartacus purse the freedo\nm

c = 'spartacus purse the freedom spartacus'
# re.match(pattern, string, flag = 0)
# Try to apply the pattern at the start of the string,
# returning a match object, or None if no match was found.
match1 = re.match(r'\w+', c)        # \w: a-zA-Z0-9_
print(match1.group(0))              # spartacus


# re.search(pattern, string, flag = 0)
# Scan through string looking for a match to the pattern, returning
# a match object, or None if no match was found.
match2 = re.search('spartacus', c)
print(match2.group(0))              # spartacus
print(match2.start())               # 0
print(match2.end())                 # 9
print(match2.span())                # (0, 9)


# re.findall(pattern, string, flag = 0)
# Return a list of all non-overlapping matches in a string.
match3 = re.findall('spartacus', c)
print(match3)                       # ['spartacus', 'spartacus']

