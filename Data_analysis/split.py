# -*- coding: utf-8 -*-
"""
Created on Mon Nov 27 20:38:45 2017

@author: yyc
"""
# Parameter:
# str -- 分隔符，默认为所有的空字符，包括空格、换行(\n)、制表符(\t)等。
# num -- 分割次数。

s1 = 'spartacus pursue for freedom'
s2 = 'spartacus \n\n\n  pursue \t for freedom'
print(s1.split())       # ['spartacus', 'pursue', 'for', 'freedom']
print(s2.split())       # ['spartacus', 'pursue', 'for', 'freedom']
print(s2.split(' '))    # ['spartacus', '\n\n\n', '', 'pursue', '\t', 'for', 'freedom']
print(s2.split(' ', 1)) # ['spartacus', '\n\n\n  pursue \t for freedom']

