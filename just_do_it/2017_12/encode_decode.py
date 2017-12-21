# -*- coding: utf-8 -*-
"""
Created on Thu Dec 21 14:10:13 2017

@author: yyc
"""
# 机器角度：
# encode: 将人看的数据转换成它看的
# decode: 相反

s1 = '晨'
s2 = u'晨'

print(type(s1))            # <class 'str'>
print(type(s2))            # <class 'str'>

print(s1.encode())         # b'\xe6\x99\xa8'
print(s2.encode())         # b'\xe6\x99\xa8'

print(type(s1.encode()))   # <class 'bytes'>
print(type(s2.encode()))   # <class 'bytes'>

b1 = b'\xe6\x99\xa8'
print(b1.decode())         # 晨
