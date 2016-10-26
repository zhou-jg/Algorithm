package basic.graph.datastructure;

public class Edge<T> {
	//边中存放的数据元素
	protected T data;
	//在图中的索引
	protected int indexInGraph;
	//边的头节点
	protected Vertex<?> head;
	//边的尾节点
	protected Vertex<?> tail;
	//边类型
	protected EdgeType type;
	
	/**
	 * 构造函数
	 * @param g 图
	 * @param head 头节点
	 * @param tail 尾节点
	 * @param data 边中的数据元素
	 */
	public Edge(Graph<?, T> g, Vertex<?> head, Vertex<?> tail, T data){
		this.data = data;
		indexInGraph = g.insert(this);
		this.head = head;
		this.tail = tail;
		head.inEdges().add(this);
		tail.outEdges().add(this);
		type = EdgeType.UNKNOWN;
	}
	
	/**
	 * @return 边中的数据
	 */
	public T getData(){
		return data;
	}
	
	/**
	 * 设置边中的数据元素
	 * @param data
	 */
	public void setData(T data){
		this.data = data;
	}
	
	/**
	 * @return 边在图中的索引
	 */
	public int getIndexInGraph(){
		return indexInGraph;
	}
	
	/**
	 * @return 边的头节点
	 */
	public Vertex<?> getHead(){
		return head;
	}
	
	/**
	 * @return 边的尾节点
	 */
	public Vertex<?> getTail(){
		return tail;
	}
	
	/**
	 * @return 边的类型
	 */
	public EdgeType getType(){
		return type;
	}
	
	/**
	 * 设置边的类型
	 * @param type
	 */
	public void setType(EdgeType type){
		this.type = type;
	}
}
