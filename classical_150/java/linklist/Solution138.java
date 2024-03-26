package classical_150.java.linklist;

import java.util.*;

public class Solution138 {
    public static void main(String[] args) {

    }

    HashMap<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        if (!cachedNode.containsKey(head)) {
            Node newHead = new Node(head.val);
            cachedNode.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    public Node copyRandomList1(Node head) {
        if (head == null)
            return null;

        Node node = head;

        while (node != null) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }

        node = head;
        while (node != null) {
            node.next.random = (node.random == null) ? null : node.random.next;
            node = node.next.next;
        }

        node = head;
        Node p = head.next;

        while (node != null) {
            Node newNode = node.next;
            node.next = newNode.next;
            newNode.next = (newNode.next == null) ? null : newNode.next.next;
            node = node.next;
        }

        return p;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}