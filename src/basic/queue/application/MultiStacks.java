package basic.queue.application;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 模拟生活中的堆盘子，当高度到一定程度后，再新起一堆，即多个栈。
 * 遵循传统的pop和push规则，且支持在指定的栈上pop（这里与堆盘子
 * 不同，而是要将后续栈的栈底依次移到前一堆栈的栈顶）。
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * 
 * @author Jingang Zhou
 *
 */
public class MultiStacks<T> {
	//预置的栈的高度
	private final int HEIGHT;
	//纪录每个栈的栈顶
	private final List<Deque<T>> stacks = new ArrayList<>();
	//纪录每个栈的高度
	private final List<Integer> heights = new ArrayList<>();
	
	public MultiStacks (int height){
		if (height <= 0){
			throw new IllegalArgumentException("高度必须大于0");
		}
		this.HEIGHT = height;
	}
	
	public void push(T t){
		if (stacks.isEmpty()){
			stacks.add(new ArrayDeque<>());
			heights.add(0);
		}			
		//当前栈索引
		int index = stacks.size() - 1;
		if (heights.get(index) == HEIGHT){
			stacks.add(new ArrayDeque<>());
			heights.add(0);
			index++;
		}
		Deque<T> stack = stacks.get(index);
		stack.offerFirst(t);
		heights.set(index, heights.get(index)+1);		
	}
	
	public T pop(){
		if (stacks.isEmpty()){
			return null;
		}
		int index = stacks.size() - 1;
		if (index < 0){
			return null;
		}else{
			//发生在当前的新栈尚未push任何元素时
			if (heights.get(index) == 0){
				stacks.remove(index);
				heights.remove(index);
				index--;
			}
			if (index >= 0){
				T ret = stacks.get(index).pollFirst();
				int count = heights.get(index);
				if (--count == 0){
					stacks.remove(index);
					heights.remove(index);
				}else{
					heights.set(index, count);
				}
				
				return ret;
			}
			return null;
		}
	}

	public T pop(int i){
		if (i < 0 || i >= stacks.size()){
			throw new ArrayIndexOutOfBoundsException("索引越界");
		}else if(i==stacks.size()-1){
			return pop();
		}else{
			T t = stacks.get(i).pollFirst();
			for (int j=i+1; j<=stacks.size()-1; j++){
				stacks.get(j-1).offerFirst(stacks.get(j).pollLast());
			}
			int count = heights.get(stacks.size()-1);
			if (--count == 0){
				stacks.remove(stacks.size()-1);
				heights.remove(stacks.size()-1);
			}else{
				heights.set(stacks.size()-1, count);
			}
			
			return t;
		}
	}
}
