package classical_150.java.linklist;

public class Solution92 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Solution92 solution = new Solution92();
        ListNode res = solution.reverseBetween1(n1, 1, 5);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;

        int i = 1;
        ListNode node = head;
        ListNode leftNode = null, pre = null, rightNode = null, suc = null;
        while (node != null) {
            if (i == left - 1)
                pre = node;
            else if (i == left)
                leftNode = node;
            else if (i == right)
                rightNode = node;
            else if (i == right + 1)
                suc = node;
            node = node.next;
            i++;
        }

        ListNode reverseNode = reverseList(leftNode, suc);

        leftNode.next = suc;

        if (pre != null) {
            pre.next = reverseNode;
            return head;
        } else
            return reverseNode;

    }

    public ListNode reverseList(ListNode head, ListNode endNode) {
        if (head == null || head.next == endNode)
            return head;

        ListNode newNode = reverseList(head.next, endNode);
        head.next.next = head;

        head.next = null;

        return newNode;
    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode; // 永远指向待反转区域的第一个节点 left 的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next; // 指向待反转区域的第一个节点
        ListNode next; // 永远指向 curr 的下一个节点，循环过程中，curr 变化以后 next 会变化
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
