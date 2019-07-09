# coding = utf8
import os
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



# 根据某一商品id，从数据集中读取相关数据，筛选出评分等级与时间戳变量并以Tab键为分隔存入txt文件，文件名为商品id
# product_id = "0000230022"
# rating_dataset = "../data/ratings_Books.csv"
def filterProductId(pi, rad):
    # 从数据集中获取与该product_id相关的所有数据，并存入l1_tmp列表中
    l1_tmp = []
    # 打开数据集文件
    with open(rad) as f1:
        # 将文件中的每行内容作为单个元素，并存储为列表的形式
        content = f1.readlines()
        # 依次循环遍历content列表的每个元素，也就是数据集文件中的每行数据
        for line in content:
            # 去除每行的换行符，并以逗号分隔，生成一个列表
            line = line.strip().split(',')
            # 若分隔后的列表中的第二个元素为需查询的product_id,则将该行数据存入l1_tmp列表中
            if line[1] == pi:
                l1_tmp.append(line)

    # 将所需的变量(评分等级、时间戳)写入以product_id.txt文件中，每行以Tab键分隔。
    file_name = pi + '.txt'
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


# 根据customer_id查询customer_id.txt中的第一个字段的数据，并以列表形式返回
# Question1: 需要先生成customer_id.txt，再执行该函数
# Input: customer_id
# Output: product_list
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
# Input: product_id, related_dataset
# Output: string，相关product_id的一整条记录
def getRelatedDataByProductId(pi, red):
    with open(red) as f1:
        content = f1.readlines()
        for element in content:
            # 将str转换成原始数据类型dict
            element = eval(element)
            if element.get('asin') == pi:
                return str(element)



# 将某一customer_id所购买的所有商品的相关数据从Books.json中分离出来，并写入related_customer_id.txt中
# Input: product_list, customer_id, related_dataset
# Output: file_name(related_customer_id.txt)
def getSmallRelatedDatasetByProductList(pl, ci, red):
    for product in pl:
        file_name = 'related_' + ci + '.txt'
        # 以附加形式将相关文件写入file_name中
        # Open for reading and appending(writing at end of file)
        # This file is created if it does not exist.
        with open(file_name, 'a+') as f2:
            if getRelatedDataByProductId(product, red) != None:
                f2.write(getRelatedDataByProductId(product, red) + '\n')
    return file_name



# 输入customer_id，生成一个customer_id.txt文件，其中每行内容的字段为product_id,rating,timestamp以Tab分隔。
# Input: customer_id, rating_dataset
# Output: file_name(customer_id.txt)
def filterCustomerId(ci, rad):
    # 将数据集中符合要求的数据存入l1_tmp列表中
    l1_tmp = []
    with open(rad) as f1:
        # 读取文件中的每行数据，并以列表的形式存储
        content = f1.readlines()
        for line in content:
            # 去除文件中每行换行符，并以逗号分隔，生成一个列表
            line = line.strip().split(',')
            if line[0] == ci:
                l1_tmp.append(line)

    # 将所需的变量(评分等级、时间戳)存入以product_id.txt文件中，每行以tab键分隔。
    file_name = ci + '.txt'
    with open(file_name, 'w') as f2:
        for line in l1_tmp:
            f2.write(line[1] + '\t' + line[2] + '\t' + line[3] + '\n')
    return file_name

# filterCustomerId(customer_id, rating_dataset)
            


# 根据商品id获取其等级评分，并将浮点数转换成strong[1]([4,5]),weak[0]([0,3])
# product_id = '0553588958'
# customer_id_dataset = 'A2IIIDRK3PRRZY.txt'
# Input: product_id, customer_id_dataset
# Output: rating
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
# productA = '0553562738'  productB = '0553588958'
# Input: related_customer_id.txt(samll dataset), productA, productB
# Output: int(1/0)
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




