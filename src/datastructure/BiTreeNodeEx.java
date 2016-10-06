package datastructure;

/**
 * 带有指向父节点引用的二叉树节点
 * @author Jingang Zhou
 *
 * @param <T>
 */
public class BiTreeNodeEx<T> extends BiTree<T> {
	private BiTreeNodeEx<T> parent;	

	public BiTreeNodeEx (T content, BiTreeNodeEx<T> leftChild, BiTreeNodeEx<T> rightChild, BiTreeNodeEx<T> parent){
		super(content, leftChild, rightChild);
		this.parent = parent;
		setLeft(leftChild);
		setRight(rightChild);
	}
	public BiTreeNodeEx<T> getParent() {
		return parent;
	}

	public void setParent(BiTreeNodeEx<T> parent) {
		this.parent = parent;
	}	
	
	@Override
	public BiTreeNodeEx<T> getLeft() {
		return (BiTreeNodeEx<T>)super.getLeft();
	}
	
	@Override
	public BiTreeNodeEx<T> getRight() {
		return (BiTreeNodeEx<T>)super.getRight();
	}
		
	public BiTreeNodeEx<T> setLeft(BiTreeNodeEx<T> left) {
		super.setLeft(left);
		if (left != null){
			left.setParent(this);
		}
		return this;
	}
	
	public BiTreeNodeEx<T> setRight(BiTreeNodeEx<T> right) {
		super.setRight(right);
		if (right != null){
			right.setParent(this);
		}
		return this;
	}
}
