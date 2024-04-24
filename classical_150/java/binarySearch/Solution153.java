package classical_150.java.binarySearch;

public class Solution153 {
    public static void main(String[] args) {

    }

    // 数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为
    // 数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]]
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int low = 0, high = n - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (nums[mid] < min)
                min = nums[mid];

            if (nums[mid] < nums[high])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return min;
    }
}
