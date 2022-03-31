# -*- coding: utf-8 -*-

"""
@Time : 2022/3/28
@Author : XDwan
@File : LZW
@Description : 
"""


class LZW:

    def __init__(self):
        self.num = None
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
            res += str(self.words_dict[p]) + ' '
            p += word
            self.words_dict[p] = num
            num += 1
            p = word
        res += str(self.words_dict[p])
        return res

    def decode(self, compress):
        self.words_dict = {}
        self.num = 256
        res = ""
        origin_words = ""
        words = compress.split(' ')
        # 筛选原始字符
        for word in words:
            if int(word) < 256:
                self.words_dict[word] = chr(int(word))
        pW = None
        for word in words:
            if pW is None:
                pW = word
                res += self.words_dict[word]
                continue
            if word in self.words_dict.keys():
                res += self.words_dict[word]
                P = self.words_dict[pW]
                C = self.words_dict[word][0]
                self.words_dict[str(self.num)] = P + C
                self.num += 1
            else:
                P = self.words_dict[pW]
                C = self.words_dict[pW][0]
                self.words_dict[str(self.num)] = P + C
                self.num += 1
                res += self.words_dict[word]
            pW = word
        return res
