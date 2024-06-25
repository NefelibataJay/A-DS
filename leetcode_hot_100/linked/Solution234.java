package leetcode_hot_100.linked;

import java.util.*;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;

        Deque<Integer> list = new ArrayDeque<>();

        while (head != null) {
            list.addLast(head.val);
            head = head.next;
        }

        while (list.size() > 1) {
            if (list.pollFirst() != list.pollLast())
                return false;
        }

        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head.next == null)
            return true;

        ListNode firstHalfEnd = endOfFirstHalf(head); // 取出一半，返回的节点就是另一半的头节点
        ListNode secondHalfStart = reverseList(firstHalfEnd.next); // 反转另一半

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;

        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        firstHalfEnd.next = reverseList(secondHalfStart); // 反转回来
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
