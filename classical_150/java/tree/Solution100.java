package classical_150.java.tree;

public class Solution100 {
    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(1);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(3);

        TreeNode treeRoot2 = new TreeNode(1);
        treeRoot2.left = new TreeNode(2);
        treeRoot2.right = new TreeNode(1);

        Solution100 solution = new Solution100();
        System.out.println(solution.isSameTree(treeRoot, treeRoot));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if ((p != null && q == null) || (p == null && q != null))
            return false;
        else if (q.val != p.val)
            return false;

        if (!isSameTree(p.left, q.left))
            return false;
        if (!isSameTree(p.right, q.right))
            return false;

        return true;
    }
}
