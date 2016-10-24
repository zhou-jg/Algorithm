package basic.number;

public class LeastCommonMultiple {

	/**
	 * 求两个给定的正整数的最小公倍数
	 * @param a 正整数
	 * @param b 正整数
	 * @return a,b的最小公倍数
	 */
	public static int lcm(int a, int b){
		return a * b / GreatestCommonDivisor.gcd(a, b);
	}
}
