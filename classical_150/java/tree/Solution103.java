package classical_150.java.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            LinkedList<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft)
                    levelList.addLast(curNode.val);
                else
                    levelList.addFirst(curNode.val);

                if (curNode.left != null)
                    nodeQueue.offer(curNode.left);
                if (curNode.right != null)
                    nodeQueue.offer(curNode.right);
            }
            res.add(levelList);
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }
}
