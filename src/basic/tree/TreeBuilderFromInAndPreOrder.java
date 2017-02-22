package basic.tree;

import datastructure.TreeNode;
import util.Algorithm;

/**
 * Source: <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?tab=Description">
 *     https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/</a>
 *
 * <p>Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * <p><b>Note:</b> You may assume that duplicates do not exist in the tree.
 *
 * <p>Created by zhou-jg on 2017/2/22.
 */
public class TreeBuilderFromInAndPreOrder {
    /**
     * @see TreeBuilderFromInAndPostOrder#buildTree(int[], int[])
     */
    @Algorithm("递归")
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length ==0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int i=0;
        while(inorder[i] != preorder[0]){
            i++;
        }
        int[] leftIn = new int[i], rightIn = new int[inorder.length-i-1];
        System.arraycopy(inorder, 0, leftIn, 0, i);
        System.arraycopy(inorder, i+1, rightIn, 0, inorder.length-i-1);
        int[] leftPre = new int[i], rightPre = new int[inorder.length-i-1];
        System.arraycopy(preorder, 1, leftPre, 0, i);
        System.arraycopy(preorder, 1+i, rightPre, 0, inorder.length-i-1);
        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);

        return root;
    }
}
