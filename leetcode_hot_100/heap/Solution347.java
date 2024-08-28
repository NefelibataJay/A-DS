package leetcode_hot_100.heap;

import java.util.*;

public class Solution347 {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3, 3 };
        Solution347 solution347 = new Solution347();
        solution347.topKFrequent(nums, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));

        for (Integer key : map.keySet()) {
            priorityQueue.add(key);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }

        return res;
    }
}
