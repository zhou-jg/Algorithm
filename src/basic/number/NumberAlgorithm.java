package basic.number;

import util.Algorithm;
import static util.NumberUtil.*;

/**
 * 
 * @author Jingang Zhou
 *
 */
public class NumberAlgorithm {
	/**
	 * swap a and b using bit operation.
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
	
	@Algorithm
	public static void swapWithoutAtmp2(int a, int b){
		System.out.println("before swapping: a = " + a + "; b = " + b);
		a = a - b;
		b = a + b;
		a = b - a;
			
		System.out.println("after swapping: a = " + a + "; b = " + b);
	}
	
	/**
	 * Without IF-ELSE or other comparison operations.
	 * @param a
	 * @param b
	 * @return Math.max(a, b)
	 */
	@Algorithm
	public static int max(int a, int b){
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(a-b);
		
		//use sign of a if a and b have different signs
		int use_sa = sa ^ sb;
		int use_sc = flip(use_sa);
		
		int k = use_sa * sa + use_sc * sc;
		int q = flip(k);
		
		return a * k + b * q;
	}
	
	/**
	 * not allowed to use arithmetic operations.
	 * @param a
	 * @param b
	 * @return
	 */
	@Algorithm
	public static int sum(int a, int b){
		if (b==0) return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return sum(sum, carry);
	}
	
}
