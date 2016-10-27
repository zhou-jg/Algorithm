package basic.tree.binarysearch;

import java.util.ArrayDeque;
import java.util.Deque;

import datastructure.BiTree;

public class BinarySearchTreeChecker {

	/**
	 * 判断给定的二叉树是否是二叉查找树。
	 * 利用广度优先遍历逐层比较是否满足二叉查找树的定义。
	 * @param root
	 * @return
	 */
	public static <T extends Comparable<T>> boolean check(BiTree<T> root){
		Deque<BiTree<T>> queue = new ArrayDeque<>();
		queue.offerLast(root);
		while (!queue.isEmpty()){
			BiTree<T> node = queue.pollFirst();
			//与左子树进行比较
			BiTree<T> child = node.getLeft();			
			if (child != null){
				if (child.getData().compareTo(node.getData()) > 0){
					return false;
				}			
				queue.offerLast(child);
			}
			//与右子树进行比较
			child = node.getRight();
			if (child != null){
				if (child.getData().compareTo(node.getData()) <= 0){
					return false;
				}
				queue.offerLast(child);
			}
		}
		return true;
	}

}
