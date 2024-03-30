package classical_150.java.tree;

import java.util.*;

public class Solution101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 调用递归函数，比较左节点，右节点
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true; // 两个节点都是null
        if ((left == null && right != null) || (right == null && left != null))
            return false; // 其中一个节点不是空
        if (left.val != right.val)
            return false; // 左节点的值不等于右节点的值

        // 再递归的比较 左节点的左孩子 和 右节点的右孩子
        // 以及比较 左节点的右孩子 和 右节点的左孩子
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> que = new LinkedList<>();

        que.add(root.left);
        que.add(root.right);

        while (!que.isEmpty()) {
            TreeNode left = que.poll();
            TreeNode right = que.poll();

            if (left == null && right == null)
                continue; // 两个节点都是空的情况
            if ((left == null && right != null) || (right == null && left != null))
                return false; // 其中一个节点不是空
            if (left.val != right.val)
                return false; // 左节点的值不等于右节点的值

            // 存的时候按照先左节点的左边和右节点的右边 然后再放左节点的右边和右节点的左边
            que.add(left.left);
            que.add(right.right);
            que.add(left.right);
            que.add(right.left);
        }

        return true;
    }
}
