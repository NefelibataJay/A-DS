package leetcode_hot_100.binary;

public class Solutiuon33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = ((right - left) / 2) + left;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) { // 左边有序
                if (nums[0] <= target && target < nums[mid])
                    // target 小于左边的最小值 且 target 小于 mid
                    right = mid - 1;
                else
                    left = mid + 1;
            } else { // 左边无序，那右边一定有序
                if (nums[mid] < target && target <= nums[n - 1])
                    // mid 小于 target 且 target 小于 最右边的值
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
