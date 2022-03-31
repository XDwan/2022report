# -*- coding: utf-8 -*-

"""
@Time : 2022/3/29
@Author : XDwan
@File : demo1
@Description : 用于确定单个神经元的反向传播公式
"""
import numpy as np

from network.unit.neural_unit import Neural
from network.unit.utils import zeros
from data.normal_data import normal_data
from matplotlib import pyplot as plt

unit1 = Neural()
unit1.init_neural(2, init_method=zeros)
dataset = normal_data(1000)
for ite in range(50):
    for x, label in dataset:
        # print(x)
        out = unit1.forward(x.reshape(-1))
        if out * label > 0:
            loss = 0
        else:
            loss = out - label
        unit1.loss = loss
        back_loss = unit1.backward(0.01)
        # print(f"数据为{x}，其标签为{label}，输出为{out}，loss为{loss}")

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
y = - (unit1.w[0] * x_base + unit1.bias) / unit1.w[1]

plt.plot(x_base, y, c='gray')
plt.plot(x_base, y_base, c='b')
plt.scatter(X[Z > 0], Y[Z > 0], c='r', marker='o', s=1)
plt.scatter(X[Z < 0], Y[Z < 0], c='g', marker='*', s=1)

plt.show()

# fig = plt.figure(figsize=(12, 8),
#                  facecolor='lightyellow'
#                  )
# ax = fig.gca(fc='whitesmoke',
#              projection='3d'
#              )
# x = np.linspace(0, 1, 10)
# y = np.linspace(0, 1, 10)
# X_base, Y_base = np.meshgrid(x, y)
# ax.plot_surface(X=X_base,
#                 Y=Y_base,
#                 Z=X_base * unit1.w[0] + Y_base * unit1.w[1] + unit1.bias,
#                 color='r',
#                 alpha=0.7
#                 )
# ax.scatter(X[Z > 0], Y[Z > 0], Z[Z > 0], c='r', label='y=0', marker='o')
# ax.scatter(X[Z <= 0], Y[Z <= 0], Z[Z <= 0], c='g', label='y=1', marker='x')
# ax.view_init(elev=15,  # 仰角
#              azim=10  # 方位角
#              )
# plt.show()
