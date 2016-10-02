package datastructure;

import java.util.ArrayList;

/**
 * 图节点
 * @author Jingang Zhou
 *
 */
public class GNode<T> {
	private T data;
	private java.util.List<GNode<T>> adjacents = new ArrayList<>();
	public GNode(T t){
		data = t;
	}
	
	/**
	 * 
	 * @param node
	 * @return 当前对象
	 */
	public GNode<T> addAdjacent(GNode<T> node){
		adjacents.add(node);
		return this;
	}
	
	public java.util.List<GNode<T>> getAdjacents(){
		return adjacents;
	}
	
	public T getData(){
		return data;
	}
}
