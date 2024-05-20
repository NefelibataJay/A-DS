package leetcode_hot_100.pointer;

import java.util.*;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int k = 0; k < n - 1 && nums[k] <= 0; k++) {
            if (k > 0 && nums[k] == nums[k - 1])
                continue;
            int i = k + 1, j = n - 1;
            while (i < j) {
                int num = nums[i] + nums[k] + nums[j];

                if (num > 0) {
                    j--;
                    // while(i < j && nums[j] == nums[j+1]) j--;
                } else if (num < 0) {
                    i++;
                    // while(i < j && nums[i] == nums[i-1]) i++;
                } else {
                    res.add(Arrays.asList(nums[k], nums[i++], nums[j--]));
                    while (i < j && nums[j] == nums[j + 1])
                        j--;
                    while (i < j && nums[i] == nums[i - 1])
                        i++;
                }
            }
        }
        return res;
    }
}
