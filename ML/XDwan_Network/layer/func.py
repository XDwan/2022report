# -*- coding: utf-8 -*-

"""
@Time : 2022/3/30
@Author : XDwan
@File : func
@Description : 
"""

import numpy as np
from layerModule import Layer
from utils import sigmoid


class Relu(Layer):

    def __init__(self):
        super().__init__()

    def forward(self, x):
        self.last_x = x
        x[x < 0] = 0
        return x

    def auto_grad(self, loss_grad):
        loss_grad[self.last_x < 0] = 0
        return loss_grad

    def backward(self, lr):
        pass


class Sigmoid(Layer):

    def __init__(self):
        super().__init__()
        self.z = None

    def forward(self, x):
        self.last_x = x
        self.z = sigmoid(x)
        return self.z

    def auto_grad(self, loss_grad):
        return self.z(1 - self.z) * loss_grad

    def backward(self, lr):
        pass
