package basic.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import datastructure.BiTree;
import util.Algorithm;

/**
 * 检查二叉树是否平衡，即任意节点的两颗子树的高度差不超过1。
 * 
 * @author Jingang Zhou
 *
 */
public class BalancedBinaryTreeChecker {
	
	/**
	 * 通过非递归后续遍历来检查二叉树是否平衡。相比递归算法，可以减少存储空间，
	 * 而且减少向顶层逐级返回的调用次数。因为，在非递归算法中，如果发现某个节点
	 * 不平衡，就直接可以返回结果。
	 * @param root
	 * @return
	 */
	@Algorithm
	public static boolean check(BiTree<?> root){
		
		Deque<BiTree<?>> stack = new ArrayDeque<BiTree<?>>();
		
		BiTree<?> node = root;
		//记录前次访问的节点，对于首次访问的右子树，需要初始化为null
		BiTree<?> tmp = null;
		//是否需要访问左子树。 true:是；false：否
		boolean flag = true;
		//存储已访问节点（左右子树）的高度值
		Map<BiTree<?>, Integer> node2Height = new HashMap<>();
		
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
				//判断当前节点的是否平衡
				int hLeft = node2Height.containsKey(tmp.getLeft())? node2Height.get(tmp.getLeft()) : 0;
				int hRight = node2Height.containsKey(tmp.getRight())? node2Height.get(tmp.getRight()) : 0;
				if (Math.abs(hLeft - hRight) > 1){
					return false;
				}else{
					node2Height.put(tmp, 1 + Math.max(hLeft, hRight));
					//可以删除Map中左右子树节点信息，因为已经没用了
				}
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
		
		return true;
	}
	
	/**
	 * 检查二叉树是否平衡的递归算法
	 * @param root
	 * @return
	 */
	@Algorithm
	public static boolean checkWithRecursion(BiTree<?> root){
		if (height(root) == -1){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 判断是否平衡
	 * @param node
	 * @return 节点的高度；-1 表示节点不平衡
	 */
	private static int height(BiTree<?> node){
		if (node == null){
			return 0;
		}
		int hLeft = height(node.getLeft());
		if (hLeft == -1){
			return -1;
		}
		int hRight = height(node.getRight());
		if (hRight == -1){
			return -1;
		}
		if (Math.abs(hLeft - hRight) > 1){
			return -1;
		}else{
			return 1+Math.max(hLeft, hRight);
		}
	}
}
