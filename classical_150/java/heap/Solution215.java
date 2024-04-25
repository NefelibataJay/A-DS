package classical_150.java.heap;

import java.util.*;
import java.util.Random;

public class Solution215 {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        Solution215 solution = new Solution215();
        System.out.println(solution.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        // 随机选择基准数
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size()));
        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot)
                big.add(num);
            else if (num < pivot)
                small.add(num);
            else
                equal.add(num);
        }
        // 第 k 大元素在 big 中，递归划分
        if (k <= big.size())
            return quickSelect(big, k);
        // 第 k 大元素在 small 中，递归划分
        if (nums.size() - small.size() < k)
            return quickSelect(small, k - nums.size() + small.size());
        // 第 k 大元素在 equal 中，直接返回 pivot
        return pivot;
    }

    private int quickSelect1(int[] nums, int t, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int i = low - 1, j = high + 1;
        int pivot = nums[low];
        while (i < j) {
            i++;
            j--;
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if (t <= j) {
            return quickSelect1(nums, t, low, j);
        } else {
            return quickSelect1(nums, t, j + 1, high);
        }
    }

}
