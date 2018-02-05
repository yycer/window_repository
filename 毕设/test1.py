# coding = utf8
import re
import time
import numpy as np
import matplotlib
import matplotlib.pyplot as plt



def ts_to_time(str):
    # 作用: 将timestamp转换成time
    # ts: timestamp; st: struct_time;
    st = time.localtime(int(str))
    return time.strftime("%Y-%m-%d %H:%M:%S", st)



def not_empty(iter):
    # 作用: 配合filter(func, iter), 去除iter中的空字符串
    return iter and iter.strip()


# 查询同一用户购买的商品
def querySameCustomer(ci, rad):
    with open(rad) as f1:
        content = f1.readlines()
        for line in content:
            line = line.strip().split(",")
            if line[0] == ci:
                print(line)



# 查询同一商品购买的用户
# with open('customer.txt') as f2:
#     content = f2.readlines()
#     l = []
#     for line in content:
#         print(eval(line))



# 根据某一商品id，从数据集中读取相关数据，筛选出评分等级与时间戳变量并以tab键为分隔存入txt文件，文件名为商品id
#product_id = "0000230022"
#rating_dataset = "../data/ratings_Books.csv"
def filterProductId(product_id, rt):
    # 从数据集中获取与该product_id相关的所有数据，并存入l1_tmp(list)
    l1_tmp = []
    with open(rt) as f1:
        content = f1.readlines()
        for line in content:
            line = line.strip().split(',')
            if line[1] == product_id:
                l1_tmp.append(line)

    # 将所需的变量(评分等级、时间戳)存入以product_id.txt文件中，每行以tab键分隔。
    file_name = product_id + '.txt'
    with open(file_name, 'w') as f2:
        for line in l1_tmp:
            f2.write(line[2] + '\t' + line[3] + '\n')

# filterProductId(product_id, file)



# 由filterProductId()函数筛选出的数据，使用matplotlib绘制出以时间戳为横坐标，评分等级为纵坐标的图。
#file = "0000230022.txt"
def drawFigure1(file):
    with open(file) as f1:
        content = f1.readlines()
        number_of_lines = len(content)
        returnMat = np.zeros((number_of_lines, 2))
        # print(type(returnMat))  # <class 'numpy.ndarray'>
        index = 0
        for line in content:
            line = line.strip().split('\t')
            returnMat[index, :] = line[0:2]
            index += 1

    fig = plt.figure()
    ax = fig.add_subplot(111)
    # 第二列为时间戳，第一列为评分等级
    ax.scatter(returnMat[:, 1], returnMat[:, 0])
    plt.xlabel("timestamp")
    plt.ylabel("ranking")
    plt.show()

# drawFigure1(file)


# 根据customer_id查询customer_id.txt中的第一个字段的值
# Question1: customer_id.txt 需要先生成再执行该函数
def getProductListByCustomerId(ci):
    file_name = ci + '.txt'
    with open(file_name) as f1:
        product_list = []
        content = f1.readlines()
        for element in content:
            element = element.strip().split('\t')
            product_list.append(element[0])
    return product_list

# product_list = ['0001048791','0000143561','0000037214','0000032060']



# 根据product_id从Books.json数据集中筛选出相关数据
def getRelatedDataByProductId(pi, red):
    with open(red) as f1:
        content = f1.readlines()
        for element in content:
            element = eval(element)
            if element.get('asin') == pi:
                return str(element)



# 将指定customer所购买的product的相关数据从Books.json中分离出来，写入related_customer_id.txt中
def getSmallRelatedDatasetByProductList(pl, ci, rad):
    for product in pl:
        file_name = 'related_' + ci + '.txt'
        with open(file_name, 'a+') as f2:
            if getRelatedDataByProductId(product, rad) != None:
                f2.write(getRelatedDataByProductId(product, rad) + '\n')
    return file_name



