# -*- coding: utf-8 -*-
"""
Created on Fri Dec  1 16:24:18 2017

@author: yyc
"""
# Stored "Spartacus pursue for freedom." in try1201.txt
# read
with open('try1201.txt', 'r') as f:
    print(f.read())             # Spartacus pursue for freedom.

# write - truncate
with open('try1201.txt', 'w') as f:
    f.write('update')           # update

with open('try1201.txt', 'a') as f:
    f.write('addition')         # Spartacus pursue for freedom.addition

# read? + writing - truncate
with open('try1201.txt', 'w+') as f:
    f.write('update')           # update
    
with open('try1201.txt', 'r+') as f:
    f.write('before')           # beforecus pursue for freedom.
    print(f.read())             # cus pursue for freedom.

with open('try1201.txt', 'a+') as f:
    f.write('addition')        # Spartacus pursue for freedom.addition
