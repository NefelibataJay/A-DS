package leetcode_hot_100.linked;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode new_head = new ListNode();
        new_head.next = head;

        ListNode pre = new_head;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;

            pre = cur;
            cur = cur.next;
        }

        return new_head.next;

    }
}
