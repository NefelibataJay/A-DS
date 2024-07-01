package leetcode_hot_100.linked;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 分割
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        // 递归分割
        ListNode left = sortList(head);
        ListNode right = sortList(head2);

        // 合并
        ListNode newHead = new ListNode();
        ListNode pre = newHead;
        while (left != null && right != null) {
            if (right.val >= left.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        pre.next = left == null ? right : left;

        return newHead.next;
    }
}
