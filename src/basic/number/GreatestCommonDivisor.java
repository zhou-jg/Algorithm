package basic.number;

public class GreatestCommonDivisor{

	/**
	 * 基于欧几里得算法（辗转相除法）求两个正整数的最大公约数
	 * @param a 正整数
	 * @param b 正整数
	 * @return a,b的最大公约数
	 */
	public static int gcd(int a, int b){
		int m;
		while((m = a % b) > 0){
			a = b;
			b = m;
		}
		return b;
	}
}
