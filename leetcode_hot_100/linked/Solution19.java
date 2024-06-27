package leetcode_hot_100.linked;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        int size = 0;

        while (head != null) {
            head = head.next;
            size++;
        }

        ListNode cur = pre.next;
        for (int i = 0; i <= size; i++) {
            if (i == size - n) {
                pre.next = cur.next;
                break;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
