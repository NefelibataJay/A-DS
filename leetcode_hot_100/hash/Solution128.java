package leetcode_hot_100.hash;

import java.util.*;

public class Solution128 {
    public int longestConsecutive1(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < n; i++) {
            int cur = 1;
            while (i < n) {
                if (nums[i - 1] == nums[i]) {
                    i++;
                    continue;
                }
                if (nums[i - 1] + 1 == nums[i]) {
                    cur++;
                    i++;
                } else
                    break;
            }
            res = Math.max(res, cur);
        }
        return res;
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);

                int cur = left + 1 + right;

                map.put(num, cur);
                map.put(num - left, cur);
                map.put(num + right, cur);

                res = Math.max(cur, res);
            }
        }
        return res;
    }
}
