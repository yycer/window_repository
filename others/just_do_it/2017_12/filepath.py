# -*- coding: utf-8 -*-
"""
Created on Fri Dec  8 16:38:21 2017

@author: yyc
"""


import os


# 当前执行的py文件所在目录
path1 = os.getcwd()               # D:\myproject\caffe_web

# 当前文件所在目录
path2 = os.path.dirname(__file__) # D:\myproject\caffe_web\caffe_web\net

# 当前文件的绝对路径
path3 = os.path.abspath(__file__) # D:\myproject\caffe_web\caffe_web\net\routes.py
