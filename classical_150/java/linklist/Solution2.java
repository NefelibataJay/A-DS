package classical_150.java.linklist;

public class Solution2 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 逆序
        ListNode head = new ListNode();
        ListNode y = head;
        ListNode p = l1;
        ListNode q = l2;
        int reduce = 0;

        while (p != null && q != null) {
            int sum = q.val + p.val + reduce;
            reduce = sum / 10;
            y.next = new ListNode(sum % 10);
            y = y.next;
            p = p.next;
            q = q.next;
        }

        while (p != null) {
            int sum = p.val + reduce;
            reduce = sum / 10;
            y.next = new ListNode(sum % 10);
            y = y.next;
            p = p.next;
        }
        while (q != null) {
            int sum = q.val + reduce;
            reduce = sum / 10;
            y.next = new ListNode(sum % 10);
            y = y.next;
            q = q.next;
        }

        if (reduce != 0) {
            y.next = new ListNode(reduce);
        }

        return head.next;
    }
}
