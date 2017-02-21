package basic.search.application;

import datastructure.List;
import util.Algorithm;

/**
 * Created by zhou-jg on 2017/2/21.
 */
public class DuplicateNumberFinder {
    public int findDuplicate(int[] nums) {
        return find(nums, 1, nums.length);
    }

    /**
     * 根据鸽巢原理，如果数组中<=k的元素个数不大于k个，那么则说明重复的元素
     * 在大于k的范围内。如此，利用二分法，逐步逼近该元素。时间复杂度为O(nlogn)。
     * @param nums
     * @param begin
     * @param end
     * @return
     * @see #findDuplicateII(int[])
     */
    @Algorithm("二分法")
    private int find(int[] nums, int begin, int end){
        if (begin == end){
            return begin;
        }
        int mid = begin + (end-begin)/2;
        int count = 0;
        for (int num : nums){
            if (num <= mid){
                count++;
            }
        }
        if (count <= mid){
            return find(nums, mid+1, end);
        }else{
            return find(nums, begin, mid);
        }
    }

    /**
     * <p><a href="https://discuss.leetcode.com/topic/25685/java-o-n-time-and-o-1-space-solution-similar-to-find-loop-in-linkedlist">
     *     https://discuss.leetcode.com/topic/25685/java-o-n-time-and-o-1-space-solution-similar-to-find-loop-in-linkedlist</a>
     *
     * <p>A better solution with complexity of O(n).
     * Idea from detecting circle of a list with two (fast and slow) points.
     * @param nums
     * @return
     * @see basic.list.CircleFinder#findNode(List)
     */
    public int findDuplicateII(int[] nums){
        //Start from n to avoid the situation of nums[0]-1 = 0 in which 
        // we cannot detect the circle.
        int n=nums.length;
        int fast =n, slow = n;
        do {
            fast = nums[nums[fast-1]-1];
            slow = nums[slow-1];
        }while (fast != slow);
        slow = n;
        while (fast != slow){
            fast = nums[fast-1];
            slow = nums[slow-1];
        }
        return slow;
    }
}
