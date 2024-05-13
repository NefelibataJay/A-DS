package leetcode_hot_100.hash;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = { 3, 3 };
        twoSum(nums, 6);
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : nums)
            map.put(num, index++);

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int residue = target - nums[i];
            res[0] = i;
            if (map.containsKey(residue) && map.get(residue) != i) {
                res[1] = map.get(residue);
                break;
            }
        }

        return res;
    }
}