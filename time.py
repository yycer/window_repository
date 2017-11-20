# -*- coding: utf-8 -*-
"""
Created on Mon Nov 20 15:10:42 2017

@author: Administrator
"""

import time

# timestamp
print(time.time()) # 1511161861.6538002

print(time.strftime('%H:%M:%S')) # 15:11:54

# Month/Day/Year
print(time.strftime('%D %H:%M:%S')) # 11/20/17 15:12:24

# Year/Month/Day
print(time.strftime('%y/%m/%d %H:%M:%S')) # 17/11/20 15:13:12