package leetcode_hot_100.tree;

public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;

        TreeNode n1 = lowestCommonAncestor(root.left, p, q);
        TreeNode n2 = lowestCommonAncestor(root.right, p, q);

        if (n1 != null && n2 != null)
            return root;

        return n1 == null ? n2 : n1;
    }

}
