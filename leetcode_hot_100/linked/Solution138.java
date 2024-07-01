package leetcode_hot_100.linked;

public class Solution138 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // 复制每个节点到其后
        Node node = head;
        while (node != null) {
            Node copyNode = new Node(node.val);
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }

        // 复制random指针
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        // 拆分
        node = head;
        Node newHead = head.next;
        Node newNode = newHead;
        while (node != null) {
            newNode = node.next;
            node.next = newNode.next;
            newNode.next = node.next == null ? null : node.next.next;
            node = node.next;
        }

        return newHead;
    }
}
