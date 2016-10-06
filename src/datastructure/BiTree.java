package datastructure;

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
}
