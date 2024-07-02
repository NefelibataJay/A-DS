package leetcode_hot_100.tree;

public class Solution543 {
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        res = 1;
        depth(root);
        return res - 1;
    }

    public int depth(TreeNode node) {
        if (node == null)
            return 0;

        int L = depth(node.left);
        int R = depth(node.right);
        res = Math.max(res, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
