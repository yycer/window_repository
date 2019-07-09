# and:
#     When using and, values are evaluated in boolean context from left to right.0, '', [], (),{} and None
#     are false in a boolean context; If all values are true in a boolean context, and returns the last
#     value; If any values is false in a boolean context, and returns the first false value.


print('yyc' and 'llg' and 'last_one')                   # last_one

# 0, '', [], (), {}, False, None
print('yyc' and '')                                     # ''
print('yyc' and None)                                   # None
print('yyc' and False and 'llg')                        # False



# or:
#    When using or, values are evaluated in a boolean context from left to right. If any value is true, or
#    returns that value immediately. If all values are false, or returns the last value.

print(0 or '' or [] or () or {} or False or None)       # None

print(0 or 'yyc')                                       # yyc
print('llg' or False)                                   # llg

