package basic.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

import util.Algorithm;
import datastructure.BiTree;

public class PostOrderTraverser {
	
	/**
	 * 后序递归算法
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
	 * 后序非递归遍历
	 * @param root
	 * @return
	 */
	@Algorithm
	public static List<Integer> traverseWithoutRecursion(BiTree<Integer> root){
		Objects.requireNonNull(root);
		
		List<Integer> result = new ArrayList<Integer>();
		Deque<BiTree<Integer>> stack = new ArrayDeque<BiTree<Integer>>();
		
		BiTree<Integer> node = root;
		//记录前次访问的节点，对于首次访问的右子树，需要初始化为null
		BiTree<Integer> tmp = null;
		//是否需要访问左子树。 true:是；false：否
		boolean flag = true;
		
		stack.offerFirst(node);
		while(!stack.isEmpty()){
			node = stack.peekFirst();			
			while (node != null  && flag){
				if ((node = node.getLeft()) != null){				
					stack.offerFirst(node);				
				}
			}
						
			if (stack.peekFirst().getRight() == tmp){
				tmp = stack.pollFirst();
				result.add(tmp.getData());				
				flag = false;
			}else{
				if (stack.peekFirst().getRight() != null){
					stack.offerFirst(stack.peekFirst().getRight());
					flag = true;
				}else{
					flag = false;
				}
				tmp = null;
			}
		}
		
		return result;
	}

	private static void internalTraverse(BiTree<Integer> node, List<Integer> list) {
		if (node.getLeft() != null){
			internalTraverse(node.getLeft(), list);
		}
		if (node.getRight() != null){
			internalTraverse(node.getRight(), list);
		}
		list.add(node.getData());
	}
	
}
