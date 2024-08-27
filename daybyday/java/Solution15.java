package daybyday.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution15
 */
public class Solution15 {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 0 };
        threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // nums 无序
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        if (n < 2)
            return answer;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if (nums[i] + nums[n - 1] + nums[n - 2] < 0)
                continue; // 最小的数，和最大的两个数相加还是小于0
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0)
                break; // 最小的几个数相加已经大于0
            int j = i + 1;
            int k = n - 1;
            while (k > j) {
                if (nums[i] + nums[j] + nums[k] > 0)
                    k--;
                else if (nums[i] + nums[j] + nums[k] < 0)
                    j++;
                else {
                    List<Integer> curRes = new ArrayList<>();
                    curRes.add(nums[i]);
                    curRes.add(nums[j]);
                    curRes.add(nums[k]);
                    answer.add(curRes);

                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return answer;
    }
}