package datastructure;

import java.util.ArrayList;
import java.util.List;

import util.Algorithm;

public class BiTree<T>{
	private BiTree<T> left, right;
	private T data;
	
	public BiTree (T content, BiTree<T> leftChild, BiTree<T> rightChild){
		this.left = leftChild;
		this.right = rightChild;
		this.setData(content);
	}
	
	public BiTree(T content){
		this(content, null, null);
	}

	public BiTree<T> getLeft() {
		return left;
	}

	public BiTree<T> setLeft(BiTree<T> left) {
		this.left = left;
		return this;
	}

	public BiTree<T> getRight() {
		return right;
	}

	public BiTree<T> setRight(BiTree<T> right) {
		this.right = right;
		return this;
	}

	public T getData() {		
		return data;
	}

	public void setData(T content) {
		this.data = content;
	}

	@Override
	public String toString(){
		return data.toString();
	}
	
	/**
	 * 按照层次依序构造完全二叉树
	 * @param data 给定的数据
	 * @return 二叉树的根节点
	 */
	@Algorithm("树")
	public static <T> BiTree<T> buildTree(T[] data){
		if (data == null || data.length == 0){
			return null;
		}
		List<BiTree<T>> tree = new ArrayList<BiTree<T>>(data.length);
		for (int i=0; i<data.length; i++){
			tree.add(new BiTree<T>(data[i]));
		}
		for (int i=0; i<data.length/2; i++){
			tree.get(i).setLeft(tree.get(2*i+1));
			if (2*i+2 <= data.length-1){
				tree.get(i).setRight(tree.get(2*i+2));
			}
		}
		return tree.get(0);
	}
}
