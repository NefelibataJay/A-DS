package classical_150.java.binarySearch;

public class Solution35 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        Solution35 soltuion = new Solution35();
        System.out.println(soltuion.searchInsert(nums, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int left = 0, right = n - 1, mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else { // (nums[mid] == target)
                return mid;
            }
        }

        return nums[mid] > target ? mid + 1 : mid;
    }

    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
