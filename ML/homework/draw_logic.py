# -*- coding: utf-8 -*-

"""
@Time : 2022/3/29
@Author : XDwan
@File : draw_logic
@Description : 
"""

import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import numpy as np

x1 = np.array([0, 0, 0, 0, 1, 1, 1, 1])
x2 = np.array([0, 0, 1, 1, 0, 0, 1, 1])
x3 = np.array([0, 1, 0, 1, 0, 1, 0, 1])
y_ = np.array([0, 1, 1, 0, 1, 0, 0, 1])
fig = plt.figure()
ax = Axes3D(fig)

ax.scatter(x1[y_ == 0], x2[y_ == 0], x3[y_ == 0], c='r', label='y=0',marker='o')
ax.scatter(x1[y_ == 1], x2[y_ == 1], x3[y_ == 1], c='g', label='y=1',marker='x')
ax.set_zlabel('x3', fontdict={'size': 15, 'color': 'red'})
ax.set_ylabel('x2', fontdict={'size': 15, 'color': 'red'})
ax.set_xlabel('x1', fontdict={'size': 15, 'color': 'red'})
ax.legend()
plt.ioff()
plt.show()
