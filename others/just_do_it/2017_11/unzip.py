# -*- coding: utf-8 -*-
"""
Created on Mon Nov 20 21:03:02 2017

"""

s1 = ['asan', 'Gerg', 'qin']
s2 = [317, 403, 316]
ziped_data = zip(s1, s2)
# unzip
name, dormitory_num = zip(*ziped_data)
print(name)             # ('asan', 'Gerg', 'qin')
print(dormitory_num)    # (317, 403, 316)