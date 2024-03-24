import random


class Minesweeper:
    def __init__(self, n, m, mine_count):
        self.n = n
        self.m = m
        self.mine_count = mine_count
        self.board = self.generate_board()
        self.revealed = [[False for _ in range(self.m)] for _ in range(self.n)]

    def generate_board(self):
        board = [[0 for _ in range(self.m)] for _ in range(self.n)]
        mines_placed = 0
        while mines_placed < self.mine_count:
            x = random.randint(0, self.n - 1)
            y = random.randint(0, self.m - 1)
            if board[x][y] != 'M':
                board[x][y] = 'M'
                mines_placed += 1
        for i in range(self.n):
            for j in range(self.m):
                if board[i][j] != 'M':
                    mine_count = 0
                    for dx in [-1, 0, 1]:
                        for dy in [-1, 0, 1]:
                            nx, ny = i + dx, j + dy
                            if nx >= 0 and nx < self.n and ny >= 0 and ny < self.m and board[nx][ny] == 'M':
                                mine_count += 1
                    board[i][j] = mine_count
        return board

    def reveal(self, x, y):
        if x < 0 or x >= self.n or y < 0 or y >= self.m:
            print("Invalid position.")
        if self.board[x][y] == 'M':
            print("Game Over! You hit a mine.")
            self.print_board(True)  # 打印包含雷的游戏板
            return False
        self.reveal_recursive(x, y)
        self.print_board()
        return True

    def reveal_recursive(self, x, y):
        if x < 0 or x >= self.n or y < 0 or y >= self.m or self.revealed[x][y]:
            return
        self.revealed[x][y] = True
        if self.board[x][y] == 0:
            for dx in [-1, 0, 1]:
                for dy in [-1, 0, 1]:
                    self.reveal_recursive(x + dx, y + dy)

    def print_board(self, show_mines=False):
        for i in range(self.n):
            for j in range(self.m):
                if self.revealed[i][j] or show_mines:
                    print(self.board[i][j] if self.board[i]
                          [j] != 'M' else 'M', end=' ')
                else:
                    print('?', end=' ')
            print()
        print()


# 获取用户输入
n = int(input("Enter the number of rows: "))
m = int(input("Enter the number of columns: "))
mine_count = int(input("Enter the number of mines: "))

# 初始化游戏
game = Minesweeper(n, m, mine_count)

flag = True
# 游戏循环
while flag:
    game.print_board()
    x = int(input("Enter the row number to reveal: "))
    y = int(input("Enter the column number to reveal: "))
    flag = game.reveal(x, y)
