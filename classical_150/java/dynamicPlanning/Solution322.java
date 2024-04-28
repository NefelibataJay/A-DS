package classical_150.java.dynamicPlanning;

import java.util.*;

public class Solution322 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = in.nextInt();
        int amount = in.nextInt();
        Solution322 solution322 = new Solution322();
        System.out.println(solution322.coinChange2(coins, amount));
        in.close();
    }

    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0)
            return -1;

        int[] dp = new int[amount + 1]; // dp中第i个状态是到i块钱需要的最少硬币
        // Arrays.fill(memo,amount+1); // 填充 amout + 1的值，其实就是固定最大数
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]] + 1;
                }
                /*
                 * if (i - coins[j] >= 0)
                 * dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                 */
            }
            dp[i] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        // return dp[amount] == amount+1 ? -1 : dp[amount];
    }

    int[] memo;

    public int coinChange1(int[] coins, int amount) {
        if (coins.length == 0)
            return -1;

        memo = new int[amount];
        return backtrack(coins, amount);
    }

    public int backtrack(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0)
            return -1;

        if (memo[amount - 1] != 0)
            // 到amount的值已经有最少花费的硬币数
            // 比如到amount=5, 我们有面值5的硬币，
            return memo[amount - 1];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = backtrack(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }

}
