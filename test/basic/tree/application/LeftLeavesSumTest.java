package basic.tree.application;

import datastructure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/27.
 */
public class LeftLeavesSumTest {
    LeftLeavesSum s = new LeftLeavesSum();

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode node = new TreeNode(20);
        root.right = node;
        node.left = new TreeNode(15);
        node.right = new TreeNode(7);

        assertEquals(24, s.sumOfLeftLeaves(root));
    }
}