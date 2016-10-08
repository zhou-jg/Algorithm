package basic.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import util.Algorithm;
import util.Pair;
import static util.NumberUtil.*;

public class ArrayAlgorithm {
	/**
	 * find index m, n in array so that if we make numbers between [m] and [n]
	 * ordered, then the array is ordered. Also make n-m as small as possible.
	 * @param array
	 * @return pair of m, n
	 */
	@Algorithm
	public static Pair<Integer> findRangeIndiceToBeOrdered(int[] array){
		Objects.requireNonNull(array);

		int m = -1, n = -1;
		//store all ascending sub list ranges
		List<Pair<Integer>> subLists = new ArrayList<>();
		
		if (array.length > 2){
			initSubLists(subLists, array);
			
			m = subLists.get(0).getRight();			
			outer1: for (int i=1; i<subLists.size(); i++){
				int index = subLists.get(i).getLeft();
				while(array[index] < array[m]){
					m--;
					if (m==0) break outer1;
				}
			}
			m++;//adjust index, e.g, when make 6 compare (1,2,4,7), we want the index be at 7 not at 4.
			
			n = subLists.get(subLists.size()-1).getLeft();
			outer2: for (int i=subLists.size()-2; i>=0; i--){
				int index = subLists.get(i).getRight();
				while(array[index] > array[n]){
					n++;
					if (n==array.length-1) break outer2;
				}
			}
			n--;//adjust index
		}
		
		return new Pair<Integer>(m, n); 
	}

	
	/**
	 * 定位一个有序数组在循环之后的最小值
	 * 二分查找算法
	 * @param array 有序数组循环之后的数组，例如[2,4,6,7,9]两次循环后为[7,9,2,4,6]
	 * @return
	 */
	@Algorithm
	public static int minByDivide(int[] array){
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
	
	/**
	 * divide array into ascending sub lists.
	 * @param subLists
	 * @param array
	 */
	private static void initSubLists(List<Pair<Integer>> subLists, int[] array){
		int start = 0, end = 0;
		for (int i=0; i<array.length-1; i++){
			if (array[i] > array[i+1]){
				end = i;
				subLists.add(new Pair<Integer>(start, end));
				start = i+1;
			}
		}
		subLists.add(new Pair<Integer>(start, array.length-1));
	}
	
}
