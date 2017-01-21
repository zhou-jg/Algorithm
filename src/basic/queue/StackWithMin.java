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
	/*
	 * TODO: 这里可以做内存优化，不用每次push都纪录最小值，而是只纪录出现最小值时的纪录，例如：
	 * 对于push序列：3 2 4 4 4 4 4 1 1，只需纪录 3 2 1 1；如此，在pop时做判断是否删除相应的
	 * 最小值。这是一种典型的时间换空间的策略，要具体分析数列的特征看是否值得这么做。
	 * 此外，还要注意可能存在的风险，因为两个列表在pop和push时没有同步，如果有一个发生异常，
	 * 就会导致出现不可预期的结果。	
 	 */	
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
