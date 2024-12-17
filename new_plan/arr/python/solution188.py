from typing import List


def generate(numRows: int) -> List[List[int]]:
    ans = [[] for i in range(numRows)]

    for i in range(numRows):
        ans[i] = [1 for j in range(i+1)]
        for j in range(1, i):
            ans[i][j] = ans[i-1][j-1] + ans[i-1][j]
    return ans


def getRow(rowIndex: int) -> List[int]:
    ans = [1 for i in range(rowIndex+1)]
    for i in range(1, rowIndex):
        ans[i] = int(ans[i-1] * (rowIndex - i + 1) / i)
    return ans


getRow(3)
