
# 1.filter()用法 --- filter(function, iterable)
# 将iterable对象中的每一个元素带入function中执行, 若返回值为True, 则将对应的元素以原iterable的形式返回, 如list


# 2.and用法 --- 若均为true，返回最后一个值; 一旦存在false值, 立马返回该值

def not_empty(s):
    return s and s.strip()


l1 = ['yyc', 'llg', '', 0, False, (), [], {}, None]

print(list(filter(not_empty, l1)))      # ['yyc', 'llg']