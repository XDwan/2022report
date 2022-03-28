# -*- coding: utf-8 -*-

"""
@Time : 2022/3/28
@Author : XDwan
@File : test
@Description : 
"""

from compression.utils import fraction2binary, binary2fraction

fraction = 0.1255
precision = 16

binary = fraction2binary(fraction, precision)

print(binary)

print(binary2fraction(binary))
