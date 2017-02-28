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

	/**
	 * 后序非递归遍历，采用两个栈
	 * @param root
	 * @return
	 */
	@Algorithm
	public static List<Integer> traverseWithoutRecursionII(BiTree<Integer> root){
		Objects.requireNonNull(root);

		List<Integer> result = new ArrayList<>();
		Deque<BiTree<Integer>> stack = new ArrayDeque<>();
		Deque<BiTree<Integer>> output = new ArrayDeque<>();

		stack.offerFirst(root);
		output.offerFirst(root);
		BiTree<Integer> node = root;
		while (!output.isEmpty()) {
			while (node.getRight() != null) {
				stack.offerFirst(node.getRight());
				output.offerFirst(node.getRight());
				node = node.getRight();
			}
			while (!output.isEmpty()) {
				node = output.pollFirst();
				node = node.getLeft();
				if (node != null) {
					stack.offerFirst(node);
					output.offerFirst(node);
					break;
				}
			}
		}

		while (stack.size() > 0){
			result.add(stack.pollFirst().getData());
		}

		return result;
	}

	/**
	 * Ref: http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
	 *
	 * 后续遍历稍显复杂，需要建立一个临时节点dump，令其左孩子是root。并且还需要一个子过程，
	 * 就是倒序输出某两个节点之间路径上的各个节点。
	 *
	 * 步骤：
	 * 当前节点设置为临时节点dummy。
	 * 1. 如果当前节点的左孩子为空，则将其右孩子作为当前节点。
	 * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
	 * 	a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
	 * 	b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空。倒序输出从当前节点的左孩子到
	 * 		该前驱节点这条路径上的所有节点。当前节点更新为当前节点的右孩子。
	 * 3. 重复以上1、2直到当前节点为空。
	 *
	 * @param root
	 * @return
     */
	@Algorithm("空间O(1)")
	public List<Integer> Morris(BiTree<Integer> root){
		List<Integer> ret = new ArrayList<>();
		BiTree<Integer> dummy = new BiTree<Integer>(0, root, null);
		BiTree<Integer> cur = dummy, prev = null;
		while (cur != null){
			if (cur.getLeft() == null){
				cur = cur.getRight();
			}else {
				prev = cur.getLeft();
				while (prev.getRight() != null && prev.getRight() != cur){
					prev = prev.getRight();
				}
				if (prev.getRight() == null){
					prev.setRight(cur);
					cur = cur.getLeft();
				}else {
					printReverse(cur.getLeft(), prev, ret);
					prev.setRight(null);
					cur = cur.getRight();
				}
			}
		}

		return ret;
	}

	private void printReverse(BiTree<Integer> from, BiTree<Integer> to, List<Integer> ret) {
		reverse(from, to);
		BiTree<Integer> node = to;
		while (true){
			ret.add(node.getData());
			if (node == from){
				break;
			}
			node = node.getRight();
		}
		reverse(to, from);
	}

	private void reverse(BiTree<Integer> from, BiTree<Integer> to){
		if (from == to){
			return;
		}
		BiTree<Integer> n1 = from, n2 = from.getRight(), n3 = null;
		while (true){
			n3 = n2.getRight();
			n2.setRight(n1);
			n1 = n2;
			n2 = n3;
			if (n1 == to){
				break;
			}
		}
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
