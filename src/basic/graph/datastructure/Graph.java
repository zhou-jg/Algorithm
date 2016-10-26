package basic.graph.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 图数据结构
 * @author Jingang Zhou
 *
 * @param <V> 节点数据类型
 * @param <E> 边数据类型
 */
public class Graph<V, E> {

	//节点列表
	protected List<Vertex<V>> vertices;
	//边列表
	protected List<Edge<E>> edges;
	
	public Graph(){
		vertices = new ArrayList<Vertex<V>>();
		edges = new ArrayList<Edge<E>>();
	}
	
	/**
	 * @return 节点迭代器
	 */
	public Iterator<Vertex<V>> vertices(){
		return vertices.iterator();
	}
	
	/**
	 * @return 边迭代器
	 */
	public Iterator<Edge<E>> edges(){
		return edges.iterator();
	}
	
	/**
	 * 插入一个节点
	 * @param vertex
	 * @return 节点的索引
	 */
	public int insert(Vertex<V> vertex){
		vertices.add(vertex);
		return vertices.size()-1;
	}
	
	/**
	 * 插入一条边
	 * @param edge
	 * @return 边的索引
	 */
	public int insert(Edge<E> edge){
		edges.add(edge);
		return edges.size()-1;
	}
	
	/**
	 * @return 节点数目
	 */
	public int getVertexNumber(){
		return vertices.size();
	}
	
	/**
	 * @return 边数目
	 */
	public int getEdgeNumber(){
		return edges.size();
	}
	
	/**
	 * @param u 尾节点
	 * @param v 头节点
	 * @return 是否存在边(u, v)
	 */
	public boolean isAdjacent(Vertex<?> u, Vertex<?> v){
		return u.isAdjacent(v);
	}
	
	/**
	 * 删除指定的节点
	 * @param v
	 */
	public void remove(Vertex<?> v){
		vertices.remove(v);
					
		//删除以v为头的边
		for(Edge<?> edge : v.inEdges()){
			remove(edge);
		}
		//删除以v为尾的边
		for(Edge<?> edge: v.outEdges()){
			remove(edge);
		}
		
	}
	
	/**
	 * 删除指定的边
	 * @param e
	 */
	public void remove(Edge<?> e){
		edges.remove(e);
		
		e.getHead().inEdges().remove(e);
		e.getTail().outEdges().remove(e);		
	}
}
