# -*- coding: utf-8 -*-

"""
@Time : 2022/3/30
@Author : XDwan
@File : demo2
@Description : 
"""

from layer.linear import Linear
from data.normal_data import normal_data
import numpy as np
import matplotlib.pyplot as plt

layer = Linear(2, 1)
dataset = normal_data(1000)

for it in range(50):
    for x, label in dataset:
        out = layer.forward(x)
        if out * label > 0:
            loss_grad = 0
        else:
            loss_grad = out - label
        layer.auto_grad(loss_grad)
        layer.backward(0.01)

X = []
Y = []
Z = []

for x, label in dataset:
    x = x.reshape(-1)
    X.append(x[0])
    Y.append(x[1])
    Z.append(label)

X = np.array(X)
Y = np.array(Y)
Z = np.array(Z)

x_base = np.linspace(0, 1, 50)
y_base = - x_base + 1
y = - (layer.w[0][0] * x_base + layer.b) / layer.w[0][1]

plt.plot(x_base, y.reshape(-1), c='gray')
plt.plot(x_base, y_base, c='b')
plt.scatter(X[Z > 0], Y[Z > 0], c='r', marker='o', s=1)
plt.scatter(X[Z < 0], Y[Z < 0], c='g', marker='*', s=1)
plt.show()

