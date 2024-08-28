package leetcode_hot_100.heap;

import java.util.*;

public class Solution215 {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        Solution215 solution215 = new Solution215();
        System.out.println(solution215.findKthLargest(nums, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }

    public int quickSelect(int[] nums, int k, int start, int end) {
        if (start == end)
            return nums[k];
        int x = nums[start], i = start - 1, j = end + 1;

        while (i < j) {
            i++;
            j--;
            while (nums[i] < x)
                i++;
            while (nums[j] > x)
                j--;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        } // 快速排序
        if (k <= j)
            return quickSelect(nums, k, start, j);
        else
            return quickSelect(nums, k, j + 1, end);
    }

    public int findKthLargest1(int[] nums, int k) {
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++; // +10000防止负数
        }

        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0)
                return i - 10000;
        }

        return 0;
    }

    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            --heapSize;
            // 取出最大根
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public void maxHeapify(int[] nums, int i, int heapSize) {
        int l = i * 2 + 1; // 左孩子节点坐标
        int r = i * 2 + 2;// 右孩子节点坐标
        int largets = i;
        if (l < heapSize && nums[l] > a[largets]) {
            largets = l;
        }
        if (r < heapSize && nums[r] > nums[largets]) {
            largets = r;
        }
        if (largets != i) {
            int temp = nums[i];
            nums[i] = nums[largets];
            nums[largets] = temp;
            maxHeapify(nums, largets, heapSize);
        }
    }
}
