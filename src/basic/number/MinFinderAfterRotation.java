package basic.number;

import java.util.Objects;

import util.Algorithm;

public class MinFinderAfterRotation {
	
	/**
	 * 定位一个有序数组在循环之后的最小值
	 * 二分查找算法
	 * @param array 有序数组循环之后的数组，例如[2,4,6,7,9]两次循环后为[7,9,2,4,6]
	 * @return
	 */
	@Algorithm
	public static int min(int[] array){
		Objects.requireNonNull(array);
//		int result = Integer.MIN_VALUE;
		
		int index = array.length / 2;
		int start = 0, end = array.length - 1;
		if (array[index-1] <= array[start]){
			return minByDivide(array, start, index-1);
		}else{
			return minByDivide(array, index, end);
		}
	}
	
	private static int minByDivide(int[] array, int start, int end){
		if (end - start == 1){
			if (array[end] < array[start]){
				return array[end];
			}
			return array[start];
		}else if (end == start){
			return array[start];
		}
		int index = (end + start) / 2;
		if (array[index] >= array[end]){
			return minByDivide(array, index+1, end);
		}else{
			return minByDivide(array, start, index);
		}
	}
	
}
