# -*- coding: utf-8 -*-

"""
@Time : 2022/3/28
@Author : XDwan
@File : LZW
@Description : 
"""


class LZW:

    def __init__(self):
        self.words_dict = {}

    def encode(self, words):
        self.words_dict = {}
        res = ""
        num = 256
        for word in words:
            if word not in self.words_dict.keys():
                self.words_dict[word] = ord(word)
        p = ""
        for word in words:
            if p + word in self.words_dict.keys():
                p += word
                continue
            self.words_dict[p + word] = num
            num += 1
            res += str(self.words_dict[p]) + ' '
            p = word
        res += str(self.words_dict[p])
        return res

    def decode(self, compress):
        self.words_dict = {}
        res = ""
        words = compress.split(' ')
        return words
