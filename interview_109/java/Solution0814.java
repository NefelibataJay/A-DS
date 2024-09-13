package interview_109.java;

public class Solution0814 {
    public int countEval(String s, int result) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return (s.charAt(0) - '0') == result ? 1 : 0;

        char[] ch = s.toCharArray();
        int[][][] dp = new int[ch.length][ch.length][2];

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0' || ch[i] == '1') {
                dp[i][i][ch[i] - '0'] = 1;
            }
        }

        // 套区间dp模板
        // 枚举区间长度len，跳步为2，一个数字一个符号
        for (int len = 2; len <= ch.length; len += 2) {
            // 枚举区间起点，数字位，跳步为2
            for (int i = 0; i <= ch.length - len; i += 2) {
                // 区间终点，数字位
                int j = i + len;
                // 枚举分割点，三种 '&','|', '^'，跳步为2
                for (int k = i + 1; k <= j - 1; k += 2) {
                    if (ch[k] == '&') {
                        // 结果为0 有三种情况： 0 0, 0 1, 1 0
                        // 结果为1 有一种情况： 1 1
                        dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0] + dp[i][k - 1][0] * dp[k + 1][j][1]
                                + dp[i][k - 1][1] * dp[k + 1][j][0];
                        dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][1];
                    }
                    if (ch[k] == '|') {
                        // 结果为0 有一种情况： 0 0
                        // 结果为1 有三种情况： 0 1, 1 0, 1 1
                        dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0];
                        dp[i][j][1] += dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0]
                                + dp[i][k - 1][1] * dp[k + 1][j][1];
                    }
                    if (ch[k] == '^') {
                        // 结果为0 有两种情况： 0 0, 1 1
                        // 结果为1 有两种情况： 0 1, 1 0
                        dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0] + dp[i][k - 1][1] * dp[k + 1][j][1];
                        dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][0] + dp[i][k - 1][0] * dp[k + 1][j][1];
                    }
                }
            }
        }
        return dp[0][ch.length - 1][result];
    }
}
