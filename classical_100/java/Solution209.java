package classical_100.java;

import java.util.Arrays;
import java.util.Map;

public class Solution209 {
    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(solution209.minSubArrayLen(7,nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++){
            int sum = nums[i];
            if (sum >= target) return 1;

            for (int j=i+1; j<nums.length; j++){
                sum += nums[j];
                if (sum >= target){
                    min = Math.min(min, j-i+1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
