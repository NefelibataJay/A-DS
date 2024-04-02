package classical_150.java.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution112 {
    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(1);
        treeRoot.left = new TreeNode(2);
        // treeRoot.right = new TreeNode(3);

        Solution112 solution = new Solution112();

        System.out.println(solution.dfs(treeRoot, 1));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null || targetSum < root.val)
            return false;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            sum += node.val;
            if (sum == targetSum)
                return true;

            if (node.left != null)
                stack.add(node.left);
        }
        return false;
    }

    private int sum = 0;

    public boolean dfs(TreeNode node, int targetSum) {
        sum += node.val;

        boolean leftB = false, rightB = false;

        if (node.left != null)
            leftB = dfs(node.left, targetSum);
        if (node.right != null)
            rightB = dfs(node.right, targetSum);

        if (sum == targetSum && node.right == null && node.left == null)
            return true;

        sum -= node.val;

        return leftB || rightB;
    }
}
