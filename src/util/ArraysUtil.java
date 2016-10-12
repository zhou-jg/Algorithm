package util;

public class ArraysUtil {

	/**
	 * 用指定的索引对元素互换
	 * @param data 给定的数组
	 * @param i 指定的元素索引
	 * @param j 指定的元素索引
	 * @throws {@code NullPointerException} 如果 {@code data}为空
	 * @throws {@code ArrayIndexOutOfBoundsException} 如果{@code i}或{@code j}越界
	 */
	public static <T> void swap(T[] data, int i, int j){
		T tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
