package leetcode_hot_100.tree;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        root.right = invertTree(leftNode);
        root.left = invertTree(rightNode);

        return root;
    }
}
