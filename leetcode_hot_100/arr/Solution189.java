package leetcode_hot_100.arr;

import java.util.Arrays;

public class Solution189 {
    public static void main(String[] args) {
        Solution189 solution189 = new Solution189();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

        solution189.rotate(nums, 7);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] arrs, int start, int end) {
        while (start < end) {
            int temp = arrs[start];
            arrs[start++] = arrs[end];
            arrs[end--] = temp;
        }
    }
}
