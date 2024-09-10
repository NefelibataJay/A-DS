package leetcode_hot_100.DP;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return false;

        int sum = 0, maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        int target = sum / 2;

        if (sum % 2 != 0 || maxNum > target)
            return false;

        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num)
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n - 1][target];
    }
}
