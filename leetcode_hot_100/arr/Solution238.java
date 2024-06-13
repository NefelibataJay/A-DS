package leetcode_hot_100.arr;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        for (int i = 1; i < n; i++)
            ans[i] = nums[i - 1] * ans[i - 1];

        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R *= nums[i];
        }

        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] R = new int[n];
        int[] L = new int[n];

        L[0] = 1;
        R[n - 1] = 1;

        for (int i = 1; i < n; i++)
            L[i] = nums[i - 1] * L[i - 1];

        for (int i = n - 2; i >= 0; i--)
            R[i] = nums[i + 1] * R[i + 1];

        int[] ans = new int[n];

        for (int i = 0; i < n; i++)
            ans[i] = L[i] * R[i];

        return ans;
    }
}