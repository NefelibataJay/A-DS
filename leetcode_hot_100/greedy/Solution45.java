package leetcode_hot_100.greedy;

public class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int res = 0;
        int next = 0;
        int end = next;

        for (int i = 0; i < n - 1; i++) {
            next = Math.max(nums[i] + i, next);

            if (end == i) {
                res++;
                end = next;
            }
        }
        return res;
    }
}
