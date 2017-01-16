package basic.list;

/**
source: https://leetcode.com/problems/partition-list/

Given a linked list and a value x, partition it such that all nodes 
less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
public class PartitionByValueXII {
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  
  public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = head;
        ListNode s1 = null, l1 = head;
        while (l1 != null && l1.val < x){
            s1 = l1;
            l1 = l1.next;
        }
        if (l1 == null){
            return newHead;//all nodes are less than x
        }else{
            //l1 is the first larger or equal to x
            ListNode l2 = l1;
            ListNode s2 = l2.next;
            for (;;){
                while (s2 != null && s2.val >= x){
                    l2 = s2;
                    s2 = s2.next;
                }
                if (s2 == null){
                    return newHead; //nodes are larger or equal x
                }else{
                    l2.next = s2.next;
                    s2.next = l1;
                    if (s1 == null){
                        newHead = s2;
                    }else{
                        s1.next = s2;
                    }
                    s1 = s2;
                    s2 = l2.next;
                }
            }
            //return newHead;
        }
    }
}
