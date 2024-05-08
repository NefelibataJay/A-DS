package classical_150.java.bitOperation;

import java.util.*;

public class Solution136 {
    public static void main(String[] args) {
        System.out.println(9 ^ 8 ^ 10 ^ 9 ^ 8);
    }

    public int singleNumber(int[] nums) {
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = pre ^ nums[i]; // 两个相同的数做异或操作结果为0
        }
        return pre;
    }

    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 1)
                res = key;
        }
        return res;
    }
}