package leetcode_hot_100.binary;

public class Solution153 {
    public int findMin(int[] nums) {
        // 寻找旋转排序数组中的最小值
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int low = 0, high = n - 1;
        while (low < high) {
            int mid = ((high - low) / 2) + low;
            if (nums[mid] < high)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}
