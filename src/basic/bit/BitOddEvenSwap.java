package basic.bit;

import util.Algorithm;

/**
 * 将给定的数进行奇偶位互换，所用的指令越少越好。
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 */
public class BitOddEvenSwap {

	/**
	 * 对指定的数进行奇偶位互换
	 * @param num
	 * @return 互换后的值
	 */
	@Algorithm(kind="bit")
	public static int swap(int num){
		/*
		 * 0x55555555 = 0B0101010101010101....0101，目的是提前奇数位
		 * 0xaaaaaaaa = 0B1010101010101010....1010，目的是提前偶数位
		 */
		return ((0x55555555 & num)<<1) | ((0xaaaaaaaa & num)>>1);
	}
}
