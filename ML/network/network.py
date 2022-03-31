# -*- coding: utf-8 -*-

"""
@Time : 2022/3/30
@Author : XDwan
@File : network
@Description : 
"""


class Network:

    def __init__(self):
        self.last_x = None
        self.layers = []

    def add_layer(self, layer):
        self.layers.append(layer)

    def forward(self, x):
        self.last_x = x
        h = None
        for layer in self.layers:
            h = layer.forward(x)

    def auto_grad(self, loss_grad):
        h_grad = loss_grad
        self.layers.reverse()
        for layer in self.layers:
            h_grad = layer.auto_grad(h_grad)
        self.layers.reverse()

    def backward(self, lr):
        for layer in self.layers:
            layer.backward(lr)