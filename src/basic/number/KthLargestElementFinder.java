package basic.number;

import java.util.ArrayList;
import java.util.List;

/**
source: https://leetcode.com/problems/kth-largest-element-in-an-array/

Find the kth largest element in an unsorted array. Note that it is 
the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
public class KthLargestElementFinder {
  public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>(k);
        outer: for (int i=0; i<nums.length; i++){
        	int j=0, len = list.size();        	
        	while (j < len && j < k){
        		if (nums[i] > list.get(j)){
        			list.add(j, nums[i]);
        			continue outer;
        		}else{
        			j++;
        		}
        	}
        	list.add(j, nums[i]);
        }
        
        return list.get(k-1);
    }
}
