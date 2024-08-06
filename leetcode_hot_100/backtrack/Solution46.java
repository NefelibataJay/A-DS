package leetcode_hot_100.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution46 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return res;
    }

    public void backtrack(int[] nums) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 100)
                continue;
            stack.add(nums[i]);
            int temp = nums[i];
            nums[i] = 100;

            // 递归
            backtrack(nums);

            // 回溯
            nums[i] = temp;
            stack.removeLast();
        }
    }
}
