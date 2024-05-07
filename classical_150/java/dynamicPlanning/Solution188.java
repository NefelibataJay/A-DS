package classical_150.java.dynamicPlanning;

import java.util.Arrays;

public class Solution188 {
    public int maxProfit1(int k, int[] prices) {
        int n = prices.length;
        int[] dp = new int[2 * k];

        for (int i = 0; i < 2 * k; i += 2) {
            dp[i] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            for (int j = 2; j < 2 * k; j += 2) {
                dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i]);
            }
        }

        return dp[2 * k - 1];
    }

    public int maxProfit2(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell).max().getAsInt();
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2 * k];
        for (int i = 0; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            for (int j = 2; j < 2 * k; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }

        return dp[n - 1][2 * k - 1];
    }

}
