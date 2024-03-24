package classical_150.java.linklist;

public class Solution141 {
    public static void main(String[] args) {
        ListNode head = null;

    }

    public boolean hasCycle(ListNode head) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

}
