package basic.number;

import static util.NumberUtil.max;

import java.util.Objects;

import util.Algorithm;

public class MaxSumForSubList {
	
	/**
	 * 获取整数数组中联系子序列和的最大值。
	 * 例如：如果数组为[-3, 3, 2, -6, 8, -2, 1],则最大和为 8
	 * @param array
	 * @return
	 */
	@Algorithm
	public static int compute(int[] array){
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
}
