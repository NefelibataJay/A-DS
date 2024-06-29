package leetcode_hot_100.linked;

/**
 * Solution25
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }

        ListNode cur = head;
        ListNode next;

        for (int j = 0; j < (n / k); j++) {
            for (int i = 1; i < k; i++) { // 内部的一次单独循环
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
