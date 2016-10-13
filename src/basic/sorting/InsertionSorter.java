package basic.sorting;

import java.util.Objects;

import util.Algorithm;

public class InsertionSorter {

	/**
	 * 插入排序
	 * @param array
	 */
	@Algorithm(value="sort")
	public static void sort(int[] array){
		Objects.requireNonNull(array);
		for (int i=1; i<array.length; i++){
			int num = array[i];
			//找到array[i]应该插入的索引值 index
			int index = findInsertionIndexFor(array, i);
			//从index到i-1元素依次右移
			moveRight(array, index, i);
			//将原来的array[i]在应在的位置写入
			array[index] = num;
		}
	}
	
	/**
	 * 找到array[i]应该插入的索引位置
	 * @param array
	 * @param i 
	 * @return 原索引i所指元素应该插入的索引值
	 */
	private static int findInsertionIndexFor(int[] array, int i){
		int num = array[i];
		for (int j=i-1; j>=0; j--){
			if (num >= array[j]) {
				return j+1;
			}
		}
		return 0;
	}
	
	/**
	 * 将从begin开始到end-1结束的元素依次后移一位
	 * @param array
	 * @param begin
	 * @param end
	 */
	private static void moveRight(int[] array, int begin, int end){
		for (int j=end; j>begin; j--){
			array[j] = array[j-1];
		}
	}
}
