package util;

import datastructure.BiTree;
import datastructure.IBiList;

public class BiTreeListAdaptor<T> extends BiTree<T> implements IBiList<T>{

	public BiTreeListAdaptor(T content, BiTree<T> leftChild,
			BiTree<T> rightChild) {
		super(content, leftChild, rightChild);		
	}

	@Override
	public IBiList<T> getPre() {
		return (BiTreeListAdaptor<T>) getLeft();
	}

	@Override
	public IBiList<T> getNext() {
		return (BiTreeListAdaptor<T>) getRight();
	}

}
