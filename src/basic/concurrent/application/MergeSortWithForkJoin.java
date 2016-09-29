package basic.concurrent.application;

import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

import static util.NumberUtil.swap;

public class MergeSortWithForkJoin {
	/**
	 * 利用 Fork/Join 实现数组排序
	 * @param array
	 * @return
	 */
	public static int[] sort(int[] array){
		Objects.requireNonNull(array);
		
		ForkJoinTask<?> task = new MergeSortAction(array, 0, array.length-1);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		
		return array;
	}
	
	@SuppressWarnings("serial")
	static class MergeSortAction extends RecursiveAction {
		
		private final int[] array;
		private final int begin, end;
		
		MergeSortAction(final int[] array, int begin, int end){
			this.array = array;
			this.begin = begin;
			this.end = end;
		}

		@Override
		protected void compute() {
			if (begin == end){
				return;
			}else if (end - begin == 1){
				if (array[begin] > array[end]){
					swap(array, begin, end);
				}
			}else{
				int middle = (begin + end)/2;
				invokeAll(new MergeSortAction(array, begin, middle), 
							new MergeSortAction(array, middle+1, end));
				
				merge(array, begin, middle, end);
			}
		}
		
		static void merge(int[] array, int begin, int middle, int end) {
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

}