# 根据tidied_customer_id.txt文件，计算出每种模式的数量
# Input: tidied_customer_id.txt
# Output: 数量最多是哪一种模式及具体数量
def evaluateCustomerModelByTidiedCustomerIdTxt(td):
    model_list_base = ['000', '001', '010', '011', '100', '101', '110', '111']
    # 将八种模式的初始值均设置为0
    model_list = [0] * 8
    with open(td) as f1:
        content = f1.readlines()
        for element in content:
            element = element.strip().split('\t')
            # 将文件中ratingA, ratingB, relation字段的值相加，三个字段的值均为str
            model = element[1] + element[3] + element[4]
            if model == model_list_base[0]:
                model_list[0] += 1
            elif model == model_list_base[1]:
                model_list[1] += 1
            elif model == model_list_base[2]:
                model_list[2] += 1
            elif model == model_list_base[3]:
                model_list[3] += 1
            elif model == model_list_base[4]:
                model_list[4] += 1
            elif model == model_list_base[5]:
                model_list[5] += 1
            elif model == model_list_base[6]:
                model_list[6] += 1
            else:
                model_list[7] += 1
    # 需要知道哪个模式数量最多，以及数量为多少
    print("The max model is : {0}, The amount is {1}.".format('model' + str(model_list.index(max(model_list))), max(model_list)))

# tidied_data = 'tidied_customer_id/tidied_A1ESQ3ZLSD5WJQ.txt'
# evaluateCustomerModelByTidiedCustomerIdTxt(tidied_data)



# 1.模拟一个列表包含三个子文件，分别计算这三个文件的模式，并以customer_id,model_type,model_num的格式写入result.txt文件
# tidied_data_list = ['tidied_A1BM81XB4QHOA3.txt', 'tidied_A1CP960DFEHZ5H.txt', 'tidied_A1ESQ3ZLSD5WJQ.txt']
# Input: tidied_dataset_list
# Output: result.txt，其中分为customer_id,model_type,model_num三个字段，并以Tab键分隔
def evaluateCustomerModelByTidiedCustomerIdList(tdl):
    model_list_base = ['000', '001', '010', '011', '100', '101', '110', '111']
    for td in tdl:
        model_list = [0] * 8
        with open('tidied_customer_id/' + td) as f1:
            content = f1.readlines()
            for element in content:
                element = element.strip().split('\t')
                model = element[1] + element[3] + element[4]
                if model == model_list_base[0]:
                    model_list[0] += 1
                elif model == model_list_base[1]:
                    model_list[1] += 1
                elif model == model_list_base[2]:
                    model_list[2] += 1
                elif model == model_list_base[3]:
                    model_list[3] += 1
                elif model == model_list_base[4]:
                    model_list[4] += 1
                elif model == model_list_base[5]:
                    model_list[5] += 1
                elif model == model_list_base[6]:
                    model_list[6] += 1
                else:
                    model_list[7] += 1
        # 使用正则，通过特殊符号来获取customer_id
        ci = re.split(r'[_.]', td)
        with open('result.txt', 'a+') as f2:
            f2.write(ci[1] + '\t' + 'model' + str(model_list.index(max(model_list))) + '\t' + str(max(model_list)) + '\n')




# 根据样本数据，分别统计各种模式的数量
# Input: result.txt
# Output: 由各种模式的数量组成的列表
def evaluateModelAmount(rt):
    model_list = ['model0', 'model1', 'model2', 'model3', 'model4', 'model5', 'model6', 'model7']
    model0,model1,model2,model3,model4,model5,model6,model7 = 0,0,0,0,0,0,0,0
    with open(rt) as f1:
        content = f1.readlines()
        for line in content:
            line = line.strip().split('\t')
            if line[1] == model_list[0]:
                model0 += 1
            elif line[1] == model_list[1]:
                model1 += 1
            elif line[1] == model_list[2]:
                model2 += 1
            elif line[1] == model_list[3]:
                model3 += 1
            elif line[1] == model_list[4]:
                model4 += 1
            elif line[1] == model_list[5]:
                model5 +=1
            elif line[1] == model_list[6]:
                model6 += 1
            else:
                model7 += 1
    print('model0: ' + str(model0) + '\n' + 'model1: ' + str(model1) + '\n' + 'model2: ' + str(model2) + '\n' + 'model3: ' + str(model3) + '\n'
        + 'model4: ' + str(model4) + '\n' + 'model5: ' + str(model5) + '\n' + 'model6: ' + str(model6) + '\n' + 'model7: ' + str(model7) + '\n')
    return [model0, model1, model2, model3, model4, model5, model6, model7]



