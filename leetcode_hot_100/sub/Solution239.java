package leetcode_hot_100.sub;

import java.util.*;

public class Solution239 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        Solution239 s = new Solution239();
        int[] res = s.maxSlidingWindow(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst(); // 删除 deque 中对应的 nums[i-1], 滑动窗口最左边的元素
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast(); // 删除 窗口内比当前还小的元素
            deque.addLast(nums[j]);
            if (i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }

    // 超时
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k && i < n; i++) {
            if (nums[i] > max) {
                res[0] = i;
                max = nums[i];
            }
        }

        int i = 0;
        for (int end = k; end < n; end++) {
            if (res[i] >= end - k + 1) {
                if (nums[end] > nums[res[i]]) {
                    res[++i] = end;
                } else {
                    res[++i] = res[i - 1];
                }
            } else {
                int maxIndex = end;
                for (int s = end - k + 1; s < end; s++) {
                    if (nums[s] > nums[maxIndex]) {
                        maxIndex = s;
                    }
                }
                res[++i] = maxIndex;
            }
        }

        int[] result = new int[n - k + 1];

        for (int j = 0; j < result.length; j++) {
            result[j] = nums[res[j]];
        }

        return result;
    }
}