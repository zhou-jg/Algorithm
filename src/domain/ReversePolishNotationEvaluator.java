package domain;

import java.util.ArrayDeque;
import java.util.Deque;

import util.Algorithm;

/**
 * Source: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * <p>Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another 
 * expression.
 * 
 * <p>Some examples:</br>
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 <br>
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6 <br>
 *   
 * @author Jingang Zhou
 */
public class ReversePolishNotationEvaluator {
	@Algorithm("栈")
	public int evalRPN(String[] tokens) {
        Deque<Integer> operands = new ArrayDeque<>();
        int i = 0;
        while (i<tokens.length){
            String token = tokens[i];
            if (isOp(token)){
                compute(operands, token);
            }else{
                operands.offerFirst(Integer.parseInt(token));
            }
            i++;
        }
        
        return operands.pollFirst();
    }
    
    private void compute(Deque<Integer> operands, String op){
        int operand2 = operands.pollFirst();
        int operand1 = operands.pollFirst();
        switch (op){
            case "+" : operands.offerFirst(operand1 + operand2);break;
            case "-" : operands.offerFirst(operand1 - operand2);break;
            case "*" : operands.offerFirst(operand1 * operand2);break;
            case "/" : operands.offerFirst(operand1 / operand2);break;
        }
    }
    
    private boolean isOp(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
