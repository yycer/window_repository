# -*- coding: utf-8 -*-
"""
Created on Wed Dec  6 20:08:41 2017

@author: yyc
"""

# 什么是序列化？将变量从内存中转化成可存储(disk)或传输的过程 - pickling
try:
    import cPickle as pickle
except ImportError:
    import pickle

d = dict(name = 'Gerg', age = 21, hobby = 'running')

print(type(pickle.dumps(d))) # <class 'bytes'>
print(pickle.dumps(d))
# b'\x80\x03}q\x00(X\x04\x00\x00\x00nameq\x01X\x04\x00\x00\x00
# Gergq\x02X\x03\x00\x00\x00ageq\x03K\x15X\x05\x00\x00\x00hobbyq
# \x04X\x07\x00\x00\x00runningq\x05u.'

print(pickle.loads(pickle.dumps(d))) # {'name': 'Gerg', 'age': 21, 'hobby': 'running'}

with open('pickle.txt', 'wb+') as f:
    pickle.dump(d, f)