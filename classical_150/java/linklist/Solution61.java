package classical_150.java.linklist;

public class Solution61 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Solution61 solution = new Solution61();
        ListNode res = solution.rotateRight(n1, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0)
            return head;
        int n = 1;
        ListNode tail = head;
        ListNode newHead;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        } // 此时的tail 一定指向最后一个尾节点

        tail.next = head; // 形成回环

        int target = n - (k % n);
        // 新的头节点 也就是倒数第k % n个节点
        // 正着数就是 第n - (k % n) 个节点

        for (int i = 0; i < target; i++) {
            tail = tail.next;
        }
        newHead = tail.next;
        tail.next = null;

        return newHead;
    }
}
