package basic.list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

import datastructure.List;

/**
 * 判断指定的链表是否是回文。
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 */
public class PalindromeChecker {

	/**
	 * 借助一个栈来将链表前半部分压栈，然后依次与后半部分比较。为了获得链表的中间位置，采用链表快慢双指针技巧，
	 * 慢指针一次一步，快指针一次两步。当快指针到链表末尾时，满指针正好在链表中间位置。
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<T>> boolean isPalindrome(List<T> list){
		Objects.requireNonNull(list);
		List<T> slowRunner, fastRunner;
		slowRunner = fastRunner = list;
		Deque<T> stack = new ArrayDeque<>();
		
		while (fastRunner.getNext() != null){
			stack.offerFirst(slowRunner.getData());
			slowRunner = slowRunner.getNext();			
			fastRunner = fastRunner.getNext();
			if (fastRunner.getNext() == null){
				return false;
			}else{
				fastRunner = fastRunner.getNext();
			}
		}
		
		T t = null;
		while ((t=stack.pollFirst()) != null){
			if (!t.equals(slowRunner.getNext().getData())){
				return false;
			}else{
				slowRunner = slowRunner.getNext();
			}
		}
		
		return true;
	}
}
