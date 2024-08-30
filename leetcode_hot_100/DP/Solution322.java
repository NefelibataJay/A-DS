package leetcode_hot_100.DP;

import java.util.Arrays;

public class Solution322 {
    public static void main(String[] args) {
        int[] coins = { 2, 5, 10, 1 };
        System.out.println(coinChange(coins, 27));
    }

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1]; // dp[i] i块钱最少要多少个coin
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // 遍历到总量 i 最少需要多少个coin
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) { // 当前的面值超过当前的总量 i
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    // dp[i - coins[j]]就是当前的总价 i 减掉当前coin面值还要多少钱
                    // +1 表示加上当前的coin
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
