package classical_150.java.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution117 {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        // 广度优先
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null; // 记录上一个节点
            // 这里一旦进入下一层， last 被 重新 null

            for (int i = 1; i <= n; ++i) {
                Node f = queue.poll();
                if (f.left != null)
                    queue.offer(f.left);
                if (f.right != null)
                    queue.offer(f.right);
                if (i != 1) // 忽略根节点，根节点要不在此之前已经被更新过next，要不本就应该指向null
                    last.next = f;
                last = f;
            }
        }
        return root;
    }

    Node last = null, nextStart = null;

    public Node connect1(Node root) {
        // 广度优先
        if (root == null)
            return root;
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null)
                    handle(p.left);
                if (p.right != null)
                    handle(p.right);
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};