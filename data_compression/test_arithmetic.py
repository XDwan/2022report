# -*- coding: utf-8 -*-

"""
@Time : 2022/3/28
@Author : XDwan
@File : test_arithmetic
@Description : 
"""

from compression.ArithmeticCode import Arithmetic
from compression.utils import fraction2binary_shortest, binary2fraction
import numpy as np

# words_probability = {"A": 0.4, "B": 0.3, "C": 0.2, "D": 0.1}
words_probability = {"A": 0.5, "B": 0.4, "C": 0.1}
arithmetic = Arithmetic(words_probability)
words = "A"
res = arithmetic.encode(words)
fraction = np.mean(res)
binary = fraction2binary_shortest(res)
fraction_from_binary = binary2fraction(binary)
print(f"编码的概率字典为：{words_probability}")

print(f"编码后的范围为：{res}")
print(f"选择结果为：{fraction}")
print(f"二进制编码为：{binary}")
print(f"二进制转十进制为：{fraction_from_binary}")
print(f"编码的字符串为：{words}")
print(f"编码后字符串为：{arithmetic.decode(fraction_from_binary, len(words))}")
