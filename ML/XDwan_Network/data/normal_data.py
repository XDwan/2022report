# -*- coding: utf-8 -*-

"""
@Time : 2022/3/29
@Author : XDwan
@File : normal_data
@Description : 
"""

import numpy as np


def normal_data(num):
    x1 = np.random.random(num)
    x2 = np.random.random(num)
    y = np.zeros_like(x1)
    y[(x1 + x2) < 1] = -1
    y[(x1 + x2) > 1] = 1
    X = np.dstack((x1, x2)).reshape((num, 2, 1))
    return generate_dataset(X, y)

def xor_data():

    X = np.array([
                [0,0,0],
                [0,0,1],
                [0,1,0],
                [0,1,1],
                [1,0,0],
                [1,0,1],
                [1,1,0],
                [1,1,1]   
                ])
    X = X.reshape([8,3,1])
    y = np.array([0,1,1,0,1,0,0,1])
    return generate_dataset(X,y)

def generate_dataset(X, labels):
    dataset = []
    for idx, x in enumerate(X):
        dataset.append((x, labels[idx]))
    return dataset
