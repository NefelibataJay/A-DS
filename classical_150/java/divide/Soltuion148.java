package classical_150.java.divide;

public class Soltuion148 {
    public ListNode sortList(ListNode head) {
        // 归并排序
        // 1. cut
        // 终止条件：当cut到只剩一个数时，则为有序，可以merge
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针，找到链表中间点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 从slow处断开
        ListNode head2 = slow.next;
        slow.next = null;

        // 继续对两端进行分割，直到只剩一个数（如上终止条件）
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(head2);

        // 2. merge并返回
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        p.next = list1 == null ? list2 : list1;

        return dummy.next;
        // return mergeList(list1, list2);
    }

    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) { // 将其subLength以2
            ListNode prev = dummyHead, curr = dummyHead.next; // 重置归并 按照 1，2，4，8 的Sub List 长度， 顺序 归并每个ListNode
            while (curr != null) { // 循环归并每一个 Sub List
                ListNode head1 = curr; // head1 指到第一个Sub List的头节点
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next; // curr指到第一个Sub List的末尾节点的前一个节点
                }
                ListNode head2 = curr.next; // head1 指到第二个Sub List的头节点
                curr.next = null; // 分割两个Sub List
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next; // curr指到第二个Sub List的末尾节点的前一个节点
                }
                ListNode next = null; // next 记录 被分割后的主 List 头
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                } // 第二个 Sub List 和 主 List 分割

                ListNode merged = merge(head1, head2); // 合并两个 Sub List 并为有序
                prev.next = merged; // 把两个Sub List 合并到结果集中
                while (prev.next != null) {
                    prev = prev.next; // prev 指向排完序的最后一个节点上
                }
                curr = next; // curr 指向没有排序过的下一个 Sub List 上
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }

    public class ListNode {
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
