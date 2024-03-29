package classical_150.java.arrwithstr;

public class Solution122 {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        Solution122 solution = new Solution122();
        System.out.println(solution.maxProfit2(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int max = 0, beforePreice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > beforePreice)
                // 管你怎么算， 反正只要我现在的价格比之前买的时候贵，我就卖
                max += prices[i] - beforePreice;
            beforePreice = prices[i]; // 程序中只是记录，并不是真的买
            // 比如 我一直没进入到上面的if 中， 我就一直不卖，这里可能就会被误解为每天都买
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length < 2)
            return 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            // 只要今天的比昨天便宜，我就买！
            max += Math.max(prices[i] - prices[i - 1], 0);
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length < 2)
            return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        // 定义状态 dp[i][0]表示第 i 天交易完后手里没有股票的最大利润，
        // dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
        // 第一维 i 表示下标为 i 的那一天（ 具有前缀性质，即考虑了之前天数的交易 ）；
        // 第二维 j 表示下标为 i 的那一天是持有股票，还是持有现金。这里 0 表示持有现金（cash），1 表示持有股票（stock）。
        // 0：持有现金
        // 1：持有股票

        dp[0][0] = 0; // 第一天不买
        dp[0][1] = -prices[0]; // 第一天买

        for (int i = 1; i < len; i++) {
            // 第i天不买股票，所以我们当前没有股票时的最大利润，
            // 就是Max(昨天不买股票的利润（或者昨天卖出了）, 昨天买完股票后的钱 + 今天这个股票的价格)
            // 昨天持有股票时的钱 + 今天这个股票的价格 = 我昨天持有股票（我不管我昨天持有的是哪一天的），我今天给他卖了后赚得利润
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // 第i天买入股票
            // Max(昨天买完股票后的钱， 昨天没有买入时的钱 - 今天这个股票的价格)
            // 昨天没有买入时的钱 - 今天这个股票的价格 = 今天花钱买完股票后的利润
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        // 我们最后一天无论怎么样都得卖出了
        // 所以我们直接要最后一天没有股票时，我们的最大利润
        return dp[len - 1][0];
    }
}