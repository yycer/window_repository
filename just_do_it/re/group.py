# -*- coding: utf-8 -*-
"""
Created on Tue Dec 19 10:52:18 2017

@author: yyc
"""

import re

# re.compile(pattern, flags = 0): Compile a regular expression pattern, returning a pattern obejct.
pattern = re.compile(r'([a-z]+) ([a-z]+)', re.I)
print(type(pattern))             # <class '_sre.SRE_Pattern'>
m = pattern.match('spartacus pursue for freedom')
print(m)                         # <_sre.SRE_Match object; span=(0, 16), match='spartacus pursue'>

print(m.group())                 # spartacus pursue
print(m.group() == m.group(0))   # True

print(m.group(1))                # spartacus
print(m.span(1))                 # (0, 9)

print(m.group(2))                # pursue
print(m.span(2))                 # (10, 16)

print(m.groups())                # ('spartacus', 'pursue')


