package classical_150.java.linklist;

public class Solution206 {
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
        Solution206 solution = new Solution206();
        ListNode res = solution.reverseList1(n1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            // head == null 是为了处理一开始就为null 的情况， head.next == null 才是处理递归的最后面
            return head;

        ListNode newNode = reverseList1(head.next);
        head.next.next = head;

        head.next = null;
        // 为了处理递归到一开始的头节点需要指向null，当前节点的next置位null时，在上一层递归时又会重新指向前一个节点。

        return newNode;
    }

}
