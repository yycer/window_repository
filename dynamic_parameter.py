# -*- coding: utf-8 -*-
"""
Created on Mon Nov 20 10:29:39 2017

"""
# 由于Python是按引用传递的，所以传入函数的参数也是动态的
def append_element(a_list, element):
    a_list.append(element)

data = [1, 2, 3]
append_element(data, 'Gerg')
print(data)