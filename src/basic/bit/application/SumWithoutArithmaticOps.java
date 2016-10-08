package basic.bit.application;

import util.Algorithm;

/**
 * 两数求和，但不允许用使用算术运算符。
 * @author Jingang Zhou
 *
 */
public class SumWithoutArithmaticOps {

	/**
	 * not allowed to use arithmetic operations.
	 * @param a
	 * @param b
	 * @return a+b;
	 */
	@Algorithm
	public static int sum(int a, int b){
		if (b==0) return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return sum(sum, carry);
	}
	
}
