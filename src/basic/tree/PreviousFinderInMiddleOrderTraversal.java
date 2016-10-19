package basic.tree;

import datastructure.BiTreeNodeEx;

public class PreviousFinderInMiddleOrderTraversal {
	
	/**
	 * 返回指定节点在树的中序遍历下的直接前趋节点。
	 * @param node 指定节点
	 * @return
	 * @exception NullPointerException 如果给定节点为空
	 */
	public static <T> BiTreeNodeEx<T> find(BiTreeNodeEx<T> node){
		BiTreeNodeEx<T> lChild = node.getLeft();
		if (lChild != null){
			BiTreeNodeEx<T> tmp = lChild;
			while (tmp.getRight() != null){
				tmp = tmp.getRight();
			}
			return tmp;
		}
		BiTreeNodeEx<T> parent = node.getParent();
		if (parent != null){
			BiTreeNodeEx<T> tmp = node;
			while (parent != null && tmp == parent.getLeft()){
				tmp = parent;
				parent = parent.getParent();
			}
			return tmp.getParent();
		}
		return null;
	}

}
