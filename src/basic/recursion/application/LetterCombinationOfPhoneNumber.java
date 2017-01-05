package basic.recursion.application;

import java.util.ArrayList;
import java.util.List;

import util.Algorithm;

/**
 * 来源：https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @author Jingang Zhou
 *
 */
public class LetterCombinationOfPhoneNumber {

	@Algorithm("递归")
	public List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<String>();
        char[][] lists = getCharSets(digits);
        if (lists.length > 0){
        	StringBuilder sb = new StringBuilder(lists.length);
        	internalProcessing(ret, sb, lists, 0);
        }
        return ret;
    }
	
	private void internalProcessing(List<String> ret, StringBuilder sb, char[][] lists, int k){
		if (sb.length()==lists.length){
			ret.add(sb.toString());
		}else{			
			for (int i=0; i< lists[k].length; i++){
				sb.append(lists[k][i]);
				internalProcessing(ret, sb, lists, k+1);
				sb.deleteCharAt(sb.length()-1);				
			}
		}
	}
	
	private char[][] getCharSets(String digits){
		if (digits==null || digits.length() == 0){
			return new char[0][0];
		}
		char[][] ret = new char[digits.length()][];
		for (int i=0; i<ret.length; i++){		
			switch(digits.charAt(i)){
			case '2' : ret[i] = new char[]{'a', 'b', 'c'};break;
			case '3' : ret[i] = new char[]{'d', 'e', 'f'};break;
			case '4' : ret[i] = new char[]{'g','h','i'};break;
			case '5' : ret[i] = new char[]{'j', 'k', 'l'};break;
			case '6' : ret[i] = new char[]{'m', 'n', 'o'};break;
			case '7' : ret[i] = new char[]{'p', 'q', 'r', 's'};break;
			case '8' : ret[i] = new char[]{'t', 'u', 'v'};break;
			case '9' : ret[i] = new char[]{'w', 'x', 'y', 'z'}; break;
			default : return new char[0][0];
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(new LetterCombinationOfPhoneNumber().letterCombinations("23"));
	}
}
