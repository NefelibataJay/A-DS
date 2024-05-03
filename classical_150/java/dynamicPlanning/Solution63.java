package classical_150.java.dynamicPlanning;

class Solution63 {
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m];

        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < n; i++) {
            dp[0] = obstacleGrid[i][0] == 1 ? 0 : dp[0];
            for (int j = 1; j < m; j++) {
                    dp[j] = (dp[j] + dp[j - 1]) * (1-obstacleGrid[i][j]);
                }
            }
        }

    return dp[m-1];
}}
