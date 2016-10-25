package basic.graph.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph {

	//节点列表
	protected List<Vertex<?>> vertices;
	//边列表
	protected List<Edge<?>> edges;
	
	public Graph(){
		vertices = new ArrayList<Vertex<?>>();
		edges = new ArrayList<Edge<?>>();
	}
	
	/**
	 * @return 节点迭代器
	 */
	public Iterator<Vertex<?>> vertices(){
		return vertices.iterator();
	}
	
	/**
	 * 插入一个节点
	 * @param vertex
	 * @return 节点的索引
	 */
	public int insert(Vertex<?> vertex){
		vertices.add(vertex);
		return vertices.size()-1;
	}
	
	/**
	 * 插入一条边
	 * @param edge
	 * @return 边的索引
	 */
	public int insert(Edge<?> edge){
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
