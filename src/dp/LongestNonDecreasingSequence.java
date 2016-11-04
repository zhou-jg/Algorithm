package dp;

import util.Algorithm;

/**
 * 计算给定数组中非递减子序列的最大长度。<br/>
 * 如果想输出最长子序列，那么只需根据构造的中间长度
 * 记录反向构造有向图，然后再遍历该有向图输出路径即可。
 * 
 * @author Jingang Zhou
 */
public class LongestNonDecreasingSequence {

	/**
	 * 计算给定数组非递减子序列的最大长度
	 * @param data 给定数组
	 * @return 非递减子序列的最大长度
	 */
	@Algorithm("动态规划")
	public static int length(int[] data){
		if (data == null || data.length == 0){
			return 0;
		}
		
		int[] length = new int[data.length];
		length[0] = 1;
		//返回结果，记录最长结果
		int ret = 1;
		
		for (int i=1; i<data.length; i++){
			int tmp = 1;
			for (int j=0; j<i; j++){
				if (data[i] >= data[j]){
					if (length[j] + 1 > tmp){
						tmp = length[j] + 1;
					}
				}
			}
			length[i] = tmp;
			if (tmp > ret){
				ret = tmp;
			}
		}
		
		return ret;
	}
	
	/**
	 * 输出一条最长子序列
	 * @param data 原始数据
	 * @param lengths 中间长度记录
	 * @param length 最长子序列长度
	 * @return 一条最长子序列
	 */
	public static int[] sequences(int[] data, int[] lengths, int length){
		int[] ret = new int[length];
		int tmpLength = length;
		for (int i=data.length-1; i>=0; i--){
			if (lengths[i] == tmpLength && (tmpLength == length || data[ret[tmpLength-1]] >= data[i])){
				ret[tmpLength-1] = i;
				tmpLength--;
			}
			if (tmpLength == 0){
				break;
			}
		}
		return ret;
	}
}
