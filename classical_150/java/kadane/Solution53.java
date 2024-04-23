package classical_150.java.kadane;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0], pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num); // 要求连续子数组，所以需要判断石否需要前一个数加入当前数组
            max = Math.max(max, pre);
        }
        return max;
    }
}