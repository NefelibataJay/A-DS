from typing import List


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])
        copy_board = [[board[row][col]
                       for col in range(n)] for row in range(m)]

        for i in range(m):
            for j in range(n):
                if copy_board[i][j] == 1:
                    count = self.count(copy_board, i, j)
                    if count < 2 or count > 3:
                        board[i][j] = 0
                elif copy_board[i][j] == 0 and self.count(copy_board, i, j) == 3:
                    board[i][j] = 1

    def count(self, board, row, col):
        res = 0
        for i in range(row-1, row+2):
            if i < 0 or i > len(board)-1:
                continue
            for j in range(col-1, col+2):
                if j < 0 or j > len(board[0])-1 or (i == row and j == col):
                    continue
                res += board[i][j]
        return res

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])

        for i in range(m):
            for j in range(n):
                if board[i][j] == 1:
                    count = self.count(board, i, j)
                    if count < 2 or count > 3:
                        board[i][j] = -1
                elif board[i][j] == 0 and self.count(board, i, j) == 3:
                    board[i][j] = 2
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1

    def count2(self, board, row, col):
        res = 0
        for i in range(row-1, row+2):
            if i < 0 or i > len(board)-1:
                continue
            for j in range(col-1, col+2):
                if j < 0 or j > len(board[0])-1 or (i == row and j == col):
                    continue
                if board[i][j] == -1:
                    res += 1
                elif board[i][j] == 2:
                    res += 0
                else:
                    res += board[i][j]
        return res
