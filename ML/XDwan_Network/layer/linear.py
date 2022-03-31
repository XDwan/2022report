# -*- coding: utf-8 -*-

"""
@Time : 2022/3/30
@Author : XDwan
@File : linear
@Description : 
"""
import numpy as np

# from utils import normal
from layer.utils import normal

class Linear:

    def __init__(self, input_num, output_num):
        """
        一个线性层 应该有output_num个神经元 每个神经元的输入维度为input_num
        参数w为 output_num * input_num
        参数b为 output_num * 1
        输入x为 input_num * 1
        输出out为 output_num * 1
        :param input_num:
        :param output_num:
        """
        self.grad = None
        self.out = None
        self.last_x = None
        self.w = normal(input_num, output_num).T
        self.b = normal(1, output_num).T

    def forward(self, x):
        """

        :param x: 输入的X应该满足shape=(input_num,:)
        :return:
        """
        self.last_x = x
        # print("x")
        # print(x.shape)
        # print("w")
        # print(self.w.shape)
        self.out = np.dot(self.w, x) + self.b
        # print("out")
        # print(self.out.shape)
        return self.out

    def auto_grad(self, loss_grad):
        """
        输入的 loss_grade shape是 output_num * 1
        :param loss_grad:
        :return:
        """
        self.grad = loss_grad
        return np.dot(self.w.T, self.grad)

    def backward(self, lr):
        w_grad = np.dot(self.grad, self.last_x.T)
        self.w -= lr * w_grad
        self.b -= lr * self.grad

