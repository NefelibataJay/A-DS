package leetcode_hot_100.linked;

import java.util.*;

/**
 * Solution142
 */
public class Solution142 {
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;

        while (cur != null) {
            if (!set.add(cur)) {
                return cur;
            } else {
                cur = cur.next;
            }
        }
        return null;
    }
}