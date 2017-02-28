package basic.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

import datastructure.TreeNode;
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

	/**
	 * 步骤：
	 * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
	 * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
	 * 	a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
	 * 	b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。
	 * 		当前节点更新为当前节点的右孩子。
	 * 3. 重复以上1、2直到当前节点为空。
	 *
	 * @param root
	 * @return
     */
	@Algorithm(value = "非递归", text="O(1)")
	public List<Integer> Morris(BiTree<Integer> root){
		List<Integer> ret = new ArrayList<>();
		BiTree<Integer> cur = root, pre = null;
		while (cur != null){
			if (cur.getLeft() == null){
				ret.add(cur.getData());
				cur = cur.getRight();
			}else{
				//find predecessor
				pre = cur.getLeft();
				while (pre.getRight() != null && pre.getRight() != cur){
					pre = pre.getRight();
				}
				if (pre.getRight() == null){//2. a)
					pre.setRight(cur);
					cur = cur.getLeft();
				}else {//2. b)
					pre.setRight(null);
					ret.add(cur.getData());
					cur = cur.getRight();
				}
			}
		}

		return ret;
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
