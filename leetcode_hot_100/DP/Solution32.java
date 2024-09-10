package leetcode_hot_100.DP;

public class Solution32 {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.longestValidParentheses("())"));
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2)
            return 0;
        int[] dp = new int[n];
        int res = 0;

        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(')
                    dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = 2 + dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
