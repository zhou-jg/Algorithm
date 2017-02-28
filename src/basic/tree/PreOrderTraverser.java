package basic.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

import datastructure.TreeNode;
import util.Algorithm;
import datastructure.BiTree;

public class PreOrderTraverser {
	
	/**
	 * 前序递归遍历
	 * @param root
	 * @return
	 */
	@Algorithm
	public static List<Integer> traverse(BiTree<Integer> root){
		Objects.requireNonNull(root);
		
		List<Integer> result = new ArrayList<Integer>();
		internalTraverse(root, result);
		return result;
	}
	
	/**
	 * 前序非递归遍历
	 * @param root
	 * @return
	 */
	@Algorithm
	public static List<Integer> traverseWithoutRecursion(BiTree<Integer> root){
		Objects.requireNonNull(root);
		
		List<Integer> result = new ArrayList<Integer>();
		Deque<BiTree<Integer>> stack = new ArrayDeque<BiTree<Integer>>();
		
		stack.offerFirst(root);
		BiTree<Integer> node;
		while (!stack.isEmpty()){
			node = stack.pollFirst();
			result.add(node.getData());
			if (node.getRight() != null){
				stack.offerFirst(node.getRight());
			}
			if (node.getLeft() != null){
				stack.offerFirst(node.getLeft());
			}
		}
		return result;
	}

	/**
	 * Ref : http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
	 * 步骤：
	 * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
	 * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
	 * 	a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。输出当前节点（在这里输出，
	 * 		这是与中序遍历唯一一点不同）。当前节点更新为当前节点的左孩子。
	 * 	b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空。当前节点更新为当前节点的右孩子。
	 * 3. 重复以上1、2直到当前节点为空。
	 *
	 * @param root
	 * @return
	 * @see MiddleOrderTraverser#Morris(BiTree)
     */
	@Algorithm(value = "非递归", text = "空间O(1)")
	public List<Integer> Morris(BiTree<Integer> root){
		List<Integer> ret = new ArrayList<>();
		BiTree<Integer> cur = root, prev = null;
		while (cur != null){
			if (cur.getLeft() == null){
				ret.add(cur.getData());
				cur = cur.getRight();
			}else {
				prev = cur.getLeft();
				while (prev.getRight() != null && prev.getRight() != cur) {
					prev = prev.getRight();
				}
				if (prev.getRight() == null){
					ret.add(cur.getData());
					prev.setRight(cur);
					cur = cur.getLeft();
				}else {
					prev.setRight(null);
					cur = cur.getRight();
				}
			}
		}

		return ret;
	}
	
	private static void internalTraverse(BiTree<Integer> node, List<Integer> list){
		list.add(node.getData());
		if (node.getLeft() != null){
			internalTraverse(node.getLeft(), list);
		}
		if (node.getRight() != null){
			internalTraverse(node.getRight(), list);
		}
	}
}
