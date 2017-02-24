package basic.tree;

import datastructure.TreeNode;
import util.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Source：<a href="https://leetcode.com/problems/binary-tree-right-side-view/">
 *     https://leetcode.com/problems/binary-tree-right-side-view/</a>
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 * \     \
 *  5     4        <---
 * You should return [1, 3, 4].
 *
 * Created by zhou-jg on 2017/2/24.
 */
public class RightSideView {
    int depth = 0;

    @Algorithm("二叉树")
    @Algorithm("深度优先遍历")
    @Algorithm("递归")
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root != null){
            traverseLevelFromRight(ret, root, 1);
        }
        return ret;
    }

    private void traverseLevelFromRight (List<Integer> ret, TreeNode node, int level){
        if (level > depth){
            ret.add(node.val);
            depth = level;
        }
        if (node.right != null){
            traverseLevelFromRight(ret, node.right, level+1);
        }
        if (node.left != null){
            traverseLevelFromRight(ret, node.left, level+1);
        }
    }
}
