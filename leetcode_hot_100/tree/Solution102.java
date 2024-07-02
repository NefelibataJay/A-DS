package leetcode_hot_100.tree;

import java.util.*;

/**
 * Solution102
 */
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);

        while (!level.isEmpty()) {
            int count = level.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = level.poll();
                layer.add(node.val);
                if (node.left != null)
                    level.add(node.left);
                if (node.right != null)
                    level.add(node.right);
            }
            res.add(layer);
        }

        return res;
    }
}