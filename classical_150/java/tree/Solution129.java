package classical_150.java.tree;

import java.util.*;

public class Solution129 {
    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(2);
        treeRoot.left = new TreeNode(0);
        // treeRoot.right = new TreeNode(0);

        Solution129 solution = new Solution129();
        System.out.println(solution.dfs(treeRoot, 0));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int rootSum) {
        if (node == null)
            return 0;
        int sum = rootSum * 10 + node.val;
        if (node.left == null && node.right == null)
            return sum;
        else
            return dfs(node.left, sum) + dfs(node.right, sum);
    }

    public int bfs(TreeNode node) {
        Queue<TreeNode> que = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        int sum = 0;
        que.offer(node);
        numQueue.offer(node.val);
        while (!que.isEmpty()) {
            TreeNode curNode = que.poll();
            int num = numQueue.poll();
            TreeNode left = curNode.left, right = curNode.right;
            if (left == null && right == null)
                sum += num;
            else {
                if (left != null) {
                    que.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    que.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}
