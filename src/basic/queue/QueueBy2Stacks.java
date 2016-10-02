package basic.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 由两个栈来实现队列的操作。
 * 新入队的元素总是压入新栈(stackNew)，出队的元素总是来自旧栈(stackOld)。
 * 当旧栈空时，把新栈的元素重全部新弹入旧栈，成为队列。
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 */
public class QueueBy2Stacks<T> {
	
	private Deque<T> stackNew, stackOld;

	public QueueBy2Stacks(){
		stackNew = new ArrayDeque<>();
		stackOld = new ArrayDeque<>();
	}
	
	/**
	 * 入队
	 * @param t
	 */
	public void in(T t){
		//压栈
		stackNew.offerFirst(t);
	}
	
	/**
	 * 出队
	 * @return
	 */
	public T out(){		
		shiftStacks();
		return stackOld.pollFirst();
	}
	
	public T peek(){
		shiftStacks();
		return stackOld.peek();
	}
	
	public int size(){
		return stackNew.size() + stackOld.size();
	}
	
	private void shiftStacks(){
		if (stackOld.isEmpty()){
			while (stackNew.peekFirst()!=null){
				stackOld.offerFirst(stackNew.pollFirst());
			}
		}
	}
}
