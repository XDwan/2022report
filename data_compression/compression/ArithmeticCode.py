# -*- coding: utf-8 -*-

"""
@Time : 2022/3/28
@Author : XDwan
@File : ArithmeticCode
@Description : 
"""


class Arithmetic:
    """
    算术编码
    """
    def __init__(self, words_probability):
        """
        初始化算术编码，对各个区间进行划分
        :param words_probability: eg:{A:0.5,B:0.4,C:0.1}
        """
        self.words_probability = words_probability
        self.words = list(words_probability.keys())
        self.probability = list(words_probability.values())
        self.divide_range = [0]
        divide = 0
        for res in self.words_probability:
            divide += self.words_probability[res]
            self.divide_range.append(divide)
        if divide > 1:
            raise ValueError("the words range' sum should be 1")

    def encode(self, words):
        high = 1
        low = 0
        for word in words:
            res = high - low
            p_high = self.divide_range[self.words.index(word) + 1]
            p_low = self.divide_range[self.words.index(word)]
            high = res * p_high + low
            low = res * p_low + low
        return [low, high]

    def decode(self, fraction, precision):
        high = 1
        low = 0
        bits = 0
        words = ""
        while bits < precision:
            res = high - low
            for word in self.words:
                p_high = self.divide_range[self.words.index(word) + 1]
                p_low = self.divide_range[self.words.index(word)]
                if res * p_low + low <= fraction < res * p_high + low:
                    words += word
                    high = res * p_high + low
                    low = res * p_low + low
                    break
            bits += 1
        return words
