package classical_150.java.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution114 {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        while (root != null) {
            // 左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

    private TreeNode pre = null;

    public void flatten1(TreeNode root) {
        if (root == null)
            return;
        flatten1(root.right);
        flatten1(root.left);

        root.right = pre;
        root.left = null;
        pre = root;
    }

    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

}
