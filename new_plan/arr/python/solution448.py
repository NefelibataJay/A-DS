from typing import *


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        temp = [0 for i in range(n)]

        for num in nums:
            temp[num] += 1

        res = list()

        for i in range(1, n+1):
            if (temp[i] == 0):
                res.append(i+1)

        return res

    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        a = set(nums)
        b = []
        for i in range(1, 1+len(nums)):
            if i not in a:
                b.append(i)
        return b
