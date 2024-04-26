package classical_150.java.dynamicPlanning;

public class Solution198 {
    public int rob(int[] nums) {
        // f(x) = Max(f(x - 2) + C, f(x-1))
        int x1 = nums[0], x2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int x = Math.max(x2 + nums[i], x1);
            x2 = x1;
            x1 = x;
        }

        return x2 > x1 ? x2 : x1;
    }

    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

        int N = nums.length;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            dp[k] = Math.max(dp[k - 1], nums[k - 1] + dp[k - 2]);
        }
        return dp[N];
    }

    public int rob2(int[] nums) {
        int prev = 0;
        int curr = 0;

        // 每次循环，计算“偷到当前房子为止的最大金额”
        for (int i : nums) {
            // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
            // dp[k] = max{ dp[k-1], dp[k-2] + i }
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
            // 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
        }

        return curr;
    }
}
