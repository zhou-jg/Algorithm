package basic.bit;

/**
 * 通过右移或左移来判断某个树指定位的值。
 * @author Jingang Zhou
 *
 */
public class BitGetter {

	/**
	 * 通过左移来判断所给定的整数某个位是否为0.
	 * @param num 给定的整数
	 * @param i  指定的位数，从右往左（从1开始）
	 * @return true: 第i位为0; false: 第i位为1
	 */
	public static boolean isZeroByLeftShift(int num, int i){
		if (i < 1){
			throw new IllegalArgumentException("位数不能小于1.");
		}
		return (1<<i-1 & num) == 0;
	}
	
	/**
	 * 通过右移来判断所给定的整数某个位是否为0.
	 * @param num 给定的整数
	 * @param i 指定的位数，从右往左（从1开始）
	 * @return true: 第i位为0; false: 第i位为1
	 */
	public static boolean isZeroByRightShift(int num, int i){
		if (i < 1){
			throw new IllegalArgumentException("位数不能小于1.");
		}
		return (num>>i-1 & 1) == 0;
	}
}
