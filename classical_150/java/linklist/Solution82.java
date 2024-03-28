package classical_150.java.linklist;

public class Solution82 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Solution82 solution = new Solution82();
        ListNode res = solution.deleteDuplicates(n1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode curNode = dummyNode;
        ListNode q;
        while (curNode.next != null && curNode.next.next != null) {
            if (curNode.next.val == curNode.next.next.val) {
                q = curNode.next;
                while (q.next != null && q.val == q.next.val)
                    q = q.next;
                curNode.next = q.next;
            } else
                curNode = curNode.next;
        }

        return dummyNode.next;
    }
}
