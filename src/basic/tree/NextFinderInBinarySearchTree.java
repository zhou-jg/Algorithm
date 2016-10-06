package basic.tree;

import datastructure.BiTreeNodeEx;

/**
 * 找出二叉查找树中给定节点的后继节点
 * @author Jingang Zhou
 *
 */
public class NextFinderInBinarySearchTree {

	/**
	 * 查找中序遍历中给定节点的后续节点。一共三种情况：
	 * <ol>给定的节点有右子树，则后继是右子树的最左叶子，如果该右子树没用左子树，则后继即为该右子树的根节点</ol>
	 * <ol>给定的节点是父节点的左子树，则后继是父节点</ol>
	 * <ol>给定的节点是父节点的右子树，则后继要一直顺着父节点向上，直到某个父节点是其父节点的左子树，则后继
	 * 就是该父节点的父节点。</ol>
	 * 否则没用后继。
	 * @param node
	 * @return
	 */
	public static BiTreeNodeEx<?> findNext(BiTreeNodeEx<?> node){
		//判断node是否有右子树，如果有，则返回右子树中序遍历的第一个节点
		BiTreeNodeEx<?> rChild = node.getRight();
		if (rChild != null){
			BiTreeNodeEx<?> lChild = rChild;
			while(lChild.getLeft() != null){
				lChild = lChild.getLeft();
			}
			return lChild == null? rChild : lChild;
		}
		//判断node是否是父节点的左子树，如果是，则返回父节点
		if (node.getParent()!=null){
			if (node==node.getParent().getLeft()){
				return node.getParent();
			}else{
				//是父亲的右子树
				BiTreeNodeEx<?> parent = node.getParent();
				while(parent.getParent()!=null){
					if (parent == parent.getParent().getLeft()){
						return parent.getParent();
					}
					parent = parent.getParent();
				}
			}
		}
		
		return null;
	}
}
