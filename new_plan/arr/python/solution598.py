from typing import List


def maxCount(m: int, n: int, ops: List[List[int]]) -> int:
    # a = [[0 for _ in range(n)] for _ in range(m)]

    mina, minb = 0, 0
    for a, b in ops:
        mina = min(a, mina)
        minb = min(b, minb)
    return mina * minb


maxCount(3, 3, [[2, 2], [3, 3], [3, 3], [3, 3], [2, 2], [3, 3],
         [3, 3], [3, 3], [2, 2], [3, 3], [3, 3], [3, 3]])
