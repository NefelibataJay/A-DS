
from typing import List


class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        n = len(points)
        pos = [0] * n
        ans = 0

        pass


def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quick_sort(left) + middle + quick_sort(right)


if __name__ == "__main__":
    solution = Solution()
    points = [[3, 9], [7, 12], [3, 8], [6, 8], [
        9, 10], [2, 9], [0, 9], [3, 9], [0, 6], [2, 8]]
    print(solution.findMinArrowShots(points=points))
