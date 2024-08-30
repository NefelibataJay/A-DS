package leetcode_hot_100.DP;

public class Solution70 {
    public int climbStairs(int n) {
        int a = 1, b = 1, sum = 0;
        ;
        for (int i = 0; i < n - 1; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
