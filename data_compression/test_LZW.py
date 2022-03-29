# -*- coding: utf-8 -*-

"""
@Time : 2022/3/28
@Author : XDwan
@File : test_LZW
@Description : 
"""

from compression.LZW import LZW

compress = LZW()

message = "ababcababac"
res = compress.encode(message)
print(res)
print(compress.words_dict)
print(compress.decode(res))