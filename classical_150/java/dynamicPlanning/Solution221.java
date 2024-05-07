package classical_150.java.dynamicPlanning;

public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int max = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (dp[i][j] > 0 & dp[i][j + 1] > 0 && dp[i + 1][j] > 0) {
                        dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]);
                    } else
                        dp[i + 1][j + 1] = 1;
                    max = Math.max(dp[i + 1][j + 1], max);
                }
            }
        }

        return max * max;
    }
}
