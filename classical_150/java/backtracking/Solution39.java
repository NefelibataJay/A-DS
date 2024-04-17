package classical_150.java.backtracking;

import java.util.*;

public class Solution39 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, 0, target);
        return res;
    }

    public void backtrack(int[] candidates, int beforsum, int start, int target) {
        if (beforsum > target || start > candidates.length)
            return;
        else if (beforsum == target)
            res.add(new ArrayList<>(stack));
        else {
            for (int i = start; i < candidates.length; i++) {
                stack.addLast(candidates[i]);
                backtrack(candidates, beforsum + candidates[i], i + 1, target);
                stack.removeLast();
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序
        Arrays.sort(candidates);
        backtrackingCS(candidates, target, 0, 0);
        return res;
    }

    private void backtrackingCS(int[] can, int target, int curIdx, int sum) {
        // 递归出口
        if (sum == target) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = curIdx; i < can.length; i++) {
            // 剪枝
            if ((sum + can[i]) > target) {
                break;
            }

            stack.addLast(can[i]);
            backtrackingCS(can, target, i, sum + can[i]);
            stack.removeLast();
        }
    }
}