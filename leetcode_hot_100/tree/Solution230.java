package leetcode_hot_100.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0)
                break;
            root = root.right;
        }
        return root.val;
    }
}
