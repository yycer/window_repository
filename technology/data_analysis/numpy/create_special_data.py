# -*- coding: utf-8 -*-
"""
Created on Sun Dec 10 13:56:03 2017

@author: yyc
"""
import numpy as np

a = np.arange(1, 20, 2)
print(a)              # [ 1  3  5  7  9 11 13 15 17 19]

a = a.reshape(2, 5)
print(a)              # [[ 1  3  5  7  9]
                      #  [11 13 15 17 19]]

a = a.reshape(5, 2)
print(a)              # [[ 1  3]
                      #  [ 5  7]
                      #  [ 9 11]
                      #  [13 15]
                      #  [17 19]]

# linspace = linear space 等差数列
b = np.linspace(1, 10, 20)
print(b)
#[  1.           1.47368421   1.94736842   2.42105263   2.89473684
#   3.36842105   3.84210526   4.31578947   4.78947368   5.26315789
#   5.73684211   6.21052632   6.68421053   7.15789474   7.63157895
#   8.10526316   8.57894737   9.05263158   9.52631579  10.        ]


b = b.reshape(5, 4)
print(b)
#[[  1.           1.47368421   1.94736842   2.42105263]
# [  2.89473684   3.36842105   3.84210526   4.31578947]
# [  4.78947368   5.26315789   5.73684211   6.21052632]
# [  6.68421053   7.15789474   7.63157895   8.10526316]
# [  8.57894737   9.05263158   9.52631579  10.        ]]


