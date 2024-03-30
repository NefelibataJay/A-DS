package classical_150.java.tree;

import java.util.*;

public class Solution226 {
    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(1);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(3);

        Solution226 solution = new Solution226();
        TreeNode res = solution.invertTree1(treeRoot);
    }

    public TreeNode invertTree(TreeNode root) {
        // 广度优先遍历
        if (root == null)
            return root;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            TreeNode leftNode = node.left;
            TreeNode rightNode = node.right;

            node.right = leftNode;
            node.left = rightNode;

            if (leftNode != null)
                que.add(leftNode);
            if (rightNode != null)
                que.add(rightNode);
        }

        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        // 深度优先遍历
        if (root == null)
            return root;

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        root.right = invertTree1(leftNode);
        root.left = invertTree1(rightNode);

        return root;
    }
}
