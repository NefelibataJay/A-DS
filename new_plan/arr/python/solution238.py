from ast import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        leftPod = [1]*n
        rightPod = [1]*n
        res = [1]*n
        for i in range(1, n):
            leftPod[i] = nums[i-1] * leftPod[i-1]

        for i in range(n-2, -1, -1):
            rightPod[i] = nums[i+1] * rightPod[i+1]

        for i in range(n):
            res[i] = leftPod[i]*rightPod[i]

        return res

    def productExceptSelf2(self, nums: List[int]) -> List[int]:
        length = len(nums)
        answer = [0]*length

        # answer[i] 表示索引 i 左侧所有元素的乘积
        # 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1
        for i in range(1, length):
            answer[i] = nums[i - 1] * answer[i - 1]

        # R 为右侧所有元素的乘积
        # 刚开始右边没有元素，所以 R = 1
        R = 1
        for i in reversed(range(length)):
            # 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R
            # R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i]

        return answer
