package basic.sorting;

import java.util.Objects;

import util.Algorithm;

public class QuickSorter {

	/**
	 * 快速排序
	 * @param array
	 */
	@Algorithm(value = "sort")
	public static void sort(int[] array){
		Objects.requireNonNull(array);
		internalSort(array, 0, array.length-1);
	}

	private static void internalSort(int[] array, int begin, int end) {
		if (begin>=end){
			return;
		}else{
			int i=begin, j=end;
			int base = array[i];
			while (i < j){
				while (array[j] >= base && j > i){
					j--;
				}
				if (j > i) {
					swap(array, i, j);
					i++;
				}else{
					break;
				}
				
				while (array[i] <= base && i < j){
					i++;
				}
				if (i < j){
					swap(array, i, j);
					j--;
				}else{
					break;
				}
			}
			internalSort(array, begin, i-1);
			internalSort(array, i+1, end);
		}
	}
	
	private static void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
		
}
