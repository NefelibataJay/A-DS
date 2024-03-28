package classical_150.java.linklist;

public class Solution19 {
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
        Solution19 solution = new Solution19();
        ListNode res = solution.removeNthFromEnd(n1, 5);
        while (res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode tail = head;
        for (int i = 1; i < n; i++) {
            if (tail == null)
                return head;
            tail = tail.next;
        }

        while (tail.next != null) {
            pre = pre.next;
            tail = tail.next;
        }
        ListNode removeNode = pre.next;

        pre.next = removeNode.next;
        removeNode.next = null;

        return pre.equals(dummyNode) ? pre.next : head;
    }
}
