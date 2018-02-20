# -*- coding: utf-8 -*-
"""
Created on Tue Nov 21 16:22:55 2017

"""

#import re
#
#all_data = ['guang   zhou', ' shanghai', 'Bei#Jing', 'shenzhen!', '?Hongzhou ']
#
#def clean_strings(all_data):
#    result = []
#
#    for i in all_data:
#        i = i.strip()
         # re.sub(pattern, replacement, string, ...)
#        i = re.sub('[ ?!#]', '', i)
#        i = i.title()
#        result.append(i)
#        
#    return result
#
#print(clean_strings(all_data))           # ['Guangzhou', 'Shanghai', 'Beijing', 'Shenzhen', 'Hongzhou']


import re

all_data = ['guang   zhou', ' shanghai', 'Bei#Jing', 'shenzhen!', '?Hongzhou ']

def remove_punctuation(value):
    # 可用\W
    return re.sub('[ !#?]', '', value)
                    
clean_ops = [str.strip, remove_punctuation, str.title]

def clean_strings(data, ops):
    result = []
    for value in data:
        for function in ops:
            value = function(value)
        result.append(value)
    return result

print(clean_strings(all_data, clean_ops)) # ['Guangzhou', 'Shanghai', 'Beijing', 'Shenzhen', 'Hongzhou']
