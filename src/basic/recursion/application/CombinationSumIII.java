package basic.recursion.application;

import util.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Source: <a href="https://leetcode.com/problems/combination-sum-iii/">
 *     https://leetcode.com/problems/combination-sum-iii/</a>
 *
 * <p>Find all possible combinations of <i><b>k</b></i> numbers that add
 * up to a number <i><b>n</b></i>, given that only numbers from 1 to 9 can
 * be used and each combination should be a unique set of numbers.
 *
 * <p><b>Example 1:</b></p>
 * Input: <b><i>k</i></b> = 3, <i><b>n</b></i> = 7<br>
 * Output: <code>[[1,2,4]]</code>
 *
 * <p><b>Example 2:</b></p>
 * Input: <b><i>k</i></b> = 3, <i><b>n</b></i> = 9<br>
 * Output: <code>[[1,2,6], [1,3,5], [2,3,4]]</code>
 *
 * <p>Created by zhou-jg on 2017/2/20.
 */
public class CombinationSumIII {
    @Algorithm("递归")
    @Algorithm("回溯")
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (!isValid(k, n)){
            return Collections.emptyList();
        }
        int a = n/k;
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=a; i++){
            traverse(ret, list, i, k, n);
        }

        return ret;
    }

    private void traverse(List<List<Integer>> ret, List<Integer> list, int val, int k, int n){
        list.add(val);
        if (list.size() == k){
            if (sum(list) == n){
                ret.add(new ArrayList<>(list));
            }
        }else{
            for (int i=val+1; i<=Math.min(n, 9); i++){
                traverse(ret, list, i, k, n);
            }
        }
        list.remove(list.size()-1);
    }

    private boolean isValid(int k, int n){
        if (k > 9){
            return false;
        }
        int max = 0, val = 9;
        for (int i=1;i<=k;i++){
            max += val;
            val--;
        }
        return max >= n;
    }

    private int sum(List<Integer> list){
        int sum = 0;
        for (int n : list){
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args){
        CombinationSumIII c = new CombinationSumIII();
        System.out.println(c.combinationSum3(3, 7));
    }
}
