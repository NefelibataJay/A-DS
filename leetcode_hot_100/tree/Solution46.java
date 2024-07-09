package leetcode_hot_100.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = solution46.permute(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> out = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return ans;
    }

    public void backtrack(int[] nums){
        if (out.size() == nums.length){
            ans.add(new ArrayList<>(out));
            return ;
        }

        for (int i=0;i<nums.length;i++){
            if (nums[i] == 100)
                continue;
            out.add(nums[i]);
            int temp = nums[i];
            nums[i] = 100;
            backtrack(nums);
            nums[i] = temp;
            out.remove(out.size()-1);
        }
    }

//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> out = new ArrayList<>();
//        for (int num : nums) {
//            out.add(num);
//        }
//        int n = nums.length;
//        backtrack(n, ans, out, 0);
//        return ans;
//    }
//
//    public void backtrack(int n, List<List<Integer>> ans, List<Integer> out, int idx) {
//        if (idx == n)
//            ans.add(new ArrayList<>(out));
//
//        for (int i = idx; i < n; i++) {
//            Collections.swap(out, idx, i); // 交换元素
//            backtrack(n, ans, out, idx + 1);
//            Collections.swap(out, idx, i);
//        }
//    }
}
