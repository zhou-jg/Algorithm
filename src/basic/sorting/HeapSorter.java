package basic.sorting;

import datastructure.Heap;
import util.Algorithm;

/**
 * 堆排序
 * @author Jingang Zhou
 *
 */
public class HeapSorter {
	
	@Algorithm
	public static void sort(int[] array){
		//构造小堆
		Heap<Integer> heap = new Heap<>(true);
		for(int t : array){
			heap.add(t);
		}
		for(int i=0; i<array.length-1; i++){
			array[i] = heap.pop();
		}		
	}
}
