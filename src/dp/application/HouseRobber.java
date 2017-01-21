package dp.application;

/**
 * Source: https://leetcode.com/problems/house-robber/
 * 
 * <p>You are a professional robber planning to rob houses 
 * along a street. Each house has a certain amount of 
 * money stashed, the only constraint stopping you from 
 * robbing each of them is that adjacent houses have 
 * security system connected and <b>it will automatically 
 * contact the police if two adjacent houses were broken 
 * into on the same night.</b>

 * <p>Given a list of non-negative integers representing 
 * the amount of money of each house, determine the maximum 
 * amount of money you can rob tonight <b>without alerting the 
 * police.</b>
 * 
 * @author Jingang Zhou
 */
public class HouseRobber {
	public int rob(int[] nums) {
        if (nums == null || nums.length==0){
            return 0;
        }
        int[] money = new int[nums.length];
        money[0] = nums[0];
        for (int i=1; i<nums.length; i++){
        	if (i>1){
        		money[i] = Math.max(nums[i]+money[i-2], money[i-1]);
        	}else{
        		money[i] = Math.max(nums[1], money[0]);
        	}
        }
        return money[money.length-1];
    }
}
