package basic.bit;

public class BitCounter {

	/**
	 * 获取给定正整数的二进制表示的位数。
	 * @param num 正整数
	 * @return
	 */
	public static int count(int num){
		if (num <= 0){
			throw new IllegalArgumentException("输入必须是正整数.");
		}
		int count = 0;
		while (num != 0){
			num /= 2;
			count++;
		}
		return count;
	}
}
