# -*- coding: utf-8 -*-

"""
@Time : 2022/3/30
@Author : XDwan
@File : utils
@Description : 
"""

import numpy as np


def normal(input_num, output_num):
    """
    生成input_num * output_num的正态分布矩阵
    :param input_num:
    :param output_num:
    :return:
    """
    return np.random.normal(0, 0.5, (input_num, output_num))


def sigmoid(x):
    return 1 / (1 + np.exp(-x))
