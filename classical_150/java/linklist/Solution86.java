package classical_150.java.linklist;

import java.util.List;

public class Solution86 {
  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(4);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(2);
    ListNode n5 = new ListNode(5);
    ListNode n6 = new ListNode(2);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    Solution86 solution = new Solution86();
    ListNode res = solution.partition(n1, 2);
    while (res != null) {
        System.out.println(res.val);
        res = res.next;
    }
  }
  public ListNode partition(ListNode head, int x) {
    if (head == null) return null;
    ListNode smallhead = new ListNode(0);
    ListNode largehead = new ListNode(0);

    ListNode smallNode = smallhead;
    ListNode largeNode = largehead;
    
    ListNode curNode = head;
    while (curNode != null) {
      if (curNode.val > x){
        largeNode.next = curNode;
        largeNode = largeNode.next;
      }else{
        smallNode.next = curNode;
        smallNode = smallNode.next;
      }
      curNode = curNode.next;
    }
    // 此时形成了两个链式 一个保存比x小的数，一个保存比x大的数
    // 并且smallNode 和 largeNode 分别指向他们的最后一个节点

    smallNode.next = largehead.next;
    largeNode.next = null;
    return smallhead.next;
  }
}
