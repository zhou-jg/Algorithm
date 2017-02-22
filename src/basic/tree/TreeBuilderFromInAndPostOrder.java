package basic.tree;

import datastructure.TreeNode;
import util.Algorithm;

/**
 * Source：<a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/?tab=Description">
 *     https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/</a>
 *
 * <p>Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * <p><b>Note:</b> You may assume that duplicates do not exist in the tree.
 *
 * <p>Created by zhou-jg on 2017/2/22.
 */
public class TreeBuilderFromInAndPostOrder {
    @Algorithm("递归")
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int i=0;
        while(inorder[i] != postorder[postorder.length-1]){
            i++;
        }
        int[] leftIn = new int[i], rightIn = new int[inorder.length-i-1];
        System.arraycopy(inorder, 0, leftIn, 0, i);
        System.arraycopy(inorder, i+1, rightIn, 0, inorder.length-i-1);
        int[] leftPost = new int[i], rightPost = new int[rightIn.length];
        System.arraycopy(postorder, 0, leftPost, 0, i);
        System.arraycopy(postorder, i, rightPost, 0, rightPost.length);
        root.left = buildTree(leftIn, leftPost);
        root.right = buildTree(rightIn, rightPost);

        return root;
    }
}
