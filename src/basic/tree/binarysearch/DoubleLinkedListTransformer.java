package basic.tree.binarysearch;

import sun.reflect.generics.tree.Tree;
import util.Pair;

/**
 * 不用创建任何节点将一颗二叉排序树转成双向链表。
 * Created by zhou-jg on 2017/1/12.
 */
public class DoubleLinkedListTransformer {
    public static Pair<TreeNode> transform (TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode head = null, tail= null;
        transformHelper (head, tail, root);

        return new Pair<TreeNode>(head, tail);
    }

    private static void transformHelper(TreeNode head, TreeNode tail, TreeNode node){
        if (node == null){
            return;
        }
        transformHelper (head, tail, node.leftChild);
        if (head == null){
            head = node;
            tail = node;
        }else{
            tail.rightChild = node;
            node.leftChild = tail;
            tail = node;
        }
        TreeNode head2 = null, tail2 = null;
        transformHelper(head2, tail2, node.rightChild);
        if (head2 != null){
            tail.rightChild = head2;
            head2.leftChild = tail;
            tail = tail2;
        }
    }

    static class TreeNode {
        TreeNode leftChild, rightChild;
        int val;
    }
}
