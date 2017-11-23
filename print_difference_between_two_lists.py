# -*- coding: utf-8 -*-
"""
Created on Thu Nov 23 08:31:26 2017

@author: yyc
"""

import json

l1 = ['asan', 'pangzi', 'qin', 'laowang']
l2 = ['asan', 'shoushan', 'laowang']

l1.extend(l2)
print(json.dumps(dict(enumerate(set(l1))), indent = 4))

#    output:
#            {
#                "0": "qin",
#                "1": "asan",
#                "2": "laowang",
#                "3": "shoushan",
#                "4": "pangzi"
#            }