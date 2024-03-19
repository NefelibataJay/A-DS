package classical_150.java;

import java.util.*;
public class Solution15 {
    public static void main(String[] args) {
        Solution15 s = new Solution15();
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println(s.threeSum1(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;

        Arrays.sort(nums);
        int i = 0, j =nums.length - 1;

        while(i < j-1){
            //此时数组为有序的数组，最小的数都大于0了，三数之和肯定大于0
            if(nums[i]>0){
                break;
            }

            //去重，当起始的值等于前一个元素，那么得到的结果将会和前一次相同
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for (int k = i+1; k<j; k++){
                if (nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[k]);
                    temp.add(nums[j]);
                    ans.add(temp);
                }
            }

            if (nums[i] + nums[j] < 0) i++;
            else j--;

        }

        // 去重
        Set<List<Integer>> set = new HashSet<>(ans);
        ans.clear();

        ans.addAll(set);

        return ans;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;

        Arrays.sort(nums);

        for (int i = 0; i< nums.length-2; i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1, right = nums.length-1;

            while (left<right){
                int sum = nums[i] + nums[right] + nums[left];
                if (sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 取出重复的元素
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                } else if (sum < 0)
                    right--;
                else left++;
            }
        }
        return ans;
    }
}
