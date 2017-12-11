# -*- coding: utf-8 -*-
"""
Created on Mon Nov 20 19:33:11 2017

"""
# 二分法
import bisect


l = ['asan', 'Gerg', 'pangzi']

# append
l.append('laowang')
print(l) # ['asan', 'Gerg', 'pangzi', 'laowang']

# insert
l.insert(2, 'shoushan')
print(l) # ['asan', 'Gerg', 'shoushan', 'pangzi', 'laowang']

# pop
l.pop(2)
print(l) # ['asan', 'Gerg', 'pangzi', 'laowang']

# remove
l.remove('Gerg')
print(l) # ['asan', 'pangzi', 'laowang']

# in
print('asan' in l) #  True

# merge: lose a lot of resources
l2 = ['qin', 'tuhao']
print(l + l2) # ['asan', 'pangzi', 'laowang', 'qin', 'tuhao']

# extend: add multiply elements at once
#l.extend(True) # TypeError: 'bool' object is not iterable
l.extend('haoren')
print(l) # ['asan', 'pangzi', 'laowang', 'h', 'a', 'o', 'r', 'e', 'n']

l2 = [1, 8, 2, 6, 5]
l2.sort()
print(l2) # [1, 2, 5, 6, 8]

l3 = [1, 10, 2, 9]
l3.sort()
# the index that the element should be inserted
print(bisect.bisect(l3, 5)) # 2
# bisect.insort() really do it!
bisect.insort(l3, 5)
print(l3) # [1, 2, 5, 9, 10]

l4 = ['H','e','l','l','o','!']
print(len(l4)) # 6
print(l4[-4: -2] == l4[- 4 + 6 : -2 + 6]) # True