# 向柱状图添加数据标签
def add_labels(rects):
    for rect in rects:
        height = rect.get_height()
        plt.text(rect.get_x() + rect.get_width() / 2, height, height, ha='center', va='bottom')
        # 柱形图边缘用白色填充，纯粹为了美观
        rect.set_edgecolor('white')



# 根据随机样本，使用matplotlib绘制出直方图
# Input: result_distribution(evaluateModelAmount()函数返回的列表)
# Output: figure
def drawBarBySample(rd):
    # labels = ['model0', 'model1', 'model2', 'model3', 'model4', 'model5', 'model6', 'model7']
    rects1 = plt.bar(range(len(rd)), rd, alpha = 0.8)
    # 在柱状图上添加数据标签
    add_labels(rects1)
    plt.xlabel('model type')
    plt.ylabel('number')
    plt.title('The distribution of models')
    plt.show()




# 1.如果rating>3 -->strong[1]，否则weak[0]
# 2.根据productA查询数据集的related，若相关，related字段为1，否则为0
# 3.生成tidied_customer_id.txt文件，包含productA,ratingA,productB,ratingB,relation字段。
# customer_id_dataset = 'A1TADCM7YWPQ8M.txt'
# related_dataset = 'deceptive_three_related.txt'
# cid=  customer id dataset; red = related dataset, pll = product list length
# Input: customer_id, rating_dataset, related_dataset
# Output: tidied_customer_id.txt
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



# 为了方便获得多个customer_id的最终结果，创建一个customer_id_list，遍历即可
def tidyDataByCustomerIdList(cil, rad, red):
    for ci in cil:
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


# 获得消费者列表
def getCustomerIdList():
    customer_id_list = []
    with open('rating_test.txt') as f1:
        content = f1.readlines()
        for line in content:
            line = line.strip().split(',')
            customer_id_list.append(line[0])
    return customer_id_list



# 整个多个启动函数的参数，使其让一个主函数控制，也就是让相关函数写入主函数
# filtered_customer_id_dataset_file_name = filterCustomerId(customer_id, rating_dataset)
# product_list = getProductListByCustomerId(customer_id)
# new_related_dataset = getSmallRelatedDatasetByProductList(product_list, customer_id, related_dataset)




customer_id = 'AWTQZWBDCE0RD'
customer_id_list = getCustomerIdList()
rating_dataset = "../data/ratings_Books.csv"
related_dataset = '../data/Books.json'
# querySameCustomer(customer_id, rating_dataset)
# tidyDataByCustomerId(customer_id, rating_dataset, related_dataset)
# start = time.clock()
# tidyDataByCustomerIdList(customer_id_list, rating_dataset, related_dataset)
# elapsed = time.clock() - start
# print(elapsed)


# tidied_data_list = os.listdir('tidied_customer_id')
# evaluateCustomerModelByTidiedCustomerIdList(tidied_data_list)

# evaluateModelAmount('result.txt')
# model0: 136
# model1: 0
# model2: 22
# model3: 0
# model4: 28
# model5: 1
# model6: 312
# model7: 1

# result_distribution = evaluateModelAmount('result.txt')
# drawBarBySample(result_distribution)



















