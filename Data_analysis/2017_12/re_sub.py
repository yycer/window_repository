# -*- coding: utf-8 -*-
"""
Created on Wed Dec 13 15:00:50 2017

@author: yyc
"""

import re

a = 'This book is the best book on Python or M.L. I have ever laid eyes upon.'
# re.sub(pattern, replacement, string, count)
tmp = re.sub(r'\W', ' ', a).split(' ')
# ['This', 'book', 'is', 'the', 'best', 'book', 'on', 'Python', 'or', 'M', 'L', 'I', 'have', 'ever', 'laid', 'eyes', 'upon']
print([i for i in tmp if len(i) > 0])
