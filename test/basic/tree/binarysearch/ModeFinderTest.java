package basic.tree.binarysearch;

import datastructure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/28.
 */
public class ModeFinderTest {
    ModeFinder finder = new ModeFinder();

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.left = new TreeNode(2);

        assertArrayEquals(new int[]{2}, finder.findMode(root));
    }
}