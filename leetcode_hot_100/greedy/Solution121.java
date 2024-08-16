package leetcode_hot_100.greedy;

public class Solution121 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // dp[i][0] 今天卖出的最大利润 dp[i][1] 今天不买的最大利润

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }

        return dp[n - 1][0];
    }

    public int maxProfit2(int[] prices) {

        int n = prices.length;
        int max = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(prices[i], min);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
