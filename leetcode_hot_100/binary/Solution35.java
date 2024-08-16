package leetcode_hot_100.binary;

public class Solution35 {
    // 搜索插入位置
    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        System.out.println(solution35.searchInsert(new int[] { 1, 3, 5, 7 }, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = ((right - left) / 2) + left;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else
                return mid;
        }

        return left;
    }
}
