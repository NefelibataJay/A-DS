package classical_150.java.window;

import java.util.Arrays;

public class Solution209 {
    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(solution209.minSubArrayLen3(7,nums));
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

    public int minSubArrayLen2(int target, int[] nums){
        int low = 0, high = 0, sum = 0, min = Integer.MAX_VALUE;

        while (high < nums.length) {
            sum += nums[high++]; // 计算当前和
            while(sum >= target) {
                min = Math.min(min, high - low); // 更新最小子数组长度
                sum -= nums[low++]; // 移动左指针，并减去左指针的值
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen3(int s, int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int[] sums = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= length; i++) {
            int target = s + sums[i];
            int index = Arrays.binarySearch(sums, target);
            if (index < 0)
                index = ~index;
            if (index <= length) {
                min = Math.min(min, index - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
