package classical_150.java.backtracking;

import java.util.*;

public class Solution51 {
    private int n;
    private int[] col;
    private boolean[] onPath, diag1, diag2;
    private final List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        col = new int[n];
        onPath = new boolean[n]; // 记录每个列是否使用过
        // (n * 2 - 1) 两个斜对角线的长度-1
        diag1 = new boolean[n * 2 - 1]; // 记录 r + c
        diag2 = new boolean[n * 2 - 1]; // 记录 r - c
        dfs(0);
        return ans;
    }

    private void dfs(int r) {
        if (r == n) {
            List<String> board = new ArrayList<>(n);
            for (int c : col) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board.add(new String(row));
            }
            ans.add(board);
            return;
        }
        for (int c = 0; c < n; ++c) { // 遍历当前行的列
            int rc = r - c + n - 1; // +(n-1) 防止复数
            if (!onPath[c] && !diag1[r + c] && !diag2[rc]) {
                // onPath[c] 没有选择过 ， diag1[r + c] 也没有选择过， diag2[r - c] 也没有选择过
                col[r] = c; // 记录当前列
                onPath[c] = diag1[r + c] = diag2[rc] = true;
                dfs(r + 1);
                onPath[c] = diag1[r + c] = diag2[rc] = false; // 恢复现场
            }
        }
    }

    public static void main(String[] args) {
        Solution51 solution = new Solution51();
        solution.solveNQueens(4);
    }
}
