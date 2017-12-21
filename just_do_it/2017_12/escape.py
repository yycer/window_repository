# coding: utf-8

s1 = 'hello\nworld'

print s1                  # hello
                          # world
# solution 1
s2 = r'hello\nworld'
print s2                  # hello\nworld

# 现有一个字符串变量，仅知道它是一个路径且不知道其具体值，如何原样输出？
# solution 2
print repr(s1)            # 'hello\nworld'
print type(repr(s1))      # <type 'str'>

# solution 3
print '%r' % s1           # 'hello\nworld'
