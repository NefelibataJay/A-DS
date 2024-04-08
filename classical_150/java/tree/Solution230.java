package classical_150.java.tree;

import java.util.*;

public class Solution230 {

    public int kthSmallest(TreeNode root, int k) {
        int res = -1;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int count = 0;
        TreeNode node = root;
        while (!stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            count++;
            if (count == k)
                return node.val;
            node = node.right;
        }
        return res;
    }

}
