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

print(type(s1))                        # <class 'str'>
print(type(s2))                        # <class 'unicode'>

print(u'晨'.encode('utf-8'))           # 晨
print(type(u'晨'.encode('utf-8')))     # <type 'str'>

print(s1.decode('utf-8'))              # 晨
print(type(s1.decode('utf-8')))        # <type 'unicode'>

