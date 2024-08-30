package leetcode_hot_100.DP;

public class Solution279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        int f[] = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i - j * j] + 1, f[i]); // 上一个数n - j * j 所对应的完全平方数最少数量 f[n - j * j]
            }
        }
        return f[n];
    }
}
