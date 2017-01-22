package dp.application;

/**
 * Source: https://leetcode.com/problems/house-robber-ii/
 * <p>
 * <b>Note</b>: This is an extension of {@link HouseRobber}.
 * <p>After robbing those houses on that street, the thief has 
 * found himself a new place for his thievery so that he will 
 * not get too much attention. This time, all houses at this 
 * place are arranged in a circle. That means the first house 
 * is the neighbor of the last one. Meanwhile, the security 
 * system for these houses remain the same as for those in the 
 * previous street.

 * <p>Given a list of non-negative integers representing the 
 * amount of money of each house, determine the maximum amount 
 * of money you can rob tonight without alerting the police.
 * 
 * @author Jingang Zhou
 */
public class HouseRobberII {
	/**
	 * 两次遍历，分别是考虑第一间房子(0..n-2)和不考虑第一间房子(1..n-1)
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[1], nums[0]);
        }
        int r1 = inner(nums, 0, nums.length-1);
        int r2 = inner(nums, 1, nums.length);
        return Math.max(r1, r2);
    }
    
    private int inner(int[] nums, int start, int end){
        int[] sum = new int[end-start];
        sum[0] = nums[start];
        if (sum.length == 1){
            return sum[0];
        }
        sum[1] = Math.max(nums[start], nums[start+1]);
        for (int i=start+2; i<end; i++){
            sum[i-start] = Math.max(sum[i-start-1], sum[i-start-2]+nums[i]);
        }
        return sum[sum.length-1];
    }
}
