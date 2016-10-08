package basic.bit;

import util.Algorithm;

public class BitClearner {

	/**
	 * 对给定的数从最高位到第i位清零。
	 * @param num
	 * @param i
	 * @return 修改后的数
	 */
	@Algorithm(kind="bit")
	public static int clearTop(int num, int i){
		return num & (1<<i-1)-1;
	}
	
	/**
	 * 对给定的数从最低位到第i位清零。
	 * @param num
	 * @param i
	 * @return 修改后的数
	 */
	@Algorithm(kind="bit")
	public static int clearLow(int num, int i){
		return num & ~((1<<i)-1);
	}
}
