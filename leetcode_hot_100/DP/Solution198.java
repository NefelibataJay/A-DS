package leetcode_hot_100.DP;

public class Solution198 {
    // 打家劫舍
    public int rob(int[] nums) {
        int n = nums.length;
        int res = 0;
        int a = 0, b = nums[0];

        for (int i = 1; i < n; i++) {
            res = Math.max(a + nums[i], b);
            a = b;
            b = res;
        }

        return b;
    }
}
