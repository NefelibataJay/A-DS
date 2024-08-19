package leetcode_hot_100.backtrack;

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean check(char[][] board, String word, int row, int col, int index) {
        if (row >= board.length || col >= board[0].length || row < 0 || col < 0
                || board[row][col] != word.charAt(index))
            return false;

        if (index == word.length() - 1)
            return true;

        char temp = board[row][col];
        board[row][col] = '#';

        boolean flag = check(board, word, row, col + 1, index + 1) ||
                check(board, word, row, col - 1, index + 1) ||
                check(board, word, row + 1, col, index + 1) ||
                check(board, word, row - 1, col, index + 1);

        board[row][col] = temp;
        return flag;
    }
}
