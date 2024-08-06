package leetcode_hot_100.tree;

import java.util.HashMap;
import java.util.Map;

public class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int res = rootSum(root, targetSum); // 第一层以当前的根节点为root向下递归
        res += pathSum(root.left, targetSum); // 第二层继续以左右子节点为root向下递归
        res += pathSum(root.right, targetSum);
        return res;
    }

    public int rootSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int res = 0;
        if (root.val == targetSum)
            res++;

        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);
        return res;
    }

    Map<Long, Integer> map = new HashMap<>();
    int ans, t;

    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        t = targetSum;
        map.put(0L, 1);
        dfs(root, root.val);
        return ans;
    }

    public void dfs(TreeNode root, long value) {
        if (map.containsKey(value - t))
            ans += map.get(value - t);
        map.put(value, map.getOrDefault(value, 0) + 1);
        if (root.left != null)
            dfs(root.left, value + root.left.val);
        if (root.right != null)
            dfs(root.right, value + root.right.val);
        map.put(value, map.getOrDefault(value, 0) - 1);
    }
}
