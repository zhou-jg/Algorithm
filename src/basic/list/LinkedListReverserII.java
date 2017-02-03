package basic.list;

import datastructure.ListNode;

/**
 * Source: https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * <p>Reverse a linked list from position <i>m</i> to <i>n</i>. 
 * Do it in-place and in one-pass.
 * 
 * <p>For example:<br>
 * Given 1->2->3->4->5->NULL, <i>m</i> = 2 and <i>n</i> = 4,<br>
 * return 1->4->3->2->5->NULL.
 * 
 * <p><b>Note:</b><br>
 * Given <i>m</i>, <i>n</i> satisfy the following condition:<br>
 * 1 ≤ <i>m</i> ≤ <i>n</i> ≤ length of list.
 * 
 * @author Jingang Zhou
 *
 */
public class LinkedListReverserII {

	//要点是创建一个伪头节点，以方便处理m=1的情况。
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n){
            return head;
        }
        //伪头节点
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        
        int steps = 1;
        ListNode pre = dumy, cur = head, nxt = cur.next;
        while (steps < m){
            pre = cur;
            cur = nxt;
            nxt = nxt.next;
            steps++;
        }
        ListNode start = cur;
        
        while (steps < n){
            ListNode tmp = nxt.next;
            nxt.next = cur;
            cur = nxt;
            nxt = tmp;
            steps++;
        }
        
        pre.next = cur;
        start.next = nxt;
        
        return dumy.next;
    }
}
