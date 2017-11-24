# -*- coding: utf-8 -*-
"""
Created on Fri Nov 24 10:01:00 2017

@author: Administrator
"""

import json
from collections import defaultdict
from collections import Counter

path = 'D:\\myproject\\pydata-book-2nd-edition\\pydata-book-2nd-edition\\datasets\\bitly_usagov\\example.txt'
records = [json.loads(line) for line in open(path)]
time_zones = [rec['tz'] for rec in records if 'tz' in rec]



def get_counts(sequence):
    counts = {}
    for i in sequence:
        if i in counts:
            counts[i] += 1
        else:
            counts[i] = 1
    return counts


def get_counts2(sequence):
    counts = defaultdict(int)
    for i in sequence:
        counts[i] += 1
    return counts

    
#tz_count_pairs =  [(count, tz) for tz, count in get_counts2(time_zones).items()]
#tz_count_pairs.sort()
#print(tz_count_pairs)
#result = tz_count_pairs[-10:]
#print(result)


# traditional way
def top_counts(sequence, n):
    tz_count_pairs =  [(count, tz) for tz, count in get_counts2(sequence).items()]
    tz_count_pairs.sort()
    #print(tz_count_pairs)
    result = tz_count_pairs[-n:]
    return result

# convenient way
counts = Counter(time_zones)
tz_count_pairs = [(count, tz) for tz, count in dict(counts.most_common(10)).items()]
tz_count_pairs.sort()


print(tz_count_pairs == top_counts(time_zones, 10)) # True
