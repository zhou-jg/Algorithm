package basic.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 支持获得栈最小值的栈。且满足 push、pop和min的时间复杂度都是O(1)。
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 * @param <T> 栈元素类型，必须是大小可比的，即实现了{@link java.util.Comparable}接口
 */
public class StackWithMin<T extends Comparable<T>> {
	private Deque<T> stackNormal = new ArrayDeque<>();
	private Deque<T> stackMin = new ArrayDeque<>();
	private T min = null;
	
	public void push(T t){
		stackNormal.offerFirst(t);
		if (min == null || t.compareTo(min) <= 0){
			min = t;
			stackMin.offerFirst(min);
		}
	}
	
	public T pop(){
		T ret = stackNormal.pollFirst();
		if (ret.compareTo(stackMin.peekFirst()) == 0){
			stackMin.pollFirst();
		}
		return ret;
	}
	
	public T min(){
		return stackMin.peekFirst();
	}
}
