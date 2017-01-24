package basic.search;

import util.Algorithm;

/**
 * https://leetcode.com/problems/search-insert-position/
 * 
 * <p>Given a sorted array and a target value, return the index if the 
 * target is found. If not, return the index where it would be if it 
 * were inserted in order.
 * 
 * <p>You may assume no duplicates in the array.
 * 
 * <p>Here are few examples.<br>
 * [1,3,5,6], 5 → 2<br>
 * [1,3,5,6], 2 → 1<br>
 * [1,3,5,6], 7 → 4<br>
 * [1,3,5,6], 0 → 0<br>
 * 
 * @author Jingang Zhou
 */
public class InsertPositionSearcher {
	@Algorithm("二分查找")
	public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        return find(nums, target, 0, nums.length-1);
    }
    
    private int find(int[] nums, int target, int begin, int end){
        if (begin > end){
            return begin;
        }else{
            int mid = (begin + end)/2;
            if (target == nums[mid]){
                return mid;
            }else if (target > nums[mid]){
                return find (nums, target, mid+1, end);
            }else{
                return find(nums, target, begin, mid-1);
            }
        }
    }
}
