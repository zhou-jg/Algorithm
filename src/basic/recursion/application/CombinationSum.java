package basic.recursion.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.Algorithm;

/**
 * 来源：https://leetcode.com/problems/combination-sum/
 * Given a set of candidate numbers (C) (without duplicates) and 
 * a target number (T), find all unique combinations in C where 
 * the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 *	[
 *	 [7],
 *	 [2, 2, 3]
 *	]
 *
 * @author Jingang Zhou
 *
 */
public class CombinationSum {

	@Algorithm("递归")
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0 || target <= 0){
			return Collections.emptyList();
		}
		int[] nums = new int[candidates.length];
		System.arraycopy(candidates, 0, nums, 0, candidates.length);
		Arrays.sort(nums);
		if (nums[0] > target){
			return Collections.emptyList();
		}
		Set<List<Integer>> ret = new HashSet<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		internalProcessing (ret, list, nums, target, 0);
		
		return new ArrayList<List<Integer>>(ret);
    }
	
	private void internalProcessing(Set<List<Integer>> ret, 
					List<Integer> list, int[] nums, int target, int start){
		if (target == 0){
			if (list.size() > 0){
				ret.add(list);
			}
		}else if (target < 0){
			return;
		}else {
			if (start == nums.length || nums[start] > target){
				return;
			}else{
				int num = nums[start];
				int index = start+1;
				internalProcessing(ret, list, nums, target, index);
				List<Integer> list2 = new ArrayList<Integer>(list);
				list2.add(num);
				internalProcessing(ret, list2, nums, target-num, start);
				internalProcessing(ret, list2, nums, target-num, index);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new CombinationSum().combinationSum(new int[]{1}, 2));
		System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7));
	}

}
