package basic.tree;

import java.util.ArrayDeque;
import java.util.Deque;

import datastructure.BiTree;

/**
 * 查找二叉树中指定的两个节点的最小公共长辈
 * @author Jingang Zhou
 *
 */
public class LeastCommonAncestorFinder {

	/**
	 * 获得指定节点的最小公共祖先
	 * @param root 二叉树的根节点
	 * @param u 指定的节点之一
	 * @param v 指定的节点之一
	 * @return 指定节点的最小公共祖先
	 */
	public static <T> BiTree<T> find(BiTree<T> root, BiTree<T> u, BiTree<T> v){
		if (root == null || u == null || v == null){
			return null;
		}
		if (u==v){
			return findParent(root, u);
		}
		//找到u所在的祖先链
		Deque<BiTree<T>> us = findAncestors(root, u);
		if (us.isEmpty()){
			return null;
		}
		//找到v所在的祖先链
		Deque<BiTree<T>> vs = findAncestors(root, v);
		if (vs.isEmpty()){
			return null;
		}
		Deque<BiTree<T>> longer = us.size() > vs.size()? us : vs;
		Deque<BiTree<T>> smaller = us.size() > vs.size()? vs : us;
		while (longer.size() > smaller.size()){
			longer.poll();
		}
		while(longer.size() > 0){
			if (longer.peek() == smaller.peek()){
				return longer.poll();
			}else{
				longer.poll();
				smaller.poll();
			}
		}
		return null;//Wrong to be here.
	}
	
	private static <T> BiTree<T> findParent(BiTree<T> root, BiTree<T> u){
		if (root==u){
			return root;
		}
		BiTree<T> parent = null;
		if (root.getLeft() != null){
			parent = findParent(root.getLeft(), u);
		}
		if (parent == null){
			if (root.getRight() != null){
				parent = findParent(root.getRight(), u);
			}
		}
		return parent;
	}
	
	/**
	 * 在指定的二叉树中找到指定节点的祖先链
	 * @param root 二叉树的根节点
	 * @param u 指定的节点
	 * @return 指定节点的祖先链栈，栈底是根节点，栈顶是指定的节点
	 */
	private static <T> Deque<BiTree<T>> findAncestors(BiTree<T> root, BiTree<T> u){
		Deque<BiTree<T>> deque = new ArrayDeque<BiTree<T>>();
		findAncestors(root, u, deque);
		return deque;
	}
	
	private static <T> boolean findAncestors(BiTree<T> root, BiTree<T> u, Deque<BiTree<T>> deque){
		deque.offerFirst(root);
		if (root == u){
			return true;
		}
		boolean found = false;
		if (root.getLeft() != null){
			found = findAncestors(root.getLeft(), u, deque); 
			if (found){
				return found;
			}
		}
		if (root.getRight() != null){
			found = findAncestors(root.getRight(), u, deque);
			if (found){
				return found;
			}
		}
		deque.pollFirst();
		return false;
	}
}
