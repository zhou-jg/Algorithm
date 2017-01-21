package basic.string.application;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Source: https://leetcode.com/problems/decode-string/
 * 
 * <p>Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the 
 * <i>encoded_string</i> inside the square brackets is 
 * being repeated exactly <i>k</i> times. Note that k is 
 * guaranteed to be a positive integer.

 * <p>You may assume that the input string is always valid; 
 * No extra white spaces, square brackets are well-formed, etc.

 * <p>Furthermore, you may assume that the original data does 
 * not contain any digits and that digits are only for those 
 * repeat numbers, <i>k</i>. For example, there won't be input 
 * like 3a or 2[4].

 * <p>Examples:

 * <li>s = "3[a]2[bc]", return "aaabcbc".
 * <li>s = "3[a2[c]]", return "accaccacc".
 * <li>s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * @author Jingang Zhou
 */
public class StringDecoder {
	//对字符从左到右遍历，依次处理顶级的'['和']'，内嵌的字符采用递归。
	public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int i =0;
        while (i < s.length()){
        	//重复次数
            int num = 0;
            char c = s.charAt(i);
            if (isDigit(c)){
                do {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }while (isDigit(s.charAt(i)));
                //i is the index of '['
                int right = i+1; //the counter part of i
                //匹配顶层的方括号
                Deque<Character> stack = new ArrayDeque<>();
                stack.push('[');
                while (!stack.isEmpty()){
                    if (s.charAt(right) == ']'){
                        stack.pop();
                    }else if (s.charAt(right) == '['){
                        stack.push('[');
                    }
                    right++;
                }
                //递归处理方括号内部的字符串
                String inner = decodeString(s.substring(i+1, right-1));
                for (int j=0; j<num; j++){
                    sb.append(inner);
                }
                i = right;
            }else{
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
    
    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}
