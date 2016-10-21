package basic.tree;

import util.Algorithm;
import datastructure.BiTreeNodeEx;

/**
 * 二叉查找树的插入
 * @author Jingang Zhou
 *
 */
public class BinarySearcheTreeInserter {

	/**
	 * 以递归方式将指定的节点插入二叉树
	 * @param root 二叉树的根节点
	 * @param node 指定节点，不能为空
	 * @return 二叉树的根节点
	 */
	@Algorithm("二叉树")
	@Algorithm("递归")
	public static <T extends Comparable<T>> BiTreeNodeEx<T> insert(BiTreeNodeEx<T> root, T node){
		if (root == null){
			root = new BiTreeNodeEx<T>(node, null, null, null);
			return root;
		}
		if (root.getData().compareTo(node) < 0){
			if (root.getRight() != null){
				insert(root.getRight(), node);
			}else{
				root.setRight(new BiTreeNodeEx<T>(node, null, null, root));
			}
		}else{
			if (root.getLeft() != null){
				insert(root.getLeft(), node);
			}else{
				root.setLeft(new BiTreeNodeEx<T>(node, null, null, root));
			}
		}
		return root;
	}
	
	/**
	 * 以迭代方式将指定的节点插入二叉树
	 * @param root 二叉树的根节点
	 * @param node 指定节点，不能为空
	 * @return 二叉树的根节点
	 */
	@Algorithm("二叉树")
	@Algorithm("迭代")
	public static <T extends Comparable<T>> BiTreeNodeEx<T> insertIteratively(BiTreeNodeEx<T> root, T node){
		if (root == null){
			root = new BiTreeNodeEx<T>(node, null, null, null);
			return root;
		}
		BiTreeNodeEx<T> tmp = root;
		while (tmp != null){
			if (tmp.getData().compareTo(node) < 0){
				if (tmp.getRight() == null){
					tmp.setRight(new BiTreeNodeEx<T>(node, null, null, tmp));
					return root;
				}else{
					tmp = tmp.getRight();
				}
			}else{
				if (tmp.getLeft() == null){
					tmp.setLeft(new BiTreeNodeEx<T>(node, null, null, tmp));
					return root;
				}else{
					tmp = tmp.getLeft();
				}
			}
		}
		return root;
	}
}
