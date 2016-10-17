package basic.queue.application;

import java.util.ArrayDeque;
import java.util.Deque;

import util.Algorithm;

public class BracketsMatcher {

	/**
	 * 判断字符串中的左右括号是否匹配
	 * @param data
	 * @return
	 * @exception NullPointerException 如果输入为空
	 */
	@Algorithm("栈")
	public static boolean isMatch(char[] data){
		Deque<Character> stack = new ArrayDeque<Character>();
		for (int i=0; i<data.length; i++){
			if (data[i] == '('){
				stack.offerFirst('(');
			}else if (data[i] == ')'){
				if (stack.isEmpty()){
					return false;
				}else{
					stack.pollFirst();
				}
			}
		}
		if (stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}
