package classical_150.java.divide;

import java.util.PriorityQueue;

public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> {
            return o1.val - o2.val;
        }));
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        // 此时PriorityQueue里的头节点们已经有序了
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (!pq.isEmpty()) {
            ListNode s = pq.poll();
            cur.next = s;
            cur = cur.next;
            s = s.next;
            if (s != null) {
                pq.offer(s);// 当前节点的下一个节点入队
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (r == l)
            return null;
        if (r == l + 1)
            return lists[l];
        int m = r - l;
        ListNode left = merge(lists, l, l + m / 2);
        ListNode right = merge(lists, l + m / 2, r);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        int n = lists.length;
        if (n == 0)
            return null;

        ListNode dummyHead = lists[0];
        for (int i = 1; i < n; i++) {
            dummyHead = mergeTwoLists(dummyHead, lists[i]);
        }

        return dummyHead;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
