package basic.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

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
