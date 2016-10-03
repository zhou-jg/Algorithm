package basic.list;

import datastructure.List;

/**
 * 找到链表中的环路
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 */
public class CircleFinder {

	/**
	 * 找到链表中环路的起始节点。
	 * 思路：快指针以每次2步，慢指针以每次1部前进，如果有环路，那么在两指针第一次
	 * 相遇位置开始，两指针以相同步速开始直至再次相遇于环路起始位置。
	 * @param head
	 * @return 环路中的起始节点或者null
	 */
	public static <T> List<T> findNode(List<T> head){		
		List<T> slow, fast;
		slow = fast = head;

		while ((fast=moveTwoSteps(fast)) != null && (slow=slow.getNext()) != null){
			if (fast == slow){
				break;
			}
		}
		if (fast == null){
			return null;
		}else{
			slow = head;
			while (slow != fast){
				slow = slow.getNext();
				fast = fast.getNext();
			}
			return slow;
		}
	}
	
	/**
	 * 将node指针向前移动两步，捕获空指针异常来判断是否成功，这种方式代码会更简洁
	 * @param node
	 * @return node节点的后续之后续节点，或者null
	 */
	private static <T> List<T> moveTwoSteps(List<T> node){		
		try{
			node = node.getNext().getNext();
			return node;
		}catch(NullPointerException e){
			return null;
		}
	}
}
