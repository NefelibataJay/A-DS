package leetcode_hot_100.linked;

public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headB;
        ListNode q = headA;

        while (p.next != null && q.next != null) {
            p = p.next;
            q = q.next;
        }

        int countA = 0;
        int countB = 0;
        while (q.next != null) {
            q = q.next;
            countA++;
        }
        while (p.next != null) {
            p = p.next;
            countB++;
        }

        q = headA;
        for (int i = 0; i < countA; i++) {
            q = q.next;
        }

        p = headB;
        for (int i = 0; i < countB; i++) {
            p = p.next;
        }

        while (p != null && q != null && !p.equals(q)) {
            p = p.next;
            q = q.next;
        }

        return p == null ? null : p;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
            if (pA != null && pB != null)
        }
        return pA;
    }
}
