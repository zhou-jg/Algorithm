package basic.tree;

import util.Algorithm;
import util.BiTreeListAdaptor;
import datastructure.IBiList;

public class BiTree2BiListTransformer<T> {
		
	private BiTreeListAdaptor<T> tmp = null;
	/**
	 * 从一个二叉排序树得到一个排序好的双向链表，不引入其它数据结构
	 * TODO: 非线程安全，因此可能需要把转变的参数通过构造函数来传递
	 * @param tree 一个二叉排序树
	 * @return 排序好的双向链表
	 */
	@Algorithm
	public IBiList<T> transform(BiTreeListAdaptor<T> tree){
		midorder(tree);
		return tree;
	}
	
	private void midorder(BiTreeListAdaptor<T> tree){
		if (tree.getLeft() != null){
			midorder((BiTreeListAdaptor<T>) tree.getLeft());
		}		
		if (tmp != null){
			tmp.setRight(tree);
			tree.setLeft(tmp);
		}
		tmp = tree;
		if (tree.getRight() != null){
			midorder((BiTreeListAdaptor<T>)tree.getRight());
		}
	}
}
