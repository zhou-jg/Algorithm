package basic.tree;

import datastructure.TreeNode;
import util.Algorithm;

import java.util.*;

/**
 * Traverse tree by level from top to bottom and from left to right.
 * Which is a kind of BFS of graph.
 *
 * Created by zhou-jg on 2017/2/27.
 */
public class LevelTraverser {
    /**
     * @see  basic.graph.BreadthFirstTraverser
     */
    @Algorithm("队列")
    public List<Integer> traverse (TreeNode root){
        List<Integer> ret = new ArrayList<>();
        if (root != null){
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                ret.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return ret;
    }
}
