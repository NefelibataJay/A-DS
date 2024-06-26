package classical_150.java.dynamicPlanning;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1]; // dp[i][j] 表示 word1的第i个字符转换为word2到第j个字符需要多少步数
        for (int j = 1; j <= m; j++)
            dp[0][j] = dp[0][j - 1] + 1;
        for (int i = 1; i <= n; i++)
            dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n][m];
    }
}
