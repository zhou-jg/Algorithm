package basic.bit.application;

import util.Algorithm;

public class NumberSwap {

	/**
	 * swap a and b using bit operation.
	 * @param a
	 * @param b
	 * @see basic.number.NumberSwap#swap()
	 */
	@Algorithm
	public static void swap(int a, int b){
		System.out.println("before swapping: a = " + a + "; b = " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
			
		System.out.println("after swapping: a = " + a + "; b = " + b);
	}
}
