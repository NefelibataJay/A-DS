package classical_150.java.arrwithstr;

import java.util.*;

class Solution1 {
    public int trap(int[] height) {
        // 动态规划
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        // 它前边的墙(i-1)的左边的最高高度和它前边的墙(i-1)的高度选一个较大的，就是当前列左边最高的墙了。
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }

        // 它后边的墙(i+1)的右边的最高高度和它后边的墙(i+1)的高度选一个较大的，就是当前列右边最高的墙了。
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1; // 左指针
        int right = height.length - 2; // 右指针

        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                //从左到右更
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;  // 左边最大值
                if (min > height[left]) {
                    sum += (min - height[left]);
                }
                left++;

            } else {
                //从右到左更
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum += (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    public int trap3(int[] height) {
        // 栈  peek()查看栈顶元素  pop()弹出栈顶元素  push()压入栈顶元素
        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        int current = 0;

        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                // 先取出上一个栈顶元素，作为当前的底高
                int bottom_h = height[stack.pop()];
                if (stack.isEmpty()) // 栈空就出去
                    break;
                int distance = current - stack.peek() - 1; // 两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                // 两堵墙之间的水，就是两堵墙中较小的墙的高度减去底高，乘以两堵墙之间的距离。
                sum = sum + distance * (min - bottom_h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution1.trap3(height));
    }
}
