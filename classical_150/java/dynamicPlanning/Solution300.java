package classical_150.java.dynamicPlanning;

import java.util.Arrays;

public class Solution300 {
    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        Solution300 solution300 = new Solution300();
        System.out.println(solution300.lengthOfLIS3(nums));
    }

    public int lengthOfLIS3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            // 返回的负数，比如[2,4,6] 查找3返回-2，查找1返回-1，查找7返回-4，找到了就返回对应下标
            // 负数其实对应的就是，刚好比你要查找的数字大一点的位置 比如我们查3, -2 -> 2, 列表中第二个位置就是3，刚好比他大一点
            // 如果我们查数字 target， 返回的是正数，那么他在nums中，如果是负数 (-res)
            // 那么 nums[res - 1] 刚好大于 target 且最近数字
            // 那么 nums[res - 2] 刚好小于 target 且最近数字
            // 那么我们可以知道 num[2 - 2]
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n]; // tail[i] 的值表示长度为 (i+1) 的子序列尾部元素值
        int res = 0; // 当前tail的长度

        for (int k = 0; k < n; k++) {
            int left = 0, high = res;
            while (left < high) {
                int m = (left + high) / 2;
                if (tail[m] < nums[k])
                    left = m + 1;
                else
                    high = m;
            }

            tail[left] = nums[k];
            if (res == high)
                res++;
        }

        return res;
    }

    public int lengthOfLIS1(int[] nums) {
        // 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }

        int re = 1;
        for (int i = 1; i <= n; i++) {
            if (dp[i] > re)
                re = dp[i];
        }

        return re;
    }

    public int lengthOfLIS10(int[] nums) {
        // 这里求的是 最长递增的连续子序列
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;

        int count = 0;
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > pre)
                count++;
            else
                count = 0;
            pre = nums[i];

            dp[i + 1] = Math.max(count, dp[i]);
        }

        return dp[n];
    }
}
