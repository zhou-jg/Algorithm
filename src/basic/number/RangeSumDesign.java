package basic.number;

/**
Source: https://leetcode.com/problems/range-sum-query-immutable/

Given an integer array nums, find the sum of the elements 
between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]
<br>
sumRange(0, 2) -> 1<br>
sumRange(2, 5) -> -1<br>
sumRange(0, 5) -> -3
<br/>Note:
<li>You may assume that the array does not change.
<li>There are many calls to <i>sumRange</i> function.
*/
public class RangeSumDesign{
  private int[] data;
   
    public RangeSumDesign(int[] nums) {
        this.data = new int[nums.length];
        System.arraycopy(nums, 0, data, 0, nums.length);
        for (int i=1; i<data.length; i++){
            data[i] += data[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if (i==0){
            return data[j];
        }else{
            return data[j]-data[i-1];
        }
    }
}
