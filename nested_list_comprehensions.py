# -*- coding: utf-8 -*-
"""
Created on Tue Nov 21 14:14:25 2017

@author: Administrator
"""

# -*- coding: utf-8 -*-
"""
Created on Tue Nov 21 11:08:10 2017

@author: yyc
"""

# 筛选出有两个以上（包括两个）e的名字，并将其存入一个新的列表
all_data = [['Tom', 'Billy', 'Jefferson', 'Andrew', 'Wesley', 'Steven', 'Joe'],
            ['Susie', 'Casey', 'Jill', 'Ana', 'Eva', 'Jennifer', 'Staphanie']]

#    First way
#    result = []
#    for i in all_data:
#        for j in i:
#            if j.count('e') >= 2:
#                result.append(j)
#    print(result) # ['Jefferson', 'Wesley', 'Steven', 'Jennifer']


#    Second way
#    result = []
#    for i in all_data:
#        tmp = [j for j in i if j.count('e') >= 2]
#        # 两段i中筛选出的内容合并
#        result.extend(tmp)
#        
#    print(result) # ['Jefferson', 'Wesley', 'Steven', 'Jennifer']

#    more convenient
print([j for i in all_data for j in i if j.count('e') >= 2])
# ['Jefferson', 'Wesley', 'Steven', 'Jennifer']
