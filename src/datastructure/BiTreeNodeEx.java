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
	}
	public BiTreeNodeEx<T> getParent() {
		return parent;
	}

	public void setParent(BiTreeNodeEx<T> parent) {
		this.parent = parent;
	}	
	
}
