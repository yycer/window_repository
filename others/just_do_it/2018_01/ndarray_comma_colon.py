# coding = utf8
import numpy as np


data = np.arange(25).reshape((5, 5))
print(data)             # [[ 0  1  2  3  4]
                        #  [ 5  6  7  8  9]
                        #  [10 11 12 13 14]
                        #  [15 16 17 18 19]
                        #  [20 21 22 23 24]]

print(data[0, ])        # [0 1 2 3 4]

# 冒号：[...)
print(data[0, 0:4])     # [0 1 2 3]

print(data[2:5, 0:3])   # [[10 11 12]
                        #  [15 16 17]
                        #  [20 21 22]]