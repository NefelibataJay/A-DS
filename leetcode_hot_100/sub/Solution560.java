package leetcode_hot_100.sub;

import java.util.HashMap;
import java.util.Map;

public class Solution560 {
    public int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int right = 0; right < n; right++) {
            int sum = 0;
            for (int left = right; left >= 0; left--) {
                sum += left;
                if (sum == k)
                    count++;
            }
        }

        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);

        int preSum = 0;
        for (int num : nums) {
            preSum += num;

            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
