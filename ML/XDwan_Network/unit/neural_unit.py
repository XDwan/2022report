# -*- coding: utf-8 -*-

"""
@Time : 2022/3/29
@Author : XDwan
@File : neural_unit
@Description : 
"""

import numpy as np


class Neural:

    def __init__(self):
        self.w = None
        self.bias = 0
        self.last_x = None
        self.loss = 0

    def init_neural(self, input_num, init_method):
        self.w = init_method(input_num)
        self.bias = 0
        self.loss = 0
        self.last_x = None

    def forward(self, x):
        self.last_x = x.T
        return np.dot(self.w, x.T) + self.bias

    def add_loss(self, loss):
        self.loss += loss

    def backward(self, lr):
        self.w -= lr * self.loss * self.last_x
        self.bias -= lr * self.loss
        return self.w * self.loss
