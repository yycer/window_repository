# -*- coding: utf-8 -*-
"""
Created on Mon Nov 27 14:15:05 2017

@author: yyc
"""

import os

sep = '-'
sequence1 = ['asan', 'pangzi', 'Gerg']
sequence2 = 'string'
sequence3 = ('name', 'age', 'hobby')
# 以sep为分隔符，将sequence中的所有元素合并成一个新的字符串
print(sep.join(sequence1))  # asan-pangzi-Gerg
print(sep.join(sequence2))  # s-t-r-i-n-g
print(sep.join(sequence3))  # name-age-hobby


print(os.path.join('/layer1/', 'layer2/', 'layer3/')) # /layer1/layer2/layer3/

