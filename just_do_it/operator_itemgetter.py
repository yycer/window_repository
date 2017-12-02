# -*- coding: utf-8 -*-
"""
Created on Sat Dec  2 20:31:50 2017

@author: yyc
"""
import operator

students = [('Gerg', 'C', 21), ('asan', 'A', 22), ('Qin', 'B', 23)]
# [('asan', 'A', 22), ('Qin', 'B', 23), ('Gerg', 'C', 21)]
print(sorted(students, key = operator.itemgetter(1)))

# [('Qin', 'B', 23), ('asan', 'A', 22), ('Gerg', 'C', 21)]
print(sorted(students, key = operator.itemgetter(2), reverse = True))