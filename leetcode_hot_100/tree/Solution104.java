package leetcode_hot_100.tree;

import java.util.Queue;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // 当前层的节点数
            while (size > 0) {
                TreeNode cur = queue.poll();
                // 循环添加下一层的节点
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                size--; // 当前层节点数减一
            }
            res++; // 深度加一
        }
        return res;
    }
}
