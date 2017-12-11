# -*- coding: utf-8 -*-
"""
Created on Fri Dec  1 10:04:29 2017

@author: yyc
"""

# eval()执行一个字符串表达式，并返回表达式的值
l = '[1, 2, 3]'
d = "{'name': 'Gerg', 'age': 21}"
t = "('name', 'age', 'hobby')"

print(eval(l))          # [1, 2, 3]
print(type(eval(l)))    # <class 'list'>

print(eval(d))          # {'name': 'Gerg', 'age': 21}
print(type(eval(d)))    # <class 'dict'>

print(eval(t))          # ('name', 'age', 'hobby')
print(type(eval(t)))    # <class 'tuple'>
