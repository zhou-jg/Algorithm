package basic.graph.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	//顶点中存放的数据元素
	protected final T data;
	//在图的顶点列表中的索引
	protected int indexInGraph;
	//所有出边
	protected List<Edge<?>> outEdges;
	//所有入边
	protected List<Edge<?>> inEdges;
	//遍历过程中顶点的状态
	protected VertexStatus status;
	//遍历中被发现的时刻
	protected int dStamp;
	//遍历中结束访问（回溯）的时刻
	protected int fStamp;
	//到指定节点的距离
	protected int distance;
	//在最短距离树中的父亲
	protected Vertex<T> parent;
	
	public Vertex(Graph<T, ?> g, T data){
		this.data = data;
		indexInGraph = g.insert(this);
		outEdges = new ArrayList<Edge<?>>();
		inEdges = new ArrayList<Edge<?>>();
		status = VertexStatus.UNDISCOVERED;
		dStamp = fStamp = Integer.MAX_VALUE;
		distance = Integer.MAX_VALUE;
		parent = null;
	}
	
	/**
	 * @return 节点出度
	 */
	public int outDeg(){
		return outEdges.size();
	}
	
	/**
	 * @return 节点入度
	 */
	public int inDeg(){
		return inEdges.size();
	}
	
	/**
	 * @return 出边列表
	 */
	public List<Edge<?>> outEdges(){
		return outEdges;
	}
	
	/**
	 * @return 入边列表
	 */
	public List<Edge<?>> inEdges(){
		return inEdges;
	}
	
	/**
	 * @return 节点在图中的索引
	 */
	public int getIndexInGraph(){
		return indexInGraph;
	}
	
	/**
	 * @return 遍历中节点的当前状态
	 */
	public VertexStatus getStatus(){
		return status;
	}
	
	/**
	 * 设置节点的当前状态
	 * @param status 指定的状态
	 */
	public void setStatus(VertexStatus status){
		this.status = status;
	}
	
	/**
	 * @return 节点访问的时间标签
	 */
	public int getDStamp(){
		return dStamp;
	}
	
	/**
	 * 设置节点访问的时间标签
	 * @param stamp
	 */
	public void setDStamp(int stamp){
		dStamp = stamp;
	}
	
	/**
	 * @return 节点结束访问的时间标签
	 */
	public int getFStamp(){
		return fStamp;
	}
	
	/**
	 * 设置节点结束访问的时间标签
	 * @param stamp
	 */
	public void setFStamp(int stamp){
		fStamp = stamp;
	}
	
	/**
	 * @return 节点至起点的最短距离
	 */
	public int getDistance(){
		return distance;
	}
	
	/**
	 * 设置节点至起点的最短距离
	 * @param distance
	 */
	public void setDistance(int distance){
		this.distance = distance;
	}
	
	/**
	 * @return 节点的父亲
	 */
	public Vertex<T> getParent(){
		return parent;
	}
	
	/**
	 * 设置节点的父亲
	 * @param parent
	 */
	public void setParent(Vertex<T> parent){
		this.parent = parent;
	}

	/**
	 * 判断是否有边指向指定的节点
	 * @param v 指定的节点
	 * @return true: 存在边；false: 没有边
	 */
	public boolean isAdjacent(Vertex<?> v) {
		for (Edge<?> edge : outEdges){
			if (edge.getHead() == v){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 找到邻接指定节点的边
	 * @param to 指定节点
	 * @return 与指定节点关联的边
	 */
	public Edge<?> edgeTo(Vertex<T> to){
		for (Edge<?> e : outEdges){
			if (e.getHead() == to){
				return e;
			}
		}
		return null;
	}
}
