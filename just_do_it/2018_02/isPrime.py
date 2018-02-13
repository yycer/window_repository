
n = 30
# 判断一个数是否为素数
# 当一个数与该序列全部数值取余结果均大于零时，并这个数大于1时，为素数
print([n % i for i in range(2, int(n ** 0.5) + 1)])                 # [0, 0, 2, 0]
print(all(n % i for i in range(2, int(n ** 0.5) + 1)) and n > 1)    # False



# 列出一个区间(正整数)内所有素数
a, b = 1, 30
l = []
for i in range(a, b + 1):
    if all(i % j for j in range(2, int(i ** 0.5) + 1)) and i > 1:
        l.append(i)
print(l)       # [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]

