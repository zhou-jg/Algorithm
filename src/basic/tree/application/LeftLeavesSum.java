package basic.tree.application;

import datastructure.TreeNode;

/**
 * Source: https://leetcode.com/problems/sum-of-left-leaves/?tab=Description
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15  7
 *
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 *
 * Created by zhou-jg on 2017/2/27.
 */
public class LeftLeavesSum {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        int[] sum = new int[]{0};
        treeHelper(root, sum);
        return sum[0];
    }

    private void treeHelper(TreeNode root, int[] sum){
        if (root.left != null){
            if (root.left.left == null && root.left.right == null){
                sum[0] += root.left.val;
            }else{
                treeHelper(root.left, sum);
            }
        }
        if (root.right != null){
            treeHelper(root.right, sum);
        }
    }
}
