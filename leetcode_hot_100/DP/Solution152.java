package leetcode_hot_100.DP;

public class Solution152 {
    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        System.out.println(solution152.maxProduct2(new int[] { 2, -1, 3, -2, 2, -1 }));
    }

    public int maxProduct2(int[] nums) {
        // 初始化最大乘积和最小乘积
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0]; // 记录全局最大值

        // 从第二个元素开始遍历数组
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // 当 current 是负数时，交换 maxProduct 和 minProduct
            if (current < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // 更新最大乘积和最小乘积
            maxProduct = Math.max(current, maxProduct * current);
            minProduct = Math.min(current, minProduct * current);

            // 更新全局最大值
            result = Math.max(result, maxProduct);
        }

        return result;

    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(Math.max(nums[i], dp[i - 1][0] * nums[i]), dp[i - 1][1] * nums[i]);
            dp[i][1] = Math.min(Math.min(nums[i], dp[i - 1][1] * nums[i]), dp[i - 1][0] * nums[i]);

            max = Math.max(max, dp[i][0]);
        }

        return max;
    }
}
