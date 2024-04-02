package classical_150.java.tree;

public class Solution222 {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
