package domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Source: https://leetcode.com/problems/basic-calculator/
 * 
 * <p>Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), 
 * the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * <p>You may assume that the given expression is always valid.

 * <p>Some examples:<br>
 * "1 + 1" = 2</br>
 * " 2-1 + 2 " = 3</br>
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * 
 * @author Jingang Zhou
 */
public class BasicCalculator {
	public int calculate(String s) {
		//去除表达式中的所有空格
		return process(s.replaceAll(" ", ""));
    } 
	
	/**
	 * 遇到括号，就递归处理，否则将解析的操作数和操作符分别按序保存。
	 * @param s
	 * @return
	 */
	private int process(String s){		
		//保持括号的索引
        Deque<Integer> stack = new ArrayDeque<>();
        //操作数列表
        List<Integer> operands = new ArrayList<>();
        //操作符列表
        List<Character> ops = new ArrayList<>();        
        
        int i=0, operand = 0;
        boolean isNum = false;
        while (i<s.length()){
            char c = s.charAt(i);
            if (c >= '0' && c <= '9'){
            	operand = operand * 10 + (c - '0');
            	isNum = true;
            	
            }else{            	
            	if (isNum){
            		operands.add(operand);
            		operand = 0;
            		isNum = false;
            	}
            	if (c == '+' || c == '-'){
            		ops.add(c);
            	}else if (c == '('){
	                stack.offerFirst(i);
	                for (int j=i+1; j<s.length(); j++){
	                	c = s.charAt(j);	                
	                	if (c == '('){
	                		stack.offerFirst(j);
	                	}else if (c == ')'){
	                		int begin = stack.pollFirst();
	                		if (stack.isEmpty()){
	                			operands.add(calculate(s.substring(begin+1, j)));
	                			i = j;
	                			break;
	                		}
	                	}
	                }
	            }            	
            }     
            i++;
        }
        if (isNum){
        	operands.add(operand);
        }
                
        int sum = operands.get(0);
        for (i=0; i<ops.size(); i++){
        	char op = ops.get(i);
        	if (op == '+'){
        		sum += operands.get(i+1);
        	}else{
        		sum -= operands.get(i+1);
        	}
        }
        return sum;
	}
}
