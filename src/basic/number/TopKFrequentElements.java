package basic.number.applications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Source: https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * <p>Given a non-empty array of integers, return the k most frequent elements.

 * <p>For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].

 * <p><b>Note:</b> 
 * <li>You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * <li>Your algorithm's time complexity must be better than O(n log n),
 *  where n is the array's size.
 * 
 * @author Jingang Zhou
 *
 */
public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fre = new HashMap<>();
        for (int num : nums){
            fre.put(num, fre.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for (int key : fre.keySet()){
            int val = fre.get(key);
            if (buckets[val] == null){
                buckets[val] = new ArrayList<Integer>();
            }
            buckets[val].add(key);
        }
        
        List<Integer> ret = new ArrayList<>();
        for (int i=buckets.length-1; ret.size() < k; i--){
            if (buckets[i] != null){
                ret.addAll(buckets[i]);
            }
        }
        
        return ret;
    }
}
