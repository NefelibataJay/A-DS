package classical_150.java.dynamicPlanning;

public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        System.out.println(solution.longestPalindrome("baxbabyad"));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return s;
        boolean[][] dp = new boolean[n][n];
        // dp[i,j] = (dp[i+1,j-1] && s[i] == s[j])
        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n; i++) {
                int j = l + i - 1;
                if (j >= n)
                    break;
                if (charArray[i] != charArray[j])
                    dp[i][j] = false;
                else {
                    if (j - i - 1 < 2) // 长度为1的子串
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}