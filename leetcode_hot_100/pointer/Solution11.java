package leetcode_hot_100.pointer;

public class Solution11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1, max = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;

            max = Math.max(h * w, max);

            if (height[left] <= height[right])
                left++;
            else
                right--;
        }

        return max;
    }
}
