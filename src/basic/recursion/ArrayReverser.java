package basic.recursion;

import util.Algorithm;
import util.ArraysUtil;

/**
 * 递归将给定数组逆序（reverse）
 * @author Jingang Zhou
 *
 */
public class ArrayReverser {
	
	/**
	 * 将给定数组逆序
	 * @param data
	 * @return
	 */
	@Algorithm(value="递归")
	public static <T> T[] reverse (T[] data){
		if (data == null){
			return null;
		}
		
		internalReverse(data, 0, data.length - 1);
		return data;
	}
	
	//递归主体，首尾互换，逐渐向中间逼近
	private static <T> void internalReverse(T[] data, int begin, int end){
		if (begin >= end){
			return;
		}
		ArraysUtil.swap(data, begin, end);
		internalReverse(data, begin+1, end-1);
	}
}
