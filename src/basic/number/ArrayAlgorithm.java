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
	 * 获取整数数组中联系子序列和的最大值。
	 * 例如：如果数组为[-3, 3, 2, -6, 8, -2, 1],则最大和为 8
	 * @param array
	 * @return
	 */
	@Algorithm
	public static int getMaxSumForSubList(int[] array){
		Objects.requireNonNull(array);	
		if (array.length > 0){
			//记录前次最大和与当前求和
			int preMax, sum;
			int start = -1, end = array.length-1;
			
			//预处理，滤掉数组首部出现的连续负数
			for(int i = 0; i<=end; i++){
				if (array[i] > 0){
					start = i;
					break;
				}
			}
			
			//如果数组全部为负数，那么选择其中最大的一个
			if (start == -1){
				return max(array);
			}else{		
				//滤掉数组尾部连续的负数
				for(int i=end; i>=start; i--){
					if (array[i] > 0){
						end = i;
						break;
					}
				}
			}
			
			//如果整个数组就一个正数，返回该正数
			if (start == end){
				return array[start];
			}else{
				/*关键逻辑*/
				preMax = sum = array[start];
				for (int i=start+1; i<=end; i++){
					sum += array[i];
					if (sum < 0){
						sum = 0;
					}else if (preMax < sum){
						preMax = sum;
					}
				}
				return preMax;
			}
		}else{
			throw new RuntimeException("array is not allowed to be empty.");
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
