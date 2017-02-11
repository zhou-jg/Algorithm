package basic.queue.application;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Source: https://leetcode.com/problems/next-greater-element-i/
 * 
 * <p>You are given two arrays (without duplicates) nums1 and nums2 where 
 * nums1’s elements are subset of nums2. Find all the next greater numbers 
 * for nums1's elements in the corresponding places of nums2.
 * 
 * <p>The Next Greater Number of a number x in nums1 is the first greater 
 * number to its right in nums2. If it does not exist, output -1 for this 
 * number.
 * 
 * <p><b>Example 1:</b><br>
 * {@code Input: nums1 = [4,1,2], nums2 = [1,3,4,2].}<br>
 * {@code Output: [-1,3,-1]}<br>
 * Explanation:<br>
 * For number 4 in the first array, you cannot find the next greater 
 * number for it in the second array, so output -1.<br>
 * For number 1 in the first array, the next greater number for it in the 
 * second array is 3.<br>
 * For number 2 in the first array, there is no next greater number for it 
 * in the second array, so output -1.<br>
 * 
 * <p><b>Example 2:</b><br>
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].<br>
 * Output: [3,-1]<br>
 * Explanation:<br>
 * For number 2 in the first array, the next greater number for it in the 
 * second array is 3.<br>
 * For number 4 in the first array, there is no next greater number for it 
 * in the second array, so output -1.<br>
 * 
 * <p>Note:<br>
 * <li>All elements in nums1 and nums2 are unique.
 * <li>The length of both nums1 and nums2 would not exceed 1000.
 * <br>
 * @author Jingang Zhou
 *
 */
public class NextGreaterElementFinder {
	//用一个栈来处理数组中下一个较大元素，并用Map来做纪录
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (findNums == null ){
            return null;
        }
        if (findNums.length == 0){
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<nums.length; i++){
            while (!stack.isEmpty() && nums[i] > stack.peekFirst()){                
                map.put(stack.pollFirst(), nums[i]);                
            }
            stack.offerFirst(nums[i]);
        }
        while (!stack.isEmpty()){
            map.put(stack.pollFirst(), -1);
        }
        int[] ret = new int[findNums.length];
        for (int i=0; i<ret.length; i++){
            ret[i] = map.get(findNums[i]);
        }
        
        return ret;
    }
}
