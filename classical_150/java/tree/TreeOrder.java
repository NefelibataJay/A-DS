package classical_150.java.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeOrder {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t1.right = t5;
        t5.right = t6;

        TreeOrder to = new TreeOrder();
        to.flatten2(t1);

    }

    public void PrintBinaryTreeBacRecur(TreeNode root) {
        if (root == null)
            return;

        PrintBinaryTreeBacRecur(root.right);
        PrintBinaryTreeBacRecur(root.left);
        System.out.print(root.val);

    }

    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        TreeNode pre = null;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (pre != null) {
                pre.right = node;
                pre.left = null;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            pre = node;
        }
    }
}
