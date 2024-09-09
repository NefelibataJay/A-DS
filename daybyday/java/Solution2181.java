package daybyday.java;

public class Solution2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode point = head.next;

        ListNode newHead = new ListNode();
        ListNode next = newHead;

        int sum = 0;
        while (point != null) {
            if (point.val == 0) {
                next.next = new ListNode(sum);
                next = next.next;
            } else {
                sum += point.val;
            }
            point = point.next;
        }
        return newHead.next;
    }
}
