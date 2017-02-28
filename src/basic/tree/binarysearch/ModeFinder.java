package basic.tree.binarysearch;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: https://leetcode.com/problems/find-mode-in-binary-search-tree/?tab=Description
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s)
 * (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than or
 * equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than
 * or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * For example:
 * Given BST [1,null,2,2],
 *      1
 *      \
 *      2
 *     /
 *    2
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that
 * the implicit stack space incurred due to recursion does not count).
 * 
 * Created by zhou-jg on 2017/2/28.
 */
public class ModeFinder {
    public int[] findMode(TreeNode root) {
        int[] nums = new int[3];
        findModeNum(root, nums);
        if (nums[2]>nums[0]){
            nums[0] = nums[2];
        }
        List<Integer> ret = new ArrayList<>();
        nums[1]=root.val;
        nums[2]=0;
        findMode(root, nums, ret);
        if (nums[2]==nums[0]){
            ret.add(nums[1]);
        }
        int[] r = new int[ret.size()];
        for (int i=0; i<r.length; i++){
            r[i] = ret.get(i);
        }
        return r;
    }

    private void findModeNum(TreeNode node, int[] nums){
        if (node.left != null){
            findModeNum(node.left, nums);
        }
        if (node.val == nums[1]){
            nums[2] += 1;
        }else{
            if (nums[2] > nums[0]){
                nums[0] = nums[2];
            }
            nums[1] = node.val;
            nums[2] = 1;
        }
        if (node.right != null){
            findModeNum(node.right, nums);
        }
    }

    private void findMode(TreeNode node, int[] nums, List<Integer> ret){
        if (node.left != null){
            findMode(node.left, nums, ret);
        }
        if (node.val == nums[1]){
            nums[2] += 1;
        }else{
            if (nums[2] == nums[0]){
                ret.add(nums[1]);
            }
            nums[1] = node.val;
            nums[2] = 1;
        }
        if (node.right != null){
            findMode(node.right, nums, ret);
        }
    }

}
