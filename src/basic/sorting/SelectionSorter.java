package basic.sorting;

public class SelectionSorter {
	/**
	 * 选择排序
	 * @param array
	 */
	public static void sort(int[] array){
		int min, tmp, index;
		for (int i=0; i<array.length-1; i++){
			min = tmp = array[i];
			index = i;
			for (int j=i+1; j<array.length; j++){
				if (array[j] < min){
					min = array[j];
					index = j;
				}
			}
			array[i] = min;
			array[index] = tmp;
		}
	}
}
