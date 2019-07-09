# -*- coding: utf-8 -*-
"""
Created on Sat Dec 16 10:11:56 2017

@author: yyc
"""

sequence = [8, 1, 5, 9, 6, 18, 25, 13]

def merge(left, right):
    result, i, j = [], 0, 0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result += left[i: ]
    result += right[j: ]
    return result


def mergesort(seq):
    if len(seq) <= 1:
        return seq
    mid = int(len(seq) / 2)
    left = mergesort(seq[: mid])
    right = mergesort(seq[mid: ])
    return merge(left, right)

print(mergesort(sequence)) # [1, 5, 6, 8, 9, 13, 18, 25]
    