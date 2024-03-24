import random

class Minesweeper:
    def __init__(self, n, m, mine_count):
        self.n = n
        self.m = m
        self.mine_count = mine_count
        self.board = self.generate_board()

    def generate_board(self):
        # 初始化一个n x m的二维数组，所有元素初始化为0
        board = [[0 for _ in range(self.m)] for _ in range(self.n)]
        # 随机分布雷
        mines_placed = 0
        while mines_placed < self.mine_count:
            x = random.randint(0, self.n - 1)
            y = random.randint(0, self.m - 1)
            if board[x][y] != 'M':
                board[x][y] = 'M'
                mines_placed += 1
        return board

    def reveal(self, x, y):
        # 检查点击的位置是否有效
        if x < 0 or x >= self.n or y < 0 or y >= self.m:
            print("Invalid position.")
            return
        # 如果点击的位置已经被揭开，则不做任何操作
        if self.board[x][y] != 0:
            return
        # 如果点击的位置是雷，则游戏结束
        if self.board[x][y] == 'M':
            print("Game Over! You hit a mine.")
            return
        # 计算周围的雷的数量
        mine_count = 0
        for dx in [-1, 0, 1]:
            for dy in [-1, 0, 1]:
                nx, ny = x + dx, y + dy
                if nx >= 0 and nx < self.n and ny >= 0 and ny < self.m and self.board[nx][ny] == 'M':
                    mine_count += 1
        # 更新点击位置的值
        self.board[x][y] = mine_count
        # 打印整个二维数组
        self.print_board()

    def print_board(self):
        for row in self.board:
            print(' '.join(str(cell) for cell in row))
        print()

# 测试扫雷游戏
game = Minesweeper(5, 5, 5)
game.print_board()
game.reveal(2, 2)
game.print_board()
