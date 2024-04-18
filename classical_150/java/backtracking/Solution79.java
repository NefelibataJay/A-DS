package classical_150.java.backtracking;

public class Solution79 {
    public static void main(String[] args) {

    }

    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (check(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean check(char[][] board, String word, int x, int y, int k) {
        if (x < 0 && x >= board.length && y >= board[0].length && y < 0 || board[x][y] != word.charAt(k))
            return false;
        else if (k == word.length() - 1)
            return true;

        // 相等且没达到最大长度
        board[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            int nextX = dx[i] + x, nextY = dy[i] + y;
            if (check(board, word, nextX, nextY, k + 1))
                return true;
        }
        board[x][y] = word.charAt(k);
        return false;
    }
}
