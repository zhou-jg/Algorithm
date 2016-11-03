package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.Algorithm;
import util.NumberUtil;
import util.Pair;

/**
 * 从给定面值的钱币中找出组合为指定面值的最小钱币个数的方案。利用一个二维数组来记录中间过程
 * 中 0~sum 所有方案，结构如下，每一列列向量代表了满足表头的总额前提下的每种钱币的数量。
 * 
 * 面额		| 0	| 1	| ... | sum
 * coins[0]	| 0	|	|	  |		
 * coins[1]	| 0	|	| 	  |
 * ...		| 0	|	|     |
 * coins[n]	| 0	|	|     |
 * 
 * 列中用 {@code Integer.Max_VALUE} 表示该总额没有拆分方案。
 * 
 * @author Jingang Zhou
 */
public class MinimalCoinsForGivenSum {

	/**
	 * 从给定面值的钱币中找出组合为指定面值的最小钱币个数的方案
	 * @param coins 不同的钱币面值，假设每种面值钱币无限多
	 * @param sum 指定的组合面值额度
	 * @return 找到的钱币组合方案，其中的每个元素代表该面值钱币({@code Pair#getLeft()})的数量({@code Pair#getRight()})
	 */
	@Algorithm("动态规划")
	public static List<Pair<Integer>> find(int[] coins, int sum){
		int coinKind = coins.length;
		//中间结果结构
		int[][] solution = new int[coinKind][sum+1];
		for (int i=0; i<coinKind; i++){
			solution[i][0] = 0;
		}
		for (int i=0; i<coinKind; i++){
			for (int j=1; j<=sum; j++){
				solution[i][j] = Integer.MAX_VALUE; //表明不可组合
			}
		}
		
		//主体逻辑
		for (int i=1; i<=sum; i++) {
			int[] nums = new int[coinKind];
			initSolution(nums);
			int count = Integer.MAX_VALUE;
			
			for (int j=0; j<coinKind; j++){
				int k = i - coins[j];
				if (k >= 0){
					int[] s = getSolutionFor(k, solution);					
					if (isValid(s)){//可以按该面值钱币进行拆分
						int _count = NumberUtil.sum(s);
						if (_count+1 < count){
							nums = s;
							nums[j] += 1;
							count = _count + 1;
						}
					}
				}
			}
			if (count < Integer.MAX_VALUE){
				for (int j=0; j<coinKind; j++){
					solution[j][i] = nums[j];
				}
			}
		}
		
		//构造返回结果
		if (isValid(getSolutionFor(sum, solution))){
			List<Pair<Integer>> ret = new ArrayList<Pair<Integer>>(coinKind);
			for (int i=0; i<coinKind; i++){
				ret.add(new Pair<Integer>(coins[i], solution[i][sum]));				
			}
			return ret;
		}else{
			return Collections.emptyList();//该额度不可拆分成指定的面值钱币的组合
		}
	}
	
	/**
	 * 从给定面值的指定数量的钱币中构造满足指定总额的最少钱币数量的方案
	 * @param coins 不同的面值
	 * @param amount 对于不同面值钱币的数量
	 * @param sum 给定的额度和
	 * @return 满足要求的列表，每个元素代表了该面值纸币需要的数量
	 * 
	 * @see #find(int[], int)
	 */
	public static List<Pair<Integer>> find(int[] coins, int[] amount, int sum){
		int coinKind = coins.length;
		int allSum = 0;
		for (int i=0; i<coinKind; i++){
			allSum += coins[i] * amount[i];
		}
		if (allSum < sum){
			return Collections.emptyList();
		}
		
		//中间结果结构
		int[][] solution = new int[coinKind][sum+1];
		for (int i=0; i<coinKind; i++){
			solution[i][0] = 0;
		}
		for (int i=0; i<coinKind; i++){
			for (int j=1; j<=sum; j++){
				solution[i][j] = Integer.MAX_VALUE; //表明不可组合
			}
		}
		
		//主体逻辑
		for (int i=1; i<=sum; i++) {
			int[] nums = new int[coinKind];
			initSolution(nums);
			int count = Integer.MAX_VALUE;
			
			for (int j=0; j<coinKind; j++){
				int k = i - coins[j];
				if (k >= 0){
					int[] s = getSolutionFor(k, solution);					
					if (isValid(s)){//可以按该面值钱币进行拆分
						int _count = NumberUtil.sum(s);
						if (_count+1 < count && _count+1 <= amount[j]){//与find(int[], int)的唯一区别
							nums = s;
							nums[j] += 1;
							count = _count + 1;
						}
					}
				}
			}
			if (count < Integer.MAX_VALUE){
				for (int j=0; j<coinKind; j++){
					solution[j][i] = nums[j];
				}
			}
		}
		
		//构造返回结果
		if (isValid(getSolutionFor(sum, solution))){
			List<Pair<Integer>> ret = new ArrayList<Pair<Integer>>(coinKind);
			for (int i=0; i<coinKind; i++){
				ret.add(new Pair<Integer>(coins[i], solution[i][sum]));				
			}
			return ret;
		}else{
			return Collections.emptyList();//该额度不可拆分成指定的面值钱币的组合
		}
	}
	
	private static void initSolution(int[] s){
		for (int i=0; i<s.length; i++){
			s[i] = Integer.MAX_VALUE;
		}
	}
	
	private static boolean isValid(int[] s){
		return s[0] < Integer.MAX_VALUE;
	}
	
	/**
	 * 获取数组的指定列
	 * @param k 列索引
	 * @param solution 给定的二维数组 
	 * @return 给定数组中指定的列向量
	 */
	private static int[] getSolutionFor(int k, int[][] solution){
		int[] ret = new int[solution.length];
		for (int i=0; i<ret.length; i++){
			ret[i] = solution[i][k];
		}
		return ret;
	}
}
