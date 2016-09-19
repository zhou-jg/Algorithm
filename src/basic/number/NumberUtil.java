package basic.number;

import util.Algorithm;


/**
 * 
 * @author Jingang Zhou
 *
 */
public class NumberUtil {
	/**
	 * swap a and b without using a temporal variable.
	 * @param a
	 * @param b
	 */
	@Algorithm
	public static void swapWithoutAtmp(int a, int b){
		System.out.println("before swapping: a = " + a + "; b = " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
			
		System.out.println("after swapping: a = " + a + "; b = " + b);
	}
	
	public static void main(String[] args){
		swapWithoutAtmp(23, 34);
	}
}
