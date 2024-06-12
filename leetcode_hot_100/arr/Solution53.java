package leetcode_hot_100.arr;

public class Solution53 {
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(solution53.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int pre = 0;

        for (int i = 0; i < n; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
