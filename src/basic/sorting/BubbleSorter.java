package basic.sorting;

import util.Algorithm;


public class BubbleSorter {
	/**
	 * 
	 * @param array
	 * @return
	 */
	@Algorithm(kind = "sort")
	public static int[] sort(int[] array){
		for (int i=0; i<array.length; i++){
			for (int j=0; j<array.length-1-i; j++){
				if (array[j] > array[j+1]){
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}
		return array;
	}
}
