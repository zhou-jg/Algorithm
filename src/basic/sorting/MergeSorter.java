package basic.sorting;

import java.util.Objects;

import util.Algorithm;

public class MergeSorter {
	/**
	 * 归并排序
	 * @param array
	 */
	@Algorithm(kind="sort")
	public static void sort(int[] array){
		Objects.requireNonNull(array);
		
		mergeSort(array, 0, array.length-1);
	}

	private static void mergeSort(int[] array, int begin, int end) {
		if (begin==end){
			return;
		}
		int middle = (begin+end)/2;
		mergeSort(array, begin, middle);
		mergeSort(array, middle+1, end);
		merge(array, begin, middle, end);
	}

	private static void merge(int[] array, int begin, int middle, int end) {
		int[] left = new int[middle-begin+1];
		int[] right = new int[end-middle];
		for (int i=0; i<left.length; i++){
			left[i] = array[begin+i];
		}
		for (int i=0;i<right.length;i++){
			right[i] = array[middle+1+i];
		}
		
		int i=0, j=0, k=begin;
		while (i < left.length || j < right.length){
			if (left[i] > right[j]){
				array[k++] = right[j];
				j++;
				if (j==right.length){
					do{
						array[k++] = left[i++];
					}while (i<left.length-1);
					break;
				}
			}else{
				array[k++] = left[i];
				i++;
				if (i==left.length){
					do{
						array[k++] = right[j++];
					}while(j<right.length-1);
					break;
				}				
			}
		}
	}
}
