package classical_150.java.range;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public static void main(String[] args){
        int[] nums = {0,2,3,4,6,8,9}; //0,2,3,4,6,8,9
        Solution228 solution228 = new Solution228();
        System.out.println(solution228.summaryRanges(nums));

    }

    public List<String> summaryRanges(int[] nums){
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int left = 0, right = 1, rangeCount = 0;

        while(right<nums.length){

            if (nums[left+rangeCount]+1 == nums[right]) rangeCount++;
            else {
                if (rangeCount>0) res.add(nums[left]+"->"+nums[left+rangeCount]);
                else res.add(nums[left]+"");
                left = right;
                rangeCount = 0;
            }

            right++;
        }

        // 处理最后一个区间
        if (rangeCount>0) res.add(nums[left]+"->"+nums[left+rangeCount]);
        else res.add(nums[left]+"");

        return res;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int n = nums.length;
        int left = 0, right = 0, rangeCount = 0;
        while (right < n){
            rangeCount = 0;
            left = right;
            right++;
            while(right<n && nums[left+rangeCount]+1 == nums[right]){
                right++;
                rangeCount++;
            }

            StringBuffer temp = new StringBuffer(Integer.toString(nums[left]));
            if (rangeCount>0) {
                temp.append("->");
                temp.append(nums[left+rangeCount]);
            }
            ret.add(temp.toString());

        }
        return ret;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if(low<high){
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }

}
