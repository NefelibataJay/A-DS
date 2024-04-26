package classical_150.java.dynamicPlanning;

public class Solution198 {
    public int rob(int[] nums) {
        // f(x) = Max(f(x - 2) + C, f(x-1))
        int n = nums.length;
        int[][] money = new int[n][2]; // [每个房子][偷了的话, 不偷的话]

        int x1 = nums[0], x2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int x = Math.max(x2 + nums[i], x1);
            x2 = x1;
            x1 = x;
        }

        return x2 > x1 ? x2 : x1;
    }
}
