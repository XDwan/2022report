# -*- coding: utf-8 -*-

"""
@Time : 2022/3/28
@Author : XDwan
@File : utils
@Description : 
"""


def fraction2binary(fraction, precision):
    """
    将小于等于1的正小数转为二进制数
    :param fraction: 小数 （float）
    :param precision: 精度（int） 二进制精确到几位
    :return: 二进制（string）
    """
    tmp = fraction
    res = ""
    bits = 0

    if tmp < 0:
        raise ValueError("fraction should be positive")
    if tmp > 1:
        raise ValueError("fraction should be less than 1")
    if tmp == 1:
        res += "1."
        return res
    while (bits < precision):
        tmp = tmp * 2
        if (tmp >= 1):
            tmp = tmp - 1
            res += "1"
        else:
            res += "0"
        if tmp == 0:
            break
        bits += 1
    return res


def binary2fraction(binary):
    """
    二进制转为小数
    :param binary: 二进制（string）
    :return: 对应小数 （float)
    """

    precision = 1
    res = 0
    bits = 0

    while bits < len(binary):
        # print(f"{bits} : " + str(precision))
        precision /= 2
        if binary[bits] == "1":
            res += precision
            # print(precision)
        elif binary[bits] == "0":
            pass
        else:
            raise ValueError("the string is not a binary")
        bits += 1
    return res
