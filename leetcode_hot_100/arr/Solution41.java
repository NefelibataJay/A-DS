package leetcode_hot_100.arr;

public class Solution41 {
    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        int[] nums = { 7, 8, 9, 11, 12 };
        System.out.println(solution41.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            if (nums[i] <= 0)
                nums[i] = n + 1;

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            // 如果其中的数小于0或者大于n的话，就不用管了
            // 因为这个数不会影响到1~n的数
            // 一但有小于0或者大于n，则最终的结果一定是1~n中的某个数
            if (num <= n)
                // 将出现过的数对应的位置的数变成负数
                nums[num - 1] = -Math.abs(nums[num - 1]);
        }

        for (int i = 0; i < n; i++)
            if (nums[i] > 0)
                // 如果当前位置还是>0，说明这个位置的数没有出现过
                return i + 1;
        return n + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
