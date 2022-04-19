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
print("压缩信息为 "+message)
print("压缩结果为 "+res)
# print(compress.words_dict)
print("解压结果为 "+compress.decode(res))
 