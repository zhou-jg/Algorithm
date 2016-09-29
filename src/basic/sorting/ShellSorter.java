package basic.sorting;

public class ShellSorter {

	/**
	 * 带步长的多遍插入排序，参考自维基百科。
	 * 步长选择为：O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
	 * @param array
	 */
	public static void sort(int[] array){
		int gap = 1, i, j, len = array.length;
		int temp;
		while (gap < len / 3){
			gap = gap * 3 + 1; 
		}
		for (; gap > 0; gap /= 3){
			for (i = gap; i < len; i++) {
				temp = array[i];
				for (j = i - gap; j >= 0 && array[j] > temp; j -= gap){
					array[j + gap] = array[j];
				}
				array[j + gap] = temp;
			}
		}
	}

}
