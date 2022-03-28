# -*- coding: utf-8 -*-

"""
@Time : 2022/3/28
@Author : XDwan
@File : test_arithmetic
@Description : 
"""

from compression.ArithmeticCode import Arithmetic
from random import random
import numpy as np

words_probability = {"A": 0.4, "B": 0.3, "C": 0.2,"D":0.1}

arithmetic = Arithmetic(words_probability)
words = "AABABCABABD"
res = arithmetic.encode(words)
fraction = np.mean(res)
print(res)
print(arithmetic.decode(fraction, len(words)))
