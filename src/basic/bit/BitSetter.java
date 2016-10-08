package basic.bit;

import util.Algorithm;

public class BitSetter {

	/**
	 * 将给定整数的第i位置1.
	 * @param num
	 * @param i 指定的位，大于等于1
	 * @return 修改后的值
	 */
	@Algorithm(kind="bit")
	public static int setOne(int num, int i){
		return num | 1<<i-1;
	}
	
	/**
	 * 将给定整数的第i位置0.
	 * @param num
	 * @param i
	 * @return 修改后的值
	 */
	public static int setZeroByExclusiveOr(int num, int i){
		int value = BitGetter.getBit(num, i);
		return num ^ value<<i-1;
	}
	
	/**
	 * 通过将1左移取反得到第i位为0其余位为1的数，与原数与达到置零的目的。
	 * @param num
	 * @param i
	 * @return 修改后的值
	 */
	public static int setZeroByAnd(int num, int i){
		return num & ~(1<<i-1);
	}
}
