# -*- coding: utf-8 -*-

"""
@Time : 2022/3/29
@Author : XDwan
@File : utils
@Description : 
"""

import numpy as np


def zeros(input_num):
    return np.zeros(input_num)


def normal(input_num):
    return np.random.normal(0, 0.5, input_num)
