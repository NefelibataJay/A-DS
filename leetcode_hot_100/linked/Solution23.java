package leetcode_hot_100.linked;

import java.util.PriorityQueue;

/**
 * Solution23
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        // ListNode res = lists[0];

        // for (int i = 1; i < lists.length; i++) {
        // res = merge2Lists(res, lists[i]);
        // }

        // return res;

        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        return merge2Lists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    public ListNode merge2Lists(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode(), cur = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return newHead.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> a.val - b.val);

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }

            ListNode node = lists[i];
            while (node != null) {
                pq.add(node);
                node = node.next;
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
        }

        cur.next = null;

        return dummy.next;
    }
}