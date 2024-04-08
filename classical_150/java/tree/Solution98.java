package classical_150.java.tree;

public class Solution98 {
    long pre = Long.MIN_VALUE;

    public static void main(String[] args) {
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MIN_VALUE < -2147483648);
    }

    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    public boolean inOrder(TreeNode root) {
        if (root == null)
            return true;
        if (!inOrder(root.left))
            return false;
        if (root.val < pre)
            return false;
        pre = root.val;

        return inOrder(root.right);
    }
}
