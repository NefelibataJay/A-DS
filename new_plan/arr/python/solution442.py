from typing import *


class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        n = len(nums)
        count = [0] * (n+1)
        res = []

        for num in nums:
            if count[num] != 0:
                res.append(num)
            count[num] += 1
        return res
