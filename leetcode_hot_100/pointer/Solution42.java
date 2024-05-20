package leetcode_hot_100.pointer;

public class Solution42 {
    public static void main(String[] args) {
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;
        if (n < 3)
            return 0;

        int rain = 0;
        int[][] dp = new int[n][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][1], height[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            int h = Math.min(dp[i][0], dp[i][1]);
            if (h > height[i]) {
                rain += h - height[i];
            }
        }

        return rain;
    }

    public static int trap2(int[] height) {
        int n = height.length;
        if (n < 3)
            return 0;

        int rain = 0;
        int left = 0, right = n - 1, leftMax = 0, rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[right] > height[left]) {
                rain += leftMax - height[left++];
            } else {
                rain += rightMax - height[right--];
            }
        }

        return rain;
    }
}
