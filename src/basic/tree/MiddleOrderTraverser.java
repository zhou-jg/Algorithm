package basic.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

import util.Algorithm;
import datastructure.BiTree;

public class MiddleOrderTraverser {

	/**
	 * 递归中序遍历，加返回值只是为了方便测试
	 * @param root
	 * @return
	 */
	@Algorithm
	public static List<Integer> traverse(BiTree<Integer> root){
		Objects.requireNonNull(root);
		List<Integer> result = new ArrayList<Integer>();
		recursiveTraverse(root, result);
		return result;
	}
	
	/**
	 * 非递归中序遍历
	 * @param root
	 * @return
	 */
	@Algorithm
	public static List<Integer> traverseWithoutRecursion(BiTree<Integer> root){
		Objects.requireNonNull(root);
		
		List<Integer> result = new ArrayList<Integer>();
		Deque<BiTree<Integer>> stack = new ArrayDeque<BiTree<Integer>>();
		
		BiTree<Integer> node = root;		
		while (node != null){
			stack.offerFirst(node);
			node = node.getLeft();
		}
		while(!stack.isEmpty()){
			node = stack.pollFirst();
			result.add(node.getData());
			node = node.getRight();			
			while (node != null){
				stack.offerFirst(node);
				node = node.getLeft();
			}
		}
		
		return result;
	}

	private static void recursiveTraverse(BiTree<Integer> root, List<Integer> result) {
		if (root.getLeft() != null){
			recursiveTraverse(root.getLeft(), result);
		}
		result.add(root.getData());
		if (root.getRight() != null){
			recursiveTraverse(root.getRight(), result);
		}
	}
}
