from typing import *


class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        map = dict()  # num : [出现的次数, 第一次出现的位置, 最后一次出现的位置]

        for i, num in enumerate(nums):
            if num in map:
                map[num][0] += 1
                map[num][2] = i
            else:
                map[num] = [1, i, i]

        maxIn = 0
        res = 0

        for count, start, end in map.values():
            if count > maxIn:
                res = end-start+1
                maxIn = max(count, maxIn)
            elif count == maxIn:
                res = min(end-start+1, res)

        return res
