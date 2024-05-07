package classical_150.java.dynamicPlanning;

public class Solution123 {
    public int maxProfit1(int[] prices) {
        int firstBuy = -prices[0], firstSeal = 0, secondBuy = -prices[0], secondSeal = 0;
        for (int i = 1; i < prices.length; ++i) {
            firstBuy = Math.max(firstBuy, -prices[i]);
            firstSeal = Math.max(firstSeal, firstBuy + prices[i]);
            secondBuy = Math.max(secondBuy, firstSeal - prices[i]);
            secondSeal = Math.max(secondSeal, secondBuy + prices[i]);
        }
        return secondSeal;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = dp[0][2] = prices[0];

        // dp[i][0] = max(dp[i-1][0], -prices[i])
        // dp[i][1] = max(dp[i-1][1], dp[i-1][0]+prices[i])
        // dp[i][2] = max(dp[i-1][2], dp[i-1][1]-prices[i])
        // dp[i][3] = max(dp[i-1][3], dp[i-1][2]+prices[i])

        for (int i = 1; i < n; i++) {
            // 取哪一天买入的价格最小，判断上一天买和今天买，哪个价格最小
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 取哪一天卖出的价格最高，判断上一天卖和今天卖，哪个利润最大
            // 今天的利润就是，今天的股票价格加上一天计算的买入价格（负数）
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            // 计算第二次交易股票的最低买入价格，因为计算的是第二次交易，所以需要考虑第一次交易的利润
            // 所以需要判断，上一天的第二次买入价格和当天买入价格（前一天的利润减去当天的股票价格）
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            // 第二次交易的利润和第一次交易的利润差不多
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }

        return dp[n - 1][3];
    }
}
