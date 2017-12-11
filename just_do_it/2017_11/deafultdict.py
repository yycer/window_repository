# -*- coding: utf-8 -*-
"""
Created on Tue Nov 21 10:52:29 2017

"""

import json
from collections import defaultdict

words = ['asan', 'qin', 'apple', 'query', 'quick']

# {[], [], ..., []}
d = defaultdict(list)
for word in words:
    d[word[0]].append(word)

print(json.dumps(d, indent = 4))

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