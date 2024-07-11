package leetcode_hot_100.tree;

import java.util.*;

public class Solution199 {
    public static void main(String[] args) {
        Solution199 solution199 = new Solution199();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        System.out.println(solution199.rightSideView(root));
    }

    // public List<Integer> rightSideView(TreeNode root) {
    // List<Integer> res = new ArrayList<>();
    // dfs(root, 0, res);
    // return res;
    // }

    public void dfs(TreeNode node, int depth, List<Integer> res) {
        if (node == null)
            return;
        if (depth == res.size())
            res.add(node.val);

        dfs(node.right, depth + 1, res);
        dfs(node.left, depth + 1, res);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return res;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;
            while (!queue.isEmpty() && size > 0) {
                node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
            res.add(node.val);
        }

        return res;
    }
}
