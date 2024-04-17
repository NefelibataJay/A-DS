package classical_150.java.backtracking;

import java.util.*;

public class Solution52 {
    private int n;
    private boolean[] onPath, diag1, diag2;

    public int totalNQueens(int n) {
        this.n = n;
        onPath = new boolean[n];
        diag1 = new boolean[n * 2 - 1];
        diag2 = new boolean[n * 2 - 1];
        return backtrack(0);
    }

    public int backtrack(int r) {
        if (r == n)
            return 1;
        int count = 0;
        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            if (!onPath[c] && !diag1[r + c] && !diag2[rc]) {
                onPath[c] = diag1[r + c] = diag2[rc] = true;
                count += backtrack(r + 1);
                onPath[c] = diag1[r + c] = diag2[rc] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution52 solution = new Solution52();
        System.out.println(solution.totalNQueens(4));
    }
}
