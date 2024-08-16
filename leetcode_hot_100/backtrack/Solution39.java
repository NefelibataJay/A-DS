package leetcode_hot_100.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution39 {
    // 组合总和
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] can, int target, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (sum > target)
            return;

        for (int i = 0; i < can.length; i++) {
            path.offer(can[i]);
            sum += can[i];

            backtrack(can, target, sum);

            path.removeLast();
            sum -= can[i];
        }
    }
}
