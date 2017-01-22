package basic.tree.application;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: https://leetcode.com/problems/path-sum-ii/
 * 
 * <p>Given a binary tree and a sum, find all root-to-leaf paths 
 * where each path's sum equals the given sum.
 * <p>For example: Given the below binary tree and sum = 22,<br>
             ------ 5<br>
             ------/ \<br>
             -----4 - 8<br>
             ----/---/ \<br>
             --11  13 - 4<br>
             --/ \------/ \<br>
             -7--2----5---1
 *<p>return<br>
 * [
    [5,4,11,2],
    [5,8,4,5]
 * ]
 * 
 * @author Jingang Zhou
 */
public class PathForGivenSumFromRootToLeaf {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        List<Integer> list = new ArrayList<>();
        helper(root, sum, ret, list);
        return ret;
    }
    
    private void helper(TreeNode node, int sum, List<List<Integer>> ret, List<Integer> list){
        list.add(node.val);
        if (node.left == null && node.right == null){
            int total = 0;
            for (int num : list){
                total += num;
            }
            if (total == sum){
                ret.add(new ArrayList<Integer>(list));
            }
        }else{
            if (node.left != null){
                helper(node.left, sum, ret, list);
            }
            if (node.right != null){
                helper(node.right, sum, ret, list);
            }
        }
        list.remove(list.size()-1);
    }
}
