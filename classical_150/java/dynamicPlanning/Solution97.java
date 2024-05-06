package classical_150.java.dynamicPlanning;

public class Solution97 {
    public boolean isInterleave1(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), len = s3.length();
        if (n + m != len)
            return false;

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        // dp[i][j] = (dp[i-1][j] && s1[i]==s3[i+j]) || (dp[i][j-1] && s2[j]==s3[i+j])
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i > 0)
                    dp[i][j] = (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]);
                if (j > 0)
                    dp[i][j] = dp[i][j] || (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), len = s3.length();
        if (n + m != len)
            return false;

        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i > 0)
                    dp[j] = dp[j] && s3.charAt(i + j - 1) == s1.charAt(i - 1);
                if (j > 0)
                    dp[j] = dp[j] || (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[j - 1]);
            }
        }
        return dp[m];
    }
}
