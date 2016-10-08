package basic.number;

import util.Algorithm;

public class NumberSwap {

	/**
	 * 用算术运算符实现两数互换。
	 * @param a
	 * @param b
	 * @see basic.bit.application.NumberSwap#swap()
	 */
	@Algorithm
	public static void swap(int a, int b){
		System.out.println("before swapping: a = " + a + "; b = " + b);
		a = a - b;
		b = a + b;
		a = b - a;
			
		System.out.println("after swapping: a = " + a + "; b = " + b);
	}
}
