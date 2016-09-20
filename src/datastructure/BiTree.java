package datastructure;

public class BiTree<T>{
	private BiTree<T> left, right;
	private T data;
	
	public BiTree (T content, BiTree<T> leftChild, BiTree<T> rightChild){
		this.left = leftChild;
		this.right = rightChild;
		this.setData(content);
	}

	public BiTree<T> getLeft() {
		return left;
	}

	public void setLeft(BiTree<T> left) {
		this.left = left;
	}

	public BiTree<T> getRight() {
		return right;
	}

	public void setRight(BiTree<T> right) {
		this.right = right;
	}

	public T getData() {		
		return data;
	}

	public void setData(T content) {
		this.data = content;
	}

}
