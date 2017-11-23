# -*- coding: utf-8 -*-
"""
Created on Thu Nov 23 08:31:26 2017

@author: yyc
"""

import json

l1 = ['asan', 'pangzi', 'qin', 'laowang']
l2 = ['asan', 'shoushan', 'laowang']

l12set = set(l1)
l22set = set(l2)
print(json.dumps(dict(enumerate(l12set ^ l22set)), indent = 4))