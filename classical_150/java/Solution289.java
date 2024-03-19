package classical_150.java;

import java.util.Arrays;

public class Solution289 {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        Solution289 solution289 = new Solution289();
        solution289.gameOfLife1(board);
        System.out.println(Arrays.deepToString(board));
        // [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
    }

    public void gameOfLife1(int[][] board){
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCell = this.countLiveCell(board, i, j, m, n);
                if (board[i][j] == 0) {
                    // 如果周围活细胞的数量等于3就置位2，否则还是0
                    if (liveCell == 3) board[i][j] = 2;
                } else {
                    // 如果周围活细胞的数量小于3大于2就置位-1，否则还是1
                    if (liveCell < 2 || liveCell > 3) board[i][j] = -1;
                }
            }
        }

        // -1 代表原本是活着，后来死了
        // 2 代表原来是死的，后来活了

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                switch (board[i][j]){
                    case -1: board[i][j] = 0; break;
                    case 2: board[i][j] = 1; break;
                }
            }
        }
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCell = this.countLiveCell(board, i, j, m, n);
                if (board[i][j] == 0) {
                    // 如果周围活细胞的数量等于3就置位1，否则还是0
                    if (liveCell == 3) newBoard[i][j] = 1;
                    else newBoard[i][j] = 0;
                } else {
                    if (liveCell < 2 || liveCell > 3) newBoard[i][j] = 0;
                    else newBoard[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    private int countLiveCell(int[][] box, int x, int y, int m, int n) {
        // 计算周围活细胞数量
        int count = 0;

        for (int row = x - 1; row <= x + 1; row++) {
            if (row < 0 || row >= m) continue;
            for (int col = y - 1; col <= y + 1; col++) {
                if (col < 0 || col >= n || (row == x && col == y)) continue;
                if (box[row][col] == 1 || box[row][col]==-1) count++;
                // box[row][col]==-1 是处理原本是活着，后来死了的情况
            }
        }

        return count;
    }
}
