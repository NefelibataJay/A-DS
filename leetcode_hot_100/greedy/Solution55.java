package leetcode_hot_100.greedy;

public class Solution55 {
    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(solution55.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i] - 1, nums[i]);
            if (i != n - 1 && dp[i + 1] == 0)
                return false;
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        int n = nums.length;

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max - 1, nums[i]);
            if (i != n - 1 && max == 0)
                return false;
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length;

        int max = 0; // 当前最大步数
        for (int i = 0; i < n; i++) {
            max = Math.max(max - 1, nums[i]);

            if (max + i >= n - 1) // 提前计算是否到达终点
                return true;
            if (i != n - 1 && max == 0)
                return false;
        }
        return true;
    }
}
