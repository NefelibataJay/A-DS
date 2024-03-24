package classical_150.java.linklist;

public class Solution21 {
    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);
        Solution21 solution = new Solution21();
        System.out.println(solution.mergeTwoLists(l1, l2));

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode p = list1;
        ListNode q = list2;
        ListNode y = head;

        while (p != null && q != null) {
            if (q.val > p.val) {
                y.next = p;
                p = p.next;
            } else {
                y.next = q;
                q = q.next;
            }
            y = y.next;
        }

        if (q != null)
            y.next = q;
        else
            y.next = p;

        return head.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
