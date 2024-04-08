package classical_150.java.tree;

public class Solution530 {
    int res = Integer.MAX_VALUE;
    int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        // 二叉搜索树中序遍历得到的值序列是递增有序的
        if (root == null)
            return 0;
        inOrder(root);
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (pre == -1)
            pre = root.val;
        else {
            res = Math.min(res, Math.abs(pre - root.val));
            pre = root.val;
        }
        inOrder(root.right);
    }
}
