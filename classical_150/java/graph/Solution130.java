package classical_150.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Solution130 {

    public static void main(String[] args) {
        Solution130 solution130 = new Solution130();
        char[][] board = new char[][] {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };
        solution130.solve(board);
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0)
            return;

        // 只循环整个矩阵的左边界、右边界、上边界和下边界
        // 一旦有'O' 连接到边界，则和他相连的节点都会变成'Y'
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int j = 1; j < board[0].length - 1; j++) {
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'Y') // 从边界蔓延过来的岛
                    board[r][c] = 'O';
                else if (board[r][c] == 'O') // 没有蔓延岛边界的岛，就是被海水包围的岛
                    board[r][c] = 'X';
            }
        }
    }

    public void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O')
            return;
        board[r][c] = 'Y';
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }

    // 用于遍历当前节点的邻居
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };

    public void solve2(char[][] board) {
        if (board.length == 0)
            return;

        Queue<int[]> queue = new LinkedList<>(); // 记录节点的坐标
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[] { i, 0 });
                board[i][0] = 'A';
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new int[] { i, m - 1 });
                board[i][m - 1] = 'A';
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[] { 0, i });
                board[0][i] = 'A';
            }
            if (board[n - 1][i] == 'O') {
                queue.offer(new int[] { n - 1, i });
                board[n - 1][i] = 'A';
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            // 遍历当前节点的邻居
            for (int i = 0; i < 4; i++) {
                int r = x + dx[i], c = y + dy[i];
                if (r < 0 || c < 0 || r >= n || c >= m || board[r][c] != 'O')
                    continue;
                queue.offer(new int[] { r, c });
                board[r][c] = 'A';
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'Y') // 从边界蔓延过来的岛
                    board[r][c] = 'O';
                else if (board[r][c] == 'O') // 没有蔓延岛边界的岛，就是被海水包围的岛
                    board[r][c] = 'X';
            }
        }
    }
}
