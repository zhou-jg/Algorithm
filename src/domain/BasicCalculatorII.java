package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: https://leetcode.com/problems/basic-calculator-ii/
 * 
 * <p>Implement a basic calculator to evaluate a simple expression 
 * string. The expression string contains only non-negative integers, 
 * +, -, *, / operators and empty spaces . The integer division 
 * should truncate toward zero.
 * 
 * <p> You may assume that the given expression is always valid.
 *
 * <p>Some examples:<br>
 * "3+2*2" = 7<br>
 * " 3/2 " = 1<br>
 * " 3+5 / 2 " = 5<br>
 * 
 * @author Jingang Zhou
 */
public class BasicCalculatorII {
	/**
	 * 从左到右遍历字符串，遇到'*'或'/'，直接处理，以减少内存占用，之后再整体处理'+'和'－'。
	 * @param s
	 * @return
	 */
	public int calculate(String s) {
		List<Integer> operands = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        
        int operand = 0;
        boolean start = true;
        int i = 0;
        for (; i<s.length(); i++){
            char c = s.charAt(i);
            if (c >= '0' && c <= '9'){
                operand = operand * 10 + (c - '0');
                start = false;
            }else if (c == ' ' && start){
                continue;
            }else{                 
            	if (!start){ 
                	operands.add(operand);
                	operand = 0;
                	processing(operands, ops);
                }
            	if (c == '+' || c == '-' || c == '*' || c == '/'){
                    ops.add(c);                       
                }
                start = true;
            }
        }
        if (!start){
        	operands.add(operand);
        	processing(operands, ops);
        }
        
        for (i=0; i<ops.size(); i++){
            char c = ops.get(i);
            if (c == '+' || c == '-'){
                int num;
                if (c == '+'){
                    num = operands.get(i) + operands.get(i+1);
                }else{
                    num = operands.get(i) - operands.get(i+1);
                }
                
                operands.set(i+1, num);
            }
        }
        
        return operands.get(operands.size()-1);
    }
	
	private void processing(List<Integer> operands, List<Character> ops){
		int len = operands.size()-1;		
		if (len > 0){
			char op = ops.get(len-1);
			int num = 0;
			if (op == '*' || op == '/'){
				if (op == '*'){
					num = operands.get(len-1) * operands.get(len);
				}else{
					num = operands.get(len-1) / operands.get(len);
				}
				ops.remove(len-1);
				operands.remove(len-1);
				operands.set(len-1, num);
			}
		}
	}
}
