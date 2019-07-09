# -*- coding: utf-8 -*-
"""
Created on Tue Dec 19 10:36:50 2017

@author: yyc
"""
# 参考：http://www.pythontab.com/html/2013/pythonjichu_0201/199.html
import re

a = 'spartacus purse the freedo\nm'
b = r'spartacus purse the freedo\nm'

print(a)                            # spartacus purse the freedo
                                    # m
print(b)                            # spartacus purse the freedo\nm

c = 'spartacus purse the freedom spartacus'
d = '@spartacus purse the freedom spartacus'

# re.match(pattern, string, flag = 0)
# Try to apply the pattern at the start of the string,
# returning a match object, or None if no match was found.
# match()只有当起始位置匹配成功，才有返回，否则为None
match1 = re.match(r'\w+', c)        # \w: a-zA-Z0-9_
match11 = re.match(r'\w+', d)
print(match1.group(0))              # spartacus
if match11:
    print(match11.group(0))
else:
    print('match11 is not match')   # match11 is not match


# re.search(pattern, string, flag = 0)
# Scan through string looking for a match to the pattern, returning
# a match object, or None if no match was found.
# search()会扫描整个字符串并返回第一个成功的匹配
match2 = re.search('spartacus', c)
print(match2.group(0))              # spartacus
print(match2.start())               # 0
print(match2.end())                 # 9
print(match2.span())                # (0, 9)

pattern = re.compile(r'\d+')
m2 = pattern.search('Hello world 123456')
if m2:
    print('matching string: {}'.format(m2.group()))     # matching string: 123456
    print('position: {}'.format(m2.span()))             # position: (12, 18)


# re.findall(pattern, string, flag = 0)
# Return a list of all non-overlapping matches in a string.
match3 = re.findall('spartacus', c)
print(match3)                       # ['spartacus', 'spartacus']


# re.split(pattern, string, maxsplit = 0, flag = 0)
# Split the source string by the occurrences of the pattern, returning a list
# containing the resulting substrings.
pattern = re.compile(r'[\s\,\;]+')
match4 = pattern.split('a;;;;b   c,,,,,   d  ; e')
print(match4)                       # ['a', 'b', 'c', 'd', 'e']


