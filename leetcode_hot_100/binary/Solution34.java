package leetcode_hot_100.binary;

import java.util.Arrays;

public class Solution34 {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        solution34.searchRange(new int[] { 1 }, 1);
    }

    public int[] searchRange(int[] nums, int target) {
        // 非递减顺序
        int n = nums.length;
        int[] res = new int[2];
        Arrays.fill(res, -1);
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = ((high - low) / 2) + low;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                int start = mid;
                while (start >= 0) {
                    if (nums[--start] != target)
                        break;
                }
                int end = mid;
                while (end < n - 1) {
                    if (nums[end] != target)
                        break;
                }
                res[0] = start + 1;
                res[1] = end - 1;
                return res;
            }
        }
        return res;
    }
}