# 输入customer_id，生成一个以customer_id.txt为文件名的文件，其中每行内容的字段为product_id,rating,timestamp以Tab分隔。
def filterCustomerId(customer_id, rad):
    l1_tmp = []
    with open(rad) as f1:
        content = f1.readlines()
        for line in content:
            line = line.strip().split(',')
            if line[0] == customer_id:
                l1_tmp.append(line)
#   将所需的变量(评分等级、时间戳)存入以product_id.txt文件中，每行以tab键分隔。
    file_name = customer_id + '.txt'
    with open(file_name, 'w') as f2:
        for line in l1_tmp:
            f2.write(line[1] + '\t' + line[2] + '\t' + line[3] + '\n')
    return file_name

# filterCustomerId(customer_id, rating_dataset)
            


# 根据商品id获取其等级评分，并将浮点数转换成strong[1]([4,5]),weak[0]([0,3])
# product_id = '0553588958'
# customer_id_dataset = 'A2IIIDRK3PRRZY.txt'
# pi = product id; cid = customer id dataset
def getRatingByProductId(pi, cid):
    with open(cid) as f1:
        content = f1.readlines()
        for line in content:
            line = line.strip().split('\t')
            if line[0] == pi:
                rating = line[1]
                if float(rating) > 3.0:
                    rating = 1
                else:
                    rating = 0
                return rating

# print(getRatingByProductId(product_id, customer_id_dataset))



# 根据productA，在related dataset中查询其related字段中是否含有productB，包含为1，否则为0

# productA = '0553562738'
# productB = '0553588958'
def confirmProductAIsRealtedB(red, pA, pB):
    with open(red) as f1:
        content = f1.readlines()
        for line in content:
            line = eval(line)
            if line.get('asin') == pA:
                if pB in str(line.get('related')):
                    return 1
                else:
                    return 0
            else:
                return 0


# print(confirmProductAIsRealtedB(related_dataset, productA, productB))




# 1.如果rating>3 -->strong[1]，否则weak[0]
# 2.根据productA查询数据集的related，若相关，related字段为1，否则为0
# 3.生成tidied_customer_id.txt文件，包含productA,ratingA,productB,ratingB,relation字段。
# customer_id_dataset = 'A1TADCM7YWPQ8M.txt'
# related_dataset = 'deceptive_three_related.txt'
# cid=  customer id dataset; red = related dataset, pll = product list length
# ci = customer id;
def tidyDataByCustomerId(ci, rad, red):
    cid = filterCustomerId(ci, rad)
    product_list = getProductListByCustomerId(ci)
    new_related_dataset = getSmallRelatedDatasetByProductList(product_list, ci, red)
    pll = len(product_list)
    file_name = 'tidied_' + cid
    with open(file_name, 'w+') as f2:
        for productA in product_list[ : pll - 1]:
            for productB in product_list[product_list.index(productA) + 1 : pll]:
                ratingA = str(getRatingByProductId(productA, cid))
                ratingB = str(getRatingByProductId(productB, cid))
                relation = str(confirmProductAIsRealtedB(new_related_dataset, productA, productB))
                # print(productA, ratingA, productB, ratingB, relation)
                # 将5个字段数据写入txt文件，命名为tidied_customer_id.txt
                f2.write(productA + '\t' + ratingA + '\t' + productB + '\t' + ratingB + '\t' + relation + '\n')



# 整个多个启动函数的参数，使其让一个主函数控制，也就是让相关函数写入主函数
# filtered_customer_id_dataset_file_name = filterCustomerId(customer_id, rating_dataset)
# product_list = getProductListByCustomerId(customer_id)
# new_related_dataset = getSmallRelatedDatasetByProductList(product_list, customer_id, related_dataset)
customer_id = 'A1340OFLZBW5NG'
rating_dataset = "../data/ratings_Books.csv"
related_dataset = '../data/Books.json'
# querySameCustomer(customer_id, rating_dataset)
tidyDataByCustomerId(customer_id, rating_dataset, related_dataset)

# start = time.clock()
# elapsed = time.clock() - start
# print(elapsed)






















