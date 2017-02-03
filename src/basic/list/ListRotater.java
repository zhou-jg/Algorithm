package basic.list;

import datastructure.ListNode;

/**
 * Source: https://leetcode.com/problems/rotate-list/
 *
 * <p> </p>Given a list, rotate the list to the right by k places,
 * where k is non-negative.
 * <p></p>For example:<br>
 * Given 1->2->3->4->5->NULL and k = 2,<br>
 * return 4->5->1->2->3->NULL.
 *
 * Created by zhou-jg on 2017/2/3.
 */
public class ListRotater {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }

        ListNode tail = head;
        int length = 1;
        while (tail.next != null){
            tail = tail.next;
            length++;
        }
        if (length == 1){
            return head;
        }
        k %= length;
        if (k == 0){
            return head;
        }

        int steps = length - k;
        tail.next = head;
        while (steps > 1){
            head = head.next;
            steps--;
        }
        ListNode newHead = head.next;
        head.next = null;

        return newHead;
    }
}
