package classical_150.java.binarySearch;

public class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return -1;
        if (n == 1)
            return nums[0] == target ? 0 : -1;

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (nums[mid] == target)
                return mid;
            if (nums[0] <= nums[mid]) {
                // 以mid为中线，左边是有序的
                if (target < nums[mid] && target >= nums[0])
                    // target大于nums[0] 才有可能在前半段
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                // 以mid为中线，右边是有序的
                if (target > nums[mid] && target <= nums[n - 1])
                    low = mid + 1;
                else
                    high = mid - 1;
            }

        }
        return -1;
    }
}
