package classical_150.java.tree;

import java.util.*;

public class Solution173 {
    public static void main(String[] args) {

    }

}

class BSTIterator {
    TreeNode rootNode;

    Queue<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        rootNode = root;
        queue = new LinkedList<>();
        inOrder(root);
    }

    public void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);
        queue.offer(node);
        inOrder(node.right);
    }

    public int next() {
        return queue.poll().val;
    }

    public boolean hasNext() {
        return queue.size() > 0;
    }
}