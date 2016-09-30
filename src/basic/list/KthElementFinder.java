package basic.list;

import java.util.ArrayDeque;
import java.util.Deque;

import util.Algorithm;
import datastructure.List;

/**
 * 找到单向链表中的倒数第 k 的元素
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典
 * @author Jingang Zhou
 *
 */
public class KthElementFinder {
	/**
	 * 借助栈实现
	 * @param head 链表头
	 * @param k 
	 * @return 链表的倒数第 k 个元素
	 */
	@Algorithm
	public static <T> T findWithStack(List<T> head, int k){		
		if (head == null){
			return null;
		}else{
			List<T> node = head;
			Deque<List<T>> stack = new ArrayDeque<List<T>>();
			int count = 0;
			while(node != null){
				stack.offerFirst(node);
				node = node.getNext();
				count++;
			}
			if (count < k){//链表长度小于k
				return null;
			}else{
				for (int i=1; i<k; i++){
					stack.pollFirst();
				}
				return stack.pollFirst().getData();
			}
		}		
	}
	
	/**
	 * 使用双指针来实现，节省存储空间。
	 * 开始时，头指针指示链表头部，第二个指针从头开始前进k步；之后两个指针
	 * 同步前进，当第二个指针为空时，第一个指针所在的位置就是目标元素位置。
	 * @param head
	 * @param k
	 * @return
	 */
	@Algorithm
	public static <T> T findWithDoublePointers(List<T> head, int k){
		if (head == null){
			return null;
		}else{
			List<T> node1 = head, node2 = head;
			int count = 0;			
			do {
				node2 = node2.getNext();
				count++;
			}while (count < k && node2 != null);
			if (count < k){
				return null;
			}else{
				while (node2 != null){
					node2 = node2.getNext();
					node1 = node1.getNext();
				}
				return node1.getData();
			}
		}
	}
}
