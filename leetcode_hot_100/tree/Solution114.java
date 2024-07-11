package leetcode_hot_100.tree;

public class Solution114 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode right = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode cur = root;
                while (cur.right != null) {
                    cur = cur.right;
                }
                cur.right = right;
            }
            root = root.right;
        }
    }

    private TreeNode pre = null;

    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
