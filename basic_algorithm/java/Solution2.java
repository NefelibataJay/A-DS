package basic_algorithm.java;

import java.util.*;


public class Solution2 {
    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * 2024-1-15
     */
    public static void main(String[] args) {
        int[] nums= new int[]{5,7,7,8,8,10,11,111,111,111,111,111,111,111,111,111,111,111,111};
        int target = 5;
        Solution2 s = new Solution2();
        int[] result = s.search(nums, target);
        System.out.println(result.toString());

    }


    public int getRightBorder(int[] nums, int target){
        int left = 0, right = nums.length-1; 
        int rightBorder = -1;

        while (left <= right){
            int middle = left + ((right - left)/2);
            if ( target < nums[middle] ) right = middle - 1;
            else{
                // 当nums[middle] == target的时候，更新left，这样才能得到target的右边界
                left = middle + 1;
                rightBorder = left;
            }
        }

        return rightBorder;
    }

    public int getLeftBorder(int[] nums, int target){
        int left = 0, right = nums.length-1; 
        int leftBorder = -1;
        while (left <= right){
            int middle = left + ((right - left)/2);
            if ( target > nums[middle] ) left = middle + 1;
            else{
                // 寻找左边界，就要在nums[middle] == target的时候更新right
                right = middle - 1;
                leftBorder = right;
            }
        }

        return leftBorder;
    }
    

    public int[] search(int[] nums, int target){
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);

        // 有且
        if ( rightBorder - leftBorder > 1) return new int[]{leftBorder+1,rightBorder-1};

        return new int[]{leftBorder,rightBorder}; // 未找到
    }
}
