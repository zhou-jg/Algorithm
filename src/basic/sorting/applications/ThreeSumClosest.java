package basic.sorting.applications;

import util.Algorithm;

import java.util.*;

/**
 * Source: <a href="https://leetcode.com/problems/3sum-closest/?tab=Description">
 *     https://leetcode.com/problems/3sum-closest/</a>
 *
 * <p>Given an array <i>S</i> of <i>n</i> integers, find three integers in <i>S</i>
 * such that the sum is closest to a given number, target. Return the sum of the
 * three integers. You may assume that each input would have exactly one solution.
 *
 * <p><code>For example, given array S = {-1 2 1 -4}, and target = 1.<br>
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).</code>
 *
 * <p>Created by zhou-jg on 2017/2/22.
 */
public class ThreeSumClosest {
    /**
     * After sorting, we can use three pointers to move among the array, so that
     * we can get a solution of time complexity O(n^2).
     * @param nums
     * @param target
     * @return
     */
    @Algorithm("数字")
    @Algorithm("排序")
    @Algorithm("相向指针")
    public int threeSumClosestII(int[] nums, int target){
        int sum = 0;
        if (nums.length <= 3){
            for (int i=0; i<nums.length; i++){
                sum += nums[i];
            }
            return sum;
        }

        Arrays.sort(nums);
        int ret = nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0; i<nums.length-2; i++){
            int j=i+1, k=nums.length-1;
            while (j < k){
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target){
                    return target;
                }else if(sum > target){
                    k--;
                }else{
                    j++;
                }
                if (Math.abs(ret - target) > Math.abs(sum - target)){
                    ret = sum;
                }
            }
        }

        return ret;
    }

    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        if (nums.length <= 3){
            for (int i=0; i<nums.length; i++){
                sum += nums[i];
            }
            return sum;
        }
        int ret = nums[0]+nums[1]+nums[2];
        for (int i=0; i<=nums.length-3; i++){
            sum=nums[i];
            for (int j=i+1; j<=nums.length-2; j++){
                sum += nums[j];
                for (int k=j+1; k<nums.length; k++){
                    sum += nums[k];
                    if (sum == target){
                        return target;
                    }else if (Math.abs(sum-target) < Math.abs(ret-target)){
                        ret = sum;
                    }
                    sum -= nums[k];
                }
                sum -= nums[j];
            }
        }
        return ret;
    }
}
