package leetcode_hot_100.linked;

public class Solution106 {
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode Nhead = new ListNode();
        ListNode pre = head, last = head;

        while (last.next != null) {
            Nhead.next = last.next;
            last.next = Nhead.next.next;
            Nhead.next.next = pre;
            pre = Nhead.next;
        }

        return Nhead.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
