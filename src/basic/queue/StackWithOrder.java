package basic.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 出栈时要求是最大（小）元素，即出栈是按大小排序的，最多只允许用一个额外的栈，
 * 不得使用其它数据结构（如数组等）。该栈支持pop, push, peek和isEmpty。
 * 主要思想：两个栈，一个用于存放有序的元素，一个存放无序的元素。每次<code>push</code>时，将元素
 * 压入无序栈，当每次出栈或读取栈顶元素时，将无序栈中的元素全部插入有序栈，并始终保持有序栈的有序性。这样
 * 对于pop或peek，只需在有序栈上执行相应操作即可。为了实现无序元素插入有序栈并保持栈的有序性，需要借助
 * 无序栈将要插入元素在有序栈位置之上的元素先压入无序栈，等把该元素压入有序栈后，再把院里压入无序栈的元素
 * 反弹回有序栈，这样就可以保障有序栈始终是有序的。
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 */
public class StackWithOrder<T extends Comparable<T>> {
	private final boolean isAscending;
	private Deque<T> ordered, unordered;
	/**
	 * 
	 * @param isAscending true: 按升序出栈；false: 按降序出栈
	 */
	public StackWithOrder(boolean isAscending){
		this.isAscending = isAscending;
		this.ordered = new ArrayDeque<>();
		this.unordered = new ArrayDeque<>();
	}
	
	public void push(T t){
		unordered.offerFirst(t);
	}
	
	public T pop(){
		shiftOrder();
		return ordered.pollFirst();
	}
	
	public T peek(){
		shiftOrder();
		return ordered.peek();		
	}
	
	public boolean isEmpty(){
		return ordered.isEmpty() && unordered.isEmpty();
	}
	
	/*
	 * 算法的主体部分，用在出栈和读取栈顶元素时。
	 */
	private void shiftOrder(){
		T u, o;		
		while ((u = unordered.pollFirst()) != null){
			int count = 0;								
			while ((o = ordered.peek()) != null){
				if (isAscending && u.compareTo(o) <= 0 ||
					!isAscending && u.compareTo(o) >= 0){													
						break;
				}else{
					unordered.offerFirst(ordered.pollFirst());
					count++;
					o = ordered.peek();
				}
			}
			ordered.offerFirst(u);
			reback(count);	
		}
	}

	//把之前由有序栈压入无序栈的元素反弹回有序栈
	private void reback(int count) {
		for (int i=1; i<=count; i++){
			ordered.offerFirst(unordered.pollFirst());
		}
	}
}
