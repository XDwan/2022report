# -*- coding: utf-8 -*-

"""
@Time : 2022/3/30
@Author : XDwan
@File : layerModule
@Description : 
"""


class Layer:

    def __init__(self):
        self.last_x = None
        pass

    def forward(self, x):
        pass

    def auto_grad(self, loss_grad):
        pass

    def backward(self, lr):
        pass
