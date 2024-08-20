
package leetcode_hot_100.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution51
 */
public class Solution51 {
    // N 皇后
    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        solution51.solveNQueens(4);
    }

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    int[] chessboard; // 存储第i行的皇后在第几列

    public List<List<String>> solveNQueens(int n) {
        chessboard = new int[n];
        Arrays.fill(chessboard, -1);
        dfs(0, n);
        return ans;
    }

    private void dfs(int row, int n) {
        if (row == n) {
            ans.add(new ArrayList<String>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(row, i))
                continue;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i)
                    sb.append("Q");
                else
                    sb.append(".");
            }

            path.add(sb.toString());
            chessboard[row] = i;
            dfs(row + 1, n);
            path.remove(path.size() - 1);
            chessboard[row] = -1;
        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chessboard[i] == col || chessboard[i] + i == row + col || chessboard[i] - i == col - row)
                return false;
        }
        return true;
    }
}