# -*- coding: UTF-8 -*-

from black_box import make_pizza
from black_box.make_pizza import material


def sell_pizza():
    pizza = make_pizza.make_pizza(material) # 强行用模板，无视之
    return 'it sells hot'


if __name__ == '__main__':
    result = sell_pizza()
    print(result)        # it sells hot
    print(__name__)      # __main__
    # flour + butter + olive_oil + meat
    # it sells hot






