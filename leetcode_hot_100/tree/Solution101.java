package leetcode_hot_100.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode left = root.left;
        TreeNode right = root.right;
        q.offer(left);
        q.offer(right);
        while (!q.isEmpty()) {
            left = q.poll();
            right = q.poll();
            if (left == null && right == null)
                continue;
            if ((left == null || right == null) || left.val != right.val)
                return false;

            q.offer(left.left);
            q.offer(right.right);

            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
}
