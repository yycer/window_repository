# -*- coding: utf-8 -*-
"""
Created on Tue Nov 21 10:35:31 2017

"""
import json


words = ['asan', 'qin', 'apple', 'query', 'quick']

d = {}
#    traditional way
#    for word in words:
#        letter = word[0]
#        if not letter in d:
#            d[letter] = [word]
#        else:
#            d[letter].append(word)

#    print(json.dumps(d, indent = 4))

#     brief way
for word in words:
    letter = word[0]
    d.setdefault(letter, []).append(word)
    
print(json.dumps(d, indent = 4))

#     output:
#    {
#        "a": [
#            "asan",
#            "apple"
#        ],
#        "q": [
#            "qin",
#            "query",
#            "quick"
#        ]
#    }
#    
#     dict.setdefault?
#     Docstring: D.setdefault(k[,d]) -> D.get(k,d), also set D[k]=d if k not in D