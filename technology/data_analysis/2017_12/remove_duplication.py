# -*- coding: utf-8 -*-
"""
Created on Tue Dec 12 17:08:55 2017

@author: yyc
"""
# 补充(2018_02_22)
l = [[1, 2, 3, 1, 2], [4, 5, 6, 5, 6], [7, 8, 9, 8]]

# Resolution one:
tmp = [j for i in l for j in i]
result = list(set(tmp))
print(result)           # [1, 2, 3, 4, 5, 6, 7, 8, 9]


# Resolution two:
# s = set({}); s = set(()); s = set([])均可
s = set()
for i in l:
    # 逻辑或
    s = s | set(i)
print(list(s))          # [1, 2, 3, 4, 5, 6, 7, 8, 9]