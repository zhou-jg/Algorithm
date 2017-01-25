package dp;

/**
 * Source: https://leetcode.com/problems/target-sum/
 * 
 * <p>You are given a list of non-negative integers, a1, a2, ..., an, 
 * and a target, S. Now you have 2 symbols + and -. For each integer, 
 * you should choose one from + and - as its new symbol.
 * 
 * <p>Find out how many ways to assign symbols to make sum of integers 
 * equal to target S.
 *
 *<p>Example 1:<br>
 * Input: nums is [1, 1, 1, 1, 1], S is 3.<br>
 * Output: 5<br>
 * Explanation:<br> 
 * -1+1+1+1+1 = 3<br>
 * +1-1+1+1+1 = 3<br>
 * +1+1-1+1+1 = 3<br>
 * +1+1+1-1+1 = 3<br>
 * +1+1+1+1-1 = 3<br>
 *
 * <p>There are 5 ways to assign symbols to make the sum of nums be target 3.
 * <p><b>Note:</b>
 * <li>The length of the given array is positive and will not exceed 20.
 * <li>The sum of elements in the given array will not exceed 1000.
 * <li>Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {
	/**
	 * 参考：https://discuss.leetcode.com/topic/76243/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation/2
	 * <p>首先进行问题转换，转换为求数组中元素和数为指定值的方案个数。之后用动态规划进行状态求解。
	 * <p>问题转换思路：原问题要求解数组中一组非负数集合减去另一组非负数集合，值为指定值。设第一组非负数集合为P，
	 * 	要减去的另一组非负数集合为N，则有：<br>
	 *  	sum(P) - sum(N) = target<br>
	 *  	sum(P) + sum(N) = sumAll<br>
	 *  		2 * sum(P)	= target + sumAll<br>
	 *  			sum(P)	= (target + sumAll)/2<br>
	 *  这样，如果target+sumAll不是偶数的话，则没有方案。
	 *  
	 * @param nums
	 * @param S
	 * @return
	 */
	public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        for (int n : nums){
            sum += n;
        }
        if (sum < S || -sum > S || (S+sum) % 2 == 1){
            return 0;
        }
        
        //新的和数
        int s = (Math.abs(S)+sum)/2;
        int[] dp = new int[s+1];
        dp[0] = 1;
        for (int i=0; i<nums.length; i++){
            for (int j=s; j>=nums[i]; j--){
            	dp[j] += dp[j-nums[i]];
            }
            /* 不能按照如下代码计算，因此它重复计算
        	for (int j=nums[i]; j<=s; j++){
        		dp[j] += dp[j-nums[i]];
        	}*/
        }
        
        return dp[s];
    }

}
