package leetcode_hot_100.pointer;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int q = 1, p = 0;

        while (p < n && q < n) {
            if (nums[p] == 0) {
                while (q < n && nums[q] == 0) {
                    q++;
                }
                if (q == n)
                    break;
                int temp = nums[q];
                nums[q] = nums[p];
                nums[p] = temp;
            }
            p++;
            q++;
        }
    }

    public void moveZeroes1(int[] nums) {
        int n = nums.length, s = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0)
                nums[s++] = nums[i];
        }

        for (int i = s; i < n; i++)
            nums[i] = 0;
    }
}
