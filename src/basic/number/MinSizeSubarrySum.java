package basic.number;

/**
 * Source: https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * <p>Given an array of <b>n</b> positive integers and a positive 
 * integer <b>s</b>, find the minimal length of a <b>contiguous</b> 
 * subarray of which the sum ≥ <b>s</b>. If there isn't one, return 0 instead.
 * <p>For example, given the array [2,3,1,2,4,3] and s = 7, the 
 * subarray [4,3] has the minimal length under the problem constraint.
 * 
 * @author Jingang Zhou
 */
public class MinSizeSubarrySum {
	/**
	 * 从头到尾遍历，因为要求连续子序列，所以向右加新元素，直到>=s，从左减老元素，直到<s，
	 * 在这个过程中比较取序列个数最小的值。时间复杂度是O(n)。
	 * 
	 * <p>另一种简单的方法是对数组降序（升序亦可）排序，然后从开头开始加，找到第一次>s的
	 * 情况，即可返回结果。时间复杂度在于排序算法O(nlogn)。
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int tmp = 0, sum = 0, index = 0, i= 0;

        while(true){
            while (i<nums.length && sum < s){
                sum += nums[i];
                tmp++;
                i++;
            }
            if (sum >= s){
            	if (tmp < min){
                    min = tmp;
                }
                while (sum >= s){
                    sum -= nums[index];
                    index++;
                    tmp--;
                }
                if (tmp + 1 < min){
                	min = tmp + 1; 
                }
            }else {               
                break;//遍历完毕
            }
        }
        
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
