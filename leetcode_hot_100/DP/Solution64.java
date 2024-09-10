package leetcode_hot_100.DP;

import java.util.Arrays;

public class Solution64 {
    public int minPathSum1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                dp[col + 1] = Math.min(dp[col + 1], dp[col]) + grid[row][col];
            }
        }
        return dp[n];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0)
                    dp[col] = grid[row][col];
                else if (row == 0)
                    dp[col] = grid[row][col] + dp[col - 1];
                else if (col == 0)
                    dp[col] = grid[row][col] + dp[col];
                else
                    dp[col] = grid[row][col] + Math.min(dp[col - 1], dp[col]);
            }
        }

        return dp[n - 1];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // return dfs(grid, 0, 0);

        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0)
                    dp[row][col] = grid[row][col];
                else if (row == 0)
                    dp[row][col] = grid[row][col] + dp[row][col - 1];
                else if (col == 0)
                    dp[row][col] = grid[row][col] + dp[row - 1][col];
                else
                    dp[row][col] = grid[row][col] + Math.min(dp[row][col - 1], dp[row - 1][col]);
            }
        }

        return dp[m - 1][n - 1];
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row == grid.length - 1 && col == grid[0].length - 1)
            return grid[row][col];

        if (row == grid.length - 1)
            return dfs(grid, row, col + 1) + grid[row][col];

        if (col == grid[0].length - 1)
            return dfs(grid, row + 1, col) + grid[row][col];

        return Math.min(dfs(grid, row + 1, col), dfs(grid, row, col + 1)) + grid[row][col];
    }
}
