from typing import List


def findPoisonedDuration(timeSeries: List[int], duration: int) -> int:
    res, expired = 0, 0

    for i in range(0, len(timeSeries)):
        if timeSeries[i] >= expired:
            res += duration
        else:
            res += timeSeries[i] + duration - expired
        expired = timeSeries[i] + duration
    return res


nums = [1, 2, 3, 4, 7]
findPoisonedDuration(nums, 2)
