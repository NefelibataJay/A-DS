package classical_150.java.backtracking;

import java.util.*;

public class Solution46 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Solution46 solution = new Solution46();
        solution.permute(nums);
    }

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
            stack.addLast(nums[i]);
            int temp = nums[i];
            nums[i] = 100;
            backtrack(nums);
            stack.removeLast();
            nums[i] = temp;
        }
    }
}
