package basic_algorithm.java;

import java.util.*;


public class Solution1 {
    // 数组相关
    public static void main(String[] args) {
        int[] nums= new int[]{-7,-3,2,3,11};
        int target = 2;
        Solution1 s = new Solution1();
        // int result = s.search1(nums, target);
        // int result = s.deleteNum(nums, target);

        // System.out.println(result);
    }

    public int search1(int[] nums, int target){
        int left = 0, right = nums.length-1; 

        while (left <= right){
            int middle = left + ((right - left)/2);
            if (nums[middle] > target) right = middle - 1;
            else if (nums[middle] < target) left = middle + 1;
            else return middle;  // nums[middle] == target
        }

        return -1; // 未找到
    }

    public int deleteNum(int[] nums, int val){
        int k = 0, i = 0, n = nums.length;

        while(i < n){
            if (nums[i] != val) nums[k++] = nums[i];
            i++;
        }

        return k;
    }

    public int[] arrayPower(int[] nums){
        int n = nums.length - 1;
        int[] result = new int[n];
        int left = 0, right = nums.length-1; 
        while (left<= right){
            if (nums[left]*nums[left] > nums[right]*nums[right]){
                result[n--] = nums[left]*nums[left];
                left ++;
            }else{
                result[n--] = nums[right]*nums[right];
                right ++;
            }
        }

        return result;
    }

}
