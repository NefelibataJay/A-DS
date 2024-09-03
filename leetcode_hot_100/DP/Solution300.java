package leetcode_hot_100.DP;

import java.util.*;

public class Solution300 {
    public static void main(String[] args) {
        int[] nums = { 7, 8, 9, 1, 2, 3, 4, 5 };
        Solution300 solution300 = new Solution300();
        solution300.lengthOfLIS1(nums);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp[n - 1];
    }

    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) // 查找tail 中，该元素的位置
                    i = m + 1; // 该元素大于 mid ，左指针向右
                else
                    j = m; // 该元素小于等于 mid， 右指针左移
            }
            tails[i] = num; // 二分查找后，左指针指向二分查找表 tail 中适合插入的位置，就是左边全都小于当前的num
            if (res == j) // 更新 长度
                res++;
        }
        return res;
    }
}
