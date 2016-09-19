package util.datastructure;

public class TreeNode<T> {
	private TreeNode<T> left, right, parent;
	private T content;
	
	public TreeNode (T content, TreeNode<T> leftChild, TreeNode<T> rightChild, TreeNode<T> parent){
		this.left = leftChild;
		this.right = rightChild;
		this.parent = parent;
		this.content = content;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
	
}
