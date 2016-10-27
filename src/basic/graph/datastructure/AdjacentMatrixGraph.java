package basic.graph.datastructure;

/**
 * 基本的邻接矩阵
 * @author Jingang Zhou
 *
 * @param <V> 节点类型
 */
public class AdjacentMatrixGraph<V> {
	//节点数组
	protected V[] vertex;
	//节点距离数组
	protected int[][] distance;
	
	/**
	 * 构造函数
	 * @param vertex 节点数组，可以用来设置节点名称
	 */
	public AdjacentMatrixGraph(V[] vertex){
		this.vertex = vertex;
		distance = new int[vertex.length][vertex.length];
		initDistance();
	}
	
	/**
	 * @return 节点数组
	 */
	public V[] getVertex(){
		return vertex;
	}
	
	/**
	 * 根据节点索引设置节点间距离
	 * @param i 源节点的索引
	 * @param j 目标节点的索引
	 * @param distance 节点间距离。{@code Integer.MAX_VALUE} 表示无穷大
	 * @return 当前对象
	 */
	public AdjacentMatrixGraph<V> setDistance(int i, int j, int distance){
		this.distance[i][j] = distance;
		return this;
	}
	
	/**
	 * 设置指定节点间的距离
	 * @param u 源节点
	 * @param v 目标节点
	 * @param distance 节点间的距离。{@code Integer.MAX_VALUE} 表示无穷大
	 * @return 当前对象
	 */
	public AdjacentMatrixGraph<V> setDistance(V u, V v, int distance){
		return setDistance(index(u), index(v), distance);
	}
	
	/**
	 * 获取指定节点在图中的索引
	 * @param v 指定的节点
	 * @return 指定节点的索引
	 */
	public int index(V v){
		for (int i=0; i<vertex.length; i++){
			if (v == vertex[i]){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 获得索引处的节点
	 * @param i 索引
	 * @return 指定索引处的节点
	 */
	public V vertexAt(int i){
		return vertex[i]; 
	}
	
	/**
	 * 根据索引判断当前时刻两个节点是否相邻（有通路）。注意，两个节点有通路并不代表它们之间有一条直接的路径，
	 * 有可能是通过中间节点的。因此，该值可能是动态变化的。
	 * @param i 源节点索引
	 * @param j 目标节点索引
	 * @return true: 有通路；false: 无通路
	 */
	public boolean isAdjacent(int i, int j){
		return distance[i][j] < Integer.MAX_VALUE;
	}
	
	/**
	 * 判断指定的节点间是否有通路。
	 * @param u 源节点
	 * @param v 目标节点
	 * @return true: 有通路；false: 无通路
	 * @see AdjacentMatrixGraph#isAdjacent(int, int)
	 */
	public boolean isAdjacent(V u, V v){
		return isAdjacent(index(u), index(v));
	}
	
	/**
	 * 获得当前时刻索引处节点间的距离
	 * @param i 源节点索引
	 * @param j 目标节点索引
	 * @return 当前时刻索引节点间的距离
	 */
	public int getDistance(int i, int j){
		return distance[i][j];
	}
	
	/**
	 * 获得当前时刻节点间的距离
	 * @param u 源节点
	 * @param v 目标节点
	 * @return 当前时刻节点间的距离
	 */
	public int getDistance(V u, V v){
		return getDistance(index(u), index(v));
	}
	
	/**
	 * 邻接矩阵初始化
	 */
	protected void initDistance(){
		for (int i=0; i<distance.length; i++){
			for (int j=0; j<distance[i].length; j++){
				if (i==j){
					distance[i][j]=0;
				}else{
					distance[i][j]=Integer.MAX_VALUE;
				}
			}
		}
	}	
}
