from typing import List


def maximumProduct(nums: List[int]) -> int:
    nums = sorted(nums)
    n = len(nums)
    return max(nums[0]*nums[1]*nums[n-1], nums[n-1]*nums[n-2]*nums[n-3])
