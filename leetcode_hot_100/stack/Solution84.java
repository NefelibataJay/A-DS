package leetcode_hot_100.stack;

import java.util.*;

public class Solution84 {

    public static void main(String[] args) {
        // 柱状图中最大的矩形
    }

    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int res = 0;
        for (int left = 0; left < n; left++) {
            int minHeight = Integer.MAX_VALUE;
            for (int right = left; right < n; right++) {
                minHeight = Math.min(minHeight, heights[right]);
                res = Math.max(res, (right - left + 1) * minHeight);
            }
        }
        return res;
    }

    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int res = 0;
        for (int mid = 0; mid < n; mid++) {
            int h = heights[mid];
            int left = mid, right = mid;
            while (left > 0 && heights[left - 1] >= h)
                left--;
            while (right < n - 1 && heights[right + 1] >= h)
                right++;

            res = Math.max(res, (right - left + 1) * h);
        }
        return res;
    }

    public int largestRectangleArea3(int[] heights) {
        // 进栈前弹出的都是左边比自己大的→确定左边界；
        // 出栈时必定是右边第一次遇到比自己小的→确定右边界
        int n = heights.length;
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = i - 1 - stack.peek();
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int h = heights[stack.pop()];
            int w = n - 1 - stack.peek();
            res = Math.max(res, h * w);
        }

        return res;
    }
}
