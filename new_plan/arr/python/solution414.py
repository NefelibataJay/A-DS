from typing import List


def thirdMax(nums: List[int]) -> int:
    a, b, c = 0, 0, 0

    for num in nums:
        if num > a:
            c = b
            b = a
            a = num
        elif a > num > b:
            c = b
            b = num
        elif b > num > c:
            c = num

    return a if c == 0 else c
