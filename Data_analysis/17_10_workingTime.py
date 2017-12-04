# -*- coding: utf-8 -*-
"""
Created on Mon Dec  4 09:41:31 2017

@author: yyc
"""

fr = open('17_10_workingTime.txt')
lines = fr.readlines()
count = len(lines)
l1 = []
l2 = []
#print(count) # 18
for line in lines:
    line = line.strip()
    listFromLine = line.split('-')
#    print(listFromLine[0])
    l1.append(int(listFromLine[0]))
    l2.append(int(listFromLine[1]))
print('total: {}'.format(sum(l1) + sum(l2) / 60)) # total: 209.4
print((sum(l1) + sum(l2) / 60) / 18)              # 11.633333333333333
