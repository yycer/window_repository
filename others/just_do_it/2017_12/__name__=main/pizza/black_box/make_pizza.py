# -*- coding: UTF-8 -*-

material = ['flour', 'butter', 'olive_oil', 'meat']

def make_pizza(material):
    pizza = ''
    for i in material:
        pizza = pizza + i + ' + '
    return str(pizza.split(material[-1])[0]) + material[-1]


result = make_pizza(material)
# print(__name__)     # black_box.make_pizza
# print(result)       # flour + butter + olive_oil + meat

if __name__ == "__main__":
    # 如果仅运行make_pizza.py文件，输出:flour + butter + olive_oil + meat
    # 若以模块方式引用，则没有输出
    print result
