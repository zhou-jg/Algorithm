package basic.list;

import datastructure.ListNode;

/**
 * Source: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * <p>Given a sorted linked list, delete all nodes that have duplicate 
 * numbers, leaving only distinct numbers from the original list.
 * <p>For example,<br>
 * Given 1->2->3->3->4->4->5, return 1->2->5.<br>
 * Given 1->1->1->2->3, return 2->3.
 * 
 * @author Jingang Zhou
 *
 */
public class DupElesRemoverFromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        
        boolean dup = false;
        ListNode pre = head, cur = head, nxt = cur.next;
        while (nxt != null){
            //删除nxt节点
            if (cur.val == nxt.val){
                dup = true;
                nxt = nxt.next;
                cur.next = nxt;
            }else{
                //删除cur节点
                if (dup){
                    //cur是头节点
                    if (pre == cur){
                        head = nxt;
                        pre = nxt;
                    }else{
                        //cur不是头节点
                        pre.next = nxt;
                    }
                    dup = false;
                }else{
                    pre = cur;
                }
                cur = nxt;
                nxt = nxt.next;
            }
        }
        //仍需处理尾节点
        if (dup){
            if (pre == cur) head = null;
            pre.next = null;
        }
        
        return head;
    }

}
