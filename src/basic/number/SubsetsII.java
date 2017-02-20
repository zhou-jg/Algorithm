package basic.number;

import java.util.*;

/**
 * Source: <a href="https://leetcode.com/problems/subsets-ii/?tab=Description">
 *     https://leetcode.com/problems/subsets-ii/?tab=Description</a>
 *
 * <p>Given a collection of integers that might contain duplicates,
 * <b><i>nums</i></b>, return all possible subsets.
 *
 * <p><b>Note:</b> The solution set must not contain duplicate subsets.
 *
 * <p>For example,</p>
 * <p>If <b><i>nums</i></b> = <code>[1,2,2]</code>, a solution is:
 * <pre>
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]</pre>
 *
 * <p>Created by zhou-jg on 2017/2/20.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null){
            return Collections.emptyList();
        }
        Set<List<Integer>> set = new HashSet<>();
        set.add(new ArrayList<>());
        for (int i=0; i<nums.length; i++){
            addList(set, nums[i]);
        }
        return new ArrayList<>(set);
    }

    private void addList(Set<List<Integer>> set, int num){
        Set<List<Integer>> tmp = new HashSet<>();
        for (List<Integer> list : set){
            List<Integer> newList = new ArrayList<>(list);
            newList.add(num);
            //avoid dup due to list
            Collections.sort(newList);
            tmp.add(newList);
        }
        set.addAll(tmp);
    }
}
