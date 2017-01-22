package basic.list;

/**
 * Source: https://leetcode.com/problems/palindrome-linked-list/
 * 
 * <p>Given a singly linked list, determine if it is a palindrome.
 * <p><b>Follow up</b>: Could you do it in O(n) time and O(1) space?
 * 
 */
public class PalindromeCheckerII {
	static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	/**
	 * <b>注意</b>:该算法对原有（输入）数据进行了破坏，因此在返回前需要复原，
	 * 即再次调用 <code>reverse</code>方法，并与之前的列表进行链接。
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
	    ListNode fast = head;
	    ListNode slow = head;

	    while(fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    if(fast != null) slow = slow.next;
	    
	    slow = reverse(slow);
	    while(slow != null && head.val == slow.val) {
	        head = head.next;
	        slow = slow.next;
	    }
	    return slow == null;
	}

	private ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while(head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}
}
