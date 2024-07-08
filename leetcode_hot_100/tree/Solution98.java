package leetcode_hot_100.tree;

/**
 * Solution98
 */
public class Solution98 {
    private long pre = Long.MIN_VALUE;

    public boolean inOrder(TreeNode node) {
        if (node == null)
            return true;

        if (!inOrder(node.left))
            return false;
        if (node.val <= pre) {
            return false;
        }
        pre = node.val;
        if (!inOrder(node.right))
            return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return inOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean inOrder(TreeNode node, long lower, long upper) {
        if (node == null)
            return true;
        if (node.val <= lower || node.val >= upper)
            return false;

        return inOrder(node.left, lower, node.val) && inOrder(node.right, node.val, upper);
    }
}